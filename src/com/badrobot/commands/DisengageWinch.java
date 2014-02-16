/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.commands;

import com.badrobot.BadCommand;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Jacob
 */
public class DisengageWinch extends BadCommand
{
    private static boolean finishedExecuting;
    
    public DisengageWinch()
    {
        requires((Subsystem)shooter);
    }

    protected void initialize() {
        finishedExecuting = false;
    }

    public String getConsoleIdentity() {
        return("DisengageWinch");
    }

    protected void execute() {
        shooter.disengageWinch();
        try {
            Thread.sleep(500);
        } catch (Exception ex) {
        }
        finishedExecuting = true;
    }

    protected boolean isFinished() {
        if (finishedExecuting)
        {
            return true;
        }
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
