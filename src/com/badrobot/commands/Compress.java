/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Isaac
 */
public class Compress extends BadCommand
{
    boolean compressorEnabled;
    
    public Compress()
    {
        requires ((Subsystem) compressor);
    }

    protected void initialize() {
    }

    public String getConsoleIdentity() 
    {
        return "Compress";
    }

    protected void execute() 
    {
        compressorEnabled = compressor.isEnabled();
        if (!compressorEnabled)
        {
            compressor.startCompressor();
            log("enabling compressor");
        }
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
