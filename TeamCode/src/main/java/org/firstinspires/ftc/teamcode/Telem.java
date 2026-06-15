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
    public Gamepad gamepad;

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
    public void TeleHelper(Gamepad gamepad){
        if(gamepad.b){
            telemetry.addLine("B was Pressed");
            telemetry.addData("RPM is at: ", rpm);

            telemetry.update();
        }
        else {
            telemetry.addLine("Outtake at Rest");
        }
        if(gamepad.a){
            telemetry.addData("The robot is at: ", follower.getPose().getAsFTCStandardCoordinates());
        }
    }



}
