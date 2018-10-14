/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  WPI_TalonSRX rightIntake;
  WPI_TalonSRX leftIntake; 

  public Intake(){
    rightIntake = new WPI_TalonSRX(5);
    leftIntake = new WPI_TalonSRX(4);

    rightIntake.setInverted(true);

    leftIntake.follow(rightIntake);
  }

  public void intake() {
    rightIntake.set(ControlMode.PercentOutput, -1);
  }

  public void shoot() {
    rightIntake.set(ControlMode.PercentOutput, 1);
  }

  public void stop() {
    rightIntake.set(ControlMode.PercentOutput, 0);
  }

  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
