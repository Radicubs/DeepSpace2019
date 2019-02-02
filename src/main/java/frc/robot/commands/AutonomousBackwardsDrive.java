/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;


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

    while (Robot.ultrasonicSystem.getDistance() > 10) {
      Robot.driveBase.drive(-.5, -.5);
    }
    //Uses && so that it won't go backward constantly
    while (Robot.ultrasonicSystem.getDistance() > 20 && Robot.ultrasonicSystem.getDistance() < 30) {
      Robot.driveBase.drive(- 1, - 1);

    }

  }

}
