/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CompressorCommand extends Command {
    public CompressorCommand() {
        requires(Robot.compressSystem);
    }
    @Override
    protected void initialize() {

    }

    boolean stopOrNot = false;

    // Called repeatedly when this Command is scheduled to run
    // Compresses the compressor and fills up air tank
    @Override
    protected void execute() {
        Robot.compressSystem.Compress();
        stopOrNot = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return stopOrNot;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
