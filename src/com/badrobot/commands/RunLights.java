/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.subsystems.interfaces.ILights;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Sets the lights to run at the specified color (all colors and values 
 * are listed in the DecorativeLights subsystem.
 * 
 * @author Jon Buckley
 */
public class RunLights extends BadCommand
{
    int color = 0;
    public RunLights(int color)
    {
        this.color = color;
        requires((Subsystem) lights);
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
        lights.setColor(ILights.strip_body, color);
        lights.setColor(ILights.strip_gatherer, color);
        lights.setColor(ILights.strip_underglow, color);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
    }

    public String getConsoleIdentity() {
        return "RunLights";
    }
}
