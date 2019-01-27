package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;

public class DriveBase extends Subsystem {

    private WPI_TalonSRX LeftChassisMotor;
    private WPI_VictorSPX LeftFollowerOne;
    private WPI_VictorSPX LeftFollowerTwo;

    private WPI_TalonSRX RightChassisMotor;
    private WPI_VictorSPX RightFollowerOne;
    private WPI_VictorSPX RightFollowerTwo;

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
        /*CAN Motor Setup*/
        //Initialization
        LeftChassisMotor = new WPI_TalonSRX(RobotMap.LEFT_TALON);
        LeftFollowerOne = new WPI_VictorSPX(RobotMap.LEFT_FOLLOWER_ONE);
        LeftFollowerTwo = new WPI_VictorSPX(RobotMap.LEFT_FOLLOWER_TWO);

        RightChassisMotor = new WPI_TalonSRX(RobotMap.RIGHT_TALON);
        RightFollowerOne = new WPI_VictorSPX(RobotMap.RIGHT_FOLLOWER_ONE);
        RightFollowerTwo = new WPI_VictorSPX(RobotMap.RIGHT_FOLLOWER_TWO);

        //Factory Default Configurations
        LeftChassisMotor.configFactoryDefault();
        LeftFollowerOne.configFactoryDefault();
        LeftFollowerTwo.configFactoryDefault();
        RightChassisMotor.configFactoryDefault();
        RightFollowerOne.configFactoryDefault();
        RightFollowerTwo.configFactoryDefault();

        //Configure Followers
        LeftFollowerOne.follow(LeftChassisMotor);
        LeftFollowerTwo.follow(LeftChassisMotor);
        RightFollowerOne.follow(RightChassisMotor);
        RightFollowerTwo.follow(RightChassisMotor);

        differentialDrive = new DifferentialDrive(LeftChassisMotor, RightChassisMotor);
        
        //the default deadband was 0.02, setting it lower here
        //because the cubing messes it up otherwise?
        differentialDrive.setDeadband(0.00);
    }


    //Whenever this subsystem is idle
    //It will run the command ArcadeDrive
    //Therefore driving will always be enabled
    public void initDefaultCommand() {
        Command defaultCommand = RobotMap.ARCADE_DRIVE ? new ArcadeDrive() : new TankDrive();
        setDefaultCommand(defaultCommand);
    }
}
