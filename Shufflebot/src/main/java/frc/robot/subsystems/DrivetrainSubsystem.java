/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  SpeedController frontLeft;
  SpeedController rearLeft;
  SpeedController frontRight;
  SpeedController rearRight;
  SpeedControllerGroup leftSide;
  SpeedControllerGroup rightSide;
  DifferentialDrive drive;

  /**
   * Creates a new DrivetrainSubsystem.
   */
  public DrivetrainSubsystem() {
    frontLeft = new WPI_VictorSPX(Constants.FL_DRIVE_CAN_ID);
    rearLeft = new WPI_VictorSPX(Constants.RL_DRIVE_CAN_ID);
    frontRight = new WPI_VictorSPX(Constants.FR_DRIVE_CAN_ID);
    rearRight = new WPI_VictorSPX(Constants.RR_DRIVE_CAN_ID);

    frontRight.setInverted(true);
    rearRight.setInverted(true);
    frontLeft.setInverted(true);
    rearLeft.setInverted(true);

    leftSide = new SpeedControllerGroup(frontLeft, rearLeft);
    rightSide = new SpeedControllerGroup(frontRight, rearRight);
    drive = new DifferentialDrive(leftSide, rightSide);
  }

  public void drive(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed,-zRotation);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
