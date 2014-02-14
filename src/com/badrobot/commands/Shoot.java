/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
import com.badrobot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Isaac
 */
public class Shoot extends BadCommand
{
    private static double COCK_BACK_SPEED = 1.0;

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
        //Used when two controllers will be used
        if (!OI.isSingleControllerMode())
        {
            if (OI.secondaryController.isAButtonPressed())
            {
                shooter.cockBack(COCK_BACK_SPEED);
            }
            else
            {
                shooter.cockBack(0);
            }

            if (OI.secondaryController.isBButtonPressed())
            {
                shooter.disengageWinch();
            }
            else
            {
                shooter.engageWinch();
            }
        }
        //Used when one controller will be used
        else
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
