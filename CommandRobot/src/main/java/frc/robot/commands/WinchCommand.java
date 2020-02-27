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
import frc.robot.Constants;
//import frc.robot.Robot;
import frc.robot.subsystems.WinchSubsystem;

public class WinchCommand extends CommandBase {
        
    WinchSubsystem m_winch;
    Joystick m_controller;

    public WinchCommand(WinchSubsystem winch, Joystick controller){
        m_winch = winch;
        m_controller = controller;
        addRequirements(m_winch);
    }
}