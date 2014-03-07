/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands.autonomouscommandgroups;

import com.badrobot.commands.ArticulateGatherer;
import com.badrobot.commands.DisengageWinch;
import com.badrobot.commands.DriveBackFromWall;
import com.badrobot.commands.DriveStraightForward;
import com.badrobot.commands.RunLights;
import com.badrobot.subsystems.interfaces.ILights;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Isaac
 */
public class DriveTooFarFixAndShoot extends CommandGroup {
    
    public DriveTooFarFixAndShoot(boolean highSpeed) {
        
        if (!highSpeed) {
            this.addSequential(new ArticulateGatherer(false));
            this.addSequential(new DriveStraightForward(SmartDashboard.getNumber("AutonomousDriveStraightTime"), false));
            this.addSequential(new ArticulateGatherer(true));
            //this.addParallel(new RunLights(ILights.kWhite));
            this.addSequential(new DriveBackFromWall(SmartDashboard.getNumber("Distance to wall")));
            this.addSequential(new DisengageWinch());
            //this.addParallel(new RunLights(ILights.kGold));
        }
        else {
            this.addSequential(new ArticulateGatherer(false));
            this.addSequential(new DriveStraightForward(SmartDashboard.getNumber("AutonomousDriveStraightTime"), true));
            this.addSequential(new ArticulateGatherer(true));
            //this.addParallel(new RunLights(ILights.kWhite));
            this.addSequential(new DriveBackFromWall(SmartDashboard.getNumber("Distance to wall")));
            this.addSequential(new DisengageWinch());
            //this.addParallel(new RunLights(ILights.kGold));
        }
    }
}
