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
    
    /**
     * Rotates the gatherer wheels to pull the ball into the robot.
     */
    public void gatherBall();
    
    /**
     * Rotates the gatherer wheels to eject the ball out of the robot.
     */
    public void ejectBall();
    
    /**
     * Stops the gatherer wheels altogether.
     */
    public void stopGatherWheels();
    
    /**
     * Articulates the gatherer into the robot.
     */
    public void foldGatherer();
    
    /**
     * Articulates the gatherer to the extended position.
     */
    public void extendGatherer();
    
    /**
     * Gets the current boolean value of the optical sensor.
     * @return Optical sensor boolean value
     */
    public boolean getOpticalSensorValue();
    
    /**
     * Gives the current state of the gatherer articulation.
     * @return True if the gatherer is folded into the robot
     */
    public boolean isFolded();
}
