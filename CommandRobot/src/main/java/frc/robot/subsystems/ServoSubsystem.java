/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

public class ServoSubsystem extends SubsystemBase {
    
    private Servo frontLeft = new Servo(6);
    private Servo frontRight = new Servo(7);
    private Servo backLeft = new Servo(8);
    private Servo backRight = new Servo(9);

    static final double min = 0.1;
    static final double max = 0.9;

    // Creates a new ServoSubsystem.
    public ServoSubsystem() {
        // Sets both servos to minimum position
        frontLeft.set(min);
        frontRight.set(min);
        backLeft.set(min);
        backRight.set(min);
    }
    public void changePosition(Servo servo, double input){
        servo.set(input);
    }
}