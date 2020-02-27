/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Motor & Servo IDs

    public static final int WINCH_CAN_ID = 5;
    public static final int F_SERVO_CAN_ID = 6;
    public static final int B_SERVO_CAN_ID = 7;


    // CAN IDs
    //FL == front left, etc.
    public static final int FL_DRIVE_CAN_ID = 1;
    public static final int FR_DRIVE_CAN_ID = 2;
    public static final int RL_DRIVE_CAN_ID = 3;
    public static final int RR_DRIVE_CAN_ID = 4;

    //Joystick port IDs
    public static final int CONTROLLER_USB_ID = 0;
    //Game controller joystick axe
    public static final int LEFT_JOY_X = 0;
    public static final int LEFT_JOY_Y = 1;
    public static final int LEFT_TRIG = 2;

    public static final int RIGHT_JOY_X = 4;
    public static final int RIGHT_JOY_Y = 5;
    public static final int RIGHT_TRIG = 3;
    
    //Game controller buttons
    public static final int A = 1;
    public static final int B = 2;
    public static final int X = 3;
    public static final int Y = 4;
}
