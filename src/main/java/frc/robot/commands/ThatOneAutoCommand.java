// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/** An example command that uses an example subsystem. */
public class ThatOneAutoCommand extends SequentialCommandGroup {

  public ThatOneAutoCommand(DriveSubsystem subsystem, Spark lights) {
    addCommands(
      new DriveAutonomousCommand(subsystem, 0.1, 0, 0, 500),
      new DriveAutonomousCommand(subsystem, 0, 0, 0, 500)
    );
  }

}
