/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
import com.badrobot.RobotMap;
import com.badrobot.XboxController;
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
    
    protected void initialize() 
    {
        gatherOn = false;
        rButtonPressed = false;
        lButtonPressed = false;
    }
    
    public String getConsoleIdentity() 
    {
        return "GatherBall";
    }

    protected void execute() 
    {
        //Used when two controllers will be used
        if (!OI.isSingleControllerMode())
        {
            if (OI.secondaryController.isRBButtonPressed())
            {
                gatherer.gatherBall(true, true);
            }
            else if (OI.secondaryController.isLBButtonPressed())
            {
                gatherer.gatherBall(true, false);
            }
            else
            {
                gatherer.gatherBall(false, true);
            }
        }
        //Used when one controller will be used
        else
        {
            if (OI.primaryController.isXButtonPressed())
            {
                rButtonPressed = true;
            }
            else if (!OI.primaryController.isXButtonPressed() && rButtonPressed)
            {
                if (!gatherOn)
                {
                    gatherer.gatherBall(true, true);
                    gatherOn = true;
                }
                else
                {
                    gatherer.gatherBall(false, true);
                    gatherOn = false;
                }
                rButtonPressed = false;
            }

            if (OI.primaryController.isYButtonPressed())
            {
                lButtonPressed = true;
            }
            else if (!OI.primaryController.isYButtonPressed() && lButtonPressed)
            {
                lButtonPressed = false;
                if (!gatherOn)
                {
                    gatherer.gatherBall(true, false);
                    gatherOn = true;
                }
                else
                {
                    gatherer.gatherBall(false, false);
                    gatherOn = false;
                }
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
