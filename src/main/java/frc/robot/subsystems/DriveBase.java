package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.TankDrive;

public class DriveBase extends Subsystem {

    private TalonSRX LeftChassisMotor;
    private VictorSPX LeftFollowerOne;
    private VictorSPX LeftFollowerTwo;

    private TalonSRX RightChassisMotor;
    private VictorSPX RightFollowerOne;
    private VictorSPX RightFollowerTwo;

    public DriveBase() {
        /*CAN Motor Setup*/
        //Initialization
        LeftChassisMotor = new TalonSRX(RobotMap.LEFT_TALON);
        LeftFollowerOne = new VictorSPX(RobotMap.LEFT_FOLLOWER_ONE);
        LeftFollowerTwo = new VictorSPX(RobotMap.LEFT_FOLLOWER_TWO);

        RightChassisMotor = new TalonSRX(RobotMap.RIGHT_TALON);
        RightFollowerOne = new VictorSPX(RobotMap.RIGHT_FOLLOWER_ONE);
        RightFollowerTwo = new VictorSPX(RobotMap.RIGHT_FOLLOWER_TWO);

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

        //differentialDrive = new DifferentialDrive(LeftChassisMotor, RightChassisMotor);
        
        //the default deadband was 0.02, setting it lower here
        //because the cubing messes it up otherwise?
        //differentialDrive.setDeadband(0.00);
    }

    //This takes joystick inputs and converts it to appropriate motor inputs depending on the drive mode
    //private DifferentialDrive differentialDrive;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void drive(double adjustedFSpeed, double adjustedRSpeed) {

        //differentialDrive.arcadeDrive(adjustedFSpeed, adjustedRSpeed, false);
            LeftChassisMotor.set(ControlMode.PercentOutput, adjustedFSpeed);
            RightChassisMotor.set(ControlMode.PercentOutput, adjustedRSpeed);
        


        System.out.println("Left Motor Speed: " + LeftChassisMotor.getSelectedSensorVelocity());
        System.out.println("Right Motor Speed: " + RightChassisMotor.getSelectedSensorVelocity());

        //This old version uses the default of squaring instead of cubing
        //differentialDrive.arcadeDrive(forwardSpeed, rotationalSpeed, false);

        // leftSpeed = forwardSpeed;
        // rightSpeed = forwardSpeed;

        // leftSpeed += rotationalSpeed * 0.5;
        // rightSpeed += rotationalSpeed * 0.5;

        // LeftChassisMotor.set(leftSpeed);
        // RightChassisMotor.set(-rightSpeed);

    }


    //Whenever this subsystem is idle
    //It will run the command ArcadeDrive
    //Therefore driving will always be enabled
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
}

