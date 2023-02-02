package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class Constants {
    WPI_TalonFX frontLeftTalon, frontRightTalon, backLeftTalon, backRightTalon;

    public void motors(){
        backLeftTalon = new WPI_TalonFX(4);
        backRightTalon = new WPI_TalonFX(3);
        frontLeftTalon = new WPI_TalonFX(2);
        frontRightTalon = new WPI_TalonFX(1);
    }
}