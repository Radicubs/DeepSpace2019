package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class DriveBase extends Subsystem {

    private Spark LeftChassisMotor;
    private Spark RightChassisMotor;


    //This takes joystick inputs and converts it to appropriate motor inputs depending on the drive mode
    private DifferentialDrive differentialDrive;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void drive(double adjustedFSpeed, double adjustedRSpeed) {
        if(RobotMap.ARCADE_DRIVE) {
            differentialDrive.arcadeDrive(adjustedFSpeed, adjustedRSpeed, false);
        }
        else {
            differentialDrive.tankDrive(adjustedFSpeed, adjustedRSpeed, false);
        }

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
        Command defaultCommand = RobotMap.ARCADE_DRIVE ? new ArcadeDrive() : new ArcadeDrive();
        setDefaultCommand(defaultCommand);
    }
}
