/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.BadSubsystem;
import com.badrobot.RobotMap;
import com.badrobot.commands.DriveRobot;
import com.badrobot.subsystems.interfaces.IDriveTrain;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The drive train subsystem for the prototype robot;
 * All drive train functionality code should go in this class.
 * @author Isaac
 */
public class ProtoDriveTrain extends BadSubsystem implements IDriveTrain
{
    private static ProtoDriveTrain instance;
    
    //Physical components of the drive train:
    RobotDrive train;
    Solenoid shiftDownSolenoid, shiftUpSolenoid;
    SpeedController frontLeft, backLeft, frontRight, backRight;
    Gyro gyro;
    Ultrasonic ultrasonic;
    Encoder rightEncoder, leftEncoder;
    
    //Other variables:
    boolean shiftedDown;
    double encoderDistancePerPulse;
    
    /**
     * Gets the current instance of the subsystem;
     * If one doesn't exist, make one.
     * @return The current instance of this subsystem
     */
    public static ProtoDriveTrain getInstance()
    {
        if (instance == null)
        {
            instance = new ProtoDriveTrain();
        }
        return instance;
    }
    
    /**
     * Private constructor for an instance of the subsystem;
     * Required for the getInstace() method.
     */
    private ProtoDriveTrain()
    {
    }

    /**
     * Initializes the instance variables.
     */
    protected void initialize() 
    {
        encoderDistancePerPulse = 1;
        
        rightEncoder = new Encoder(RobotMap.rightEncoderA, RobotMap.rightEncoderB);
        leftEncoder = new Encoder(RobotMap.leftEncoderA, RobotMap.leftEncoderB);
        rightEncoder.start();
        leftEncoder.start();

        gyro = new Gyro(RobotMap.driveTrainGyro);
        gyro.reset();

        ultrasonic = new Ultrasonic(RobotMap.ultrasonicPing, 
                RobotMap.ultrasonicEcho, Ultrasonic.Unit.kInches);
        ultrasonic.setEnabled(true);
        ultrasonic.setAutomaticMode(true);

        shiftDownSolenoid = new Solenoid(RobotMap.shiftDownSolenoid);
        shiftUpSolenoid = new Solenoid(RobotMap.shiftUpSolenoid);
        shiftDown();

        frontLeft = new Talon(RobotMap.frontLeftController);
        backLeft = new Talon(RobotMap.backLeftController);
        frontRight = new Talon(RobotMap.frontRightController);
        backRight = new Talon(RobotMap.backRightController);

        train = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    }

    /**
     * Returns the console identity, which is
     * generally the class name.
     * @return the class name
     */
    public String getConsoleIdentity() 
    {
        return "ProtoDriveTrain";
    }

    /**
     * Defines the default command for this subsystem.
     */
    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new DriveRobot());
    }

    /**
     * Drives the robot tank-style with two inputs.
     * @param left Speed from -1 to 1 to drive the left side of the robot
     * @param right Speed from -1 to 1 to drive the right side of the robot
     */
    public void tankDrive(double left, double right) 
    {
        train.tankDrive(left, right);
    }
    
    /**
     * Shifts both sides of the drive train into high gear.
     */
    public void shiftUp()
    {
        if (shiftedDown)
        {
            shiftDownSolenoid.set(false);
            shiftUpSolenoid.set(true);
            shiftedDown = false;
        }
    }
    
    /**
     * Shifts both sides of the drive train into low gear.
     */
    public void shiftDown()
    {
        if (!shiftedDown)
        {
            shiftUpSolenoid.set(false);
            shiftDownSolenoid.set(true);
            shiftedDown = true;
        }
    }
    
    /**
     * Gets the gyro.
     * @return The gyro object
     */
    public Gyro getGyro()
    {
        return gyro;
    }
    
    /**
     * Gets the right encoder.
     * @return The right encoder object
     */
    public Encoder getRightEncoder()
    {
        return rightEncoder;
    }
    
    /**
     * Gets the left encoder.
     * @return The left encoder object
     */
    public Encoder getLeftEncoder()
    {
        return leftEncoder;
    }
    
    /**
     * Gets the distance to the wall using the ultrasonic sensor.
     * @return The distance to wall in inches
     */
    public double getDistanceToWall()
    {
        ultrasonic.ping();
        return ultrasonic.getRangeInches();
    }
    
    /**
     * Gets the train object of the drive train.
     * @return The train object
     */
    public RobotDrive getTrain()
    {
         return train;
    }
    
    /**
     * Gets the drive train encoder distance per pulse;
     * This is used to calibrate the encoder distance per pulse.
     * @return The encoder distance per pulse value
     */
    public double getEncoderDistancePerPulse()
    {
        return encoderDistancePerPulse;
    }
    
    /**
     * Sets the drive train encoder distance per pulse;
     * This is used to calibrate the encoder distance per pulse.
     * @param d The value to set the distance per pulse to
     */
    public void setEncoderDistancePerPulse(double d)
    {
        encoderDistancePerPulse = d;
        //rightEncoder.setDistancePerPulse(d);
        //leftEncoder.setDistancePerPulse(d);
    }
    
}
