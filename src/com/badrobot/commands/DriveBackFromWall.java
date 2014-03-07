/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.badrobot.commands;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Drives in reverse (in a straight line) until hitting the correct distance mark.
 * @author Isaac
 */
public class DriveBackFromWall extends BadCommand {
    
    double distance, initialAngle, Kp;
    int checkNumber;

    public DriveBackFromWall(double dist) {
        requires ((Subsystem) driveTrain);
        distance = dist;
    }
    
    protected void initialize() {
        driveTrain.tankDrive(0, 0);
        checkNumber = 1;
        Kp = .05;
        initialAngle = driveTrain.getGyro().getAngle();
        driveTrain.shiftDown();
    }

    public String getConsoleIdentity() {
        return "DriveBackFromWall";
    }

    protected void execute() {
        driveTrain.getTrain().drive(-1.0, -(driveTrain.getGyro().getAngle()-initialAngle)*Kp);
        if (driveTrain.getDistanceToWall() > distance) {
            switch (checkNumber) {
                case 1:
                    checkNumber++;
                    break;
                case 2:
                    checkNumber++;
                    break;
                case 3:
                    checkNumber = 0;
                    break;
            }
        }
        else {
            checkNumber = 1;
        }
    }

    protected boolean isFinished() {
        if (checkNumber == 0) {
            return true;
        }
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
