/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.subsystems;

import com.badrobot.subsystems.interfaces.ILights;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * The LED lights subsystem for the prototype robot;
 * All LED lights functionality code should go in this class.
 * @author Saaj
 */
public class Lights extends BadSubsystem implements ILights
{
    private static Lights instance;
    
    DigitalOutput redChannel;
    DigitalOutput greenChannel;
    DigitalOutput blueChannel;
    
    /**
     * Gets the current instance of the subsystem;
     * If one doesn't exist, make one.
     * @return The current instance of this subsystem
     */
    public static Lights getInstance()
    {
        if (instance == null)
        {
            instance = new Lights();
        }
        return instance;
    }
    
    private int currentColor = 0;
    
    /**
     * Private constructor for an instance of the subsystem;
     * Required for the getInstace() method.
     */
    private Lights()
    {
    }
    
    /**
     * Initializes the instance variables.
     */
    protected void initialize() 
    {
        redChannel = new DigitalOutput(getRobotMap().getRedChannelPort());
        greenChannel = new DigitalOutput(getRobotMap().getGreenChannelPort());
        blueChannel = new DigitalOutput(getRobotMap().getBlueChannelPort());
        
        redChannel.enablePWM(0);
        greenChannel.enablePWM(0);
        blueChannel.enablePWM(0);
    }

    /**
     * Returns the console identity, which is
     * generally the class name.
     * @return the class name
     */
    public String getConsoleIdentity()
    {
        return "Decorative LED Lights";
    }
    
    /**
     * Defines the default command for this subsystem.
     */
    protected void initDefaultCommand() {
    }
    
    public static double byteToPWM(int Color)
    {
        double bytePercent = (double) ((double) Color / 255);
        double pwmValue = (bytePercent*1);
        return pwmValue;
    }
    
    /**
     *  Turns on Lights
     */  
    public void turnOn()
    {
        setColor(ILights.kETech);
    }

    /**
     *  Turns off Lights
     */   
    public void turnOff()
    {
        redChannel.updateDutyCycle(0);
        greenChannel.updateDutyCycle(0);
        blueChannel.updateDutyCycle(0);
    }

    /**
     * ALL values are to be in between 0 and 255
     * @param r red
     * @param g green
     * @param b blue
     */
    public void setColor(int r, int g, int b)
    {
        redChannel.updateDutyCycle(byteToPWM(Math.abs(r)));
        greenChannel.updateDutyCycle(byteToPWM(Math.abs(g)));
        blueChannel.updateDutyCycle(byteToPWM(Math.abs(b)));
    }

    /**
     * Sets color of lights to predefined enumerable color
     * @param color predefined enumerable color
     */
    public void setColor(int color)
    {
        switch(color)
        {
            case(ILights.kBlue):
                setColor(0,0,255);
                break;
            case(ILights.kRed):
                setColor(255,0,0);
                break;
            case(ILights.kGreen):
                setColor(0,255,0);
                break;
            case(ILights.kWhite):
                setColor(255,255,255);
                break;
            case(ILights.kYellow):
                setColor(255,255,0);
                break;
            case(ILights.kETech):
                setColor(255,0,255);
                break;
                        }
        currentColor = color;
    }

    /**
     * Gets the current color.
     * @return current enumerated color as specified in interface
     */
    public int getColor()
    {
        return currentColor;
    }
}
