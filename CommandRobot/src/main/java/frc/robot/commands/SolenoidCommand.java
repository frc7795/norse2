/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Constants;
import frc.robot.RobotContainer;
//import frc.robot.Robot;
import frc.robot.subsystems.SolenoidSubsystem;

public class SolenoidCommand extends CommandBase {
        
    SolenoidSubsystem m_solenoid;
    Joystick m_controller;

    public SolenoidCommand(SolenoidSubsystem solenoid, Joystick controller){
        m_solenoid = solenoid;
        m_controller = controller;
        addRequirements(m_solenoid);
    }

    @Override
    public void execute() {
      boolean y = RobotContainer.getDriverYButton();
      if(y) {
        m_solenoid.activate();
      }
  }
}