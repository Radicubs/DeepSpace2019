package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class TankDrive extends Command {

    public TankDrive() {
        //requires is method that tells commands which subsystems will be using it
        //IT IS MANDATORY
        requires(Robot.driveBase);
    }


    @Override
    protected void initialize() {

    }


    @Override
    protected void execute() {
        double leftSpeed = Robot.oi.controller.getY(Hand.kLeft);
        double rightSpeed = Robot.oi.controller.getX(Hand.kLeft);

        //inverting these values make it work more intuitively
        double adjustedLSpeed = -adjustByExponent(leftSpeed, 3);
        double adjustedRSpeed = -adjustByExponent(rightSpeed, 3);

        //this magnitude assumes the range of the controller is a perfect circle
        //it actually extends slightly beyond that, but it should be fine?
        double magnitude = Math.sqrt(leftSpeed * leftSpeed + rightSpeed * rightSpeed);
        double multiplier = magnitude / Math.max(Math.abs(adjustedLSpeed), Math.abs(adjustedRSpeed));
        
        adjustedLSpeed *= multiplier;
        adjustedRSpeed *= multiplier;

        System.out.println("Raw Forward Speed: " + leftSpeed);
        System.out.println("Raw Rotational Speed: " + rightSpeed);
        System.out.println("Magnitude: " + magnitude);

        Robot.driveBase.drive(Robot.oi.controller.getY(Hand.kLeft),//Y-Axis of left joystick
                              Robot.oi.controller.getY(Hand.kRight));//Y-Axis of right joystick
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
