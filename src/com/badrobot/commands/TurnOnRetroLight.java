/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.subsystems.RetroLight;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Steve
 */
public class TurnOnRetroLight extends BadCommand {

    public TurnOnRetroLight()
    {
        requires((Subsystem) retroLight);
    }

    protected void initialize() 
    {
        retroLight.getRingLightRelay().set(Relay.Value.kOn);
    }

    public String getConsoleIdentity() 
    {
        return "TurnOnRetroLight";
    }

    protected void execute() 
    {
        if(!retroLight.ringLightIsOn())
        {
            retroLight.getRingLightRelay().set(Relay.Value.kOn);
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
