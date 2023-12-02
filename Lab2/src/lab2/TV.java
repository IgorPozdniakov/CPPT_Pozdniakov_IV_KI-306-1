package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;

public class TV {
    private PrintWriter fout = new PrintWriter(new FileOutputStream(
            new File("MyTV.txt"),
            true));
    private String[] channelTV = new String[]{"QTV","NLO TV","Новий канал","M1","K1","ICTV","TET","UATV"};
    public enum Type{
        PDP, LCD, OLED, QLED
    }
    private Dynamics dynamics;
    private Type TvType;
    private String model;
    private RemoteControl remoteControl;
    private Date release;

    public TV() throws FileNotFoundException {
    }
    public TV(Type Tvtype,String model) throws FileNotFoundException {
        this.TvType = Tvtype;
        this.model = model;
        remoteControl = new RemoteControl();
        checkAndPrintLCD();
    }

    private void checkAndPrintLCD() {
        if (TvType == Type.LCD) {
            getModelAndTypeOfTV();
        }
    }
    public TV(Type Tvtype,String model,Date release) throws FileNotFoundException {
        dynamics = new Dynamics();
        this.TvType = Tvtype;
        this.model = model;
        this.release = release;
        remoteControl = new RemoteControl();
    }


    public PrintWriter getFout() {
        return fout;
    }

    public String[] getChannelTV() {
        return channelTV;
    }

    public Type getTvType() {
        return TvType;
    }

    public String getModel() {
        return model;
    }

    public RemoteControl getRemoteControl() {
        return remoteControl;
    }

    public Date getRelease() {
        return release;
    }
    public void getInfoAboutTV(){
        System.out.println("Model is " + getModel());
        getFout().println("Model is " + getModel());

        System.out.println("Type is " + getTvType());
        getFout().println("Type is " + getTvType());

        System.out.println("Date of release: " + getRelease());
        getFout().println("Date of release: " + getRelease());

        getFout().println();
        getFout().flush();

    }

    public void getModelAndTypeOfTV(){
        System.out.println("TV: " + getModel() + " and Type: " + getTvType());
        getFout().println("TV: " + getModel() + " and Type: " + getTvType());

        getFout().println();
        getFout().flush();
    }


}
