package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
public class setCubePipeline extends CommandBase{
    private final Vision LimeLight;
    public setCubePipeline(Vision LimeLight){
        this.LimeLight = LimeLight;
        addRequirements(LimeLight);
    }
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        LimeLight.setCubePipeline();;
    }
    @Override
    public void end(boolean interrupted){

    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
