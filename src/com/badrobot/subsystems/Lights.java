/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.subsystems.interfaces.ILights;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 *
 * @author Saaj
 */
public class Lights implements ILights
{

    DigitalOutput redChannel;
    DigitalOutput greenChannel;
    DigitalOutput blueChannel;
    
    private static Lights instance;
    
    public static Lights getInstance()
    {
        if (instance == null)
        {
            instance = new Lights();
        }
        return instance;
    }
    
    private int currentColor = 0;
    
    private Lights()
    {
        redChannel = new DigitalOutput(RobotMap.redChannel);
        greenChannel = new DigitalOutput(RobotMap.greenChannel);
        blueChannel = new DigitalOutput(RobotMap.blueChannel);
        
        redChannel.enablePWM(0);
        greenChannel.enablePWM(0);
        blueChannel.enablePWM(0);
    }
    
    public String getConsoleIdentity()
    {
        return "Decorative LED Lights";
    }
    
    public static double byteToPWM(int Color)
    {
        double bytePercent = (double) ((double) Color / 255);
        double pwmValue = (bytePercent*1);
        return pwmValue;
    }
    
    public void turnOn()
    {
        setColor(ILights.kETech);
    }

    public void turnOff()
    {
        redChannel.updateDutyCycle(0);
        greenChannel.updateDutyCycle(0);
        blueChannel.updateDutyCycle(0);
    }

    public void setColor(int r, int g, int b)
    {
        redChannel.updateDutyCycle(byteToPWM(Math.abs(r)));
        greenChannel.updateDutyCycle(byteToPWM(Math.abs(g)));
        blueChannel.updateDutyCycle(byteToPWM(Math.abs(b)));
    }

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

    public int getColor()
    {
        return currentColor;
    }

    public void log(String out)
    {
        
    }
    
}
