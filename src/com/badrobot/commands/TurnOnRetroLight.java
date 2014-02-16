/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.BadCommand;
import com.badrobot.subsystems.RingLight;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Steve
 */
public class TurnOnRetroLight extends BadCommand {

    public TurnOnRetroLight()
    {
        requires((Subsystem) ringLight);
    }

    protected void initialize() 
    {
        ringLight.getRingLightRelay().set(Relay.Value.kOn);
    }

    public String getConsoleIdentity() 
    {
        return "TurnOnRetroLight";
    }

    protected void execute() 
    {
        if(!ringLight.ringLightIsOn())
        {
            ringLight.getRingLightRelay().set(Relay.Value.kOn);
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
