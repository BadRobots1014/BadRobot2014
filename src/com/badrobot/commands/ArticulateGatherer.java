/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.BadCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Isaac
 */
public class ArticulateGatherer extends BadCommand
{
    boolean finished, extendPosition;
    
    public ArticulateGatherer(boolean out)
    {
        requires((Subsystem) gatherer);
        extendPosition = out;
    }

    protected void initialize() {
    }

    public String getConsoleIdentity() {
        return "ArticulateGatherer";
    }

    protected void execute() {
        if (extendPosition)
        {
            gatherer.extendGatherer();
        }
        else
        {
            gatherer.foldGatherer();
        }
        finished = true;
    }

    protected boolean isFinished() {
        if (finished){
            return true;
        }
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
