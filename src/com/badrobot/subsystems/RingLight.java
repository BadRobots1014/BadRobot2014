/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.subsystems.interfaces.IRingLight;
import edu.wpi.first.wpilibj.Relay;

/**
 * The camera ring light subsystem for the prototype robot;
 * All camera ring light functionality code should go in this class.
 * @author Steve
 */
public class RingLight extends BadSubsystem implements IRingLight 
{
    private static RingLight instance;
    
    //Physical components of the ring light:
    Relay ringLightRelay;
    
    //Other variables:
    boolean isOn = false;
    
    /**
     * Gets the current instance of the subsystem;
     * If one doesn't exist, make one.
     * @return The current instance of this subsystem
     */
    public static RingLight getInstance()
    {
        if (instance == null)
        {
            instance = new RingLight();
        }
        return instance;
    }
    
    /**
     * Private constructor for an instance of the subsystem;
     * Required for the getInstace() method.
     */
    private RingLight()
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
    
    /**
     * Gets the current status of the ring light.
     * @return True if the ring light is on
     */
    public boolean ringLightIsOn()
    {
        return isOn;
    }

    /**
     * Gets the ring light object.
     * @return The relay that represents the ring light object
     */
    public Relay getRingLightRelay() {
        return ringLightRelay;
    }
}
