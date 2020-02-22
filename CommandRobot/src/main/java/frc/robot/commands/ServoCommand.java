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
  public ServoCommand(ServoSubsystem servo, Joystick controller){
      m_servo = servo;
      m_controller = controller;
      addRequirements(m_servo);
  }

  @Override
  public void execute() {
      double position = m_controller.getRawAxis(Constants.RIGHT_TRIG);
      SmartDashboard.putNumber("Servo", position);
      m_servo.changePosition(RobotContainer.getDriverRightTrigger(), RobotContainer.getDriverLeftTrigger());
  }
}