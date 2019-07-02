#RobotMap.java

RobotMap is a place where you map the different devices of the robot based on the respective mappings on the 
circuitry. You can figure out the mappings by using a software known as PhoneixTuner. These mappings should
initialized as public static final int. These final varaibles will be accessed throughout the rest of the project
as needed.

```
public class RobotMap
{
    //PWM MOTORS
    public static final int LEFT_TALON = 6;
    public static final int LEFT_FOLLOWER_ONE = 4;
    public static final int LEFT_FOLLOWER_TWO = 2;

    public static final int RIGHT_TALON = 7;
    public static final int RIGHT_FOLLOWER_ONE = 5;
    public static final int RIGHT_FOLLOWER_TWO = 3;

    ...

    //ULTRASONIC SENSOR PORTS
    public static final int ULTRASONIC = 0;

}

```