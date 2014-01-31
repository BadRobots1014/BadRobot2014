package com.badrobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.badrobot.OI;
import com.badrobot.subsystems.DriveTrain;
import com.badrobot.subsystems.ExampleSubsystem;
import com.badrobot.subsystems.Gatherer;
import com.badrobot.subsystems.Shooter;
import com.badrobot.subsystems.interfaces.IDriveTrain;
import com.badrobot.subsystems.interfaces.IGatherer;
import com.badrobot.subsystems.interfaces.IShooter;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * 
 * @author Team 1014
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    public static IDriveTrain driveTrain;
    public static IShooter shooter;
    public static IGatherer gatherer;
    
    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        oi.init();

        driveTrain = DriveTrain.getInstance();
        shooter = Shooter.getInstance();
        gatherer = Gatherer.getInstance();

        // Show what command your subsystem is running on the SmartDashboard
        //SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
