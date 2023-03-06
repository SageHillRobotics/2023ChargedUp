package frc.robot.commands;
import frc.robot.subsystems.FourBar;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class LowerArmDown extends CommandBase{
    private FourBar arm;
    public LowerArmDown(FourBar arm)
    {
        this.arm = arm;
        addRequirements(arm);
    }
    @Override
    public void initialize(){
    }
    @Override
    public void execute(){
        arm.lowerLowerJoint();
        
        
    }
    @Override
    public void end(boolean interrupted) {
        arm.stopLowerJoint();
    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
