/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

//import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Timer;

public class SolenoidSubsystem extends SubsystemBase {

    DigitalOutput solenoid;
    Timer timer;

    public SolenoidSubsystem(){
        solenoid = new DigitalOutput(0);
        timer = new Timer();
    }

    public void activate(){
        timer.start();
        while(timer.get()<.5){
            solenoid.set(true);
        }
        solenoid.set(false);
        timer.stop();
        timer.reset();
    }

    public void hold(boolean bool){
        solenoid.set(bool);
    }
}