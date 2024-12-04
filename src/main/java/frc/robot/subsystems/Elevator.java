// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Elevator extends SubsystemBase {
  /** Creates a new Elevator. */
private TalonFX m_ElevatorMotor = new TalonFX(0); 
private DigitalInput m_switch=new DigitalInput(0);

public Elevator() 
{}

public boolean getLimitSwitch() {
  return m_switch.get();
}

public void setElevatorSpeed(double speed){
  m_ElevatorMotor.set(speed);
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
