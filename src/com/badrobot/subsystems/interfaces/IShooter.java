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
    public void cockBack(double speed);
    
    public void disengageWinch();
    
    public void engageWinch();
}
