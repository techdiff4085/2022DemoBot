// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class TurnToAngleCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_driveSubsystem;
  private final PIDController m_controller;
  private double m_turnToAngle;
  private double m_currentRotationRate;
  private AHRS m_navX;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TurnToAngleCommand(DriveSubsystem subsystem, AHRS navX, double turnToAngle) {
    m_driveSubsystem = subsystem;
    m_controller = new PIDController(Constants.KP, Constants.KI, Constants.KD);
    m_controller.enableContinuousInput(-180.0, 180.0);
    m_navX = navX;
    m_turnToAngle = turnToAngle;


    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //m_turnToAngle += m_navX.getYaw();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_currentRotationRate = m_controller.calculate(
      m_navX.getYaw(), m_turnToAngle);
    
    m_driveSubsystem.turnToAngle(m_currentRotationRate, m_navX);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Math.abs(m_turnToAngle - m_navX.getYaw()) < 10){
      m_navX.zeroYaw();
      return true;
    } 
    return false;
  }
}
