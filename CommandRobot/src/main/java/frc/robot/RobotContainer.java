/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.button.Button;
import frc.robot.Constants;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.ServoCommand;
import frc.robot.commands.SolenoidCommand;
import frc.robot.commands.WinchCommand;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ServoSubsystem;
import frc.robot.subsystems.SolenoidSubsystem;
import frc.robot.subsystems.WinchSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  private static final DrivetrainSubsystem m_drivetrain = new DrivetrainSubsystem();

  private static final ServoSubsystem m_servo = new ServoSubsystem();
  
  private static final SolenoidSubsystem m_solenoid = new SolenoidSubsystem();  
  
  private static final WinchSubsystem m_winch = new WinchSubsystem();

  static Joystick controller = new Joystick(Constants.CONTROLLER_USB_ID);
  
  public static double getDriverRightTrigger() {
    return controller.getRawAxis(Constants.RIGHT_TRIG);
  }

  public static double getDriverLeftTrigger() {
    return controller.getRawAxis(Constants.LEFT_TRIG);
  }

  public static boolean getDriverYButton() {
    return controller.getRawButtonPressed(Constants.Y);
  }

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_drivetrain.setDefaultCommand(new ArcadeDriveCommand(m_drivetrain, controller));
    m_servo.setDefaultCommand(new ServoCommand(m_servo, controller));
    m_solenoid.setDefaultCommand(new SolenoidCommand(m_solenoid, controller));
    m_winch.setDefaultCommand(new WinchCommand(m_winch, controller));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
   public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
   return null;
  }
}
