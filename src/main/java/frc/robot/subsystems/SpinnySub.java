// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SpinnySub extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  private WPI_VictorSPX spinmoter = new WPI_VictorSPX(Constants.SpinnyThing);
  // 1-4 add second motor here

  private DigitalInput limitSwitch = new DigitalInput(Constants.Spinnythinglimit);

  public SpinnySub() {}

  public void Spin(){
    spinmoter.set(0.5);
    // 2-4 set speed for second motor
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // 3-4 This method will be called once per scheduler run during simulation
  }
  public boolean StopLimitSwitch() {
    if(limitSwitch.get()){
      spinmoter.set(0);
      //4-4 set second motor to '0' too.
      return true;
    } else {
      return false;
    }
  }
}
