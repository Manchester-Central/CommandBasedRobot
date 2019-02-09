/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.TalonSRX_Encoder;
import frc.robot.commands.DriveWithJoystick;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Victor leftBackVictor;
	Victor leftMidVictor;
	Victor leftFrontVictor;
	Victor rightBackVictor;
	Victor rightMidVictor;
	Victor rightFrontVictor;
	
	WPI_TalonSRX rightTalonSRX;
  WPI_TalonSRX leftTalonSRX;
  
  TalonSRX_Encoder leftEncoder;
  TalonSRX_Encoder rightEncoder;

  public static final double ENCODER_TICKS_PER_REVOLUTION = 4100D;
	public static final double WHEEL_CIRCUMFERENCE_INCHES = 4*Math.PI;

  public DriveSubsystem () {

    leftBackVictor = new Victor(RobotMap.LEFT_BACK_VICTOR);
    leftMidVictor = new Victor(RobotMap.LEFT_MID_VICTOR);
    leftFrontVictor = new Victor(RobotMap.LEFT_FRONT_VICTOR);
    rightBackVictor = new Victor(RobotMap.RIGHT_BACK_VICTOR);
    rightMidVictor = new Victor(RobotMap.RIGHT_MID_VICTOR);
    rightFrontVictor = new Victor(RobotMap.RIGHT_FRONT_VICTOR);
    rightTalonSRX = new WPI_TalonSRX(RobotMap.RIGHT_CAN_TALON);
    leftTalonSRX = new WPI_TalonSRX(RobotMap.LEFT_CAN_TALON);

    leftEncoder = new TalonSRX_Encoder(leftTalonSRX, true, ENCODER_TICKS_PER_REVOLUTION, WHEEL_CIRCUMFERENCE_INCHES);
		rightEncoder = new TalonSRX_Encoder(rightTalonSRX, false, ENCODER_TICKS_PER_REVOLUTION, WHEEL_CIRCUMFERENCE_INCHES);

    rightBackVictor.setInverted(true);
		rightMidVictor.setInverted(true);
		rightFrontVictor.setInverted(true);
		rightTalonSRX.setInverted(true);

    leftTalonSRX.enableCurrentLimit(true);
    rightTalonSRX.enableCurrentLimit(true);
    
    leftTalonSRX.configContinuousCurrentLimit(30, 0);
		rightTalonSRX.configContinuousCurrentLimit(30, 0);
		
		leftTalonSRX.configPeakCurrentDuration(50, 0);
		rightTalonSRX.configPeakCurrentDuration(50, 0);

		rightTalonSRX.configPeakCurrentLimit(30, 0);
		leftTalonSRX.configPeakCurrentLimit(30, 0);
		
		rightTalonSRX.configClosedloopRamp (1, 0);
		leftTalonSRX.configClosedloopRamp (1, 0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new DriveWithJoystick());
  }

  public void setSpeed(double leftSpeed, double rightSpeed){

    leftBackVictor.set(leftSpeed);
    leftMidVictor.set(leftSpeed);
    leftFrontVictor.set(leftSpeed);
    rightBackVictor.set(rightSpeed);
    rightMidVictor.set(rightSpeed);
    rightFrontVictor.set(rightSpeed);

    rightTalonSRX.set(rightSpeed);
    leftTalonSRX.set(leftSpeed);
  }

  public void setSpeed(double speed){

    setSpeed(speed, speed);
  }

  public void stop(){

    setSpeed(0);

  }

  public double getLeftDistanceInches() {
    return leftEncoder.getCurrentPositionInches();
  }

  public double getRightDistanceInches() {
    return rightEncoder.getCurrentPositionInches();
  }

  public double getAverageDistanceInches() {
    return (getLeftDistanceInches() + getRightDistanceInches()) / 2;
  }

  public void resetEncoders() {    
    leftEncoder.resetEncoder();
    rightEncoder.resetEncoder();
  }

}
