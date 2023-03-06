package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.autos.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* Controllers */
    private final Joystick driver = new Joystick(0);
    private final Joystick armController = new Joystick(1);
    /* Drive Controls */
    private final int translationAxis = 1;
    private final int strafeAxis = 0;
    private final int rotationAxis = 2;
    private final int deadband = 3;

    /* Driver Buttons */
    private final JoystickButton zeroGyro = new JoystickButton(driver, 11);
    private final JoystickButton robotCentric = new JoystickButton(driver, 12);
    private final JoystickButton aimButton = new JoystickButton(driver, 1);
    private final JoystickButton topPoleButton = new JoystickButton(driver, 5);
    private final JoystickButton bottomPoleButton = new JoystickButton(driver, 3);
    private final JoystickButton cubeButton = new JoystickButton(driver, 6);
    private final JoystickButton coneButton = new JoystickButton(driver, 4);
    private final JoystickButton balanceButton = new JoystickButton(driver, 2);
    private final JoystickButton activateSolenoid = new JoystickButton(driver, 7);
    private final JoystickButton lowerLower = new JoystickButton(armController, 1);
    private final JoystickButton raiseLower = new JoystickButton(armController, 2);
    /* Subsystems */
    public final Swerve s_Swerve = new Swerve();
    public final Vision LimeLight = new Vision(s_Swerve);
    public final Gripper m_Gripper = new Gripper();
    public final FourBar m_Arm = new FourBar();
    
    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {
        s_Swerve.setDefaultCommand(
            new TeleopSwerve(
                s_Swerve, 
                () -> -driver.getRawAxis(translationAxis), 
                () -> -driver.getRawAxis(strafeAxis), 
                () -> -driver.getRawAxis(rotationAxis), 
                () -> robotCentric.getAsBoolean(),
                () -> ((-driver.getRawAxis(deadband) + 1 )/ 4)
                            )
        );

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        zeroGyro.onTrue(new InstantCommand(() -> s_Swerve.zeroGyro()));
        aimButton.whileTrue(new orientDrive(LimeLight, () -> -driver.getRawAxis(translationAxis), 
        () -> -driver.getRawAxis(strafeAxis)));
        topPoleButton.onTrue(new setTopPolePipeline(LimeLight));
        bottomPoleButton.onTrue(new setBottomPolePipeline(LimeLight));
        cubeButton.onTrue(new setCubePipeline(LimeLight));
        coneButton.onTrue(new setConePipeline(LimeLight));
        balanceButton.whileTrue(new BalanceOnBeam(s_Swerve));
        activateSolenoid.onTrue(new InstantCommand(()-> m_Gripper.toggleSolenoids()));
        lowerLower.whileTrue(new LowerArmDown(m_Arm));
        raiseLower.whileTrue(new LowerArmUp(m_Arm));

    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return new exampleAuto(s_Swerve);
    }
}