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
import frc.robot.subsystems.WinchSubsystem;

public class WinchCommand extends CommandBase {
        
    WinchSubsystem m_winch;
    Joystick m_controller;

    public WinchCommand(WinchSubsystem winch, Joystick controller){
        m_winch = winch;
        m_controller = controller;
        addRequirements(m_winch);
    }

    @Override
    public void execute() {
        boolean a = RobotContainer.getDriverAButton();
        boolean b = RobotContainer.getDriverBButton();
        boolean l = RobotContainer.getDriverLButton();

        if (l) {
            m_winch.activate();
        }

        if (a && b) {
            m_winch.changeSpeed(0);
        }
        // Lets winch out
        else if(a) {
            m_winch.changeSpeed(.7);
        }
        // Pulls winch ins
        else if(b) {
            m_winch.changeSpeed(-1);
        }
        else {
            m_winch.changeSpeed(0);
        }
    }
}