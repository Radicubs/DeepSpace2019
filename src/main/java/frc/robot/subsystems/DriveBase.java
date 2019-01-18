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

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public DriveBase() {
        LeftChassisMotor = new Spark(RobotMap.LEFT_CHASSIS_MOTOR);
        RightChassisMotor = new Spark(RobotMap.RIGHT_CHASSIS_MOTOR);
    }


    public void drive(double leftValue, double rightValue) {
        //DifferentialDrive.tankDrive(leftValue, rightValue);
        LeftChassisMotor.set(leftValue);
        RightChassisMotor.set(rightValue);

    }
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
}

