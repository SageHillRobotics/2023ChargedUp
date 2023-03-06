package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Gripper extends SubsystemBase{
    private final Compressor pcmCompressor;
    private final Solenoid solenoid;

    public Gripper(){   
        this.pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
        this.solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 3);
    }
    
    public void toggleSolenoids(){
        pcmCompressor.enableDigital();
        //pcmCompressor.disable();
        solenoid.toggle();
    }
    public boolean getEnabled(){
        return pcmCompressor.isEnabled();
    }
    public boolean getPressureSwitch(){
        return pcmCompressor.getPressureSwitchValue();
    }
    //public double getCurrent(){
        //return pcmCompressor.getCompressorCurrent();
    //}


}   
