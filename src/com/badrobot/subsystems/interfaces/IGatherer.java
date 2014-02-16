/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems.interfaces;

/**
 *
 * @author Isaac
 */
public interface IGatherer {
    
    public void gatherBall();
    
    public void ejectBall();
    
    public void stopGatherWheels();
    
    public void foldGatherer();
    
    public void extendGatherer();
    
    public boolean getOpticalSensorValue();
    
    public boolean isFolded();
}
