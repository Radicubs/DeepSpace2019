package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class DriveBase extends Subsystem {

    private Spark LeftChassisMotor;
    private Spark RightChassisMotor;

    private double leftSpeed, rightSpeed;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public DriveBase() {
        LeftChassisMotor = new Spark(RobotMap.LEFT_CHASSIS_MOTOR);
        RightChassisMotor = new Spark(RobotMap.RIGHT_CHASSIS_MOTOR);
    }


    public void drive(double forwardSpeed, double rotationalSpeed) {
        leftSpeed = forwardSpeed;
        rightSpeed = forwardSpeed;

        leftSpeed += rotationalSpeed * 0.5;
        rightSpeed += rotationalSpeed * 0.5;

        LeftChassisMotor.set(leftSpeed);
        RightChassisMotor.set(-rightSpeed);

    }
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
}

