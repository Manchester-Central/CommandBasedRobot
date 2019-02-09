/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commandGroups;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.DriveDistance;
import frc.robot.commands.WaitTime;

/**  
 * Moves Motor Forward.
 */
public class AutoDrive extends CommandGroup {
  
  public AutoDrive () {
    addSequential(new DriveDistance(24));
    addSequential(new WaitTime(5));
    addSequential(new DriveDistance(-24));
  }
  
}
