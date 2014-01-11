/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Kyle
 */
public class Shoot extends BadCommand
{
    int notchesPassed;
    
    public Shoot()
    {
        requires((Subsystem) shooter);
    }
    protected void initialize() {
        
    }

    public String getConsoleIdentity() {
        return "Shoot";
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
