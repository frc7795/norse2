/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends CommandBase {
  DrivetrainSubsystem m_drivetrain;
  Joystick m_controller;
  private double lastSetPower = 0.0;
  private double magicPowerFraction = 0.05;
  /**
   * Creates a new TankDriveCommand.
   */
  public ArcadeDriveCommand(DrivetrainSubsystem drivetrain, Joystick controller) {
    m_drivetrain = drivetrain;
    m_controller = controller;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

 // private static double clip(double val) {
   // return Math.max(-1.0, Math.min(1.0, val));
  //}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //Most of this is copied/adapted from last year's code so it may not work m_controller.getRawAxis(4)
    double steeringSpeedScale = 0.6;
    double steering = m_controller.getRawAxis(4);
    double power = m_controller.getY(Hand.kLeft);

    power = lastSetPower + magicPowerFraction * (power - lastSetPower);
    lastSetPower = power;

    steering = steering * steeringSpeedScale;
    //double powerLeft = clip(power - steering);
    //double powerRight = clip(power + steering);

    Robot.drivetrain.drive(power, steering);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Stops the motors
    m_drivetrain.drive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
