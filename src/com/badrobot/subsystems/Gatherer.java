/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.commands.GatherBall;
import com.badrobot.subsystems.interfaces.IGatherer;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author Isaac
 */
public class Gatherer extends BadSubsystem implements IGatherer
{
    public static Gatherer instance;
    public static boolean gathererOn, gathererForward;
    
    Relay gathererSwitch;

    public static Gatherer getInstance()
    {
        if (instance == null)
        {
            instance = new Gatherer();
        }
        return instance;
    }
    
    private Gatherer()
    {
    }
    
    protected void initialize() 
    {
        if (!RobotMap.isPrototype)
        {
            //final robot code goes here
        }
        else
        {
            gathererOn = false;
            gathererSwitch = new Relay(RobotMap.gathererMotorRelay);
        }
    }

    public String getConsoleIdentity() 
    {
        return "Gatherer";
    }

    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new GatherBall());
    }
    
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
}
