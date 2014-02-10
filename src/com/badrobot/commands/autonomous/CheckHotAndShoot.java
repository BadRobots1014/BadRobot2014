/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands.autonomous;

import com.badrobot.commands.BadCommand;
import com.badrobot.commands.TurnOnRetroLight;
import com.badrobot.subsystems.RetroLight;
import com.badrobot.subsystems.VisionTracking;
import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 *
 * @author Steve
 */
public class CheckHotAndShoot extends BadCommand {
    private VisionTracking vt;//will be the subsystem

    protected void initialize() 
    {
       vt = vt.getInstance();
    }

    public String getConsoleIdentity() 
    {
        return "CheckHotAndShoot";
    }

    protected void execute() 
    {
        //turnOnLight
        
        if(vt.currImageIsHot())
        {
            //shoot
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
