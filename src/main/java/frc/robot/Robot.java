// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Robot extends TimedRobot {
  private XboxController xboxController = new XboxController(0);

  double leftVel = 0.0;
  double rightVel = 0.0;
  double velocity = 0.0;

  @Override
  public void teleopPeriodic() {
    backLeftTalon.setInverted(true);
    frontLeftTalon.setInverted(true);
    velocity = xboxController.getLeftY();
    
    backLeftTalon.set(ControlMode.PercentOutput, velocity);
    backRightTalon.set(ControlMode.PercentOutput, velocity);
    frontLeftTalon.set(ControlMode.PercentOutput, velocity);
    frontRightTalon.set(ControlMode.PercentOutput, velocity);
  }
}
