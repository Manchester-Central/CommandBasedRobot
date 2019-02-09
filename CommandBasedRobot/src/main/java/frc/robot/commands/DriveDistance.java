/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// TO-DO: Determine current distance (if negative or positive) to determine first direction traveled

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**  
 * Moves Motor Forward.
 */
public class DriveDistance extends Command {
  
  boolean isInterrupted = false;
  double distance;

  public DriveDistance(double distance) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drive);
    this.distance = distance;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {

    isInterrupted = false;
    Robot.drive.resetEncoders();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double currentDistance = Robot.drive.getAverageDistanceInches();
    double sign = Math.abs(currentDistance) / currentDistance;
    Robot.drive.setSpeed(0.25 * sign);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    double currentDistance = Robot.drive.getAverageDistanceInches();
    //return isInterrupted || Math.abs(currentDistance) >= Math.abs(distance);
    System.out.println(currentDistance);
    System.out.println(distance);
    return (currentDistance > (distance - 2)) && (currentDistance < (distance + 2));

  }

  // Called once after isFinished returns true
  @Override
  protected void end() {

    Robot.drive.stop();
    Robot.drive.resetEncoders();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {

    isInterrupted = true;
    Robot.drive.stop();
    Robot.drive.resetEncoders();
  }

}
