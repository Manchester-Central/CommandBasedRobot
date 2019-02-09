/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * Add your docs here.
 */
public class TalonSRX_Encoder implements PIDSource {

    private WPI_TalonSRX talon;
	private PIDSourceType type = PIDSourceType.kDisplacement;
	private int sign;
	private final double encoderTicksPerRevolution, wheelCircumferenceInches;

	/**
	 * Creates encoder object for Talon
	 * @param talon
	 * @param isInverted
	 * @param encoderTicksPerRevolution
	 * @param wheelCircumferenceInches
	 */
    public TalonSRX_Encoder(WPI_TalonSRX talon, boolean isInverted, double encoderTicksPerRevolution, double wheelCircumferenceInches) {

        this.talon = talon;
		sign = (isInverted) ? -1 : 1;
		this.encoderTicksPerRevolution  = encoderTicksPerRevolution;
		this.wheelCircumferenceInches = wheelCircumferenceInches;

    }

	public void resetEncoder() {
        
        //setSelectedSensorPosition(0, 0, 0);    
        talon.getSensorCollection().setQuadraturePosition(0,10);
    }


    public double getCurrentPositionTicks() {

        return sign * talon.getSensorCollection().getQuadraturePosition();

    }

    public double getCurrentPositionInches() {
        return ticksToInches(getCurrentPositionTicks());
    }

    

    public double inchesToTicks(double inches) {
		
		return inches * encoderTicksPerRevolution / wheelCircumferenceInches;
		
	}

	public double ticksToInches(double ticks) {
		
		return ticks * wheelCircumferenceInches / encoderTicksPerRevolution;
		
    }

	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		type = pidSource;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
        return type;
	}

	@Override
	public double pidGet() {
		return getCurrentPositionTicks();
	}


}
