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
     */
    public static final int kBlue = 0,
                            kRed = 1,
                            kGreen = 2,
                            kWhite = 3,
                            kYellow = 4,
                            kGold = 5,
                            kETech = 6;
    /**
     *  Turns on Lights
     */                        
    public void turnOn();
    
    /**
     *  Turns off Lights
     */                        
    public void turnOff();
    
    /**
     * ALL values are to be in between 0 and 255
     * @param r red
     * @param g green
     * @param b blue
     */
    public void setColor(int r, int g, int b);
    
    /**
     * Sets color of lights to predefined enumerable color
     * @param color predefined enumerable color
     */
    public void setColor(int color);
    
    /**
     * Gets the current color.
     * @return current enumerated color as specified in interface
     */
    public int getColor();
}
