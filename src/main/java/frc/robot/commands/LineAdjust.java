package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveBase;


public class LineAdjust extends Command {

    public enum LAState { SPEEDING, SLOWING, FINETUNING, FINISHED };
    double thetaAllowance = 5; // in degrees
    double speedAllowance = 0.5; // in degrees per timestep

    LAState state = LAState.SPEEDING;
    double theta;
    double lastTheta;
    double speed;

    public LineAdjust() {
        //requires is method that tells commands which subsystems will be using it
        //IT IS MANDATORY
        requires(Robot.driveBase);
    }


    @Override
    protected void initialize() {
        lastTheta = getTheta();
    }


    @Override
    protected void execute() {
        theta = getTheta();
        speed = getSpeed();

        updateState();
        updateMotors();

        lastTheta = theta;
    }

    private void updateState() {
        switch (state) {
            case SPEEDING:
            if (shouldFinetune())
                state = LAState.FINETUNING;
            else if (shouldSlow())
                state = LAState.SLOWING;
            break;

            case SLOWING:
            if (shouldFinetune())
                state = LAState.FINETUNING;            
            break;

            case FINETUNING:
                if (shouldFinish())
                    state = LAState.FINISHED;
                break;

            case FINISHED:
                break;
        }
    }

    private void updateMotors() {
        boolean turningRight = theta < 0;
        DriveBase db = Robot.driveBase;

        switch (state) {
            case SPEEDING:
            if (turningRight)
                db.drive(1, 1); //all these values may need to be reversed
            else
                db.drive(-1, -1);
            break;

            case SLOWING:
            if (turningRight)
                db.drive(-1, -1);
            else
                db.drive(1, 1);
            break;

            case FINETUNING:
            double value = finetuneValue();
            db.drive(value, value);
            break;

            case FINISHED:
            break;
        }
    }

    // something involving Pixy, should return a value within (-90, 90)
    private double getTheta() {
        return 0;
    }

    //figures out the angular speed based on last and current theta
    private double getSpeed() {
        // first handle the line crossing the horizontal
        if (theta < -45 && lastTheta > 45)
            return theta - lastTheta + 180;
        else if (lastTheta < -45 && theta > 45)
            return theta - lastTheta - 180;
        
        // normal case
        return theta - lastTheta;
    }

    // if aiming towards the target at full speed would result in passing
    // zero degrees within one timestep, this method should return true
    private boolean shouldFinetune() {
        return false;
    }

    // if reversing the motors now would result in an instantaneous stop
    // right after passing zero degrees, this method should return true
    private boolean shouldSlow() {
        return false;
    }

    // simply checks if theta and speed are within target bounds
    private boolean shouldFinish() {
        return Math.abs(theta) < thetaAllowance &&
               Math.abs(speed) < speedAllowance;
    }

    // returns the value that will get the robot's orientation closest to
    // zero degrees in one timestep
    private double finetuneValue() {
        return 0;
    }

    // don't know if this override is the way to go about it
    @Override
    protected boolean isFinished() {
        return state == LAState.FINISHED;
    }
}
