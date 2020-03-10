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
import edu.wpi.first.wpilibj.Timer;

public class WinchSubsystem extends SubsystemBase {
    
    WPI_VictorSPX winch;
    Timer timer;

    // Creates a new WinchSubsystem.
    public WinchSubsystem() {
        winch = new WPI_VictorSPX(Constants.WINCH_CAN_ID);
        timer = new Timer();
    }
    // Sets the winch to a position
    public void changeSpeed(double speed){
        winch.set(speed);
    }

    public void activate(){
        timer.start();
        while(timer.get()<.5){
            winch.set(.5);
        }
        timer.stop();
        timer.reset();
    }
}