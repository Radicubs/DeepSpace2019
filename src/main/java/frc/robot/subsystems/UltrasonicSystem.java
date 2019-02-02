package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class UltrasonicSystem extends Subsystem {

    public static AnalogInput mb1013 = new AnalogInput(0);
    static double VOLTS_TO_DIST = 1.0;


    public void initDefaultCommand() {}


    public double getVoltage() {
        return mb1013.getVoltage();
    }
      
    public double getDistance() {
        return getVoltage() * VOLTS_TO_DIST;
    }


    public void stop() {}
}
