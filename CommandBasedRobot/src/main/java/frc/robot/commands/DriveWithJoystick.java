/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Controller;
import frc.robot.Robot;

/**  
 * Moves Motor Forward.
 */
public class DriveWithJoystick extends Command {
  
  boolean isInterrupted = false;
  
  public DriveWithJoystick() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    isInterrupted = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    Controller driver = Robot.m_oi.getDriverController();
    Robot.drive.setSpeed(driver.getLeftYAxis(), driver.getRightYAxis());

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    return isInterrupted;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.drive.stop();

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    isInterrupted = true;
    Robot.drive.stop();

  }
}
