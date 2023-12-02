package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Start {
    public static void main(String[] args) throws FileNotFoundException {
        TV tv = new TV();
        Tuner tuner = new Tuner();
        tuner.include();
        tv.include();
        tuner.switchChannel("NLO TV");
        tuner.change_volume_vol_minus();
        tuner.change_volume_vol_minus();
        tv.change_volume_vol_minus();
        tv.change_volume_vol_add();
    }
}