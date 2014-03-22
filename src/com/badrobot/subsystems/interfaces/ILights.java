/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.subsystems.interfaces;

/**
 *
 * @author Saajan
 */
public interface ILights extends Logger
{   
    /**
     * Convenience names for the integer cases
     * k for color.
     */
    public static final int kRed = 1,
                            kBlue = 2,
                            kGreen = 3,
                            kETech = 4,
                            kWhite = 5,
                            kYellow = 6,
                            strip_underglow = 1,
                            strip_body = 2,
                            strip_gatherer = 3;
    /**
     *  Turns on Lights
     */                        
    public void turnOn();
    
    /**
     *  Turns off Lights
     */                        
    public void turnOff();
    
    /**
     * Sets the color of the LEDs on the identified led strip.
     * @param id LED strip id
     * @param color predefined enumerable color
     */
    public void setColor(int id, int color);
    
    /**
     * ALL values are to be in between 0 and 255
     * @param r red
     * @param g green
     * @param b blue
     */
    public int encodeRGB(int id, int r, int g, int b);
    
    /**
     * Sets color of lights to predefined enumerable color
     * on the identified LED strip.
     * @param id LED strip id
     * @param color predefined enumerable color
     */
    public int encodeRGB(int id, int color);
    
    /**
     * Gets the current color.
     * @return current enumerated color as specified in interface
     */
    public int getColor();
}
