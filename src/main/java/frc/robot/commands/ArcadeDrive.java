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

        double ixSpeed = -1 * Robot.oi.controller.getRawAxis(RobotMap.LEFTYAXIS);
        double izRotation = Robot.oi.yButton.get() ? 0 : Robot.oi.controller.getRawAxis(RobotMap.RIGHTXAXIS);

        //System.out.println("Y axis: " + ixSpeed);
        //System.out.println("X axis: " + izRotation);

        //inverting these values make it work more intuitively
        double xSpeed = -adjustByExponent(ixSpeed, 3);
        double zRotation = -adjustByExponent(izRotation, 0.08);

        //this magnitude assumes the range of the controller is a perfect circle
        //it actually extends slightly beyond that, but it should be fine?
        double magnitude = Math.sqrt(ixSpeed * ixSpeed + izRotation * izRotation);
        double multiplier = magnitude / Math.max(Math.abs(xSpeed), Math.abs(zRotation));
        
        xSpeed *= multiplier;
        zRotation *= multiplier;

	      // cap xSpeed and zRotation to (-1, 1)
	    //   xSpeed = Math.abs(xSpeed) < 1 ? xSpeed : Math.copySign(1, xSpeed);
	    //   zRotation = Math.abs(zRotation) < 1 ? zRotation : Math.copySign(1, zRotation);

	      double leftMotorOutput = 0;
	      double rightMotorOutput = 0;

	      double maxInput = Math.copySign(Math.max(Math.abs(xSpeed), Math.abs(zRotation)), xSpeed) * .50;
          if(Math.abs(zRotation) < 0.05) // changed from zRotation == 0
          {
              //System.out.println("Test " + ixSpeed);
              if(zRotation <= 0.1 && zRotation >= 0.0 || zRotation <= 0.0 && zRotation >= -0.1){
                leftMotorOutput = maxInput;
                rightMotorOutput = -maxInput;
                //System.out.println("YOSHI");
              }
              else{
                leftMotorOutput = -maxInput;
                rightMotorOutput = maxInput;
              }
          }
	      else if (xSpeed >= 0.0) {
	          // First quadrant, else second quadrant
	          if (zRotation >= 0.0) {
                    //quadrant three - anti-clockwise

		            leftMotorOutput = -maxInput;
                    rightMotorOutput = -maxInput;

            }
            else {
                    //quadrant four - clockwise
		            leftMotorOutput = maxInput;
                    rightMotorOutput = maxInput;
	          }
        }
        else {
	          if (zRotation >= 0.0) {
                //second  quadrant - anti-clockwise

                leftMotorOutput = -maxInput;
                rightMotorOutput = -maxInput;
            }
            else {
                //first quadrant - clockwise

                leftMotorOutput = maxInput;
                rightMotorOutput = maxInput;

	        }
	    }
        
        //System.out.println("Arcade Drive");
        //System.out.println("Left Motor Output: " + leftMotorOutput);
        //System.out.println("Right Motor Output: " + rightMotorOutput);

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
