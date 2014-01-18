/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.subsystems.interfaces.IDriveTrain;

/**
 *
 * @author Isaac
 */
public class DriveTrain extends BadSubsystem implements IDriveTrain
{
    public static DriveTrain instance;
    
    public static DriveTrain getInstance()
    {
        if (instance == null)
        {
            instance = new DriveTrain();
        }
        return instance;
    }
    
    private DriveTrain()
    {
        
    }

    protected void initialize() 
    {
    }

    public String getConsoleIdentity() 
    {
        return "DriveTrain";
    }

    protected void initDefaultCommand() 
    {
    }

    public void tankDrive(double left, double right) 
    {
        
    }
    
}
