/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems.interfaces;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;

/**
 * Interface for the drive train subsystem;
 * 
 * @author Isaac
 */
public interface IDriveTrain 
{
    /**
     * Drives the robot in tank drive--two sticks represent the left and right
     * sides of the robot; pushing forward on the left stick moves the left side
     * forward, pushing backwards on the right stick moves the right side of the
     * robot backwards.
     * 
     * @param left the left side joystick value (-1 to 1)
     * @param right the right joystick value (-1 to 1)
     */
    public void tankDrive(double left, double right);
    
    /**
     * Shifts each of the two gear boxes on the robot's driveTrain; Up will
     * shift the robot to the higher gear, !up will shift the robot to a lower
     * gear.
     * 
     * @param up the direction of the shift
     */
    public void shift(boolean up);
    
    /**
     * Enables or disables the compressor; On is on, !on is off.
     * 
     * @param on the state of the compressor.
     */
    public void compressorEnabled(boolean on);
    
    /**
     * Returns the value that the pressure switch outputs; Will stay on until
     * the pressure reaches 115 psi, and then stay off until it drops to 95;
     * This lets us keep the pressure in a specific range.
     * 
     * @return the pressure switch output
     */
    public boolean getCompressorLimit();
    
    public Gyro getGyro();
    
    public Encoder getRightEncoder();
    
    public Encoder getLeftEncoder();
    
    public double getDistanceToWall();
}
