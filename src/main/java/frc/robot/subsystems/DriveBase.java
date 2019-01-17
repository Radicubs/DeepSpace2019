package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class DriveBase extends Subsystem {

    private Spark LeftMotorFront;
    private Spark LeftMotorMiddle;
    private Spark LeftMotorBack;
    private Spark RightMotorFront;
    private Spark RightMotorMiddle;
    private Spark RightMotorBack;

    private SpeedControllerGroup LeftMotorGroup;
    private SpeedControllerGroup RightMotorGroup;

    private DifferentialDrive DifferentialDrive;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public DriveBase() {
        LeftMotorFront = new Spark(RobotMap.LEFT_FRONT_MOTOR);
        LeftMotorMiddle = new Spark(RobotMap.LEFT_MIDDLE_MOTOR);
        LeftMotorBack = new Spark(RobotMap.LEFT_BACK_MOTOR);
        RightMotorFront = new Spark(RobotMap.RIGHT_FRONT_MOTOR);
        RightMotorMiddle = new Spark(RobotMap.RIGHT_MIDDLE_MOTOR);
        RightMotorBack = new Spark(RobotMap.RIGHT_BACK_MOTOR);

        LeftMotorGroup = new SpeedControllerGroup(LeftMotorFront, LeftMotorMiddle, LeftMotorBack);
        RightMotorGroup = new SpeedControllerGroup(RightMotorFront, RightMotorMiddle, RightMotorBack);

        DifferentialDrive = new DifferentialDrive(LeftMotorGroup, RightMotorGroup);
    }


    public void drive(double leftValue, double rightValue) {
        //DifferentialDrive.tankDrive(leftValue, rightValue);
        LeftMotorFront.set(leftValue);
        LeftMotorMiddle.set(rightValue);

    }
    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }
}

