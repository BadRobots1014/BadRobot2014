package com.badrobot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
    public static final int driverStation_ControllerPort1 = 1;
    public static final int driverStation_ControllerPort2 = 2;
    
    public static final int NI9102_AnalogIn1 = 1;
    
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    
    //Misc Important Robot Variables
    public static final boolean isPrototype = true;
    
    //~~~~~~~~OUTPUT~~~~~~~~//
    
    //Speed Controller Ports
    public static final int frontLeftController = Sidecar.PWMOUT4;
    public static final int backLeftController = Sidecar.PWMOUT3;
    public static final int frontRightController = Sidecar.PWMOUT1;
    public static final int backRightController = Sidecar.PWMOUT2;
    public static final int winchController = Sidecar.PWMOUT5;
    
    //Gyro Ports
    public static final int driveTrainGyro = Sidecar.ANALOG_BREAKOUT1;
    
    //Ultrasonic Ports
    public static final int ultrasonicPing = Sidecar.DIO3;
    public static final int ultrasonicEcho = Sidecar.DIO2;
    
    //Encoder Ports
    public static final int rightEncoderA = Sidecar.DIO4;
    public static final int rightEncoderB = Sidecar.DIO5;
    public static final int leftEncoderA = Sidecar.DIO6;
    public static final int leftEncoderB = Sidecar.DIO7;
    
    //Compressor Ports
    public static final int compressorSwitchRelay = Sidecar.RELAY1;
    public static final int gathererMotorRelay = Sidecar.RELAY2;
    
    //Solenoid Ports
    public static final int shiftDownSolenoid = Sidecar.PNEUMATIC_BUMPER7;
    public static final int shiftUpSolenoid = Sidecar.PNEUMATIC_BUMPER8;
    public static final int engageWinchSolenoid = Sidecar.PNEUMATIC_BUMPER2;
    public static final int disengageWinchSolenoid = Sidecar.PNEUMATIC_BUMPER1;
    public static final int pullGatherer = Sidecar.PNEUMATIC_BUMPER4;
    public static final int pushGatherer = Sidecar.PNEUMATIC_BUMPER3;
    
    
    //~~~~~~~~INPUT~~~~~~~~//
    
    //Digital Input Pressure Switch
    public static final int pressureSwitchDigitalIn = Sidecar.DIO1;
}
