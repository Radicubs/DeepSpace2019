/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.CompressorCommand;

public class CompressSystem extends Subsystem {

    private Compressor pneumaticCompressor;
    private Solenoid solenoidZero;

    public CompressSystem() {
        pneumaticCompressor = new Compressor(RobotMap.COMPRESSOR);
        solenoidZero = new Solenoid(RobotMap.SOLENOIDONE);
    }

    private boolean compressorBool = true;

    public void Compress() {
        compressorBool = !compressorBool;
        pneumaticCompressor.setClosedLoopControl(compressorBool);
    }

    private boolean currentSolenoidZero = false;

    public void solenoidZero() {
        currentSolenoidZero = !currentSolenoidZero;
        solenoidZero.set(currentSolenoidZero);
        System.out.println("Should've switched...");
    }

    public void initDefaultCommand() {
        setDefaultCommand(new CompressorCommand());
    }
}
