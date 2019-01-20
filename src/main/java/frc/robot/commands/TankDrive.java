package frc.robot.commands;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;


public class TankDrive extends Command {

    private DifferentialDrive differentialDrive;

    public TankDrive(Spark left, Spark right) {
        requires(Robot.driveBase);
        differentialDrive = new DifferentialDrive(left, right);
    }

    double turningSpeed;


    @Override
    protected void initialize() {

    }


    @Override
    protected void execute() {
        //turningSpeed = Robot.oi.controller.getX(Hand.kLeft);
        //Robot.driveBase.drive(Robot.oi.controller.getY(Hand.kLeft), turningSpeed);
        differentialDrive.tankDrive(Robot.oi.controller.getY(Hand.kLeft) / 10,
            Robot.oi.controller.getY(Hand.kRight) / 10);
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
