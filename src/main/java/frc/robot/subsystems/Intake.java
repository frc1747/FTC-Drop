// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private VictorSPX one;
  private TalonSRX two;

  public Intake() {
    one = new VictorSPX(Constants.OperatorConstants.INTAKE_ONE);
    two = new TalonSRX(Constants.OperatorConstants.INTAKE_TWO);
  }

  public void setPower(double power) {
    one.set(ControlMode.PercentOutput, power);
    two.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {

  }
}
