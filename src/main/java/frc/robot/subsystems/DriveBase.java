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

        System.out.println(DifferentialDrive.kDefaultDeadband);
        
        //This one line of code replaces all the code below it
        //Additionally it is more accurate and accounts for input scaling at different speeds

        double cubedFSpeed = -Math.pow(forwardSpeed, 3);
        double cubedRSpeed = -Math.pow(rotationalSpeed, 3);

        differentialDrive.arcadeDrive(cubedFSpeed, cubedRSpeed, false);
        
        //This old version uses the default of squaring instead of cubing
        //differentialDrive.arcadeDrive(forwardSpeed, rotationalSpeed, false);

        System.out.println("Raw Forward Speed: " + forwardSpeed);
        System.out.println("Raw Rotational Speed: " + rotationalSpeed);
        System.out.println("Left Motor Speed: " + LeftChassisMotor.get());
        System.out.println("Right Motor Speed: " + RightChassisMotor.get() + "\n");

        // leftSpeed = forwardSpeed;
        // rightSpeed = forwardSpeed;

        // leftSpeed += rotationalSpeed * 0.5;
        // rightSpeed += rotationalSpeed * 0.5;

        // LeftChassisMotor.set(leftSpeed);
        // RightChassisMotor.set(-rightSpeed);

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
