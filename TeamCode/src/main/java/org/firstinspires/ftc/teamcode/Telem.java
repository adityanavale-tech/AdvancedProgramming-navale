package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.pedropathing.follower.Follower;
import com.qualcomm.*;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;
import com.qualcomm.*;
public class Telem {

    public Telemetry telemetry;
    public Follower follower;

    DcMotorEx motor = hardwareMap.get(DcMotorEx.class, "motor");
    public double rpm;


    public Telem(DcMotorEx motor, Telemetry telemetry, Follower follower) {
        this.motor = motor;
        this.telemetry = telemetry;
        this.follower = follower;
    }

    public double rpm() {
        return Math.abs(motor.getVelocity()*2.14);
    }

    public void Outtake(){

        telemetry.addData("RRM: ", rpm);
        telemetry.addData("Motor Power: ", motor.getPower());
        telemetry.addData("Current: ",motor.getCurrent(CurrentUnit.AMPS));
    }
    public void Pose(){
        telemetry.addData("Pose (x,y): ", follower.getPose().getAsFTCStandardCoordinates());
        telemetry.addData("Robot Velocity: ",follower.getVelocity().getMagnitude());
        telemetry.addData("Heading: ",follower.getTotalHeading());

    }
    public static void TeleHelper(Gamepad gamepad, Telemetry telemetry, Follower follower, double rpm){
        if(gamepad.rightTriggerWasPressed()){
            telemetry.addLine("Right Trigger Pressed");
            telemetry.addData("RPM is at: ", rpm);

            telemetry.update();
        }
        else {
            telemetry.addLine("Outtake at Rest");
        }
        if(gamepad.aWasPressed()){
            telemetry.addData("The robot is at: ", follower.getPose().getAsFTCStandardCoordinates());
        }
    }



}
