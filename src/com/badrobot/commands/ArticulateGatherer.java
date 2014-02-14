/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Isaac
 */
public class ArticulateGatherer extends BadCommand
{
    boolean finished;
    
    public ArticulateGatherer(boolean out)
    {
        requires((Subsystem)shooter);
    }

    protected void initialize() {
    }

    public String getConsoleIdentity() {
        return "ArticulateGatherer";
    }

    protected void execute() {
        gatherer.foldGatherer(false);
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
