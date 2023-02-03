package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
public class setBottomPolePipeline extends CommandBase{
    private final Vision LimeLight;
    public setBottomPolePipeline(Vision LimeLight){
        this.LimeLight = LimeLight;
        addRequirements(LimeLight);
    }
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        LimeLight.setBottomPoplePipeline();;
    }
    @Override
    public void end(boolean interrupted){

    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
