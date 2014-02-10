/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.subsystems.RetroLight;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Steve
 */
public class TurnOnRetroLight extends BadCommand {
    private RetroLight rt;

    protected void initialize() 
    {
        rt = rt.getInstance();
    }

    public String getConsoleIdentity() 
    {
        return "TurnOnRetroLight";
    }

    protected void execute() 
    {
        if(!rt.ringLightIsOn())
        {
            rt.ringLightRelay.set(Relay.Value.kOn);
        }
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    
}
