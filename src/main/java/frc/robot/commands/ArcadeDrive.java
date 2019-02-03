package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


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
        //double forwardSpeed = Robot.oi.controller.getY(Hand.kLeft);
        //double rotationalSpeed = Robot.oi.controller.getX(Hand.kLeft);
        double forwardSpeed = Robot.oi.joystick.getY(Hand.kLeft);
        double rotationalSpeed = Robot.oi.joystick.getX(Hand.kLeft);

        //inverting these values make it work more intuitively
        double adjustedFSpeed = -adjustByExponent(forwardSpeed, 3);
        double adjustedRSpeed = -adjustByExponent(rotationalSpeed, .5);

        //this magnitude assumes the range of the controller is a perfect circle
        //it actually extends slightly beyond that, but it should be fine?
        double magnitude = Math.sqrt(forwardSpeed * forwardSpeed + rotationalSpeed * rotationalSpeed);
        double multiplier = magnitude / Math.max(Math.abs(adjustedFSpeed), Math.abs(adjustedRSpeed));
        
        adjustedFSpeed *= multiplier;
        adjustedRSpeed *= multiplier;
        System.out.println("Arcade Drive");
        System.out.println("Raw Forward Speed: " + forwardSpeed);
        System.out.println("Raw Rotational Speed: " + rotationalSpeed);
        System.out.println("Magnitude: " + magnitude);

        Robot.driveBase.drive(adjustedFSpeed,//Y-Axis of left joystick
                              adjustedRSpeed);//X-Axis of left joystick
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


    @Override
    protected void end() {

    }


    @Override
    protected void interrupted() {
        super.interrupted();
    }
}