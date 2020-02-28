/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class WinchSubsystem extends SubsystemBase {
    
    WPI_VictorSPX winch;

    // Creates a new WinchSubsystem.
    public WinchSubsystem() {
        winch = new WPI_VictorSPX(Constants.WINCH_CAN_ID);
    }
    // Sets the winch to a position
    public void changeSpeed(double speed){
        winch.set(speed);
    }
}