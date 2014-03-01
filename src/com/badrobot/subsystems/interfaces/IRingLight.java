/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems.interfaces;

import edu.wpi.first.wpilibj.Relay;


/**
 *
 * @author Steve
 */
public interface IRingLight {
    
    /**
     * Gets the current status of the ring light.
     * @return True if the ring light is on
     */
    public boolean ringLightIsOn();

    /**
     * Gets the ring light object.
     * @return relay that represents the ring light object
     */
    public Relay getRingLightRelay();
   
}
