// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
    private WPI_TalonFX frontLeft = new WPI_TalonFX(Constants.LeftFrontWheel);
    private WPI_TalonFX frontRight = new WPI_TalonFX(Constants.RightFrontWheel);
    private WPI_TalonFX rearLeft = new WPI_TalonFX(Constants.LeftRearWheel);
    private WPI_TalonFX rearRight = new WPI_TalonFX(Constants.RightRearWheel);

    private MecanumDrive mechanumDrive;
    private boolean isFastMode = true;

  public DriveSubsystem() {
    mechanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    frontRight.setInverted(true);
    rearRight.setInverted(true);
  }

  public void toggleFastMode(){
    isFastMode = !isFastMode;
  }

  public boolean getIsFastMode(){
    return isFastMode;
  }

  public void drive(double y, double x, double z){
      mechanumDrive.driveCartesian(y, x, z);
  }

  public void turnToAngle(double turnToAngle, AHRS navX){
    mechanumDrive.driveCartesian(0,0,turnToAngle, 0);
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
