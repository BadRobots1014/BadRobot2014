/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot;

import com.badrobot.subsystems.interfaces.IRobotMap;

/**
 *
 * @author Isaac
 */
public class ProtoRobotMap implements IRobotMap
{
    //~~~~~~~~~~~~~OUTPUT~~~~~~~~~~~~~//

    public int getDriverStationControllerPort1() {
        return 1;
    }

    public int getDriverStationControllerPort2() {
        return 2;
    }

    public int getFrontLeftSpeedControllerPort() {
        return Sidecar.PWMOUT4;
    }

    public int getFrontRightSpeedControllerPort() {
        return Sidecar.PWMOUT1;
    }

    public int getBackLeftSpeedControllerPort() {
        return Sidecar.PWMOUT3;
    }

    public int getBackRightSpeedControllerPort() {
        return Sidecar.PWMOUT2;
    }
    
    public int getWinchSpeedControllerPort() {
        return Sidecar.PWMOUT5;
    }

    public int getGyroPort() {
        return Sidecar.ANALOG_BREAKOUT1;
    }

    public int getRightEncoderAPort() {
        return Sidecar.DIO4;
    }

    public int getRightEncoderBPort() {
        return Sidecar.DIO5;
    }

    public int getLeftEncoderAPort() {
        return Sidecar.DIO6;
    }

    public int getLeftEncoderBPort() {
        return Sidecar.DIO7;
    }

    public int getUltrasonicPingPort() {
        return Sidecar.DIO3;
    }

    public int getUltrasonicEchoPort() {
        return Sidecar.DIO2;
    }

    public int getCompressorRelayPort() {
        return Sidecar.RELAY1;
    }

    public int getGathererMotorRelayPort() {
        return Sidecar.RELAY2;
    }

    public int getShiftDownSolenoidPort() {
        return Sidecar.PNEUMATIC_BUMPER7;
    }

    public int getShiftUpSolenoidPort() {
        return Sidecar.PNEUMATIC_BUMPER8;
    }

    public int getEngageWinchSolenoidPort() {
        return Sidecar.PNEUMATIC_BUMPER2;
    }

    public int getDisengageWinchSolenoidPort() {
        return Sidecar.PNEUMATIC_BUMPER1;
    }

    public int getFoldGathererSolenoidPort() {
        return Sidecar.PNEUMATIC_BUMPER4;
    }

    public int getExtendGathererSolenoidPort() {
        return Sidecar.PNEUMATIC_BUMPER3;
    }

    public int getRedChannelPort() {
        return -1;
    }

    public int getGreenChannelPort() {
        return -1;
    }

    public int getBlueChannelPort() {
        return -1;
    }

    //~~~~~~~~~~~~~INPUT~~~~~~~~~~~~~//
    
    public int getPressureSwitchPort() {
        return Sidecar.DIO1;
    }

    public int getGathererOpticalSensorPort() {
        return Sidecar.DIO8;
    }
    
}
