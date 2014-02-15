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
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Isaac
 */
public class ProtoDriveTrain extends BadSubsystem implements IDriveTrain
{
    private static ProtoDriveTrain instance;
    private static boolean shiftedUp, compressorOn;
    
    private static double encoderDistancePerPulse;
    
    RobotDrive train;
    DigitalInput pressureSwitch;
    Relay compressorSwitch;
    Solenoid shiftDownSolenoid, shiftUpSolenoid;
    SpeedController frontLeft, backLeft, frontRight, backRight;
    Gyro gyro;
    Ultrasonic ultrasonic;
    Encoder rightEncoder, leftEncoder;
    
    public static ProtoDriveTrain getInstance()
    {
        if (instance == null)
        {
            instance = new ProtoDriveTrain();
        }
        return instance;
    }
    
    private ProtoDriveTrain()
    {
        
    }

    protected void initialize() 
    {
        if (!RobotMap.isPrototype)
        {
            shiftedUp = true;
            compressorOn = false;
            
            rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
            leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
            rightEncoder.start();
            leftEncoder.start();
            
            /*encoderDistancePerPulse = 1;
            
            gyro = new Gyro(RobotMap.driveTrainGyro);
            gyro.reset();
            
            ultrasonic = new Ultrasonic(RobotMap.ultrasonicPing, 
                    RobotMap.ultrasonicEcho, Ultrasonic.Unit.kInches);
            ultrasonic.setEnabled(true);
            ultrasonic.setAutomaticMode(true);*/
            
            pressureSwitch = new DigitalInput(RobotMap.pressureSwitchDigitalIn);
            compressorSwitch = new Relay(RobotMap.compressorSwitchRelay);
            compressorSwitch.setDirection(Relay.Direction.kForward);
            
            shiftDownSolenoid = new Solenoid(RobotMap.shiftDownSolenoid);
            shiftUpSolenoid = new Solenoid(RobotMap.shiftUpSolenoid);
            
            frontLeft = new Talon(RobotMap.frontLeftController);
            backLeft = new Talon(RobotMap.backLeftController);
            frontRight = new Talon(RobotMap.frontRightController);
            backRight = new Talon(RobotMap.backRightController);
            
            train = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
        }
        else
        {
            shiftedUp = true;
            compressorOn = false;
            
            rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
            leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
            rightEncoder.start();
            leftEncoder.start();
            
            encoderDistancePerPulse = 1;
            
            gyro = new Gyro(RobotMap.driveTrainGyro);
            gyro.reset();
            
            ultrasonic = new Ultrasonic(RobotMap.ultrasonicPing, 
                    RobotMap.ultrasonicEcho, Ultrasonic.Unit.kInches);
            ultrasonic.setEnabled(true);
            ultrasonic.setAutomaticMode(true);
            
            pressureSwitch = new DigitalInput(RobotMap.pressureSwitchDigitalIn);
            compressorSwitch = new Relay(RobotMap.compressorSwitchRelay);
            compressorSwitch.setDirection(Relay.Direction.kForward);
            
            shiftDownSolenoid = new Solenoid(RobotMap.shiftDownSolenoid);
            shiftUpSolenoid = new Solenoid(RobotMap.shiftUpSolenoid);
            
            frontLeft = new Talon(RobotMap.frontLeftController);
            backLeft = new Talon(RobotMap.backLeftController);
            frontRight = new Talon(RobotMap.frontRightController);
            backRight = new Talon(RobotMap.backRightController);
            
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
        if (up && !shiftedUp)
        {
            shiftDownSolenoid.set(false);
            shiftUpSolenoid.set(true);
            shiftedUp = true;
        }
        else if (!up && shiftedUp)
        {
            shiftUpSolenoid.set(false);
            shiftDownSolenoid.set(true);
            shiftedUp = false;
        }
    }

    public void compressorEnabled(boolean on) 
    {
        if (on && !compressorOn)
        {
            compressorSwitch.set(Relay.Value.kOn);
            compressorOn = true;
        }
        else if (!on && compressorOn)
        {
            compressorSwitch.set(Relay.Value.kOff);
            compressorOn = false;
        }
    }

    public boolean getCompressorLimit() 
    {
        return !pressureSwitch.get();
    }
    
    public Gyro getGyro()
    {
        return gyro;
    }
    
    public Encoder getRightEncoder()
    {
        return rightEncoder;
    }
    
    public Encoder getLeftEncoder()
    {
        return leftEncoder;
    }
    
    public double getDistanceToWall()
    {
        log("valid? : " + ultrasonic.isRangeValid() + "  ,  enabled: "+ultrasonic.isEnabled());
        ultrasonic.ping();
        return ultrasonic.getRangeInches();
    }
    
    public RobotDrive getTrain()
    {
         return train;
    }
    
    public double getEncoderDistancePerPulse()
    {
        return encoderDistancePerPulse;
    }
    
    public void setEncoderDistancePerPulse(double d)
    {
        encoderDistancePerPulse = d;
        //rightEncoder.setDistancePerPulse(d);
        //leftEncoder.setDistancePerPulse(d);
    }
    
}
