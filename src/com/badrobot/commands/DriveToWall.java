/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Drives in a straight line until encountering an obstacle.
 * @author Jacob
 */
public class DriveToWall extends BadCommand
{
    public static double driveSpeed;
    private static double DISTANCE_DEADZONE_MAGIC_NUMBER;
    private static int checkNumber;
    private double initialAngle;
    //Constant for turn correction
    private static final double Kp = .05;
    
    boolean started;

    public DriveToWall(double distance)
    {
        requires((Subsystem)driveTrain);
        DISTANCE_DEADZONE_MAGIC_NUMBER = distance;
    }
    
    /**
     * Sets all initial values, turns off all motors,
     * receives the initial angle value from the gyro.
     */
    protected void initialize() 
    {
        driveSpeed = 1.0;
        checkNumber = 1;
        //initialAngle = driveTrain.getGyro().getAngle();
    }

    /**
     * Returns the command name for use in logging.
     * @return The command name
     */
    public String getConsoleIdentity() 
    {
        return("DriveToWall");
    }

    /**
     * Drives forward with turn correction, checks to see if the robot is touching an obstacle, 
     * must be true 3 times in a row to end the command.
     */
    protected void execute() 
    {
        if (!started) {
            DISTANCE_DEADZONE_MAGIC_NUMBER = SmartDashboard.getNumber("Distance to wall");
            started = true;
        }
        //driveTrain.getTrain().drive(driveSpeed, -(driveTrain.getGyro().getAngle()-initialAngle)*Kp);
        driveTrain.tankDrive(driveSpeed, driveSpeed);
        if (driveTrain.getDistanceToWall() < DISTANCE_DEADZONE_MAGIC_NUMBER)
        {
            if(checkNumber == 1)
            {
                checkNumber++;
            }
            else if (checkNumber == 2)
            {
                checkNumber++;
            }
            else if (checkNumber == 3)
            {
                checkNumber = 0;
            }
        }
        else
        {
            checkNumber = 1;
        }
    }

    /**
     * If the robot has detected that it is touching an obstacle three times in a row, end the command.
     * @return True ends the command
     */
    protected boolean isFinished() 
    {
        if (checkNumber == 0)
        {
            return true;
        }
        return false;
    }

    /**
     * Turns off the motors when the command ends.
     */
    protected void end() 
    {
        driveTrain.tankDrive(0, 0);
    }

    protected void interrupted() 
    {
        
    }
     
}
