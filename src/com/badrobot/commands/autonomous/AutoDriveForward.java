/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands.autonomous;

import com.badrobot.commands.CommandBase;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Steve
 */
public class AutoDriveForward extends CommandBase {
    
    public AutoDriveForward()
    {
        requires((Subsystem)driveTrain);
    }        

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
   
}
