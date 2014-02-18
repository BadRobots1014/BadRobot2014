/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Isaac
 */
public class AutoGather extends BadCommand
{   
    boolean startSequence;
    double timePassed;
    
    Timer timer;
    
    public AutoGather()
    {
        requires((Subsystem) gatherer);
        requires((Subsystem) shooter);
    }

    protected void initialize() 
    {
        timer = new Timer();
        startSequence = false;
        
        //This code will be called from the initiation of the command until 2.0 seconds (defined below)
        gatherer.extendGatherer();
        shooter.disengageWinch();
        gatherer.gatherBall();
    }

    public String getConsoleIdentity() 
    {
        return "AutoGather";
    }

    protected void execute() 
    {
        //If the gatherer optical sensor is triggered, start the timer and sequence of events
        if (OI.driverStation.getDigitalIn(3) && !startSequence)
        {
            startSequence = true;
            timer.start();
        }
        
        //The sequence of events:
        if (startSequence)
        {
            timePassed = timer.get();
            log("Starting Sequence: 0");
            
            if (timeBetween(2.0, 3.0))
            {
                log("Changing Actions: 1");
                gatherer.foldGatherer();
            }
            else if (timeBetween(3.0, 4.0))
            {
                log("Changing Actions: 2");
                gatherer.stopGatherWheels();
                shooter.cockBack(1.0);
            }
            else if (timeBetween(4.0, 4.5))
            {
                log("Changing Actions: 3");
                shooter.cockBack(0);
            }
        }
    }

    protected boolean isFinished() 
    {
        if (timePassed > 4.0)
        {
            return true;
        }
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
    private boolean timeBetween(double start, double end)
    {
        return (timePassed > start && timePassed < end);
    }
    
}
