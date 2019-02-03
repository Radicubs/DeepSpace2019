/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class OI
{
    //public XboxController controller;
    public static Joystick joystick;

    public OI() {
        //controller = new XboxController(RobotMap.CONTROLLER);
        joystick = new Joystick(RobotMap.JOYSTICK);
    }

    public static void toggleAllButtons() {
        toggleButton1();
    }

    //toggleButton1 allows for a single press of a button to signal whatever in code
    static boolean toggleOn1 = false;
    static boolean togglePressed1 = false;

    public static void toggleButton1() {
        if (joystick.getRawButton(0)) {
            if (!togglePressed1) {
                toggleOn1 = !toggleOn1;
                togglePressed1 = true;
            }
            else {
                togglePressed1 = false;
            }
        }
    }

}
