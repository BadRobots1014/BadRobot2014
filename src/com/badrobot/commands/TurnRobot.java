/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Manu S.
 */
public class TurnRobot extends BadCommand
{
    
    double turnDegrees;
    
    public TurnRobot(double degrees)
    {
        requires((Subsystem) driveTrain);
        turnDegrees = degrees;
    }
    
    protected void initialize() 
    {
    }

    public String getConsoleIdentity() 
    {
        return "TurnRobot";
    }

    protected void execute() 
    {
        double target = driveTrain.getGyro().getAngle() + turnDegrees;
        if(turnDegrees > 0)
        {
            if(driveTrain.getGyro().getAngle() < target)
            {
                driveTrain.tankDrive(1.0, -1.0);
            }
            else if(driveTrain.getGyro().getAngle() > target)
            {
                driveTrain.tankDrive(-1.0, 1.0);
            }
        }
        else if(turnDegrees < 0)
        {
            if(driveTrain.getGyro().getAngle() > target)
            {
                driveTrain.tankDrive(-1.0, 1.0);
            }
            else if(driveTrain.getGyro().getAngle() > target)
            {
                driveTrain.tankDrive(1.0 , -1.0);
            }
        }
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
    }

    protected void interrupted() 
    {
        log(getConsoleIdentity() + ": I have been interrupted!");
    }
    
}
