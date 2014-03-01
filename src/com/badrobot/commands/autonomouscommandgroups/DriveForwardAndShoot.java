/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.commands.autonomouscommandgroups;

import com.badrobot.commands.ArticulateGatherer;
import com.badrobot.commands.DisengageWinch;
import com.badrobot.commands.DriveStraightForward;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Jacob
 */
public class DriveForwardAndShoot extends CommandGroup
{
    public static boolean useDistance;
    private static final double DISTANCE = 24;
    private static final double TIME = 3;
    
    public DriveForwardAndShoot(boolean distanceMode)
    {
        useDistance = distanceMode;
        if(useDistance)
        {
            this.addSequential(new ArticulateGatherer(true));
            this.addSequential(new DriveStraightForward(DISTANCE, 0));
            this.addSequential(new DisengageWinch());
        }
        else
        {
            this.addSequential(new ArticulateGatherer(true));
            this.addSequential(new DriveStraightForward(TIME));
            this.addSequential(new DisengageWinch());
        }
    }
    
    public void initialize()
    {
        super.initialize();
    }
}
