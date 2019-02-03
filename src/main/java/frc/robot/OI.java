/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.*;

public class OI
{
    //public XboxController controller;
    public static Joystick joystick;

    public OI() {
        //controller = new XboxController(RobotMap.CONTROLLER);
        joystick = new Joystick(RobotMap.JOYSTICK);
    }

    public static void toggleAllButtons() {
        toggleXbutton();
    }

    //toggleButton1 allows for a single press of a button to signal whatever in code
    static boolean toggleOn0 = false;
    static boolean togglePressed0 = false;

    public static void toggleXbutton() {
        if (joystick.getRawButton(RobotMap.XBUTTON)) {
            if (!togglePressed0) {
                toggleOn0 = !toggleOn0;
                togglePressed0 = true;
            }
            else {
                togglePressed0 = false;
            }
        }
    }

}
