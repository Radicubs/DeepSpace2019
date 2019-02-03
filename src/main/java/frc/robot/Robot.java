package frc.robot;
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
import frc.robot.OI;
import frc.robot.commands.*;


// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot 
{
    public static OI oi;
    public static DriveBase driveBase;
    public static CompressSystem compressSystem;
    public static UltrasonicSystem ultrasonicSystem;

    @Override
    public void robotInit() 
    {
        oi = new OI();
        driveBase = new DriveBase();
        compressSystem = new CompressSystem();
        CameraServer.getInstance().startAutomaticCapture();
        ultrasonicSystem = new UltrasonicSystem();
    }


    @Override
    public void disabledInit() 
    {
        
    }

    @Override
    public void disabledPeriodic() 
    {
        Scheduler.getInstance().run();
    }


    @Override
    public void autonomousInit() 
    {

    }


    @Override
    public void autonomousPeriodic() 
    {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() 
    {

    }


    @Override
    public void teleopPeriodic() 
    {
        OI.toggleAllButtons();

        if (OI.toggleOn0) {
            new PistonCommand();
        }

        Scheduler.getInstance().run();
    }


    @Override
    public void testPeriodic() 
    {
        
    }
}