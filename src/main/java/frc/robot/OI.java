/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.DriveTillWall;
import edu.wpi.first.wpilibj.buttons.Button;

public class OI
{
    public static Joystick driveJoystick;
    public static Button yButton;

    public OI() {
        driveJoystick = new Joystick(RobotMap.JOYSTICK);
        yButton = new JoystickButton(driveJoystick, RobotMap.YBUTTON);
        yButton.whenPressed(new DriveTillWall());
    }

    public static void toggleAllButtons() {
        toggleXbutton();
        toggleAbutton();
        toggleBbutton();
    }

    //toggleXbutton allows for a single press of the X button to signal whatever in code
    public static boolean toggleOnX = false;
    private static boolean togglePressed1 = false;

    public static void toggleXbutton() {
        if (driveJoystick.getRawButtonPressed(RobotMap.XBUTTON)) {
            if (!togglePressed1) {
                toggleOnX = !toggleOnX;
                togglePressed1 = true;
            }
            else {
                togglePressed1 = false;
            }
        }
    }

    public static boolean toggleOnA = false;
    private static boolean togglePressed2 = false;

    public static void toggleAbutton() {
        if (driveJoystick.getRawButtonPressed(RobotMap.ABUTTON)) {
            if (!togglePressed2) {
                toggleOnA = !toggleOnA;
                togglePressed2 = true;
            }
            else {
                togglePressed2 = false;
            }
        }
    }

    public static boolean toggleOnB = false;
    private static boolean togglePressed3 = false;

    public static void toggleBbutton() {
        if (driveJoystick.getRawButtonPressed(RobotMap.BBUTTON)) {
            if (!togglePressed3) {
                toggleOnB = !toggleOnB;
                togglePressed3 = true;
            }
            else {
                togglePressed3 = false;
            }
        }
    }
}
