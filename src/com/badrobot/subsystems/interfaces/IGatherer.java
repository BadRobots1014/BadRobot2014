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
    
    public void stopGatherer();
    
    public void foldGatherer(boolean pull);  
    
    public boolean getOpticalSensorValue();
    
    public boolean isFolded();
}
