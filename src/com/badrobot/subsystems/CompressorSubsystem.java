/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.commands.Compress;
import com.badrobot.subsystems.interfaces.ICompressor;
import edu.wpi.first.wpilibj.Compressor;

/**
 *
 * @author Isaac
 */
public class CompressorSubsystem extends BadSubsystem implements ICompressor
{
    private static CompressorSubsystem instance;
    
    private Compressor compressor;
    
    
    public static CompressorSubsystem getInstance()
    {
        if (instance == null)
        {
            instance = new CompressorSubsystem();
        }
        return instance;
    }
    
    private CompressorSubsystem()
    {
    }

    protected void initialize() 
    {
        compressor = new Compressor(RobotMap.compressorSwitchRelay, RobotMap.pressureSwitchDigitalIn);
    }

    public String getConsoleIdentity() 
    {
        return "CompressorSubsystem";
    }

    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new Compress());
    }

    public void startCompressor() 
    {
        compressor.start();
    }

    public void stopCompressor() 
    {
        compressor.stop();
    }
    
}
