package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.AttackWall;

public class UltrasonicSystem extends Subsystem {

    public static AnalogInput mb1013 = new AnalogInput(0);
    public static double VOLTS_TO_DIST = 38.71;   //38.71


    public void initDefaultCommand() {
       //setDefaultCommand(new AttackWall());
    }


    public double getVoltage() {
        return mb1013.getVoltage();
    }
      
    public double getDistance() {
        return getVoltage() * VOLTS_TO_DIST;
    }


    public void stop() {}
}
