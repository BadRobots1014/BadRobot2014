/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.subsystems.interfaces.IVisionTracking;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The vision tracking subsystem for the prototype robot;
 * All vision tracking functionality code should go in this class.
 * @author Steve and Scott
 */
public class VisionTracking extends BadSubsystem implements IVisionTracking 
{
    private static VisionTracking instance;
    
    //Physical components of vision tracking:
    private AxisCamera camera;
    private ColorImage image, lastWorkingImage;
    BinaryImage filteredImage;

    //Other variables:
    private int HIGH_RED = 0;
    private int HIGH_BLUE = 0;
    private int HIGH_GREEN = 0;
    private int LOW_RED = 0;
    private int LOW_BLUE = 0;
    private int LOW_GREEN = 0;//for our color we are shooting at retrotape
    
    boolean isInitialized;
    Timer timer;
    
    int errorCount = 0;

    /**
     * Gets the current instance of the subsystem;
     * If one doesn't exist, make one.
     * @return The current instance of this subsystem
     */
    public static VisionTracking getInstance()
    {
        if (instance == null)
        {
            instance = new VisionTracking();
        }
        return instance;
    }
    
    /**
     * Private constructor for an instance of the subsystem;
     * Required for the getInstace() method.
     */
    private VisionTracking()
    {
    }
    
    /**
     * Initializes the instance variables.
     */
    protected void initialize() 
    {
        SmartDashboard.putNumber("High Red", 0);
        SmartDashboard.putNumber("High Blue", 0);
        SmartDashboard.putNumber("High Green", 0);
        SmartDashboard.putNumber("Low Red", 0);
        SmartDashboard.putNumber("Low Blue", 0);
        SmartDashboard.putNumber("Low Green", 0);
        
        camera = AxisCamera.getInstance();
        camera.writeResolution(AxisCamera.ResolutionT.k320x240);
        camera.writeMaxFPS(7);
        
        timer = new Timer();
        timer.start();
    }

    /**
     * Returns the console identity, which is
     * generally the class name.
     * @return the class name
     */
    public String getConsoleIdentity()
    {
        return "VisionTrackingSubsystem";
    }

    /**
     * Defines the default command for this subsystem.
     */
    protected void initDefaultCommand() 
    {
        //this should be filled
    }


    public BinaryImage processedImage()  
    {
        if(HIGH_RED != (int) SmartDashboard.getNumber("High Red"))
                HIGH_RED = (int) SmartDashboard.getNumber("High Red");
        
        if(HIGH_BLUE != (int) SmartDashboard.getNumber("High Blue"))
                HIGH_BLUE = (int) SmartDashboard.getNumber("High Blue");
        
        if(HIGH_GREEN != (int) SmartDashboard.getNumber("High Green"))
                HIGH_GREEN = (int) SmartDashboard.getNumber("High Green");
        
        if(LOW_RED != (int) SmartDashboard.getNumber("Low Red"))
                LOW_RED = (int) SmartDashboard.getNumber("Low Red");
        
        if(LOW_BLUE != (int) SmartDashboard.getNumber("Low Blue"))
                LOW_BLUE = (int) SmartDashboard.getNumber("Low Blue");
        
        if(LOW_GREEN != (int) SmartDashboard.getNumber("Low Green"))
                LOW_GREEN = (int) SmartDashboard.getNumber("Low Green");
        
        filteredImage = null;
        if (isInitialized) {
            try {
                image.free();
            } catch (NIVisionException ex) {
                ex.printStackTrace();
            }
        }
        
        isInitialized = true;
        
        try {  
            image = camera.getImage();
        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        try {
            //this should be 320x240 (or 240x320 if I am dumb)
            log("~~~~~~~~~~~~~~~~~~~~~~~~~"+image.getWidth()+"  x  "+image.getHeight());
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        try {
            //ask someone to look over this code..
            if (image.getWidth() == 0 || image.getHeight() == 0) {
                errorCount++;
                log("Has dropped "+errorCount+" frames!");
                image = lastWorkingImage;
            }
            else {
                lastWorkingImage = image;
            }
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        try {
            filteredImage = (BinaryImage) image.thresholdRGB(LOW_RED, HIGH_RED, LOW_GREEN, HIGH_GREEN, LOW_BLUE, HIGH_BLUE);//needs to be the color we send out
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }

        return filteredImage;
    }

    public boolean isHot(BinaryImage c)
    {
        boolean isHot = false;
        try {
            if(c.getNumberParticles() > 0)
            {
                isHot = true;
            }
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        
        try {
            filteredImage.free();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
        
        return isHot;
    }

    public boolean currentImageIsHot()
    {
        return isHot(processedImage());
    }
    
}
