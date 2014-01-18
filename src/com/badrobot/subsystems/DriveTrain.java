/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.commands.DriveRobot;
import com.badrobot.subsystems.interfaces.IDriveTrain;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Isaac
 */
public class DriveTrain extends BadSubsystem implements IDriveTrain
{
    private static DriveTrain instance;
    private static boolean shiftedUp;
    
    RobotDrive train;
    DigitalInput pressureSwitch;
    Relay compressorSwitch;
    Solenoid shiftUpSolenoid, shiftDownSolenoid;
    SpeedController frontLeft, backLeft, frontRight, backRight;
    
    public static DriveTrain getInstance()
    {
        if (instance == null)
        {
            instance = new DriveTrain();
        }
        return instance;
    }
    
    private DriveTrain()
    {
        
    }

    protected void initialize() 
    {
        if (!RobotMap.isPrototype)
        {
            //final robot code goes here
        }
        else
        {
            shiftedUp = false;
            
            pressureSwitch = new DigitalInput(RobotMap.pressureSwitchDigitalIn);
            compressorSwitch = new Relay(RobotMap.compressorSwitchRelay);
            compressorSwitch.setDirection(Relay.Direction.kForward);

            shiftUpSolenoid = new Solenoid(RobotMap.shiftUpSolenoidPWM);
            shiftDownSolenoid = new Solenoid(RobotMap.shiftDownSolenoidPWM);
            
            frontLeft = new Talon(RobotMap.frontLeftControllerPWM);
            backLeft = new Talon(RobotMap.backLeftControllerPWM);
            frontRight = new Talon(RobotMap.frontRightControllerPWM);
            backRight = new Talon(RobotMap.backRightControllerPWM);
            
            train = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
        }
    }

    public String getConsoleIdentity() 
    {
        return "DriveTrain";
    }

    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new DriveRobot());
    }

    public void tankDrive(double left, double right) 
    {
        train.tankDrive(left, right);
    }

    public void shift(boolean up) 
    {
        if (!shiftedUp && up)
        {
            shiftDownSolenoid.set(false);
            shiftUpSolenoid.set(true);
            shiftedUp = true;
        }
        else if (shiftedUp && !up)
        {
            shiftUpSolenoid.set(false);
            shiftDownSolenoid.set(true);
            shiftedUp = false;
        }
    }

    public void compressorEnabled(boolean on) 
    {
        if (on)
        {
            compressorSwitch.set(Relay.Value.kOn);
        }
        else
        {
            compressorSwitch.set(Relay.Value.kOff);
        }
    }

    public boolean getCompressorLimit() 
    {
        return !pressureSwitch.get();
    }
    
}
