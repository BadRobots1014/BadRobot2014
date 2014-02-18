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
    // number of degrees robot needs to turn
    double turnDegrees;
    // the target for the robot to turn to
    double target;
    
    public TurnRobot(double degrees)
    {
        requires((Subsystem) driveTrain);
        turnDegrees = degrees;
        target = driveTrain.getGyro().getAngle() + turnDegrees;
    }
    
    protected void initialize() 
    {
        driveTrain.tankDrive(0, 0);
    }

    /**
     * Gets the console identity. Usually the class name.
     * @return the class name
     */
    public String getConsoleIdentity() 
    {
        return "TurnRobot";
    }

    /**
     * Calls this code over and over again.
     */
    protected void execute() 
    {
        if(turnDegrees > 0) // if we want a positive turn
        {
            // if the gyro is not at the target
            if(driveTrain.getGyro().getAngle() < target)
            {
                // keep turning
                driveTrain.tankDrive(1.0, -1.0);
            }
        }
        else if(turnDegrees < 0) // if we want a negative turn
        {
            // if the gyro is not at the target yet
            if(driveTrain.getGyro().getAngle() > target)
            {
                // keep turning
                driveTrain.tankDrive(-1.0, 1.0);
            }
        }
    }

    /**
     * Stops the drive train and finishes the command.
     * @return true when the command is finished.
     */
    protected boolean isFinished() 
    {
        if(turnDegrees > 0) // if we want a positive turn
        {
            // if the gyro is at or past the target
            if(driveTrain.getGyro().getAngle() > target)
            {
                // keep turning
                driveTrain.tankDrive(0, 0);
                return true;
            }
        }
        else if(turnDegrees < 0) // if we want a negative turn
        {
            // if the gyro is at or past the target
            if(driveTrain.getGyro().getAngle() < target)
            {
                // keep turning
                driveTrain.tankDrive(0, 0);
                return true;
            }
        }
        
        return false;
    }

    protected void end() 
    {
    }

    protected void interrupted() 
    {
        log("I have been interrupted!");
    }
    
}
