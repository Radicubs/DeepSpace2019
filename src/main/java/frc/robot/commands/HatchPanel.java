/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.*;

public class HatchPanel extends CommandGroup {
  /**
   * Add your docs here.
   */
  public HatchPanel() {

    addSequential(new AutonomousForwardDrive());
    //addSequential(new ClapperOpener()); --- uncomment this when we have figured out how to automate the clapper.
    addSequential(new AutonomousBackwardsDrive());

  }
}
