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
        timer.start();
        
        stopGatherWheels = false;
        cockBackStop = false;
        
        SmartDashboard.putNumber("End Gatherer Wheeling Time", 0.5);
        SmartDashboard.putNumber("Start Cock Back Time", 2.0);
        SmartDashboard.putNumber("Stop Cock Back Time", 2.5);
    }

    public String getConsoleIdentity() 
    {
        return "AutoGather";
    }

    protected void execute() 
    {
        stopWheelingTime = SmartDashboard.getNumber("End Gatherer Wheeling Time");
        cockBackStartTime = SmartDashboard.getNumber("Start Cock Back Time");
        cockBackStopTime = SmartDashboard.getNumber("Stop Cock Back Time");
        
        
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
