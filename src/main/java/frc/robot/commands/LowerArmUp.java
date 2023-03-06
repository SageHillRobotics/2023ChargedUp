package frc.robot.commands;
import frc.robot.subsystems.FourBar;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class LowerArmUp extends CommandBase{
    private FourBar arm;
    public LowerArmUp(FourBar arm)
    {
        this.arm = arm;
        addRequirements(arm);
    }
    @Override
    public void initialize(){
    }
    @Override
    public void execute(){
        arm.raiseLowerJoint();
        
        
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
