package frc.robot.subsystems;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.*;

public class Piston {
    DoubleSolenoid ds = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
    
    public Piston(){
        ds.set(DoubleSolenoid.Value.kOff);
    }

    public void toggle(){
        ds.set(DoubleSolenoid.Value.kForward);
        if(Robot.xboxController.getAButtonPressed() == true){
            ds.toggle();
        }
    }
}