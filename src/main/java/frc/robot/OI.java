package frc.robot;/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
import frc.robot.commands.AutonomousDrive;


public class OI
{
    public XboxController controller = new XboxController(RobotMap.CONTROLLER);
    public Button buttonA = new JoystickButton(controller, 1);

    public OI() {
        //buttonA.whenPressed(new lineUp);
        buttonA.whenPressed(new AutonomousDrive());
        //Robot.autonomous = true and 
        //If Button press, change Robot.autonomous to true
        //buttonA.whenReleased(auto.);
    }
}
