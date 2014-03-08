/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands.autonomouscommandgroups;

import com.badrobot.commands.ArticulateGatherer;
import com.badrobot.commands.DriveStraightForward;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Isaac
 */
public class DebugImage extends CommandGroup {
    
    public DebugImage() {
        this.addSequential(new DriveStraightForward(SmartDashboard.getNumber("AutonomousDriveStraightTime"), false));
        this.addSequential(new ArticulateGatherer(true));
    }
    
    public void initialize()
    {
        super.initialize();
    }
}
