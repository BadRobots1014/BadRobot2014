/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Isaac
 */
public class DetectGestures extends BadCommand
{
    public DetectGestures()
    {
        requires((Subsystem) kinect);
    }
    
    protected void initialize() {
    }

    public String getConsoleIdentity() {
        return "DetectGestures";
    }

    protected void execute() {
        SmartDashboard.putBoolean("RIGHT HAND RAISED", kinect.isRightHandRaised());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
