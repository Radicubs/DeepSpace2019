/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands.hatchpanel;


import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class AutonomousBackwardsDrive extends InstantCommand {
  /**
   * Add your docs here.
   */
  public AutonomousBackwardsDrive() {
    super();
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes

  @Override
  protected void initialize() {
    //Pseudo PID; Takes distance from getDistance() and divides by constant of 20. So as we get closer, we go slower
    while (Robot.ultrasonicSystem.getDistance() < 30) {
      Robot.driveBase.drive(Robot.ultrasonicSystem.getDistance()/-20, Robot.ultrasonicSystem.getDistance()/-20 );
    }
    
    }

  }
