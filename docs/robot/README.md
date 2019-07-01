If you're going to read one doc, read this one!

Robot code works this way:
You have one Robot...     
...that starts Subsystems...
...that (if idle) start default commands...
...that do actions...
...that are updated every 2 milliseconds. 

That's the entire robot in one run on sentence.
Let's look at our driving as an example. `Robot.java` starts subsystem `DriveBase.java`.
`DriveBase.java` defines `ArcadeDrive.java` as it's default command.

```
    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }
```

This will automatically start our ArcadeDrive. ArcadeDrive.java will **require** the subsystems it needs and then run method `execute` every 2 milliseconds. Inside `execute` we get our controller data, do some fancy math, and then assign values to motors. This way, our controller input is constantly being monitered.


