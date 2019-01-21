package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.RobotDriveBase;
import frc.robot.RobotMap;

public class DriveBase extends Subsystem {

    private Spark LeftChassisMotor;
    private Spark RightChassisMotor;


    //This takes joystick inputs and converts it to appropriate motor inputs depending on the drive mode
    private DifferentialDrive differentialDrive;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void drive(double forwardSpeed, double rotationalSpeed) {
        
        
        //inverting these values make it work more intuitively
        double adjustedFSpeed = -adjustByExponent(forwardSpeed, 3);
        double adjustedRSpeed = -adjustByExponent(rotationalSpeed, .5);

        //this magnitude assumes the range of the controller is a perfect circle
        //it actually extends slightly beyond that, but it should be fine?
        double magnitude = Math.sqrt(forwardSpeed * forwardSpeed + rotationalSpeed * rotationalSpeed);
        double multiplier = magnitude / Math.max(Math.abs(adjustedFSpeed), Math.abs(adjustedRSpeed));

        differentialDrive.arcadeDrive(multiplier * adjustedFSpeed, multiplier * adjustedRSpeed, false);
        
        System.out.println("Raw Forward Speed: " + forwardSpeed);
        System.out.println("Raw Rotational Speed: " + rotationalSpeed);
        System.out.println("Magnitude: " + magnitude);
        System.out.println("Left Motor Speed: " + LeftChassisMotor.get());
        System.out.println("Right Motor Speed: " + RightChassisMotor.get() + "\n");

        //This old version uses the default of squaring instead of cubing
        //differentialDrive.arcadeDrive(forwardSpeed, rotationalSpeed, false);

        // leftSpeed = forwardSpeed;
        // rightSpeed = forwardSpeed;

        // leftSpeed += rotationalSpeed * 0.5;
        // rightSpeed += rotationalSpeed * 0.5;

        // LeftChassisMotor.set(leftSpeed);
        // RightChassisMotor.set(-rightSpeed);

    }

    //takes the exponent of the positive value
    //and copies the original sign
    private static double adjustByExponent(double value, double exp) {
        return Math.copySign(Math.pow(Math.abs(value), exp), value);
    }

    public DriveBase() {
        LeftChassisMotor = new Spark(RobotMap.LEFT_CHASSIS_MOTOR);
        RightChassisMotor = new Spark(RobotMap.RIGHT_CHASSIS_MOTOR);

        differentialDrive = new DifferentialDrive(LeftChassisMotor, RightChassisMotor);
        
        //the default deadband was 0.02, setting it lower here
        //because the cubing messes it up otherwise?
        differentialDrive.setDeadband(0.00);
    }


    //Whenever this subsystem is idle
    //It will run the command ArcadeDrive
    //Therefore driving will always be enabled
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
}
