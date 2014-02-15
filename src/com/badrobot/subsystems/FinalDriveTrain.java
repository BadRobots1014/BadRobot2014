/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.RobotMap;
import com.badrobot.commands.DriveRobot;
import com.badrobot.subsystems.interfaces.IDriveTrain;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Isaac
 */
public class FinalDriveTrain extends BadSubsystem implements IDriveTrain
{
    private static FinalDriveTrain instance;
    
    boolean shiftedDown;
    double encoderDistancePerPulse;
    
    RobotDrive train;
    Solenoid shiftUpSolenoid;
    SpeedController frontLeft, backLeft, frontRight, backRight;
    Gyro gyro;
    Ultrasonic ultrasonic;
    Encoder rightEncoder, leftEncoder;
    
    public static FinalDriveTrain getInstance()
    {
        if (instance == null)
        {
            instance = new FinalDriveTrain();
        }
        return instance;
    }
    
    private FinalDriveTrain()
    {
        
    }

    protected void initialize() 
    {
        /*
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
        */
        
        shiftUpSolenoid = new Solenoid(RobotMap.shiftUpSolenoid);
        shiftDown();

        frontLeft = new Talon(RobotMap.frontLeftController);
        backLeft = new Talon(RobotMap.backLeftController);
        frontRight = new Talon(RobotMap.frontRightController);
        backRight = new Talon(RobotMap.backRightController);

        train = new RobotDrive(frontLeft, backLeft, frontRight, backRight);
    }

    public String getConsoleIdentity() 
    {
        return "FinalDriveTrain";
    }

    protected void initDefaultCommand() 
    {
        this.setDefaultCommand(new DriveRobot());
    }

    public void tankDrive(double left, double right) 
    {
        train.tankDrive(left, right);
    }
    
    public void shiftUp()
    {
        if (shiftedDown)
        {
            shiftUpSolenoid.set(true);
            shiftedDown = false;
        }
    }
    
    public void shiftDown()
    {
        if (!shiftedDown)
        {
            shiftUpSolenoid.set(false);
            shiftedDown = true;
        }
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
