package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class ArcadeDrive extends Command {

    double leftSpeed, rightSpeed;

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
        double forwardSpeed = Robot.oi.controller.getY(Hand.kLeft);
        double rotationalSpeed = Robot.oi.controller.getX(Hand.kLeft);

        //inverting these values make it work more intuitively
        double adjustedFSpeed = -adjustByExponent(forwardSpeed, 3);
        double adjustedRSpeed = -adjustByExponent(rotationalSpeed, .5);

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

        // here is where we need to implement some version
        // of the differentialDrive's arcadeDrive method
        // right here in this space
        // just use adjustedFSpeed and adjustedRSpeed
        // to do exactly what that thing does
        // to get a leftSpeed and a rightSpeed
        // that you just call drivebase.drive() with

        leftSpeed = adjustedFSpeed + adjustedRSpeed; //These two lines apply rotational speed
        rightSpeed = adjustedFSpeed - adjustedRSpeed; //by editing forward speeds

        //If rotational speed if above 0, then the driver wants to go right.
        //Subtracting the positive from the right slows down the right and adding the positive value to the left speeds the left up
        //This works inversely when turning left.

        Robot.driveBase.drive(leftSpeed, rightSpeed);//X-Axis of left joystick
    }

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
//ishan is my name

    @Override
    protected void end() {

    }


    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
