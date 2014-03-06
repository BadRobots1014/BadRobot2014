/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.subsystems.BadSubsystem;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Steve
 */
public class CheckHotMoveAndShoot extends BadCommand {
    
    Command driveToWall;
    private long time;
    boolean supaHotFire, startedDriving;
    
    Timer timer;
    
    public CheckHotMoveAndShoot()
    {
        requires((Subsystem) visionTracking);
        requires((Subsystem) shooter);
        requires((Subsystem) driveTrain);
    }

    protected void initialize() {
        timer = new Timer();
        timer.start();
    }

    public String getConsoleIdentity() {
        return "CheckHotMoveAndShoot";
    }

    protected void execute() {
        
        if(visionTracking.currentImageIsHot() && !startedDriving)
        {
            supaHotFire = true;
        }
        else if (!visionTracking.currentImageIsHot() && !startedDriving)
        {
            supaHotFire = false;
        }
        
        if (timer.get() > 0.5)
        {
            driveToWall = new DriveToWall(SmartDashboard.getNumber("Distance to wall"));
            driveToWall.start();
            startedDriving = true;
        }
        
        if (!driveToWall.isRunning() && startedDriving)
        {
            if (supaHotFire)
            {
                shooter.disengageWinch();
            }
            else if (timer.get() > 6)
            {
                shooter.disengageWinch();
            }
        }
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
