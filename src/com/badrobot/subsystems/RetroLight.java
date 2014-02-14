/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.subsystems.interfaces.IRetroLight;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Steve
 */
public class RetroLight extends BadSubsystem implements IRetroLight {

    Relay ringLightRelay;
    
    private static RetroLight instance;
    
    public static RetroLight getInstance()
    {
        if (instance == null)
        {
            instance = new RetroLight();
        }
        return instance;
    }
    
    protected void initialize()
    {
        //ringLightRelay = new Relay(RobotMap.ringLightSwitchRelay);//2nd relay
    }

    public String getConsoleIdentity()
    {
        return "RetroLight";
    }

    protected void initDefaultCommand() {
    }
    
    public boolean ringLightIsOn()
    {   
        boolean isHot = false;
        if(ringLightRelay.get() == Relay.Value.kOff)
            isHot = false;
        else if(ringLightRelay.get() == Relay.Value.kOn)
            isHot = true;
        
        return isHot;
    }

    public Relay getRingLightRelay() {
        return ringLightRelay;
    }
}
