/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.commands.Compress;
import com.badrobot.subsystems.interfaces.ICompressor;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The compressor subsystem for the prototype robot;
 * All compressor functionality code should go in this class.
 * @author Isaac
 */
public class CompressorSubsystem extends BadSubsystem implements ICompressor
{
    private static CompressorSubsystem instance;
    
    //Physical components of the compressor:
    Compressor compressor;
    
    /**
     * Gets the current instance of the subsystem;
     * If one doesn't exist, make one.
     * @return The current instance of this subsystem
     */
    public static CompressorSubsystem getInstance()
    {
        if (instance == null)
        {
            instance = new CompressorSubsystem();
        }
        return instance;
    }
    
    /**
     * Private constructor for an instance of the subsystem;
     * Required for the getInstace() method.
     */
    private CompressorSubsystem()
    {
    }

    /**
     * Initializes the instance variables.
     */
    protected void initialize() 
    {
        compressor = new Compressor(RobotMap.pressureSwitchDigitalIn, RobotMap.compressorSwitchRelay);
    }

    /**
     * Returns the console identity, which is
     * generally the class name.
     * @return the class name
     */
    public String getConsoleIdentity() 
    {
        return "CompressorSubsystem";
    }

    /**
     * Defines the default command for this subsystem.
     */
    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new Compress());
    }

    /**
     * Starts the compressor, automatically regulating
     * the pressure in the system.
     */
    public void startCompressor() 
    {
        compressor.start();
    }

    /**
     * Stops the compressor and any pressure regulation.
     */
    public void stopCompressor() 
    {
        compressor.stop();
    }
    
    public boolean isEnabled()
    {
        SmartDashboard.putBoolean("Compressor", compressor.enabled());
        return compressor.enabled();
    }
    
}
