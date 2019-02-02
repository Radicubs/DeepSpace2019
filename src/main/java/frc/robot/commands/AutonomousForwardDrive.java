package frc.robot.commands;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class AutonomousForwardDrive extends InstantCommand 
{
  /**
   * Add your docs here.
   */
  public AutonomousForwardDrive() {
    super();
    requires(Robot.driveBase);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {
    
    
    while (Robot.ultrasonicSystem.getDistance() > 20) {
      Robot.driveBase.drive(.5, .5);
    }
    // Made it 11 because Ultrasonic outputs are always greater than 10; Made it to
    // where it won't constantly go forward
    while (Robot.ultrasonicSystem.getDistance() > 11) {
      Robot.driveBase.drive(.25, .25);  
    }

  }
}

