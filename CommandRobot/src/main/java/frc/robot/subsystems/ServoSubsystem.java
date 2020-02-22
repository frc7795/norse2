/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.subsystems;

//import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Servo;

public class ServoSubsystem extends SubsystemBase {
    
    Servo front;
    Servo back;
    double min = 0;
    double scalar = 180;

    // Creates a new ServoSubsystem.
    public ServoSubsystem() {
        front = new Servo(6);
        back = new Servo(7);
    }
    // Sets the servos to inputted positions
    public void changePosition(double right, double left){
        front.setAngle(right*scalar);
        back.setAngle(left*scalar);
    }
}