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
    private double initialAngle;
    private static double Kp = .05;
    private static double driveSpeed;
    
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
        initialAngle = driveTrain.getGyro().getAngle();
        driveSpeed = 1.0;
    }

    public String getConsoleIdentity() {
        return "DriveToDistance";
    }

    protected void execute() {
        if (driveTime > 0)
        {
            currentTime = Utility.getFPGATime();
            driveTrain.getTrain().drive(driveSpeed, -(driveTrain.getGyro().getAngle()-initialAngle)*Kp);
            
        }
        else if (driveDistance > 0)
        {
            driveTrain.getTrain().drive(driveSpeed, -(driveTrain.getGyro().getAngle()-initialAngle)*Kp);
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
