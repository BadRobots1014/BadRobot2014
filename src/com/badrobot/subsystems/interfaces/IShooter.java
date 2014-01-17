/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.subsystems.interfaces;

/**
 *
 * @author Kyle
 */
public interface IShooter
{
    /**
     * releases the shooter
     */
    public void launch();
    
    /**
     * pulls shooter back, prepares for launch
     */
    public void cock();
    
    /** 
     * @return Returns the angle of the shooter during cocking 
     */
    public int getShooterAngle();
}
