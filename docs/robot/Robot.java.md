# `Robot.java`

Here, we are going to declare a Robot. We do this by making a class `Robot` by extending
one of 4 other classes. The options are (here)[https://wpilib.screenstepslive.com/s/currentCS/m/java/l/599697-choosing-a-base-class].
We used TimedRobot for DeepSpace2019, but Command-based is better. (still think we should have done that).
So something like this:

```
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot
{
```

Create objects of your subsystems and initialize them. Our subsystems were DriveBase and CompressSystem.
We also had an additional one called OI.

```
    public static OI oi;
    public static DriveBase driveBase;
    public static CompressSystem compressSystem;

    @Override
    public void robotInit() 
    {
        driveBase = new DriveBase();
        compressSystem = new CompressSystem();
        CameraServer.getInstance().startAutomaticCapture();
        oi = new OI();          //make sure this is initialized after subsystem initialization, Sujay
    }
```
