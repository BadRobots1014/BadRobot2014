// TODO: License?

package com.badrobot;

/*
NOTE: This code should never have to change unless the physical attributes
of the cRIO Sidecar change.

This class is to build an abstraction for the cRIO Sidecar, declaring
all the inputs and outputs (so that it is easy to figure out what should
be hooked up to the available ports).
*/
public class Sidecar
{
    // DO NOT CHANGE THIS CODE UNLESS THE cRIO Sidecar changes
    public static final int PWMOUT1 = 1;
    public static final int PWMOUT2 = 2;
    public static final int PWMOUT3 = 3;
    public static final int PWMOUT4 = 4;
    public static final int PWMOUT5 = 5;
    public static final int PWMOUT6 = 6;    
    public static final int PWMOUT7 = 7;    
    public static final int PWMOUT8 = 8;    
    public static final int PWMOUT9 = 9;    
    
    public static final int DIO1 = 1;
    public static final int DIO2 = 2;
    public static final int DIO3 = 3;
    public static final int DIO4 = 4;
    public static final int DIO5 = 5;
    public static final int DIO6 = 6;
    public static final int DIO7 = 7;
    public static final int DIO8 = 8;
    public static final int DIO9 = 9;
    public static final int DIO10 = 10;
    public static final int DIO11 = 11;
    public static final int DIO12 = 12;
    public static final int DIO13 = 13;
    public static final int DIO14 = 14;
    
    public static final int RELAY1 = 1;
    public static final int RELAY2 = 2;    
    
    //These are not actually on the sidecar...
    public static final int SOLENOID1 = 1;
    public static final int SOLENOID2 = 2;
    public static final int SOLENOID3 = 3;
    public static final int SOLENOID4 = 4;
    public static final int SOLENOID5 = 5;
    public static final int SOLENOID6 = 6;
    //There are more solenoids
}




