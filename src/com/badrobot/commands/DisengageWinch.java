/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Jacob
 */
public class DisengageWinch extends BadCommand
{
    private static boolean finishedExecuting;
    boolean shouldShoot;
    boolean started;
    
    Timer timer;
    
    public DisengageWinch()
    {
        requires((Subsystem) kinect);
        requires((Subsystem) shooter);
    }

    protected void initialize() {
        finishedExecuting = false;
        timer = new Timer();
    }

    public String getConsoleIdentity() {
        return("DisengageWinch");
    }

    protected void execute() {
        if (!started) {
            timer.start();
            started = true;
        }
        if (kinect.isRightHandRaised() || timer.get() > (8 - SmartDashboard.getNumber("DriveStraightForwardTime")))
        {
            shouldShoot = true;
            shooter.disengageWinch();
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
            }
            finishedExecuting = true;
        }
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
