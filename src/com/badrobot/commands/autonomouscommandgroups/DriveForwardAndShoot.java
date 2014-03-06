/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.badrobot.commands.autonomouscommandgroups;

import com.badrobot.commands.ArticulateGatherer;
import com.badrobot.commands.DisengageWinch;
import com.badrobot.commands.DriveStraightForward;
import com.badrobot.commands.DriveToWall;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Jacob
 */
public class DriveForwardAndShoot extends CommandGroup
{
    public static boolean useDistance;
    private static double time = 3;
    
    public DriveForwardAndShoot()
    {
        this.addSequential(new ArticulateGatherer(true));
        this.addSequential(new DriveStraightForward(time));
        this.addSequential(new DriveToWall(SmartDashboard.getNumber("Distance to wall")));
        this.addSequential(new DisengageWinch());
    }
    
    public DriveForwardAndShoot(double t)
    {
        time = t;
        this.addSequential(new ArticulateGatherer(true));
        this.addSequential(new DriveStraightForward(time));
        this.addSequential(new DisengageWinch());
    }
    
    public void initialize()
    {
        super.initialize();
    }
}
