/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.OI;
import com.badrobot.RobotMap;
import com.badrobot.commands.Shoot;
import com.badrobot.subsystems.interfaces.IShooter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * The shooter subsystem for the prototype robot;
 * All shooter functionality code should go in this class.
 * @author Isaac
 */
public class ProtoShooter extends BadSubsystem implements IShooter
{
    private static ProtoShooter instance;
    
    //Physical components of the shooter:
    Solenoid engageSolenoid, disengageSolenoid;
    SpeedController winch;
    
    DigitalInput shooterDIO;
    
    /**
     * Gets the current instance of the subsystem;
     * If one doesn't exist, make one.
     * @return The current instance of this subsystem
     */
    public static ProtoShooter getInstance()
    {
        if (instance == null)
        {
            instance = new ProtoShooter();
        }
        return instance;
    }
    
    /**
     * Private constructor for an instance of the subsystem;
     * Required for the getInstace() method.
     */
    private ProtoShooter()
    {
    }
    
    /**
     * Initializes the instance variables.
     */
    protected void initialize() 
    {
        winch = new Talon(RobotMap.winchController);
        engageSolenoid = new Solenoid(RobotMap.engageWinchSolenoid);
        disengageSolenoid = new Solenoid(RobotMap.disengageWinchSolenoid);
        
        //shooterDIO = new DigitalInput(RobotMap.shooterDIO);
    }

    /**
     * Returns the console identity, which is
     * generally the class name.
     * @return the class name
     */
    public String getConsoleIdentity() 
    {
        return "ProtoShooter";
    }

    /**
     * Defines the default command for this subsystem.
     */
    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new Shoot());
    }

    /**
     * Winches down the shooter catapult at the desired speed.
     * @param speed The speed from -1 to 1 to winch the shooter down
     */
    public void cockBack(double speed) 
    {
        winch.set(-speed);   
    }

    /**
     * Disengages the shooter winch, firing the shooter.
     */
    public void disengageWinch() 
    {
        engageSolenoid.set(false);
        disengageSolenoid.set(true);
    }
    
    /**
     * Engages the shooter winch, allowing it to be winched back.
     */
    public void engageWinch()
    {
        disengageSolenoid.set(false);
        engageSolenoid.set(true);
    }
    
    public boolean isCockedBack()
    {
        return false;
        //return shooterDIO.get();
    }
    
}
