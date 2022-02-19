// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.XboxController;
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
    private XboxController xboxController;

    private boolean isFastMode = true;

  public DriveSubsystem() {
    mechanumDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    xboxController = new XboxController(0);
  }

  public void toggleFastMode(){
    isFastMode = !isFastMode;
  }

  public void drive(){
    if (isFastMode){
      mechanumDrive.driveCartesian(
        xboxController.getLeftY(), 
        xboxController.getLeftX()*Math.abs(xboxController.getLeftX())/2, 
        xboxController.getRightY()
      );
    } else {
      mechanumDrive.driveCartesian(
        xboxController.getLeftY()/2, 
        xboxController.getLeftX()*Math.abs(xboxController.getLeftX())/4, 
        xboxController.getRightY()/2
      );
    }
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
