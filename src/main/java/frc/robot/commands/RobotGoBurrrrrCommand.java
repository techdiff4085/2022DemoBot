// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;


/** An example command that uses an example subsystem. */
public class RobotGoBurrrrrCommand extends SequentialCommandGroup {

  public RobotGoBurrrrrCommand(DriveSubsystem driveSubsystem, AHRS navX, Spark lights) {
    lights.set(0.93);
    addCommands(
      new TurnToAngleCommand(driveSubsystem, navX, 180)
    );
      /*
    new DriveAutonomousCommand(driveSubsystem, 0, 0, -.5, 2000),
    new DriveAutonomousCommand(driveSubsystem, 0.2, 0, 0, 1000),  
    new DriveAutonomousCommand(driveSubsystem, 0, 0.2, 0, 1000),
    new DriveAutonomousCommand(driveSubsystem, -0.2, 0, 0, 1000),
    new DriveAutonomousCommand(driveSubsystem, 0, -0.2, 0, 1000));
    */
  }
}
