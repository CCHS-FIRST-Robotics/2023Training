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

  WPI_TalonFX backLeftTalon, backRightTalon, frontLeftTalon, frontRightTalon;


  public Robot(){
    backLeftTalon = new WPI_TalonFX(Constants.leftBackPort);
    backRightTalon = new WPI_TalonFX(Constants.leftFrontPort);
    frontLeftTalon = new WPI_TalonFX(Constants.rightBackPort);
    frontRightTalon = new WPI_TalonFX(Constants.rightFrontPort);
  }
  
  

  @Override
  public void teleopPeriodic(){
    backLeftTalon.setInverted(true);
    frontLeftTalon.setInverted(true);

    //david shit(getting what motor output should be based on xbox coords)
    double[][] wheelDirections = new double[2][2];
    for (int i = 0; i < wheelDirections.length; i++) {
        for (int j = 0; j < wheelDirections.length; j++) {
            wheelDirections[i][j] = Math.max(-1, Math.min(1, xboxController.getLeftY() + (i == j ? xboxController.getLeftX() : -1*xboxController.getLeftX())));
        }
    }

    frontLeftTalon.set(ControlMode.PercentOutput, wheelDirections[0][0]);
    frontRightTalon.set(ControlMode.PercentOutput, wheelDirections[0][1]);
    backLeftTalon.set(ControlMode.PercentOutput, wheelDirections[1][0]);
    backRightTalon.set(ControlMode.PercentOutput, wheelDirections[1][1]);
  }
}