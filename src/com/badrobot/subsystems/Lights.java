/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.subsystems.interfaces.ILights;
import edu.wpi.first.wpilibj.DigitalModule;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.I2C;

/**
 * The LED lights subsystem for the prototype robot;
 * All LED lights functionality code should go in this class.
 * @author Saaj
 */
public class Lights extends BadSubsystem implements ILights
{
    private static Lights instance;
    private final int address = 168;
    private int currentColor;
    DigitalModule digiMod;
    I2C led;
    
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
        currentColor = 0;
        digiMod = DigitalModule.getInstance(1);
        led = digiMod.getI2C(address);
        led.free();
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
    protected void initDefaultCommand() 
    {
    }
    
    /**
     *  Turns on Lights
     */  
    public void turnOn()
    {
        setColor(ILights.strip_body, ILights.kETech);
        setColor(ILights.strip_gatherer, ILights.kETech);
        setColor(ILights.strip_underglow, ILights.kETech);
    }

    /**
     *  Turns off Lights
     */   
    public void turnOff()
    {
        led.write(address, encodeRGB(ILights.strip_body, 0));
        led.write(address, encodeRGB(ILights.strip_gatherer, 0));
        led.write(address, encodeRGB(ILights.strip_underglow, 0));
    }
    
    public void setColor(int id, int color) 
    {
        led.write(address, encodeRGB(id, color));
    }

    public int encodeRGB(int id, int r, int g, int b) 
    {
        return -1;
    }

    public int encodeRGB(int id, int color) 
    {
        currentColor = color;
        id = id<<4;
        id += color;
        return id;
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
