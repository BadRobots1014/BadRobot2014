/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.BadSubsystem;
import com.badrobot.RobotMap;
import com.badrobot.commands.GatherBall;
import com.badrobot.subsystems.interfaces.IGatherer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * The gatherer subsystem for the final robot;
 * All gatherer functionality code should go in this class.
 * @author Isaac
 */
public class FinalGatherer extends BadSubsystem implements IGatherer
{
    public static FinalGatherer instance;
    
    //Physical components of the gatherer:
    Relay gathererSwitch;
    Solenoid pullGatherer, pushGatherer;
    DigitalInput gathererOpticalSensor;
    
    //Other variables:
    int gatheringState;
    boolean folded;

    /**
     * Gets the current instance of the subsystem;
     * If one doesn't exist, make one.
     * @return The current instance of this subsystem
     */
    public static FinalGatherer getInstance()
    {
        if (instance == null)
        {
            instance = new FinalGatherer();
        }
        return instance;
    }
    
    /**
     * Private constructor for an instance of the subsystem;
     * Required for the getInstace() method.
     */
    private FinalGatherer()
    {
    }
    
    /**
     * Initializes the instance variables.
     */
    protected void initialize() 
    {
        gathererSwitch = new Relay(RobotMap.gathererMotorRelay);
        gathererOpticalSensor = new DigitalInput(RobotMap.gathererOpticalSensor);

        pullGatherer = new Solenoid(RobotMap.pullGatherer);
        pushGatherer = new Solenoid(RobotMap.pushGatherer);

        //Defaults the gatherer to the folded position:
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
        return "FinalGatherer";
    }

    /**
     * Defines the default command for this subsystem.
     */
    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new GatherBall());
    }
    
    /**
     * Rotates the gatherer wheels to pull the ball into the robot.
     */
    public void gatherBall()
    {
        if (gatheringState != 1)
        {
            gathererSwitch.setDirection(Relay.Direction.kForward);
            gathererSwitch.set(Relay.Value.kOn);
            gatheringState = 1;
        }
    }
    
    /**
     * Rotates the gatherer wheels to eject the ball out of the robot.
     */
    public void ejectBall()
    {
        if (gatheringState != 2)
        {
            gathererSwitch.setDirection(Relay.Direction.kReverse);
            gathererSwitch.set(Relay.Value.kOn);
            gatheringState = 2;
        }
    }
    
    /**
     * Stops the gatherer wheels altogether.
     */
    public void stopGatherWheels()
    {
        if (gatheringState != 0)
        {
            gathererSwitch.set(Relay.Value.kOff);
            gatheringState = 0;
        }
    }
    
    /**
     * Articulates the gatherer into the robot.
     */
    public void foldGatherer() 
    {
        pushGatherer.set(false);
        pullGatherer.set(true);
        folded = true;
    }
    
    /**
     * Articulates the gatherer to the extended position.
     */
    public void extendGatherer()
    {
        pullGatherer.set(false);
        pushGatherer.set(true);
        folded = false;
    }

    /**
     * Gets the current boolean value of the optical sensor.
     * @return Optical sensor boolean value
     */
    public boolean getOpticalSensorValue() 
    {
        return gathererOpticalSensor.get();
    }
    
    /**
     * Gives the current state of the gatherer articulation.
     * @return True if the gatherer is folded into the robot
     */
    public boolean isFolded()
    {
        return folded;
    }
}
