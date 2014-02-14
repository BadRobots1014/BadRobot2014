/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.commands.GatherBall;
import com.badrobot.subsystems.interfaces.IGatherer;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Isaac
 */
public class ProtoGatherer extends BadSubsystem implements IGatherer
{
    public static ProtoGatherer instance;
    // is the gatherer on and forward
    public static boolean gathererOn, gathererForward;
    
    // main system of gatherer
    Relay gathererSwitch;
    Solenoid pullGatherer, pushGatherer;

    /**
     * Gets the current instance of Gatherer.
     * If one doesn't exist, make one.
     * @return the current instance of Gatherer
     */
    public static ProtoGatherer getInstance()
    {
        if (instance == null)
        {
            instance = new ProtoGatherer();
        }
        return instance;
    }
    
    private ProtoGatherer()
    {
    }
    
    /**
     * Initializes the instance variables.
     * Done here because this can be called twice.
     */
    protected void initialize() 
    {
        if (!RobotMap.isPrototype)
        {
            gathererOn = false;
            gathererSwitch = new Relay(RobotMap.gathererMotorRelay);
            
            pullGatherer = new Solenoid(RobotMap.pullGatherer);
            pushGatherer = new Solenoid(RobotMap.pushGatherer);
            
            pushGatherer.set(false);
            pullGatherer.set(true);
        }
        else
        {
            gathererOn = false;
            gathererSwitch = new Relay(RobotMap.gathererMotorRelay);
            
            pullGatherer = new Solenoid(RobotMap.pullGatherer);
            pushGatherer = new Solenoid(RobotMap.pushGatherer);
            
            pushGatherer.set(false);
            pullGatherer.set(true);
        }
    }
    
    /**
     * Returns the console identity, which is
     * generally the class name.
     * @return the class name
     */
    public String getConsoleIdentity() 
    {
        return "Gatherer";
    }

    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new GatherBall());
    }
    
    /**
     * Controls the gatherer's gathering system.
     * @param on - should the gatherer be on?
     * @param forward - should the gatherer be moving
     * forward or backward?
     */
    public void gatherBall(boolean on, boolean forward)
    {
        if (forward && !gathererForward)
        {
            gathererSwitch.setDirection(Relay.Direction.kForward);
            gathererForward = true;
        }
        else if (!forward && gathererForward)
        {
            gathererSwitch.setDirection(Relay.Direction.kReverse);
            gathererForward = false;
        }
        
        if (on && !gathererOn)
        {
            gathererSwitch.set(Relay.Value.kOn);
            gathererOn = true;
        }
        else if (!on && gathererOn)
        {
            gathererSwitch.set(Relay.Value.kOff);
            gathererOn = false;
        }
    }
    
    public void foldGatherer(boolean pull) 
    {
        if(pull)
        {
            pushGatherer.set(false);
            //rightExhaust.set(false);
            //leftExhaust.set(false);
            pullGatherer.set(true);
        }
        else
        {
            pullGatherer.set(false);
            //rightExhaust.set(false);
            //leftExhaust.set(false);
            pushGatherer.set(true);
        }
    }
}
