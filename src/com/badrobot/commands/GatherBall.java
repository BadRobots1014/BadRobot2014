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
public class GatherBall extends BadCommand
{
    
    public static boolean gatherOn, rButtonPressed, lButtonPressed; 
    
    public GatherBall()
    {
        requires ((Subsystem) gatherer);
    }
    
    /**
     * Sets values to the instance variables.
     */
    protected void initialize() 
    {
        gatherOn = false;
        rButtonPressed = false;
        lButtonPressed = false;
    }
    /**
     * Gets the console identity. Usually this 
     * is the class name.
     * @return the class name.
     */
    public String getConsoleIdentity() 
    {
        return "GatherBall";
    }

    /**
     * Stuff that will be getting called over and over again.
     */
    protected void execute() 
    {
        //Used when two controllers will be used
        if (!OI.isSingleControllerMode())
        {
            if (OI.secondaryController.isRBButtonPressed())
            {
                // turn gatherer on and move it forward
                // to gather balls
                gatherer.gatherBall();
            }
            else if (OI.secondaryController.isLBButtonPressed())
            {
                // turn gatherer on but
                // move it backwards
                gatherer.ejectBall();
            }
            else
            {
                // turn gatherer off
                gatherer.stopGatherer();
            }
            
            if (OI.secondaryController.isXButtonPressed())
            {
                gatherer.foldGatherer(true);
            }
            else if (OI.secondaryController.isYButtonPressed())
            {
                gatherer.foldGatherer(false);
            }
        }
        //Used when one controller will be used
        else
        {
            if (OI.primaryController.isRBButtonPressed())
            {
                rButtonPressed = true;
            }
            else if (!OI.primaryController.isRBButtonPressed() && rButtonPressed)
            {
                if (!gatherOn)
                {
                    gatherer.gatherBall();
                    gatherOn = true;
                }
                else
                {
                    gatherer.stopGatherer();
                    gatherOn = false;
                }
                rButtonPressed = false;
            }

            if (OI.primaryController.isLBButtonPressed())
            {
                lButtonPressed = true;
            }
            else if (!OI.primaryController.isLBButtonPressed() && lButtonPressed)
            {
                lButtonPressed = false;
                if (!gatherOn)
                {
                    gatherer.ejectBall();
                    gatherOn = true;
                }
                else
                {
                    gatherer.stopGatherer();
                    gatherOn = false;
                }
            }
            if (OI.primaryController.isXButtonPressed())
            {
                gatherer.foldGatherer(true);
            }
            else if (OI.primaryController.isYButtonPressed())
            {
                gatherer.foldGatherer(false);
            }
        }
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
