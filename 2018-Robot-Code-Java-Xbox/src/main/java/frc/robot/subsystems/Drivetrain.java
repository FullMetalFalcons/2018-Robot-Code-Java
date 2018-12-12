/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;
import frc.robot.commands.TankDrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.   
  
  WPI_TalonSRX leftFront;
  WPI_TalonSRX leftRear;
  WPI_TalonSRX rightFront;
  WPI_TalonSRX rightRear;

  DifferentialDrive diffDrive;
  
  
  public Drivetrain() {
    leftFront = new WPI_TalonSRX(2);
    leftRear = new WPI_TalonSRX(3);
    rightFront = new WPI_TalonSRX(0);
    rightRear = new WPI_TalonSRX(1);

    leftRear.follow(leftFront);
    rightRear.follow(rightFront);

    rightFront.setInverted(true);
    rightRear.setInverted(true);

    diffDrive = new DifferentialDrive(leftFront, rightFront);

  }

  public void drive(double left, double right){
    diffDrive.tankDrive(left, right);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new TankDrive());
  }

public int getRightDistance() {
  return 0;
}

public void stop(){
  Robot.tankDrive(0.0, 0.0);
}
}
