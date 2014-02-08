
package com.badrobot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExampleSubsystem extends BadSubsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    protected void initialize() {
    }

    public String getConsoleIdentity() 
    {
        return "ExampleSubsystem";
    }
}

