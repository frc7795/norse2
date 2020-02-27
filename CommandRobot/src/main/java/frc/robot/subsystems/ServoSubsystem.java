/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

public class ServoSubsystem extends SubsystemBase {
    
    Servo front;
    Servo back;
    double scalar = 55;

    // Creates a new ServoSubsystem.
    public ServoSubsystem() {
        front = new Servo(Constants.F_SERVO_CAN_ID);
        back = new Servo(Constants.B_SERVO_CAN_ID);
    }
    // Sets the servos to inputted positions
    public void changePosition(double right, double left){
        front.setAngle(scalar-(right*scalar));
        back.setAngle(scalar-(left*scalar));
    }
}