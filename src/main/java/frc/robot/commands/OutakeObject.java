// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;


public class OutakeObject extends Command {
  /** Creates a new OutakeObject. */
  private Intake m_OutakeMotor;
  private double m_speed;


  public OutakeObject(Intake outake, double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_OutakeMotor = outake;
    m_speed = speed;
    addRequirements(outake);
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_OutakeMotor.setIntakeSpeed(0);

    
  }


  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_OutakeMotor.setIntakeSpeed(-m_speed);
  }


  // Called once the command ends or is interrupted
  @Override
  public void end(boolean interrupted) {
    m_OutakeMotor.setIntakeSpeed(0);
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}



