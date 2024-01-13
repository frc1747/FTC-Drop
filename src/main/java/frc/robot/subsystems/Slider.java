// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Slider extends SubsystemBase {
  private VictorSPX slider;

  public Slider() {
    slider = new VictorSPX(Constants.OperatorConstants.SLIDER);
  }

  public void setPower(double power) {
    slider.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void periodic() {
    
  }
}
