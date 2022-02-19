// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpinnySub extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private WPI_VictorSPX spinmoter = new WPI_VictorSPX(1);


  public SpinnySub() {}

  public void Spin(){
    spinmoter.set(0.5);
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
