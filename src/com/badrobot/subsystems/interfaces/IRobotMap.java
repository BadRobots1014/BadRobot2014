/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems.interfaces;

/**
 *
 * @author Isaac
 */
public interface IRobotMap 
{
    //Xbox Controller Ports
    public int getDriverStationControllerPort1();
    public int getDriverStationControllerPort2();
    
    //~~~~~~~~~~~~~OUTPUT~~~~~~~~~~~~~//
    
    //PWM
    public int getFrontLeftSpeedControllerPort();
    public int getFrontRightSpeedControllerPort();
    public int getBackLeftSpeedControllerPort();
    public int getBackRightSpeedControllerPort();
    public int getWinchSpeedControllerPort();
    
    //Analog Breakout
    public int getGyroPort();
    
    //Digital In/Out
    public int getRightEncoderAPort();
    public int getRightEncoderBPort();
    public int getLeftEncoderAPort();
    public int getLeftEncoderBPort();
    public int getUltrasonicPingPort();
    public int getUltrasonicEchoPort();
    
    
    //Relay
    public int getCompressorRelayPort();
    public int getGathererMotorRelayPort();
    
    //Pneumatic Bumper
    public int getShiftDownSolenoidPort();
    public int getShiftUpSolenoidPort();
    public int getEngageWinchSolenoidPort();
    public int getDisengageWinchSolenoidPort();
    public int getFoldGathererSolenoidPort();
    public int getExtendGathererSolenoidPort();
    
    //Lights
    public int getRedChannelPort();
    public int getGreenChannelPort();
    public int getBlueChannelPort();
    
    //~~~~~~~~~~~~~INPUT~~~~~~~~~~~~~//
    
    //Digital In/Out
    public int getPressureSwitchPort();
    public int getGathererOpticalSensorPort();
}
