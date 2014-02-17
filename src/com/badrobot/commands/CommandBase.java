package com.badrobot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.badrobot.OI;
import com.badrobot.subsystems.CompressorSubsystem;
import com.badrobot.subsystems.FinalDriveTrain;
import com.badrobot.subsystems.FinalGatherer;
import com.badrobot.subsystems.FinalShooter;
import com.badrobot.subsystems.ProtoDriveTrain;
import com.badrobot.subsystems.ProtoGatherer;
import com.badrobot.subsystems.RingLight;
import com.badrobot.subsystems.ProtoShooter;
import com.badrobot.subsystems.VisionTracking;
import com.badrobot.subsystems.interfaces.ICompressor;
import com.badrobot.subsystems.interfaces.IDriveTrain;
import com.badrobot.subsystems.interfaces.IGatherer;
import com.badrobot.subsystems.interfaces.IRingLight;
import com.badrobot.subsystems.interfaces.IShooter;
import com.badrobot.subsystems.interfaces.IVisionTracking;

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
    public static IVisionTracking visionTracking;
    public static IRingLight ringLight;
    public static ICompressor compressor;
    
    public static void init() {
        //Final Subsystems
        if (!OI.isPrototype)
        {
            driveTrain = FinalDriveTrain.getInstance();
            shooter = FinalShooter.getInstance();
            gatherer = FinalGatherer.getInstance();
        }
        //Prototype Subsystems
        else
        {
            driveTrain = ProtoDriveTrain.getInstance();
            shooter = ProtoShooter.getInstance();
            gatherer = ProtoGatherer.getInstance();
        }
        
        compressor = CompressorSubsystem.getInstance();
        //ringLight = RingLight.getInstance();
        //visionTracking = VisionTracking.getInstance();
        
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        oi.init();

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
