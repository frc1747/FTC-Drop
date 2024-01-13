// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.TankDrivePlus;
import frc.robot.subsystems.ArmRaiser;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Slider;
import frc.robot.subsystems.Xbox;
import frc.robot.commands.AddFiveDrivetrain;
import frc.robot.commands.TakeFiveDrivetrain;


public class RobotContainer {
  private final Drivetrain drivetrain = new Drivetrain();
  private final ArmRaiser raiser = new ArmRaiser();
  private final Intake intake = new Intake();
  private final Slider slider = new Slider();
  private final Xbox controller = new Xbox(Constants.OperatorConstants.DRIVER_CONTROLLER_PORT);
  private final TankDrivePlus m_autoCommand = new TankDrivePlus(drivetrain, raiser, intake, slider, controller);

  public RobotContainer() {
    configureButtonBindings();
    drivetrain.setDefaultCommand(new TankDrivePlus(drivetrain, raiser, intake, slider, controller));
  }

  private void configureButtonBindings() {
    controller.getButton(Xbox.A)
    .onTrue(new AddFiveDrivetrain());

    controller.getButton(Xbox.B)
    .onTrue(new TakeFiveDrivetrain());
  }

  public Command getAutonomousCommand() {
    return m_autoCommand;
  }
}
