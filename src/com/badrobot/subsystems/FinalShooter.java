/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.OI;
import com.badrobot.RobotMap;
import com.badrobot.commands.Shoot;
import com.badrobot.subsystems.interfaces.IShooter;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * The shooter subsystem for the final robot;
 * All shooter functionality code should go in this class.
 * @author Isaac
 */
public class FinalShooter extends BadSubsystem implements IShooter
{
    private static FinalShooter instance;
    
    //Physical components of the shooter:
    Solenoid engageSolenoid, disengageSolenoid;
    DoubleSolenoid winchSolenoid;
    SpeedController winch;
    
    /**
     * Gets the current instance of the subsystem;
     * If one doesn't exist, make one.
     * @return The current instance of this subsystem
     */
    public static FinalShooter getInstance()
    {
        if (instance == null)
        {
            instance = new FinalShooter();
        }
        return instance;
    }
    
    /**
     * Private constructor for an instance of the subsystem;
     * Required for the getInstace() method.
     */
    private FinalShooter()
    {
    }
    
    /**
     * Initializes the instance variables.
     */
    protected void initialize() 
    {
        winch = new Talon(RobotMap.winchController);
//        engageSolenoid = new Solenoid(RobotMap.engageWinchSolenoid);
//        disengageSolenoid = new Solenoid(RobotMap.disengageWinchSolenoid);
        winchSolenoid = new DoubleSolenoid(RobotMap.engageWinchSolenoid, RobotMap.disengageWinchSolenoid);
        
        engageWinch();
    }

    /**
     * Returns the console identity, which is
     * generally the class name.
     * @return the class name
     */
    public String getConsoleIdentity() 
    {
        return "FinalShooter";
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
//        engageSolenoid.set(false);
//        disengageSolenoid.set(true);
        winchSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    /**
     * Engages the shooter winch, allowing it to be winched back.
     */
    public void engageWinch()
    {
//        disengageSolenoid.set(false);
//        engageSolenoid.set(true);
        winchSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    
}
