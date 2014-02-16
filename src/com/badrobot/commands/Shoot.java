/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.BadCommand;
import com.badrobot.OI;
import com.badrobot.RobotMap;
import com.badrobot.XboxController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Isaac
 */
public class Shoot extends BadCommand
{
    private static double COCK_BACK_SPEED = 1.0;
    private Timer timer;

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
            //Cock shooter with A, release with B
            controlWinch(OI.secondaryController);
        }
        //Used when one controller will be used
        else
        {
            //Cock shooter with A, release with B
            controlWinch(OI.primaryController);
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
    
    private void controlWinch(XboxController controller)
    {
        if (controller.isAButtonPressed())
        {
            shooter.cockBack(COCK_BACK_SPEED);
        }
        else
        {
            shooter.cockBack(0);
        }
        
        if (controller.isBButtonPressed() && !gatherer.isFolded())
        {
            timer.start();
            shooter.disengageWinch();
        }
        else if (timer.get() > 1)
        {
            shooter.engageWinch();
        }
    }
}
