/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

public class ServoSubsystem extends SubsystemBase {
    
    private static Servo front = new Servo(6);
    private static Servo back = new Servo(7);

    static final double min = 0.1;
    static final double max = 0.9;

    // Creates a new ServoSubsystem.
    public ServoSubsystem() {
        // Sets both servos to minimum position
        front.set(min);
        back.set(min);
    }
    public static void changePosition(){
        double rightInput = RobotContainer.getDriverRightTrigger();
        double leftInput = RobotContainer.getDriverLeftTrigger();
        front.set(rightInput);
        back.set(leftInput);
    }
}