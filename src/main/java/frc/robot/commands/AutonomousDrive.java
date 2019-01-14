package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class AutonomousDrive extends Command {
    public AutonomousDrive() {
        requires(Robot.driveBase);
    }
    int i = 0;


    @Override
    protected void initialize() {
        Robot.autonomous = true;
        i = 0;
    }


    @Override
    protected void execute() {
        Robot.driveBase.drive(0.15, 0.15);
        i++;
    }

    @Override
    protected boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return (i >= 250);
    }


    @Override
    protected void end() {
        Robot.autonomous = false;
    }


    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
