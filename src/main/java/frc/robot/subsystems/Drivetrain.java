// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
   //The device Id may need to be changed
    private TalonFX m_rightPrimary = new TalonFX(0);
    private TalonFX m_leftPrimary = new TalonFX(2);
//-->Why are we initializing the follower under class? Isn't follower the same as Secondary?
// 1. code goes in a class. if not in a class, it doesn't do anything. 2. a follower is an object that takes in both motors and makes one follow the other. secondary motor name is just for distinguishing between motors
  /** Creates a new Drivetrain. */
  public Drivetrain() {}

  public void setRightSpeed(double speed){
  m_rightPrimary.set(speed);
  }
  public void setLeftSpeed(double speed){
  m_leftPrimary.set(speed);
  }
  public void setIdleMode(NeutralModeValue mode){
    m_rightPrimary.setNeutralMode(mode);
    m_leftPrimary.setNeutralMode(mode);
//-->What does mode represent? What is neutral mode? Relation to speed?
//1. Neutral mode is after it is stopping, BrakeMode immediately stops but uses more power, NeutralMode allows for the rolling after code has stopped

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
