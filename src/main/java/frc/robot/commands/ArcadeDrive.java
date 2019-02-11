package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;


public class ArcadeDrive extends Command {

    public ArcadeDrive() {
        //requires is method that tells commands which subsystems will be using it
        //IT IS MANDATORY
        requires(Robot.driveBase);
    }


    @Override
    protected void initialize() {

    }

    //private boolean tempButtonBool = Robot.oi.toggleOn0;
    private boolean forwardDone = false;
    private boolean clapperDone = false;
    private boolean backwardDone = false;

    @Override
    protected void execute() {
        
        if (Robot.oi.toggleOnB) {
            /*
            double forwardSpeed = Robot.oi.driveJoystick.getRawAxis(RobotMap.LEFTYAXIS);
            double rotationalSpeed = Robot.oi.driveJoystick.getRawAxis(RobotMap.LEFTXAXIS);

            //inverting these values make it work more intuitively
            double adjustedFSpeed = -adjustByExponent(forwardSpeed, 3);
            double adjustedRSpeed = -adjustByExponent(rotationalSpeed, 1);

            //this magnitude assumes the range of the controller is a perfect circle
            //it actually extends slightly beyond that, but it should be fine?
            double magnitude = Math.sqrt(forwardSpeed * forwardSpeed + rotationalSpeed * rotationalSpeed);
            double multiplier = magnitude / Math.max(Math.abs(adjustedFSpeed), Math.abs(adjustedRSpeed));
        
            adjustedFSpeed *= multiplier;
            adjustedRSpeed *= multiplier;
            //System.out.println("Arcade Drive");
            //System.out.println("Raw Forward Speed: " + forwardSpeed);
            //System.out.println("Raw Rotational Speed: " + rotationalSpeed);
            //System.out.println("Magnitude: " + magnitude);

            Robot.driveBase.drive(adjustedFSpeed,//Y-Axis of left joystick
                                  adjustedRSpeed);//X-Axis of left joystick
            */
        }
        /*else {
            if (!forwardDone) {
                Robot.driveBase.drive(Robot.ultrasonicSystem.getDistance() / RobotMap.kP,
                Robot.ultrasonicSystem.getDistance() / RobotMap.kP);
                //whatever else PID stuff
                if (Robot.ultrasonicSystem.getDistance() < 10.5) {
                    forwardDone = true;
                }
            }
            if (forwardDone && !clapperDone) {
                clapperDone = true;
                //whatever code
                //if (clapperCheckerMethodThingy) {
                //    clapperDone = true;
                //}
            }
            if (forwardDone && clapperDone && !backwardDone) {
                Robot.driveBase.drive(Robot.ultrasonicSystem.getDistance() / (-1 * RobotMap.kP),
                    Robot.ultrasonicSystem.getDistance() / (-1 * RobotMap.kP));
                if (Robot.ultrasonicSystem.getDistance() > 30) {
                    backwardDone = true;
                }
            }
            if (forwardDone && clapperDone && backwardDone) {
                tempButtonBool = false;
            }
        }*/
    }

    /*public void arcadeDrive(double xSpeed, double zRotation) {
        xSpeed = limit(xSpeed);
        xSpeed = applyDeadband(xSpeed, m_deadband);
    
        zRotation = limit(zRotation);
        zRotation = applyDeadband(zRotation, m_deadband);
    
        double leftMotorOutput;
        double rightMotorOutput;
    
        double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed);
    
        if (xSpeed >= 0.0) {
            // First quadrant, else second quadrant
            if (zRotation >= 0.0) {
                leftMotorOutput = maxInput;
                rightMotorOutput = xSpeed - zRotation;
            }
            else {
                leftMotorOutput = xSpeed + zRotation;
                rightMotorOutput = maxInput;
            }
        }
        else {
            // Third quadrant, else fourth quadrant
            if (zRotation >= 0.0) {
                leftMotorOutput = xSpeed + zRotation;
                rightMotorOutput = maxInput;
            }
            else {
                leftMotorOutput = maxInput;
                rightMotorOutput = xSpeed - zRotation;
            }
        }
    
        m_leftMotor.set(limit(leftMotorOutput) * m_maxOutput);
        m_rightMotor.set(limit(rightMotorOutput) * m_maxOutput * m_rightSideInvertMultiplier);
    
        feed();
    }*/

    //takes the exponent of the positive value
    //and copies the original sign
    private static double adjustByExponent(double value, double exp) {
        return Math.copySign(Math.pow(Math.abs(value), exp), value);
    }

    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }


    @Override
    protected void end() {

    }


    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
