// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class ArcadeDrive extends Command {
  /** Creates a new ArcadeDrive. */
  private Drivetrain m_drivetrain;
  private Joystick m_joystick;
  public ArcadeDrive(Drivetrain drivetrain, Joystick joystick){
    // Use addRequirements() here to declare subsystem dependencies.
    m_drivetrain = drivetrain;
    m_joystick = joystick;
    addRequirements(m_drivetrain);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double kConstant = 0.2;
    double speed = m_joystick.getRawAxis(1)*kConstant; 
    double turnSpeed = -m_joystick.getRawAxis(4)*kConstant;
m_drivetrain.setLeftSpeed(speed + turnSpeed);
m_drivetrain.setRightSpeed(speed - turnSpeed);
   }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  m_drivetrain.setLeftSpeed(0);
  m_drivetrain.setRightSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
