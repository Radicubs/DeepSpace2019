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

        double leftWheels = Robot.oi.controller.getRawAxis(1);
        double rightWheels = Robot.oi.controller.getRawAxis(5);

        double scalingExponent = 0.5f;
        //inverting these values make it work more intuitively
        double adjustedLSpeed = -adjustByExponent(leftWheels, scalingExponent);
        double adjustedRSpeed = -adjustByExponent(rightWheels, scalingExponent);
        
        //System.out.println("Tank Drive");
        //System.out.println("Raw Left Speed: " + leftWheels);
        //System.out.println("Raw Right Speed: " + rightWheels);
        //System.out.println("Scaling Exponent: " + scalingExponent);

        //Robot.driveBase.drive(leftWheels,//Y-Axis of left joystick
        //                      -1 * leftWheels);//Y-Axis of right joystick
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
