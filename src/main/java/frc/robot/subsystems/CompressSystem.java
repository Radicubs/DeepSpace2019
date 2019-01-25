/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CompressorCommand;

public class CompressSystem extends Subsystem {

    private Compressor pneumaticCompressor;

    public CompressSystem() {
        pneumaticCompressor = new Compressor(RobotMap.COMPRESSOR);
    }

    private boolean current = false;

    public void Compress() {
        current = !current;
        pneumaticCompressor.setClosedLoopControl(current);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new CompressorCommand());
    }
}
