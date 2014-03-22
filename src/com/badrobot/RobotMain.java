/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.badrobot;


import com.badrobot.commands.CheckHotMoveAndShoot;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import com.badrobot.commands.CommandBase;
import com.badrobot.commands.DriveStraightForward;
import com.badrobot.commands.RunLights;
import com.badrobot.commands.autonomouscommandgroups.DebugImage;
import com.badrobot.commands.autonomouscommandgroups.DriveForwardAndShoot;
import com.badrobot.commands.autonomouscommandgroups.DriveTooFarFixAndShoot;
import com.badrobot.subsystems.interfaces.ILights;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autoChooser;
    public static int ALLIANCE_COLOR = 0;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // Initialize all subsystems
        CommandBase.init();
        
        SmartDashboard.putNumber("AutonomousDriveStraightTime", 3.8);
        SmartDashboard.putNumber("Distance to wall", 56);
        
        //Add autonomous commandgroups to the smart dashboard chooser
        autoChooser = new SendableChooser();
        //autoChooser.addObject("Drive straight forward with distance and shoot", new DriveForwardAndShoot());
        //autoChooser.addObject("Drive straight forward with time and shoot", new DriveForwardAndShoot(SmartDashboard.getNumber("AutonomousDriveStraightTime")));
        //autoChooser.addObject("Check hot drive foward and shoot", new CheckHotMoveAndShoot());
        //autoChooser.addObject("Drive Foward", new DriveStraightForward(SmartDashboard.getNumber("AutonomousDriveStraightTime"), false));
        //autoChooser.addObject("Drive too far low speed", new DriveTooFarFixAndShoot(false));
        //autoChooser.addObject("Drive too far high speed", new DriveTooFarFixAndShoot(true));
        //autoChooser.addObject("DEBUG: Drive Straight THEN articulate gatherer", new DebugImage());
        
        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
//        ALLIANCE_COLOR = (DriverStation.getInstance().getAlliance().value 
//                == DriverStation.Alliance.kBlue_val) ? ILights.kBlue : ILights.kRed;
//        if (CommandBase.lights != null) {
//            Scheduler.getInstance().add(new RunLights(ALLIANCE_COLOR));
//        }
    }

    /**
     * Called when autonomous is first initiated
     */
    public void autonomousInit() {
        //select the selected autonomous commandgroup and add to scheduler
        autonomousCommand = (Command) autoChooser.getSelected();
        Scheduler.getInstance().add(autonomousCommand);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * Called when autonomous is first initiated
     */
    public void teleopInit() {
	//cancels autonomous mode when teleop begins
        //autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control (teleop mode)
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }

    private void log(String input) {
        System.out.println("RobotMain: "+input);
    }
}
