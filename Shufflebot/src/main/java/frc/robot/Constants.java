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
    // CAN IDs
    //FL == front left, etc.
    public static final int FL_DRIVE_CAN_ID = 1;
    public static final int FR_DRIVE_CAN_ID = 2;
    public static final int RL_DRIVE_CAN_ID = 3;
    public static final int RR_DRIVE_CAN_ID = 4;

    //Joystick port IDs
    public static final int CONTROLLER_USB_ID = 0;
    //Game controller joystick axes
    public static final int JOY_LEFT_X = 0;
    public static final int JOY_LEFT_Y = 1;
    public static final int JOY_RIGHT_X = 2;
    public static final int JOY_RIGHT_Y = 3;
    

}
