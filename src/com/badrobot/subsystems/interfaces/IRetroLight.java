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
public interface IRetroLight {
    
    public boolean ringLightIsOn();

    public Relay getRingLightRelay();
   
}
