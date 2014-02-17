/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
import com.badrobot.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author Isaac
 */
public class GatherBall extends BadCommand
{
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
        }
        else if (controller.isLBButtonPressed())
        {
            gatherer.ejectBall();
        }
        else
        {
            gatherer.stopGatherWheels();
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
