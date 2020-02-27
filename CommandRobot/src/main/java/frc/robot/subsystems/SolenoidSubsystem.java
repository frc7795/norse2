/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

//import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Solenoid;

public class SolenoidSubsystem extends SubsystemBase {

    private static Solenoid sproing = new Solenoid(0);

    public SolenoidSubsystem(){
        sproing.set(false);
    }

    public void changePosition(boolean input){
        sproing.set(input);
    }
}