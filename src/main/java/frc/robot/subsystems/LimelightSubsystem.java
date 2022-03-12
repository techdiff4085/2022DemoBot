// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Limelight;


public class LimelightSubsystem extends SubsystemBase {
  Limelight m_limelight;
  
  /** Creates a new ExampleSubsystem. */
  public LimelightSubsystem() {
    m_limelight = Limelight.getInstance();


    //usefull commands
    //m_limelight.hasValidTarget();
    
  }

  public Limelight getLimelight(){
    return m_limelight;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
