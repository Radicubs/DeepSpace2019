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
    public static final int LEFT_TALON = 6;
    public static final int LEFT_FOLLOWER_ONE = 4;
    public static final int LEFT_FOLLOWER_TWO = 2;

    public static final int RIGHT_TALON = 7;
    public static final int RIGHT_FOLLOWER_ONE = 5;
    public static final int RIGHT_FOLLOWER_TWO = 3;
    
    //CONTROLLER
    //public static final int CONTROLLER = 0;

    //JOYSTICKS
    public static final int JOYSTICK = 0;

    //JOYSTICK AXES
    public static final int LEFTXAXIS = 0;
    public static final int LEFTYAXIS = 1;
    public static final int RIGHTXAXIS = 4;
    public static final int RIGHTYAXIS = 5;

    //BUTTONS
    public static final int XBUTTON = 1;
    public static final int ABUTTON = 2;
    public static final int BBUTTON = 3;
    public static final int YBUTTON = 4;
    public static final int LBBUTTON = 5;
    public static final int RBBUTTON = 6;
    public static final int LTBUTTON = 7;
    public static final int RTBUTTON = 8;
    public static final int GOBACKBUTTON = 9;
    public static final int STARTBUTTON = 10;
    public static final int CLICKLEFTJOYSTICK = 11;
    public static final int CLICKRIGHTJOYSTICK = 12;

    //COMPRESSOR
    public static final int COMPRESSOR = 0;

    //SOLENOIDS
    public static final int SOLENOIDZERO = 0;
    public static final int SOLENOIDONE = 1;

    //ULTRASONIC SENSOR PORTS
    public static final int ULTRASONIC = 0;

    //PID Drive Constants
    public static final double kP = 20.0;
    public static final double kI = 0.0;
    public static final double kD = 0.0;


    //BUTTONS ARE MESSED UP -_-
    //Robot.oi.controller.getAbutton() ==> actually controllers X button
    //Robot.oi.controller.getBbutton() ==> actually controllers A button
    //Robot.oi.controller.getXbutton() ==> actually controllers B button
    //Robot.oi.controller.getYbutton() ==> actually controllers Y button

}