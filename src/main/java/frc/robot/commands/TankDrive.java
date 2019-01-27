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
        double rightSpeed = Robot.oi.controller.getY(Hand.kRight);

        double scalingExponent = 0.5f;
        //inverting these values make it work more intuitively
        double adjustedLSpeed = -adjustByExponent(leftSpeed, scalingExponent);
        double adjustedRSpeed = -adjustByExponent(rightSpeed, scalingExponent);
        

        System.out.println("Raw Left Speed: " + leftSpeed);
        System.out.println("Raw Right Speed: " + rightSpeed);
        System.out.println("Scaling Exponent: " + scalingExponent);

        Robot.driveBase.drive(adjustedLSpeed,//Y-Axis of left joystick
                              adjustedRSpeed);//Y-Axis of right joystick
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
