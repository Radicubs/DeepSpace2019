/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class PistonMovement extends InstantCommand {
    String function;

    public PistonMovement() {
        requires(Robot.compressSystem);  
    }
    @Override
    protected void initialize() {
        if (Robot.oi.toggleOnX) {
            Robot.compressSystem.PistonMovement();
            Robot.oi.toggleOnX = false;
        }
        if (Robot.oi.toggleOnA) {
            Robot.compressSystem.Compress();
            Robot.oi.toggleOnA = false;
        }
        if(Robot.compressSystem.solenoidOne.get())
        {
            Robot.compressSystem.solenoidZero.set(true);
            Robot.compressSystem.solenoidOne.set(false);
        }
        else
        {
            Robot.compressSystem.solenoidZero.set(false);
            Robot.compressSystem.solenoidOne.set(true);
        }
    }


    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        super.interrupted();
    }
}
