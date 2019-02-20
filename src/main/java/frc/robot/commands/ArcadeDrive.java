package frc.robot.commands;

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

    @Override
    protected void execute() {
        double ixSpeed = Robot.oi.controller.getRawAxis(RobotMap.LEFTYAXIS);
        double izRotation = Robot.oi.controller.getRawAxis(RobotMap.LEFTXAXIS);

        //inverting these values make it work more intuitively
        double xSpeed = -adjustByExponent(ixSpeed, 3);
        double zRotation = -adjustByExponent(izRotation, .5);

        //this magnitude assumes the range of the controller is a perfect circle
        //it actually extends slightly beyond that, but it should be fine?
        double magnitude = Math.sqrt((ixSpeed * ixSpeed) + (izRotation * izRotation));
        double multiplier = magnitude / Math.max(Math.abs(xSpeed), Math.abs(zRotation));
        
        xSpeed *= multiplier;
        zRotation *= multiplier;

	      // cap xSpeed and zRotation to (-1, 1)
	      xSpeed = Math.abs(xSpeed) < 1 ? xSpeed : Math.copySign(1, xSpeed);
	      zRotation = Math.abs(zRotation) < 1 ? zRotation : Math.copySign(1, zRotation);

	      double leftMotorOutput;
	      double rightMotorOutput;

	      double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed);

	      if (xSpeed >= 0.0) {
	          // Second quadrant, else first quadrant
	          if (zRotation >= 0.0) { 
                    leftMotorOutput = xSpeed + zRotation;
		            rightMotorOutput = maxInput;
            }
            else {
                leftMotorOutput = maxInput;
                rightMotorOutput = xSpeed - zRotation;
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
        
        System.out.println("Arcade Drive");

        System.out.println("Left Motor Output: " + leftMotorOutput);
        System.out.println("Right Motor Output: " + rightMotorOutput);

        Robot.driveBase.drive(leftMotorOutput, rightMotorOutput);      
    }

    //takes the exponent of the positive value
    //and copies the original sign
    private static double adjustByExponent(double value, double exp) {
        return Math.copySign(Math.pow(Math.abs(value), exp), value);
    }

    @Override
    protected boolean isFinished() {
        // Make this return true when this Command no longer needs to run execute()
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
