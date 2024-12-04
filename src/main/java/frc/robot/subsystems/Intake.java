// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  private CANSparkMax m_intakeMotor = new CANSparkMax(0, MotorType.kBrushless);
  //change id later
  public Intake() {}

  public void setIntakeSpeed(double speed){
    m_intakeMotor.set(speed);
  }
  //fix later with correct value
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
   
  }


}
