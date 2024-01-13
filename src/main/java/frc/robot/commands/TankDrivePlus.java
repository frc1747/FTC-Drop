// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ArmRaiser;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Slider;
import frc.robot.subsystems.Xbox;

public class TankDrivePlus extends Command {
  private Drivetrain drivetrain;
  private ArmRaiser raiser;
  private Intake intake;
  private Slider slider;
  private Xbox controller;

  public TankDrivePlus(Drivetrain drivetrain, ArmRaiser raiser, Intake intake, Slider slider, Xbox controller) {
    this.drivetrain = drivetrain;
    this.raiser = raiser;
    this.intake = intake;
    this.slider = slider;
    this.controller = controller;
    addRequirements(slider);
    addRequirements(drivetrain);
    addRequirements(raiser);
    addRequirements(intake);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    drivetrain.setLeftPower((controller.getRightStickY() - controller.getRightStickX()) * Constants.OperatorConstants.drivetrainSpeed);
    drivetrain.setRightPower((controller.getRightStickY() + controller.getRightStickX()) * Constants.OperatorConstants.drivetrainSpeed);
    if (Math.pow(controller.getLeftStickX(), 2) > 0.04) {
      slider.setPower(controller.getLeftStickX());
    } else {
      slider.setPower(0.0);
    }
    if (Math.pow(controller.getLeftStickY(), 2) > 0.04) {
      raiser.setPower(controller.getLeftStickY());
    } else {
      raiser.setPower(0.0);
    }
    intake.setPower(-0.30 * controller.getLeftTriggerAxis() + 0.75 * controller.getRightTriggerAxis());
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.setLeftPower(0.0);
    drivetrain.setRightPower(0.0);
    raiser.setPower(0.0);
    intake.setPower(0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
