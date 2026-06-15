package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.hardware.lynx.LynxModule;

import org.firstinspires.ftc.teamcode.Telem;

import java.util.List;

public class Robot {

    public List<LynxModule> hubs;

    public void ClearCache(){
        hubs = hardwareMap.getAll(LynxModule.class);
        for(LynxModule hub : hubs){
            hub.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
        }
    }


}
