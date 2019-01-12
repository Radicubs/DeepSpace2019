package frc.robot;/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


import edu.wpi.first.wpilibj.Joystick;

public class OI
{
    public static final double JOY_DEADZONE = 0.05;
    public final Joystick LEFT_JOYSTICK = new Joystick(RobotMap.LEFT_MOTOR);
    public final Joystick RIGHT_JOYSTICK = new Joystick(RobotMap.RIGHT_MOTOR);

    public double getLeftJoyY() {
        double raw = LEFT_JOYSTICK.getY();
        return Math.abs(raw) > JOY_DEADZONE ? raw : 0.0;
    }

    public double getRightJoyY() {
        double raw = RIGHT_JOYSTICK.getY();
        return Math.abs(raw) > JOY_DEADZONE ? raw : 0.0;
    }

    public OI() {
    }
}
