// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class RotateAutonomousCommand extends SequentialCommandGroup {
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public RotateAutonomousCommand(DriveSubsystem subsystem, Spark lights) {
    lights.set(-0.99);
    addCommands(
      new DriveAutonomousCommand(subsystem, 0, 0, 0.5, 500),
      new DriveAutonomousCommand(subsystem, 0, 0, 0, 500)
    );
  }
}
