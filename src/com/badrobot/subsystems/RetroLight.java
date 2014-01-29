/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.subsystems.interfaces.IRetroLight;

/**
 *
 * @author Steve
 */
public class RetroLight extends BadSubsystem implements IRetroLight {

    protected void initialize() {
    }

    public String getConsoleIdentity()
    {
        return "RetroLight";
    }

    protected void initDefaultCommand() {
    }
    
}
