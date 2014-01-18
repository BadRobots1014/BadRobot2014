/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot;

import edu.wpi.first.wpilibj.Joystick;

/**
 *
 * @author Isaac
 */
public class XboxController extends Joystick
{
    private static int LEFT_STICK_X = 1, LEFT_STICK_Y = 2, RIGHT_STICK_X = 3, RIGHT_STICK_Y = 5;
    private static int A_BUTTON = 1, B_BUTTON = 2, X_BUTTON = 3, Y_BUTTON = 4, 
                        LB = 5, RB = 6, SELECT = 7, START = 8, LEFT_JOY_CLICK = 9, RIGHT_JOY_CLICK = 10;
    
    public XboxController(int port)
    {
        super(port);
    }
    
    public double getLeftStickX() {
        return OI.deadzone(-this.getRawAxis(LEFT_STICK_X));
    }

    public double getLeftStickY() {
        return OI.deadzone(-this.getRawAxis(LEFT_STICK_Y));
    }

    public double getRightStickX() {
        return OI.deadzone(-this.getRawAxis(RIGHT_STICK_X));
    }

    public double getRightStickY() {
        return OI.deadzone(-this.getRawAxis(RIGHT_STICK_Y));
    }

    public boolean isXButtonPressed() {
        return this.getRawButton(X_BUTTON);
    }

    public boolean isYButtonPressed() {
        return this.getRawButton(Y_BUTTON);
    }

    public boolean isAButtonPressed() {
        return this.getRawButton(A_BUTTON);
    }

    public boolean isBButtonPressed() {
        return this.getRawButton(B_BUTTON);
    }

    public boolean isRBButtonPressed() {
        return this.getRawButton(RB);
    }

    public boolean isLBButtonPressed() {
        return this.getRawButton(LB);
    }

    public boolean isLeftJoyClick() {
        return this.getRawButton(RIGHT_JOY_CLICK);
    }

    public boolean isRightJoyClick() {
        return this.getRawButton(LEFT_JOY_CLICK);
    }

    public boolean isSelectButtonPressed() {
        return this.getRawButton(SELECT);
    }

    public boolean isStartButtonPressed() {
        return this.getRawButton(START);
    }
    
    public double getRightTrigger() {
        double triggerValue = this.getRawAxis(3);
        if (triggerValue < 0) {
            return Math.abs(OI.deadzone(triggerValue));
        } else {
            return 0;
        }
    }

    public double getLeftTrigger() {
        double triggerValue = this.getRawAxis(3);
        if (triggerValue > 0) {
            return OI.deadzone(triggerValue);
        } else {
            return 0;
        }
    }
}
