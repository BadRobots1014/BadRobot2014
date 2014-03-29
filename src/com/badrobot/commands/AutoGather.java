/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Isaac
 */
public class AutoGather extends BadCommand
{   
    boolean startSequence;
    double timePassed;
    
    Timer timer;
    
    double stopWheeling;
    double cockbackStart;
    double cockbackEnd;
    double autoGatherEnd;
    
    public AutoGather()
    {
        requires((Subsystem) gatherer);
        requires((Subsystem) shooter);
    }

    protected void initialize() 
    {
        gatherer.gatherBall();
        gatherer.foldGatherer();
        
        timer = new Timer();
        
        stopWheeling = 2.0;
        cockbackStart = 3.0;
        cockbackEnd = 4.0;
        autoGatherEnd = 4.5;
    }

    public String getConsoleIdentity() 
    {
        return "AutoGather";
    }

    protected void execute() 
    {
        SmartDashboard.putNumber("Start folding gatherer", 0);
        
        timePassed = timer.get();

        if (timeBetween(0, stopWheeling))
        {
            gatherer.stopGatherWheels();
        }
        else if (timeBetween( 1.0, 4.0))
        {
            gatherer.stopGatherWheels();
            shooter.cockBack(1.0);
        }
        else if (timeBetween(4.0, 4.5))
        {
            shooter.cockBack(0);
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
