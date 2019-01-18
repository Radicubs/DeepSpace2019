package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class TankDrive extends Command {
    public TankDrive() {
        requires(Robot.driveBase);
    }

    double turningSpeed;


    @Override
    protected void initialize() {

    }


    @Override
    protected void execute() {
        turningSpeed = Robot.oi.controller.getX(Hand.kLeft);
        Robot.driveBase.drive(Robot.oi.controller.getY(Hand.kLeft), turningSpeed);
        //Robot.driveBase.drive(0.66, -0.66);
    
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
