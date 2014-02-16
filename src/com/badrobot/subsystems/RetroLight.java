/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.BadSubsystem;
import com.badrobot.RobotMap;
import com.badrobot.subsystems.interfaces.IRetroLight;
import edu.wpi.first.wpilibj.Relay;

/**
 * The camera ring light subsystem for the prototype robot;
 * All camera ring light functionality code should go in this class.
 * @author Steve
 */
public class RetroLight extends BadSubsystem implements IRetroLight 
{
    private static RetroLight instance;
    
    Relay ringLightRelay;
    
    /**
     * Gets the current instance of the subsystem;
     * If one doesn't exist, make one.
     * @return The current instance of this subsystem
     */
    public static RetroLight getInstance()
    {
        if (instance == null)
        {
            instance = new RetroLight();
        }
        return instance;
    }
    
    /**
     * Private constructor for an instance of the subsystem;
     * Required for the getInstace() method.
     */
    private RetroLight()
    {
    }
    
    /**
     * Initializes the instance variables.
     */
    protected void initialize()
    {
        //ringLightRelay = new Relay(RobotMap.ringLightSwitchRelay);//2nd relay
    }

    /**
     * Returns the console identity, which is
     * generally the class name.
     * @return the class name
     */
    public String getConsoleIdentity()
    {
        return "RetroLight";
    }

    /**
     * Defines the default command for this subsystem.
     */
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
