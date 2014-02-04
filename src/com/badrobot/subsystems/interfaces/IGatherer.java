/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems.interfaces;

/**
 *
 * @author Isaac
 */
public interface IGatherer 
{
    
    public void gatherBall(boolean on, boolean forward);
    
    //folds gatherer into robot
    public void foldGatherer(boolean pull);
    
}


