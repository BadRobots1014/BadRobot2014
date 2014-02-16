/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems.interfaces;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;

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
     * Shifts both sides of the drive train into high gear.
     */
    public void shiftUp();
    
    /**
     * Shifts both sides of the drive train into low gear.
     */
    public void shiftDown();
    
    /**
     * Gets the gyro.
     * @return The gyro object
     */
    public Gyro getGyro();
    
    /**
     * Gets the right encoder.
     * @return The right encoder object
     */
    public Encoder getRightEncoder();
    
    /**
     * Gets the left encoder.
     * @return The left encoder object
     */
    public Encoder getLeftEncoder();
    
    /**
     * Gets the distance to the wall using the ultrasonic sensor.
     * @return The distance to wall in inches
     */
    public double getDistanceToWall();
    
    /**
     * Gets the train object of the drive train.
     * @return The train object
     */
    public RobotDrive getTrain();
    
    /**
     * Gets the drive train encoder distance per pulse;
     * This is used to calibrate the encoder distance per pulse.
     * @return The encoder distance per pulse value
     */
    public double getEncoderDistancePerPulse();
    
    /**
     * Sets the drive train encoder distance per pulse;
     * This is used to calibrate the encoder distance per pulse.
     * @param d The value to set the distance per pulse to
     */
    public void setEncoderDistancePerPulse(double d);
}
