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

    public GatherBall()
    {
        requires ((Subsystem) gatherer);
    }
    
    protected void initialize() 
    {
        
    }

    public String getConsoleIdentity() 
    {
        return "GatherBall";
    }

    protected void execute() 
    {
        if (OI.primaryController.isXButtonPressed())
        {
            gatherer.gathererBall(1);
        }
        else if (OI.primaryController.isYButtonPressed())
        {
            gatherer.gathererBall(2);
        }
        else
        {
            gatherer.gathererBall(0);
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
