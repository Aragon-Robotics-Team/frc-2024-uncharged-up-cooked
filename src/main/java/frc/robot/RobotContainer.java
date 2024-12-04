// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.ArcadeElevator;
import frc.robot.commands.IntakeObject;
import frc.robot.commands.MoveForTime;
import frc.robot.commands.OutakeObject;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Intake;

import javax.sound.sampled.Port;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Joystick m_joystick = new Joystick(0);
  private JoystickButton m_intakeButton = new JoystickButton(m_joystick, 7);
  private JoystickButton m_outakeButton = new JoystickButton(m_joystick, 8);
  private Drivetrain m_drivetrain = new Drivetrain();
  private ArcadeDrive m_arcadeDrive = new ArcadeDrive(m_drivetrain, m_joystick);
  
  private Elevator m_elevator = new Elevator();
  
  private ArcadeElevator m_arcadeElevator = new ArcadeElevator(m_joystick, m_elevator);
  private MoveForTime moveForTime = new MoveForTime (m_drivetrain, 0.1, 4);
  
  private Intake m_intakeMotor = new Intake();
  private IntakeObject m_intakeObject = new IntakeObject(m_intakeMotor,0);
  private OutakeObject m_outakeObject = new OutakeObject(m_intakeMotor,0);

  // Replace with CommandPS4Controller or CommandJoystick if needed


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }


  
  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    m_intakeButton.onTrue(m_intakeObject);
    m_outakeButton.onTrue(m_outakeObject);
  }

  public Command getTeleopCommand(){
    m_drivetrain.setDefaultCommand(m_arcadeDrive);
    m_elevator.setDefaultCommand(m_arcadeElevator);
    return null;
  }
  public Command getAutonomousCommand(){
      return moveForTime;
  }

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  
  

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
    // An example command will be run in autonomous
  
  }
