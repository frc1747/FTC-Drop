// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;

public class TakeFiveDrivetrain extends Command {
  public TakeFiveDrivetrain() {
  }

  @Override
  public void initialize() {
    if (Constants.OperatorConstants.drivetrainSpeed > 0) {
      Constants.OperatorConstants.drivetrainSpeed -= 0.05;
      System.out.println("Drivetrain Speed: " + Constants.OperatorConstants.drivetrainSpeed);
    }
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}