// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

/** An example command that uses an example subsystem. */
public class ThatOneAutoCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_subsystem;
  private Spark m_lights;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public ThatOneAutoCommand(DriveSubsystem subsystem, Spark lights) {
    m_subsystem = subsystem;
    m_lights = lights;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_lights.set(-0.83);
    addCommands(
    new DriveAutonomousCommand(m_subsystem, 0.1, 0, 0),
    new WaitCommand(3),
    new DriveAutonomousCommand(m_subsystem, 0, 0, 0));
  }

  private void addCommands(DriveAutonomousCommand driveAutonomousCommand, WaitCommand waitCommand,
      DriveAutonomousCommand driveAutonomousCommand2) {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
