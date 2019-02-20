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
  final double maxMotorOutput = 0.3;
  
  int thetaAllowance = 2;
  
  //Using Integers because they can be set to null
  int previousTheta = 0;
  Integer theta = 0;

  public Integer getTheta()
  {
    //return 0;
    return Integer.parseInt(Robot.pixySystem.read());
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
    
    if(theta == null){//Does not see the line
      if(previousTheta < 0)//Needs to turn right
      {
        Robot.driveBase.drive(maxMotorOutput, -maxMotorOutput);
      }
      else
      {
        Robot.driveBase.drive(-maxMotorOutput, maxMotorOutput); 
      }
    }
    else //sees the line
    {
      if(theta < 0)//turning right
      {
        Robot.driveBase.drive(maxMotorOutput, maxMotorOutput*(-theta)/90.0);
      }
      else//turning left
      {
        Robot.driveBase.drive(maxMotorOutput*theta/90.0, maxMotorOutput);
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
