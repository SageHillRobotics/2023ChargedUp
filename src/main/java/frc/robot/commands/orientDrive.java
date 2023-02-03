package frc.robot.commands;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.Constants;
public class orientDrive extends CommandBase{
    private final Vision LimeLight;
    private DoubleSupplier translationSup;
    private DoubleSupplier strafeSup;
    private SlewRateLimiter translationLimiter = new SlewRateLimiter(3.0);
    private SlewRateLimiter strafeLimiter = new SlewRateLimiter(3.0);
    public orientDrive(Vision LimeLight,DoubleSupplier translationSup,DoubleSupplier strafeSup){
        this.LimeLight = LimeLight;
        this.translationSup = translationSup;
        this.strafeSup = strafeSup;
        addRequirements(LimeLight);
    }
    @Override
    public void initialize(){

    }
    @Override
    public void execute(){
        double translationVal =
        translationLimiter.calculate(
            MathUtil.applyDeadband(translationSup.getAsDouble(), 0));
        double strafeVal =
            strafeLimiter.calculate(
                MathUtil.applyDeadband(strafeSup.getAsDouble(), 0));
        LimeLight.aim(new Translation2d(translationVal, strafeVal).times(Constants.Swerve.maxSpeed));
    }
    @Override
    public void end(boolean interrupted){

    }
    @Override
    public boolean isFinished(){
        return false;
    }
}
