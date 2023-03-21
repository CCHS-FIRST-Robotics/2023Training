package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.*;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Drivebase {
    WPI_TalonFX backLeftTalon, backRightTalon, frontLeftTalon, frontRightTalon;
    XboxController xboxController = new XboxController(0);
    public Drivebase(){
        backLeftTalon = new WPI_TalonFX(Constants.leftBackMotorPort);
        backRightTalon = new WPI_TalonFX(Constants.leftFrontMotorPort);
        frontLeftTalon = new WPI_TalonFX(Constants.rightBackMotorPort);
        frontRightTalon = new WPI_TalonFX(Constants.rightFrontMotorPort);
    }
    //Driving
    public void drive(){
        backLeftTalon.setInverted(true);
        frontLeftTalon.setInverted(true);

        //david shit(getting what motor output should be based on xbox coords)
        double[][] wheelDirections = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                wheelDirections[i][j] = xboxController.getLeftY() + // y direction
                (i == j ? xboxController.getLeftX() : -xboxController.getLeftX()); // x direction
            }
        }
  
        // Rotation
        for(int i = 0; i < 2; i++){
            wheelDirections[i][0] += xboxController.getRightX();
            wheelDirections[i][1] -= xboxController.getRightX();
        }
  
        // Makes output between -1 & 1
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                wheelDirections[i][j] = Math.max(-1, Math.min(1, wheelDirections[i][j]));
            }
        }
  
        frontLeftTalon.set(ControlMode.PercentOutput, wheelDirections[0][0]);
        frontRightTalon.set(ControlMode.PercentOutput, wheelDirections[0][1]);
        backLeftTalon.set(ControlMode.PercentOutput, wheelDirections[1][0]);
        backRightTalon.set(ControlMode.PercentOutput, wheelDirections[1][1]);
    }
}
