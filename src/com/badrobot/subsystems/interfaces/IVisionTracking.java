/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.subsystems.interfaces;

import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;

/**
 *
 * @author Steve
 */
public interface IVisionTracking 
{
    public BinaryImage processedImage();
    
    public boolean isHot(BinaryImage c);
    
    public boolean currentImageIsHot();
    
    
}
