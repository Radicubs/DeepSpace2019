/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hatchpanel;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LineAdjust extends Command {
  //Using Integers because they can be set to null
  int previousTheta = 0;
  Integer theta = 0;

  public Integer getTheta()
  {
    return 0;
  }

  public LineAdjust() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveBase);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    theta = getTheta();
    if(theta == null)
    {
      cancel();
    }    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    previousTheta = theta;
    theta = getTheta();
    if(theta == null){
        if(previousTheta < 0)
        {
          
        }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.ultrasonicSystem.getDistance() <= 5.0;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
