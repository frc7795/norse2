package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;


public class AutonomousCommand extends CommandBase {

    // "Turtle graphics" plan for how far to drive or turn
    // Get off the starting line
    private static final double feetDrive1 = 4.0;
    // Turn right
    private static final double degreesTurn1 = 90;
    // Drive toward the loading station
    private static final double feetDrive3 = 10.0;
    // Turn right toward the loading station
    private static final double degreesTurn4 = 90;

    // How fast it can drive or turn
    // This is only approx because it doesn't account for "magic"
    // soft start, or accelerating the robot's mass.
    private static final double driveSpeed = 10.0;      // feet/sec
    private static final double turnSpeed = 360.0/2.0;  // degrees/sec (full turn takes 2 sec)

    // How much power to apply to the motors
    private static final double drivePower = 0.5;
    private static final double turnPower = 1.0;

    // Timeline for autonomous mode
    //
    // 1. Drive straight for drive1 seconds (0 to t1)
    // 2. Turn right for turn2 seconds (t1 to t2)
    // 3. Drive straight for drive3 seconds (t2 to t3)
    // 4. Turn right for turn4 seconds (t3 to t4)
    // 5. Stop (at t4)

    // How long the steps take (seconds)
    private static final double drive1 = feetDrive1 / (driveSpeed * drivePower);
    private static final double turn2 = degreesTurn1 / (turnSpeed * turnPower);
    private static final double drive3 = feetDrive3 / (driveSpeed * drivePower);
    private static final double turn4 = degreesTurn4 / (turnSpeed * turnPower);

    // Points on the timeline itself
    private static final double t1 = drive1;
    private static final double t2 = t1 + turn2;
    private static final double t3 = t2 + drive3;
    private static final double t4 = t3 + turn4;

    // Enum the names for driving operations
    private static final int D_stop = 0;
    private static final int D_drive = 1;
    private static final int D_turn = 2;

    // How gradually the actual power should approach the desired power
    // (the higher the fraction, the more abrupt; 1.0 is instant).
    // 0.1 goes 93% of the way in 0.5 second.
    // Compare with the use in ArcadeDriveCommand.
    private static final double magicPowerFraction = 0.1;

    private DrivetrainSubsystem m_drivetrain;
    private double m_startTime;
    private double m_lastSetPower = 0.0;


    public AutonomousCommand(DrivetrainSubsystem driveTrain) {
        m_drivetrain = driveTrain;
        m_startTime = Timer.getFPGATimestamp();
        addRequirements(m_drivetrain);
    }


    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double elapsed = Timer.getFPGATimestamp() - m_startTime;

        // What driving operation we should be doing now
        int op;
        if (elapsed < t1) {
            op = D_drive;
        } else if (elapsed < t2) {
            op = D_turn;
        } else if (elapsed < t3) {
            op = D_drive;
        } else if (elapsed < t4) {
            op = D_turn;
        } else {
            op = D_stop;
        }

        // What power should we apply
        double throttle = 0.0;
        double steer = 0.0;
        switch (op) {
            case D_drive:
                throttle = drivePower;
                // leave steer at zero
                break;
            case D_turn:
                // leave throttle at zero
                steer = turnPower;
                break;
            case D_stop:
            default:
                // Leave them both at zero 
                break;
        }

        // Gradually increase power, but decrease instantly.
        // Testing may reveal that we need similar cushioning for steering.
        if (throttle > m_lastSetPower) {
            throttle = m_lastSetPower + magicPowerFraction * (throttle - m_lastSetPower);
        }
        m_lastSetPower = throttle;

        // Make it so
        m_drivetrain.drive(throttle, steer);
    }

  // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        double elapsed = Timer.getFPGATimestamp() - m_startTime;
        return elapsed >= t4;
    }
}
