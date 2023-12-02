package lab3;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class Tuner implements TvTuner, ChannelSwitcher {
    private byte loudness = 90;
    private PrintWriter fout = new PrintWriter(new FileOutputStream(
            new File("MyTvTuner.txt"),
            true));
    private boolean switchTuner = false;
    private byte channel = 0;
    private String[] channelTuner = new String[]{"QTV", "NLO TV", "Новий канал", "M1", "K1", "ICTV", "TET", "UATV"};



    public Tuner() throws FileNotFoundException {
    }
    public PrintWriter getFout() {
        return fout;
    }


    public String[] getChannelTuner() {
        return channelTuner;
    }



    @Override
    public void include() {
        if (!switchTuner) {
            switchTuner = true;
            System.out.println("Тюнер включився");
            getFout().println("Тюнер включився");
        } else {
            System.out.println("Тюнер вже був включений");
            getFout().println("Тюнер вже був включений");
        }
        getFout().flush();
    }

    @Override
    public void exclude() {
        if (switchTuner) {
            switchTuner = false;
            System.out.println("Тюнер виключили");
            getFout().println("Тюнер виключили");

        } else {
            System.out.println("Тюнер вже був виключений");
            getFout().println("Тюнер вже був виключений");
        }
        getFout().flush();
    }

    @Override
    public void change_volume_vol_add() {

        if(loudness<=100){
            System.out.println("Звук: "+(++loudness) );
            getFout().println("Звук: "+(loudness));
        }else{
            System.out.println("Вже стоїть максимальна гучність");
            getFout().println("Вже стоїть максимальна гучність");
        }
        getFout().flush();
    }

    @Override
    public void change_volume_vol_minus() {

        if(loudness>=0){
            System.out.println("Звук: "+(--loudness) );
            getFout().println("Звук: "+(loudness));
        }else{
            System.out.println("Вже стоїть мінімальна гучність");
            getFout().println("Вже стоїть мінімальна гучність");
        }
        getFout().flush();
    }




    public void switchСhannel() throws FileNotFoundException {
        if (channel == new Tuner().getChannelTuner().length) {
            channel = 0;
        }
        System.out.println("Канал: "+ new Tuner().getChannelTuner()[channel]);
        getFout().println("Канал: "+ new Tuner().getChannelTuner()[channel]);
        channel++;
        getFout().flush();
    }

    public void ChannelList() throws FileNotFoundException {
        byte num = 1;
        System.out.println("--<Список каналів>--");
        for (String el: new Tuner().getChannelTuner()){
            System.out.println("\t"+num+". " + el);
            getFout().println("\t"+num+". " + el);
            num++;
        }
        getFout().flush();

    }

    public void switchChannel() {
        if (channel == channelTuner.length) {
            channel = 0;
        }
        System.out.println("Канал: " + channelTuner[channel]);
        getFout().println("Канал: " + channelTuner[channel]);
        channel++;
        getFout().flush();
    }

    @Override
    public void switchChannel(String channelName) {
        for (byte i = 0; i < channelTuner.length; i++) {
            if (channelTuner[i].equals(channelName)) {
                channel = i;
                System.out.println("Тюнер переключився на канал: " + channelTuner[channel]);
                getFout().println("Тюнер переключився на канал: " + channelTuner[channel]);
                getFout().flush();
                return;
            }
        }
        System.out.println("Канал не знайдено: " + channelName);
        getFout().println("Канал не знайдено: " + channelName);
        getFout().flush();
    }
}
