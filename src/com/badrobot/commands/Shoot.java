/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Isaac
 */
public class Shoot extends BadCommand
{
    private static double COCK_BACK_SPEED = 0.5;

    public Shoot()
    {
        requires((Subsystem) shooter);
    }
    
    protected void initialize() 
    {
        shooter.engageWinch();
    }

    public String getConsoleIdentity() 
    {
        return "Shoot";
    }

    protected void execute() 
    {
        if (OI.primaryController.isAButtonPressed())
        {
            shooter.cockBack(COCK_BACK_SPEED);
        }
        else
        {
            shooter.cockBack(0);
        }
        
        if (OI.primaryController.isBButtonPressed())
        {
            shooter.disengageWinch();
        }
        else
        {
            shooter.engageWinch();
        }
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
        
    }

    protected void interrupted() 
    {
        
    }
    
}
