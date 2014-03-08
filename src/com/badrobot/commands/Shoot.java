/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import com.badrobot.OI;
import com.badrobot.RobotMain;
import com.badrobot.RobotMap;
import com.badrobot.XboxController;
import com.badrobot.subsystems.interfaces.ILights;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Utility;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Isaac
 */
public class Shoot extends BadCommand
{
    private static double COCK_BACK_SPEED = 1.0;
    //private Timer timer;
    
    long startTime;

    public Shoot()
    {
        requires((Subsystem) shooter);
    }
    
    protected void initialize() 
    {
        shooter.engageWinch();
    }

    public String getConsoleIdentity() 
    {
        return "Shoot";
    }

    protected void execute() 
    {
        /*
        if (lights != null) {
            if (shooter.isCockedBack()) {
                lights.setColor(ILights.kGreen);
            }
        }
        * */
        
        //Used when two controllers will be used
        if (!OI.isSingleControllerMode())
        {
            //Cock shooter with A, release with B
            controlWinch(OI.primaryController, OI.secondaryController);
        }
        //Used when one controller will be used
        else
        {
            //Cock shooter with A, release with B
            controlWinch(OI.primaryController);
        }
        
        SmartDashboard.putBoolean("Shooter Cocked Back", shooter.isCockedBack());
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
        
    }

    protected void interrupted() 
    {
        
    }
    
    private void controlWinch(XboxController controller1, XboxController controller2)
    {
        SmartDashboard.putBoolean("Primary Fire", controller1.isBButtonPressed());
        SmartDashboard.putBoolean("Secondary Fire", controller2.isBButtonPressed());
        
        if (controller2.isAButtonPressed())
        {
            shooter.cockBack(COCK_BACK_SPEED);
        }
        else
        {
            shooter.cockBack(0);
        }
        //Allows firing if both B buttons are pressed or if the select button is pressed on the second controller
        if ((controller1.isBButtonPressed() && controller2.isBButtonPressed()) || controller2.isSelectButtonPressed())
        {
            startTime = Utility.getFPGATime();
            shooter.disengageWinch();
        }
        else if ((Utility.getFPGATime() - startTime) > 0.5*1000000)
        {
            shooter.engageWinch();
        }
    }
    private void controlWinch(XboxController controller2)
    {
        if (controller2.isAButtonPressed())
        {
            shooter.cockBack(COCK_BACK_SPEED);
        }
        else
        {
            shooter.cockBack(0);
        }
        
        if (controller2.isBButtonPressed())
        {
            startTime = Utility.getFPGATime();
            shooter.disengageWinch();
        }
        else if ((Utility.getFPGATime() - startTime) > 0.5*1000000)
        {
            shooter.engageWinch();
        }
    }
}