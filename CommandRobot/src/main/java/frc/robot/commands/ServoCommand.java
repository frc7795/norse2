/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ServoSubsystem;

public class ServoCommand extends CommandBase {
  
  ServoSubsystem m_servo;
  Joystick m_controller;
  double rPosition;
  double lPosition;

  // Calls every scheduler run
  public ServoCommand(ServoSubsystem servo, Joystick controller){
      m_servo = servo;
      m_controller = controller;
      addRequirements(m_servo);

      rPosition = m_controller.getRawAxis(Constants.RIGHT_TRIG);
      lPosition = m_controller.getRawAxis(Constants.LEFT_TRIG);
  }


  @Override
  public void initialize() {
      SmartDashboard.putNumber("Back Servos", lPosition);
      SmartDashboard.putNumber("Front Servos", rPosition);
  }

  // Runs two servos under same subsystem
  @Override
  public void execute() {
      m_servo.changePosition(RobotContainer.getDriverRightTrigger(), RobotContainer.getDriverLeftTrigger());
  }
}