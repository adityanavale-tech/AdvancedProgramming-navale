package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Teleop extends LinearOpMode {
private DcMotorEx motor;
private Follower follower;
    @Override
    public void runOpMode() {
        Telem telem = new Telem(motor, telemetry, follower);



        while(opModeIsActive()){
            double rpm = telem.rpm();
            telem.Outtake();
            telem.Pose();

            telemetry.update();
        }

    }
}
