/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.BadCommand;
import com.badrobot.commands.TurnOnRetroLight;
import com.badrobot.subsystems.RingLight;
import com.badrobot.subsystems.VisionTracking;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Steve
 */
public class CheckHot extends BadCommand {

    private long time;
    
    public CheckHot()
    {
        requires((Subsystem) visionTracking);
        requires((Subsystem) shooter);
    }
    
    protected void initialize() 
    {
        time = Utility.getFPGATime();
    }

    public String getConsoleIdentity() 
    {
        return "CheckHotAndShoot";
    }

    protected void execute() 
    {
        if(visionTracking.currentImageIsHot())
        {
            isFinished();
        }
        if((Utility.getFPGATime()- time) > 6*1000000)//six million microseconds! 6 seconds
        {
            isFinished();
        }
    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
