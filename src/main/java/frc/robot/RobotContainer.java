// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.math.trajectory.TrajectoryParameterizer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.TurnToAngleCommand;
import frc.robot.commands.DriveAutonomousCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FindLimelightCommand;
import frc.robot.commands.RobotGoBurrrrrCommand;
import frc.robot.commands.RotateAutonomousCommand;
import frc.robot.commands.SpinnyThingyCommand;
import frc.robot.commands.ThatOneAutoCommand;
import frc.robot.commands.ToggleFastModeCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.SpinnySub;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final SpinnySub m_spinnySub = new SpinnySub();
  private final LimelightSubsystem m_limelightSub = new LimelightSubsystem();
  private final AHRS navX = new AHRS(SPI.Port.kMXP);


  private final XboxController m_xboxController = new XboxController(0);
  private final DriveCommand m_driveCommand = new DriveCommand(m_driveSubsystem, m_xboxController);

  private final SendableChooser<Command> m_sendableChooser = new SendableChooser<>();

  private Spark m_lights = new Spark(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();


 
    m_sendableChooser.setDefaultOption("RobotGoBurrrrr", new RobotGoBurrrrrCommand(m_driveSubsystem, navX, m_lights));
    m_sendableChooser.addOption("RotateAutonomous", new RotateAutonomousCommand(m_driveSubsystem, m_lights));
    m_sendableChooser.addOption("ThatOneAuto", new ThatOneAutoCommand(m_driveSubsystem, m_lights));

    SmartDashboard.putData(m_sendableChooser);

    m_driveSubsystem.setDefaultCommand(m_driveCommand);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton buttonB = new JoystickButton(m_xboxController, XboxController.Button.kB.value);
    buttonB.whenActive(new DriveAutonomousCommand(m_driveSubsystem, 0, 0, 0.6, 260));

    JoystickButton buttonY = new JoystickButton(m_xboxController, XboxController.Button.kY.value);
    buttonY.whenActive(new DriveAutonomousCommand(m_driveSubsystem, 0, 0, 0.35, 650));

     JoystickButton buttonX = new JoystickButton(m_xboxController, XboxController.Button.kX.value);
     buttonX
      .whenActive(new ToggleFastModeCommand(m_driveSubsystem));
      JoystickButton buttonA = new JoystickButton(m_xboxController, XboxController.Button.kA.value);
     buttonA
      .whenActive(new SpinnyThingyCommand(m_spinnySub));

      JoystickButton buttonLimelight = new JoystickButton(m_xboxController, XboxController.Button.kLeftBumper.value);
      buttonLimelight
       .whenActive(new FindLimelightCommand(m_limelightSub));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_sendableChooser.getSelected();
  }
}
