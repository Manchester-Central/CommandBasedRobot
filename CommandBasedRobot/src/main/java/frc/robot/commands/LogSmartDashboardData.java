/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**  
 * Moves Motor Forward.
 */
public class LogSmartDashboardData extends Command {
  
  
  public LogSmartDashboardData() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.smart);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

    SmartDashboard.putNumber("Left Distance", Robot.drive.getLeftDistanceInches());
    SmartDashboard.putNumber("Right Distance", Robot.drive.getRightDistanceInches());
    SmartDashboard.putNumber("Average Distance", Robot.drive.getAverageDistanceInches());
    SmartDashboard.updateValues();
    
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

}
