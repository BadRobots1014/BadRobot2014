/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems.interfaces;

/**
 *
 * @author Isaac
 */
public interface ICompressor 
{
    /**
     * Starts the compressor, automatically regulating
     * the pressure in the system.
     */
    public void startCompressor();
    
    /**
     * Stops the compressor and any pressure regulation.
     */
    public void stopCompressor();
    
    public boolean isEnabled();
}
