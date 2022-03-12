// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Limelight;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class FindLimelightCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final LimelightSubsystem m_limelightSubsystem;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public FindLimelightCommand(LimelightSubsystem subsystem) {
    m_limelightSubsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Limelight.getInstance().setPipeline(0);
    Limelight.getInstance().setLightState(Limelight.LightMode.ON);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Limelight.getInstance().setLightState(Limelight.LightMode.ON);
   
    if(Limelight.getInstance().hasValidTarget() ) {
      //
      System.out.println(" Limelight found the target");
    }
    else {
      System.out.println("                      Limelight DID NOT find the target");
      //
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
