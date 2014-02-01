/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.commands;
import edu.wpi.first.wpilibj.Utility;


/**
 *
 * @author Jacob
 */
public class DriveStraightForward extends BadCommand{

    public long driveTime;
    public double driveDistance;
    public long startTime;
    public long currentTime;
    
    public DriveStraightForward(double t)
    {
        driveTime = (long) t*1000000;
        driveDistance = -1;
    }
    
    public DriveStraightForward(double d, double t)
    {
        driveDistance = d;
        driveTime = -1;
    }
        
    protected void initialize() {
        startTime = Utility.getFPGATime();
    }

    public String getConsoleIdentity() {
        return "DriveToDistance";
    }

    protected void execute() {
        if (driveTime > 0)
        {
            currentTime = Utility.getFPGATime();
            driveTrain.tankDrive(.75, .75);
            
        }
        else if (driveDistance > 0)
        {
            driveTrain.tankDrive(.75, .75);
        }
    }
    
    protected boolean isFinished() {
        if (driveTime > 0 && currentTime > (startTime + driveTime))
        {
            return true;
        }
        else if(driveDistance > 0 && driveTrain.getDistanceToWall() <= driveDistance)
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
