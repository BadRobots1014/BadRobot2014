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
public class FinalShooter extends BadSubsystem implements IShooter
{
    private static FinalShooter instance;
    
    Solenoid engageSolenoid, disengageSolenoid;
    SpeedController winch;
    
    public static FinalShooter getInstance()
    {
        if (instance == null)
        {
            instance = new FinalShooter();
        }
        return instance;
    }
    
    private FinalShooter()
    {
        
    }
    
    protected void initialize() 
    {
        winch = new Talon(RobotMap.winchController);
        engageSolenoid = new Solenoid(RobotMap.engageWinchSolenoid);
        disengageSolenoid = new Solenoid(RobotMap.disengageWinchSolenoid);
    }

    public String getConsoleIdentity() 
    {
        return "FinalShooter";
    }

    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new Shoot());
    }

    public void cockBack(double speed) 
    {
        winch.set(-speed);   
    }

    public void disengageWinch() 
    {
        engageSolenoid.set(false);
        disengageSolenoid.set(true);
    }
    
    public void engageWinch()
    {
        disengageSolenoid.set(false);
        engageSolenoid.set(true);
    }
    
}
