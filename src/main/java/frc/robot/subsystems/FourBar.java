package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.Constants;
import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
public class FourBar extends SubsystemBase{
    private CANSparkMax lowerMotor;
    private CANSparkMax upperMotor;
    private DigitalInput upperLimitSwitch;
    private DigitalInput lowerLimitSwitch;
    public FourBar(){
        this.lowerMotor = new CANSparkMax(20, MotorType.kBrushless);
        this.upperMotor = new CANSparkMax(Constants.armConstants.upperArmID,MotorType.kBrushless);
        this.lowerLimitSwitch = new DigitalInput(Constants.armConstants.lowerLimitSwitchID);
        this.upperLimitSwitch = new DigitalInput(Constants.armConstants.upperLimitSwitchID);
    }
    @Override
    public void periodic(){

    }
    
    public void raiseUpperJoint(){
        upperMotor.set(1);
    }
    public void lowerUpperJoint(){
        upperMotor.set(-1);
    }
    public void raiseLowerJoint(){
        lowerMotor.set(-1);
    }
    public void lowerLowerJoint(){
        lowerMotor.set(1);
    }
    public void stopUpperJoint(){
        upperMotor.set(0);
    }
    public void stopLowerJoint(){
        lowerMotor.set(0);
    }
    public boolean getLowerLimitSwitch(){
        return lowerLimitSwitch.get();
    }
    public boolean getUpperLimitSwitch(){
        return upperLimitSwitch.get();
    }
    
   
}
