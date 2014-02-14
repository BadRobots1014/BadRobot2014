/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.subsystems.interfaces.IBallGatherer;
import com.badrobot.RobotMap;
import edu.wpi.first.wpilibj.Talon;

/**
 *
 * @author Steve, Scott
 */
public class BallGatherer extends BadSubsystem implements IBallGatherer {
    
    public BallGatherer()
    {
        super();
    }

    protected void initialize() {
    }

    public String getConsoleIdentity() {
        return null;
    }

    protected void initDefaultCommand() {
    }

    public void autoGather() {
    }

    public void manualGather() {
    }

    public void dropBall() {
    }
    
}
