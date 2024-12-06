// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class TurnForTime extends Command {
  private Drivetrain m_drivetrain;
  private double m_speed;
  private double m_timeInSeconds;
  private double m_startTimer;
  private Timer m_timer;

  /** Creates a new TurnForTime. */
  public TurnForTime(Drivetrain drivetrain, double speed, double seconds) {
    m_drivetrain = drivetrain;
    m_speed = speed;
    m_timeInSeconds = seconds;
    m_timer = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(drivetrain);
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();
    m_timer.start();
    m_startTimer = m_timer.get();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if((m_timer.get() - m_startTimer) <= m_timeInSeconds){
      m_drivetrain.setRightSpeed(m_speed);
      m_drivetrain.setLeftSpeed(-m_speed);
    }
  }

//what direction would this turn? would this actually turn?

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
