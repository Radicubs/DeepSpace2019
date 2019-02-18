/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.I2C;

public class PixySystem extends Subsystem {

    private static I2C Wire = new I2C(Port.kOnboard, 4);
    private static final int MAX_BYTES = 32;

    public String read(){
        byte[] data = new byte[MAX_BYTES];
        Wire.read(4, MAX_BYTES, data);
        String output = new String(data);
        int pt = output.indexOf((char)255);
        return (String) output.subSequence(0, pt < 0 ? 0 : pt);
    }

    public void initDefaultCommand() {
        
    }
}
