/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.hatchpanel.HatchPanel;
import edu.wpi.first.wpilibj.buttons.Button;

public class OI
{
    public static Joystick controller;
    public static Button aButton;
    public static Button xButton;
    public static Button yButton;

    public static boolean toggleA = false;
    public static boolean toggleX = false;

    public OI() {
        controller = new Joystick(RobotMap.JOYSTICK);
        aButton = new JoystickButton(controller, RobotMap.ABUTTON);
        xButton = new JoystickButton(controller, RobotMap.XBUTTON);
        yButton = new JoystickButton(controller, RobotMap.YBUTTON);
        yButton.whenPressed(new HatchPanel());
    }
}