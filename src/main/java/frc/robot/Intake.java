// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkBase;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The robot is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */

// based on the kitbot
public class Intake extends TimedRobot {

    CANSparkMax intakeMotor = new CANSparkMax(0, MotorType.kBrushless);
    Joystick m_manipController = new Joystick(1);

    static final int INTAKE_CURRENT_LIMIT = 60;
    static final double INTAKE_OUT_SPEED = 1.0;
    static final double INTAKE_IN_SPEED = -0.4;
  
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    intakeMotor.setSmartCurrentLimit(INTAKE_CURRENT_LIMIT);
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    // intake & outtake
  if (m_manipController.getRawButton(1)) { // Button 1 pressed, outtake
    intakeMotor.set(INTAKE_OUT_SPEED);
  }
    
  else if (m_manipController.getRawButton(2)) { // Button 2 pressed, intake
    intakeMotor.set(INTAKE_IN_SPEED);
  }
    
  else // No buttons pressed
  {
    intakeMotor.set(0);
  }

    }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
