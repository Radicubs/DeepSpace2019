/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.GearShift;
import frc.robot.commands.Left;
import frc.robot.commands.Right;
import frc.robot.commands.ASevenInch;
import frc.robot.commands.AttackWall;
import frc.robot.commands.Clapper;
import edu.wpi.first.wpilibj.buttons.Button;

public class OI
{
    public static Joystick controller = new Joystick(RobotMap.JOYSTICK);
    public static Button aButton = new JoystickButton(controller, RobotMap.ABUTTON);
    public static Button xButton = new JoystickButton(controller, RobotMap.XBUTTON);
    //public static Button yButton = new JoystickButton(controller, RobotMap.YBUTTON);
    public static Button bButton = new JoystickButton(controller, RobotMap.BBUTTON);

    public static Button leftButton = new JoystickButton(controller, RobotMap.LBBUTTON);
    public static Button rightButton = new JoystickButton(controller, RobotMap.RBBUTTON);


    public OI() {
        aButton.whenPressed(new ASevenInch());
        bButton.whenPressed(new GearShift());
        xButton.whenPressed(new Clapper());
        //yButton.whenPressed(new AttackWall())
    }
}
