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
    
    double stopWheelingTime;
    double cockBackStartTime;
    double cockBackStopTime;
    double autoGatherEndTime;
    
    boolean stopGatherWheels;
    boolean cockBackStart;
    boolean cockBackStop;
    
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
        
        stopGatherWheels = false;
        cockBackStop = false;
        
        stopWheelingTime = 2.0;
        cockBackStartTime = 3.0;
        cockBackStopTime = 4.0;
    }

    public String getConsoleIdentity() 
    {
        return "AutoGather";
    }

    protected void execute() 
    {
        SmartDashboard.putNumber("End Gatherer Wheeling Time", stopWheelingTime);
        SmartDashboard.putNumber("Start Cock Back Time", cockBackStartTime);
        SmartDashboard.putNumber("Stop Cock Back Time", cockBackStopTime);
        
        
        timePassed = timer.get();

        gatherWheelProcess();
        cockBackStartProcess();
        cockBackStopProcess();
    }

    public void gatherWheelProcess()
    {
        if (!stopGatherWheels && timePassed > stopWheelingTime)
        {
            gatherer.stopGatherWheels();
            stopGatherWheels = true;
        }
    }
    
    public void cockBackStartProcess()
    {
        if (!cockBackStart && timePassed > cockBackStartTime)
        {
            shooter.cockBack(1.0);
            cockBackStart = true;
        }
    }
    
    public void cockBackStopProcess()
    {
        if (!cockBackStop && timePassed > cockBackStopTime)
        {
            shooter.cockBack(0);
            cockBackStop = true;
        }
    }
    
    protected boolean isFinished() 
    {
        if (timePassed > cockBackStopTime)
        {
            return true;
        }
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
