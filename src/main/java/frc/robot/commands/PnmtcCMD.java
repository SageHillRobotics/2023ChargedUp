package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
public class PnmtcCMD extends CommandBase{
    Gripper m_Gripper;
    public PnmtcCMD(Gripper m_Gripper){
        this.m_Gripper = m_Gripper;
    }
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        m_Gripper.toggleSolenoids();
    }
    @Override
    public void end(boolean interrupted){

    }
    @Override
    public boolean isFinished(){
        return true;
    }
}
