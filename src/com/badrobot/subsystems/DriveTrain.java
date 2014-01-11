/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.subsystems.interfaces.IDriveTrain;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Isaac
 */
public class DriveTrain extends BadSubsystem implements IDriveTrain
{
    //instance variables
    private static DriveTrain instance;
    private static boolean shiftedUp;
    
    RobotDrive train;
    DigitalInput compressorLimitSwitch;
    Relay compressorSwitch;
    Relay leftShifterRelay;
    DoubleSolenoid rightShifter;
    SpeedController leftSpeedController, rightSpeedController;
    
    //
    
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
            
            compressorLimitSwitch = new DigitalInput(RobotMap.compressorLimitSwitch);
            compressorSwitch = new Relay(RobotMap.compressorSwitch);
            compressorSwitch.setDirection(Relay.Direction.kForward);

            leftShifterRelay = new Relay(RobotMap.leftShifterRelay);
            rightShifter = new DoubleSolenoid(RobotMap.rightShifterUp, RobotMap.rightShifterDown);

            leftSpeedController = new Victor(RobotMap.leftSpeedController);
            rightSpeedController = new Victor(RobotMap.rightSpeedController);
            
            train = new RobotDrive(leftSpeedController, rightSpeedController);
        }
    }

    public String getConsoleIdentity() 
    {
        return "DriveTrain";
    }

    protected void initDefaultCommand() 
    {
        //this.setDefaultCommand(new DriveRobot());
    }

    /**
     * Drives the robot in tank drive--two sticks represent the left and right
     * sides of the robot; pushing forward on the left stick moves the left side
     * forward, pushing backwards on the right stick moves the right side of the
     * robot backwards.
     *
     * @param left the left side joystick value (-1 to 1)
     * @param right the right joystick value (-1 to 1)
     */
    public void tankDrive(double left, double right) 
    {
        train.tankDrive(left, right);
    }

    public void shift(boolean up) 
    {
        if (!shiftedUp && up)
        {
            log("shifting up");
            rightShifter.set(DoubleSolenoid.Value.kForward);
            leftShifterRelay.set(Relay.Value.kForward);
            shiftedUp = true;
        }
        else if (shiftedUp && !up)
        {
            log("shifting down");
            rightShifter.set(DoubleSolenoid.Value.kReverse);
            leftShifterRelay.set(Relay.Value.kReverse);
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
        return compressorLimitSwitch.get();
    }
    
}
