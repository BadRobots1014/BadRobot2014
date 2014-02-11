/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
//import static com.badrobot.commands.CommandBase.driveTrain;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Isaac
 */
public class DriveRobot extends BadCommand
{
    private double BUMPER_SPEED = .5;
    
    public DriveRobot()
    {
        requires((Subsystem) driveTrain);
    }
    
    protected void initialize() 
    {
        driveTrain.tankDrive(0, 0);
    }

    public String getConsoleIdentity() 
    {
        return "DriveRobot";
    }

    protected void execute() 
    {   
        driveTrain.tankDrive(OI.primaryController.getLeftStickY(), OI.primaryController.getRightStickY());
        
        if (OI.primaryController.isRBButtonPressed())
        {
            driveTrain.tankDrive(BUMPER_SPEED, -BUMPER_SPEED);
        }
        else if (OI.primaryController.isLBButtonPressed())
        {
            driveTrain.tankDrive(-BUMPER_SPEED, BUMPER_SPEED);
        }
        
        if (OI.primaryController.getRightTrigger() > 0)
        {
            driveTrain.shift(true);
        }  
        else if (OI.primaryController.getLeftTrigger() > 0)
        {
            driveTrain.shift(false);
        }
        
        if (driveTrain.getCompressorLimit())
        {
            driveTrain.compressorEnabled(true);
        }
        else
        {
            driveTrain.compressorEnabled(false);
        }
        
        SmartDashboard.putNumber("ultrasonic distance", driveTrain.getDistanceToWall());
        SmartDashboard.putNumber("gyro angle", driveTrain.getGyro().getAngle());
        SmartDashboard.putNumber("right encoder", driveTrain.getRightEncoder().get());
        SmartDashboard.putNumber("left encoder", driveTrain.getLeftEncoder().get());
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
        driveTrain.tankDrive(0, 0);
    }

    protected void interrupted() 
    {
        log("I've been interrupted and am deffering to the new Command");
    }
}
