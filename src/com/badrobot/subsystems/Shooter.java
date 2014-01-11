/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.subsystems.interfaces.IShooter;

/**
 *
 * @author Kyle
 */
public class Shooter extends BadSubsystem implements IShooter
{
    private static Shooter instance;
    
    
    
    public static Shooter getInstance()
    {
        if (instance == null)
        {
            instance = new Shooter();
        }
        return instance;
    }
    
    protected void initialize() 
    {
        if(!RobotMap.isPrototype)
        {
            
        }else
        {
            
        }
    }

    public String getConsoleIdentity() 
    {
        return "Shooter";
    
    }

    protected void initDefaultCommand() 
    {
    
    }

    public void launch() 
    {
    
    }
    
    
    public void cock() 
    {
        
    }

    public int getShooterAngle() 
    {
        return 1;
    }
    
}
