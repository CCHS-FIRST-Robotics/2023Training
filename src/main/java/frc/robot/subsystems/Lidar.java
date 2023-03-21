package frc.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lidar extends TimedRobot{
    private Counter m_LIDAR;
    @Override
    public void robotInit() {
        m_LIDAR = new Counger(0);
        m_LIDAR.setMaxPeriod(1.00);
        m_LIDAR.setSemiPeriodMode(true);
        m_Lidar.reset();
    }
    final double off = 10;

    @Override
    public void robotPeriodic() {
        double dist;
        if(m_LIDAR.get() < 1){
            dist=0;
        }
        else {
            dist=(m_LIDAR.getPeriod()*1000000.0/10.0)-off;

            if(dist<20){
                System.out.println("piece in the hole");
            }
        }
    }
}