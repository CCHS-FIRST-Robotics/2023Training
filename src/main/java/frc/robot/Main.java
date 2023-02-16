package frc.robot;

import edu.wpi.first.wpilibj.*;

public final class Main {
  private Main() {}
  public static void main(String... args) {
    RobotBase.startRobot(Robot::new);
  }
}
