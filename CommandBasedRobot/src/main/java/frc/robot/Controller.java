/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
//This is where a comment would go
//If I HAD ONE (Timmy Turner dad)
/**
 * Assigns button values and functions.
 */
public class Controller {

    private static final int LEFT_X = 1;
    private static final int DOWN_A = 2;
    private static final int RIGHT_B = 3;
    private static final int UP_Y = 4;
    
    private static final int LEFT_BUMPER = 5;
    private static final int RIGHT_BUMPER = 6;
    private static final int LEFT_TRIGGER = 7;
    private static final int RIGHT_TRIGGER = 8;

    private Joystick stick;
    private JoystickButton leftX;
    private JoystickButton downA;
    private JoystickButton rightB;
    private JoystickButton upY;

    private JoystickButton leftBumper;
    private JoystickButton rightBumper;
    private JoystickButton leftTrigger;
    private JoystickButton rightTrigger;

    public static enum DPadDirection {
		LEFT, RIGHT, UP, DOWN, UP_RIGHT, DOWN_RIGHT, UP_LEFT, DOWN_LEFT, NONE
	}

    public Controller(int port) {

        stick = new Joystick(port);

        stick.getRawAxis(0);
        leftX = new JoystickButton(stick, LEFT_X);
        downA = new JoystickButton(stick, DOWN_A);
        rightB = new JoystickButton(stick, RIGHT_B);
        upY = new JoystickButton(stick, UP_Y);
        leftBumper = new JoystickButton(stick, LEFT_BUMPER);
        rightBumper = new JoystickButton(stick, RIGHT_BUMPER);
        leftTrigger = new JoystickButton(stick, LEFT_TRIGGER);
        rightTrigger = new JoystickButton(stick, RIGHT_TRIGGER);
    }

    public boolean buttonPressed(int buttonNum) {
        return stick.getRawButton(buttonNum);
    }

    public double getLeftXAxis() {
        return stick.getRawAxis(0);
    }

    public double getLeftYAxis() {
        return -stick.getRawAxis(1);
    }

    public double getRightXAxis() {
        return stick.getRawAxis(2);
    }

    public double getRightYAxis() {
        return -stick.getRawAxis(3);
    }
    
    public JoystickButton getLeftXButton() {
        return leftX;
    }

    public JoystickButton getDownAButton() {
        return downA;
    }

    public JoystickButton getUpYButton() {
        return upY;
    }

    public JoystickButton getrightBButton() {
        return rightB;
    }

    public JoystickButton getLeftBumperButton() {
        return leftBumper;
    }

    public JoystickButton getRightBumperButton() {
        return rightBumper;
    }

    public JoystickButton getLeftTriggerButton() {
        return leftTrigger;
    }

    public JoystickButton getRightTriggerButton() {
        return rightTrigger;
    }

    public DPadDirection getDPad() {

        int pov = stick.getPOV();
        
        switch (pov) {
		case 0:
			return DPadDirection.UP;
		case 90:
			return DPadDirection.RIGHT;
		case 180:
			return DPadDirection.DOWN;
		case 270:
			return DPadDirection.LEFT;
		default:
			return DPadDirection.NONE;

		}
	}


}
