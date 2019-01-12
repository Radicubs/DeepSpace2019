package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class TankDrive extends Command {
    public TankDrive() {
        requires(Robot.driveBase);
    }



    @Override
    protected void initialize() {

    }


    @Override
    protected void execute() {
        Robot.driveBase.drive(Robot.oi.controller.getY(Hand.kLeft), Robot.oi.controller.getY(Hand.kRight));
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
