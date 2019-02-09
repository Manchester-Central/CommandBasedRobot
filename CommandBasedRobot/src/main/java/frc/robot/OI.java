/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commandGroups.AutoDrive;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.WaitTime;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveForward;

/**  
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  Controller driver = new Controller(0);
  Controller operator = new Controller(1);
  // Button button = new JoystickButton(stick, buttonNumber);

  public OI () {

    driver.getLeftXButton().whileHeld(new MoveForward());
    driver.getRightBumperButton().whileHeld(new WaitTime(5));
    driver.getLeftBumperButton().whenPressed(new DriveDistance(24));
    driver.getUpYButton().whenPressed(new AutoDrive());

  }

  public Controller getDriverController () {
    return driver;
  }

  public Controller getOperatorController() {
    return operator;
  }
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
