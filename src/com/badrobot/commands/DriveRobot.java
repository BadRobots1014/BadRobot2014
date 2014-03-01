/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Isaac
 */
public class DriveRobot extends BadCommand
{
    public DriveRobot()
    {
        requires((Subsystem) driveTrain);
    }
    
    /**
     * Turns off all drive train motors at the start of the function.
     */
    protected void initialize() 
    {
        driveTrain.tankDrive(0, 0);
    }

    /**
     * Sets the name of the command for use in logging to the console.
     * @return The name of the command
     */
    public String getConsoleIdentity() 
    {
        return "DriveRobot";
    }

    /**
     * Runs the contained code repeatedly until the command is ended.
     */
    protected void execute() 
    {
        //drives using direct input from the xbox controller
        driveTrain.tankDrive(OI.primaryController.getLeftStickY(), OI.primaryController.getRightStickY());
        
        if (OI.primaryController.getRightTrigger() > 0)
        {
            driveTrain.shiftUp();
        }
        else if (OI.primaryController.getLeftTrigger() > 0)
        {
            driveTrain.shiftDown();
        }
        
        //displays important values to the smart dashboard
        //SmartDashboard.putNumber("ultrasonic distance", driveTrain.getDistanceToWall());
        //SmartDashboard.putNumber("Ultrasonic Voltage", driveTrain.getUltrasonicVoltage());
        SmartDashboard.putNumber("gyro angle", driveTrain.getGyro().getAngle());
        
       /* log("fresh image"+AxisCamera.getInstance().freshImage());
        
        try{
            log("image "+AxisCamera.getInstance().getImage());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }*/
        
        //commented out because we don't currently have both encoders working.
        /*SmartDashboard.putNumber("right encoder", driveTrain.getRightEncoder().get());
        SmartDashboard.putNumber("left encoder", driveTrain.getLeftEncoder().get());
        
        SmartDashboard.putNumber("right encoder DPP", (driveTrain.getRightEncoder().getDistance())
                                                    / (driveTrain.getRightEncoder().get()));
        SmartDashboard.putNumber("left encoder DPP", (driveTrain.getLeftEncoder().getDistance())
                                                   / (driveTrain.getLeftEncoder().get()));
        
        if (SmartDashboard.getNumber("setEncoderDistancePerPulse") != driveTrain.getEncoderDistancePerPulse())
        {
            driveTrain.setEncoderDistancePerPulse(SmartDashboard.getNumber("setEncoderDistancePerPulse"));
        }*/
    }

    /**
     * Continuously returns false, this command will never end itself.
     * @return Always returns false
     */
    protected boolean isFinished() 
    {
        return false;
    }
    
    /**
     * Runs once when the command ends, sets all the motors to 0.
     */
    protected void end() 
    {
        driveTrain.tankDrive(0, 0);
    }

    /**
     * Log a message to the console if this command is interrupted due to the driveTrain subsystem being required by a different command.
     */
    protected void interrupted() 
    {
        log("I've been interrupted and am deffering to the new Command");
    }
}
