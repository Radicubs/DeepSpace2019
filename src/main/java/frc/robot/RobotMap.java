package frc.robot;
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

public class RobotMap
{
    //PWM MOTORS
    public static final int LEFT_TALON = 7;
    public static final int LEFT_FOLLOWER_ONE = 5;
    public static final int LEFT_FOLLOWER_TWO = 3;

    public static final int RIGHT_TALON = 6;
    public static final int RIGHT_FOLLOWER_ONE = 2;
    public static final int RIGHT_FOLLOWER_TWO = 4;
    
    //CONTROLLER
    //public static final int CONTROLLER = 0;

    //JOYSTICKS
    public static final int JOYSTICK = 0;

    //BUTTONS
    public static final int XBUTTON = 0;
    public static final int ABUTTON = 1;
    public static final int BBUTTON = 2;
    public static final int YBUTTON = 3;
    public static final int LBBUTTON = 4;
    public static final int RBBUTTON = 5;
    public static final int LTBUTTON = 6;
    public static final int RTBUTTON = 7;
    public static final int GOBACKBUTTON = 8;
    public static final int STARTBUTTON = 9;
    public static final int CLICKLEFTJOYSTICK = 10;
    public static final int CLICKRIGHTJOYSTICK = 11;

    //COMPRESSOR
    public static final int COMPRESSOR = 0;

    //SOLENOIDS
    public static final int SOLENOIDZERO = 0;
    public static final int SOLENOIDONE = 1;

    //ULTRASONIC SENSOR PORTS
    public static final int ULTRASONIC = 0;

    //PID Drive Constants
    public static final double kP = 0.0;
    public static final double kI = 0.0;
    public static final double kD = 0.0;


    //BUTTONS ARE MESSED UP -_-
    //Robot.oi.controller.getAbutton() ==> actually controllers X button
    //Robot.oi.controller.getBbutton() ==> actually controllers A button
    //Robot.oi.controller.getXbutton() ==> actually controllers B button
    //Robot.oi.controller.getYbutton() ==> actually controllers Y button

}
