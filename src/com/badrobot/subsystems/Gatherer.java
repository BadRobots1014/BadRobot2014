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
    public static boolean gathererOn;
    
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
        gathererOn = false;
        
        gathererSwitch = new Relay(RobotMap.gathererMotorRelay);
    }

    public String getConsoleIdentity() 
    {
        return "Gatherer";
    }

    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new GatherBall());
    }
    
    // 0 is off, 1 is gather ball, 2 is eject ball
    public void gathererBall(int state)
    {
        if (state == 0)
        {
            gathererSwitch.set(Relay.Value.kOff);
        }
        else if (state == 1)
        {
            gathererSwitch.setDirection(Relay.Direction.kForward);
            gathererSwitch.set(Relay.Value.kOn);
        }
        else if (state == 2)
        {
            gathererSwitch.setDirection(Relay.Direction.kReverse);
            gathererSwitch.set(Relay.Value.kOn);
        }
    }
}
