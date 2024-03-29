/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveEncoders extends Command {

    int ftDistance;
    int inDistance;
    double driveDistance;
    double endDistance;
    double botSpeed;
    double leftSpeed;
    double rightSpeed;

  public DriveEncoders(double speed, double userFeet) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    requires(Robot.m_drivetrain);

    driveDistance = (userFeet);
    botSpeed = speed;
    leftSpeed = botSpeed*-1.075;
    rightSpeed = botSpeed*1.0;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    endDistance = Robot.m_drivetrain.getRightDistance() + driveDistance;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_drivetrain.drive(leftSpeed, rightSpeed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (Robot.m_drivetrain.getRightDistance() >= endDistance);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drivetrain.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
