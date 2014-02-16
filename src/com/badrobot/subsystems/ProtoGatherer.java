/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.commands.GatherBall;
import com.badrobot.subsystems.interfaces.IGatherer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 * @author Isaac
 */
public class ProtoGatherer extends BadSubsystem implements IGatherer
{
    public static ProtoGatherer instance;
    
    int gatheringState;
    boolean folded;
    
    // main system of gatherer
    Relay gathererSwitch;
    Solenoid pullGatherer, pushGatherer;
    DigitalInput gathererOpticalSensor;

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
        gathererSwitch = new Relay(RobotMap.gathererMotorRelay);
        gathererOpticalSensor = new DigitalInput(RobotMap.gathererOpticalSensor);

        pullGatherer = new Solenoid(RobotMap.pullGatherer);
        pushGatherer = new Solenoid(RobotMap.pushGatherer);

        pushGatherer.set(false);
        pullGatherer.set(true);
        folded = true;
    }
    
    /**
     * Returns the console identity, which is
     * generally the class name.
     * @return the class name
     */
    public String getConsoleIdentity() 
    {
        return "ProtoGatherer";
    }

    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new GatherBall());
    }
    
    public void gatherBall()
    {
        if (gatheringState != 1)
        {
            gathererSwitch.setDirection(Relay.Direction.kForward);
            gathererSwitch.set(Relay.Value.kOn);
            gatheringState = 1;
        }
    }
    
    public void ejectBall()
    {
        if (gatheringState != 2)
        {
            gathererSwitch.setDirection(Relay.Direction.kReverse);
            gathererSwitch.set(Relay.Value.kOn);
            gatheringState = 2;
        }
    }
    
    public void stopGatherer()
    {
        if (gatheringState != 0)
        {
            gathererSwitch.set(Relay.Value.kOff);
            gatheringState = 0;
        }
    }
    
    public void foldGatherer(boolean pull) 
    {
        if(pull)
        {
            pushGatherer.set(false);
            pullGatherer.set(true);
            folded = true;
        }
        else
        {
            pullGatherer.set(false);
            pushGatherer.set(true);
            folded = false;
        }
    }

    public boolean getOpticalSensorValue() 
    {
        return gathererOpticalSensor.get();
    }
    
    public boolean isFolded()
    {
        return folded;
    }
}
