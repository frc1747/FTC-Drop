// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmRaiser extends SubsystemBase {
  private TalonSRX raiser;

  public ArmRaiser() {
    raiser = new TalonSRX(Constants.OperatorConstants.ARM_RAISER);
  }

  public void setPower(double power) {
    raiser.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
  }
}
