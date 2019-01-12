package frc.robot;/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


import edu.wpi.first.wpilibj.XboxController;

public class OI
{
    public XboxController controller;

    public OI() {
        controller = new XboxController(RobotMap.CONTROLLER);
    }
}
