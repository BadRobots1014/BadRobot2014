/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems.interfaces;

/**
 *
 * @author Kevin
 */
public interface IShooter 
{
    /**
     * Winches down the shooter catapult at the desired speed.
     * @param speed The speed from -1 to 1 to winch the shooter down
     */
    public void cockBack(double speed);
    
    /**
     * Disengages the shooter winch, firing the shooter.
     */
    public void disengageWinch();
    
    /**
     * Engages the shooter winch, allowing it to be winched back.
     */
    public void engageWinch();
    
    public boolean isCockedBack();
}
