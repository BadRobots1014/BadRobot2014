/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
import com.badrobot.RobotMain;
import com.badrobot.XboxController;
import com.badrobot.subsystems.interfaces.ILights;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * 
 * @author Isaac
 */
public class GatherBall extends BadCommand
{
    int debugState;
    
    /**
     * Constructor for the command;
     * Requires the subsystem to override any 
     * other commands currently using this subsystem.
     */
    public GatherBall()
    {
        requires ((Subsystem) gatherer);
    }
    
    /**
     * Sets values to the instance variables.
     */
    protected void initialize() 
    {
        SmartDashboard.putNumber("Red Channel", 0);
        SmartDashboard.putNumber("Green Channel", 0);
        SmartDashboard.putNumber("Blue Channel", 0);
    }
    /**
     * Gets the console identity. Usually this 
     * is the class name.
     * @return the class name.
     */
    public String getConsoleIdentity() 
    {
        return "GatherBall";
    }

    /**
     * Continuously called while the command is active.
     */
    protected void execute() 
    {
        //Used when two controllers will be used
        if (!OI.isSingleControllerMode())
        {
            //gather ball with RB, eject with LB
            controlGathererWheels(OI.secondaryController);
            
            //folds gatherer into robot with X, extends with Y
            controlGathererArticulation(OI.secondaryController);
        }
        //Used when one controller will be used
        else
        {
            //gather ball with RB, eject with LB
            controlGathererWheels(OI.primaryController);
            
            //folds gatherer into robot with X, extends with Y
            controlGathererArticulation(OI.primaryController);
        }
    }

    /**
     * Determines when the command will be finished
     * @return False for a continuous command
     */
    protected boolean isFinished() 
    {
        return false;
    }

    /**
     * Called when the isFinished method returns true,
     * The last thing this command will call.
     */
    protected void end() {
    }

    
    /**
     * Called when another command interrupts this command
     * by requiring the gatherer subsystem.
     */
    protected void interrupted() 
    {
        log("I've been interrupted and am deffering to the new Command");
    }
    
    /**
     * Controls the gatherer wheels:
     * RB Button: Rotates wheels to pull ball into robot;
     * LB Button: Rotates wheels to eject the ball out of the robot.
     * @param controller The controller to be used
     */
    private void controlGathererWheels(XboxController controller)
    {
        if (controller.isRBButtonPressed())
        {
            gatherer.gatherBall();
            if (lights != null) {
                if (debugState != 0) {                    
                    log("setting lights to green");
                    debugState = 0;
                }
                lights.setColor(ILights.strip_body, ILights.kGreen);
            }
        }
        else if (controller.isLBButtonPressed())
        {
            gatherer.ejectBall();
            if (lights != null) {
                if (debugState != 1) {                    
                    log("setting lights to white");
                    debugState = 1;
                }
                lights.setColor(ILights.strip_body, ILights.kWhite);
            }
        }
        else
        {
            gatherer.stopGatherWheels();
            if (lights != null) {
                if (debugState != 2) {                    
                    log("setting lights to red");
                    debugState = 2;
                }
                lights.setColor(ILights.strip_body, ILights.kRed);
            }
        }
    }
    
    /**
     * Controls the gatherer articulation:
     * X Button: Articulates the gatherer into the robot
     * Y Button: Articulates the gatherer to the extended position.
     * @param controller The controller to be used
     */
    private void controlGathererArticulation(XboxController controller)
    {
        if (controller.isXButtonPressed())
        {
            gatherer.foldGatherer();
        }
        else if (controller.isYButtonPressed())
        {
            gatherer.extendGatherer();
        }
    }
    
}
