package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.acmerobotics.dashboard.config.Config;
import com.pedropathing.follower.Follower;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import java.util.List;
import org.firstinspires.ftc.teamcode.Robot;
@TeleOp(name = "Tele")
public class Teleop extends LinearOpMode {
private DcMotorEx motor;
public List<LynxModule> hubs;
private Follower follower;
    @Override
    public void runOpMode() {

        //init
//        Robot robot = new Robot();
//        robot.ClearCache();
        motor = hardwareMap.get(DcMotorEx.class, "Outtake");
        waitForStart();

        while(opModeIsActive()){
            Telem telem = new Telem(motor, telemetry, follower);

//loop
            double rpm = telem.rpm();
//            telem.Outtake();
//            telem.Pose();
            telem.TeleHelper(gamepad1);

            for(LynxModule hub:hubs){
                hub.clearBulkCache();
            }


            telemetry.update();
        }

    }
}
