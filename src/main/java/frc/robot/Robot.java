package frc.robot;

import frc.robot.subsystems.Drivebase;
import frc.robot.subsystems.Piston;
import edu.wpi.first.wpilibj.*;


public class Robot extends TimedRobot {
  public static XboxController xboxController = new XboxController(0);
  public static Compressor cs;

  public Robot(){
    cs = new Compressor(PneumaticsModuleType.CTREPCM);
  }
  
  @Override
  public void robotInit(){
    if(!cs.isEnabled()){
      cs.enableDigital();
    }
  }

  @Override
  public void teleopPeriodic(){
    Drivebase drivebase = new Drivebase();
    drivebase.drive();
    Piston piston = new Piston();
    piston.toggle();
  }
}