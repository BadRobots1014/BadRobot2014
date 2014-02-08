/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.OI;
import com.badrobot.RobotMap;
import com.badrobot.commands.Shoot;
import com.badrobot.subsystems.interfaces.IShooter;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author Isaac
 */
public class Shooter extends BadSubsystem implements IShooter
{   //makes instance
    private static Shooter instance;
    //makes solenoids and SpeedController
    Solenoid engageSolenoid, disengageSolenoid;
    SpeedController winch;
    //creates an instance of class
    public static Shooter getInstance()
    {
        if (instance == null)
        {
            instance = new Shooter();
        }
        return instance;
    }
    
    private Shooter()
    {
        
    }
    //intitialize method
    protected void initialize() 
    {
        winch = new Talon(RobotMap.winchController);
        engageSolenoid = new Solenoid(RobotMap.engageWinchSolenoid);
        disengageSolenoid = new Solenoid(RobotMap.disengageWinchSolenoid);
    }
        /**
         * returns console Identity
         * @return shooter
         */
    public String getConsoleIdentity() 
    {
        return "Shooter";
    }
    //Default Command
    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new Shoot());
    }
    //setting winch back
    public void cockBack(double speed) 
    {
        winch.set(-speed);   
    }
    //disengage winch
    public void disengageWinch() 
    {
        engageSolenoid.set(false);
        disengageSolenoid.set(true);
    }
    //disengage winch 
    public void engageWinch()
    {
        disengageSolenoid.set(false);
        engageSolenoid.set(true);
    }
    
}
