/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems;

import com.badrobot.subsystems.interfaces.IVisionTracking;
import edu.wpi.first.wpilibj.camera.AxisCamera;
/**
 *
 * @author Steve and Scott
 */
public class VisionTracking extends BadSubsystem implements IVisionTracking {

    protected AxisCamera camera;
    protected Thread t; 
    protected boolean running;
    
    public VisionTracking(AxisCamera c)
    {
        t = new Thread();
        t.start();
        running = true;
        
        camera = c;
        camera.writeResolution(AxisCamera.ResolutionT.k160x120);
    }

    protected void initialize() 
    {
        
    }

    public String getConsoleIdentity()
    {
        return "VisionTrackingSubsystem";
    }

    protected void initDefaultCommand() 
    {
    
    }

    public void run() 
    {
        
    }
    
    public void stop() throws InterruptedException
    {
        t.join();
    }
    
}
