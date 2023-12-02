package lab2;

import java.io.FileNotFoundException;

public class RemoteControl {
    private boolean switchTV = false;
    private byte channel = 0;

    public byte getChannel() {
        return channel;
    }

    public Dynamics getDynamics() {
        return dynamics;
    }

    private Dynamics dynamics = new Dynamics();
    public void includeTV(TV tv) throws FileNotFoundException {
        if (!switchTV){
            switchTV = true;
            System.out.println("Телевізор включився");
            tv.getFout().println("Телевізор включився");
        }else {
            System.out.println("Телевізор вже був включений");
            tv.getFout().println("Телевізор вже був включений");
        }
        tv.getFout().flush();
    }
    public void excludeTV(TV tv){
        if (switchTV){
            switchTV = false;
            System.out.println("Телевізор виключили");
            tv.getFout().println("Телевізор виключили");
        }else {
            System.out.println("Телевізор вже був виключений");
            tv.getFout().println("Телевізор вже був виключений");
        }
        tv.getFout().flush();
    }
    public void change_volume_vol_add(TV tv){
        if (dynamics.getLoudness() < 100){
            dynamics.setLoudness((byte) (dynamics.getLoudness()+5));
            System.out.println("Гучність: "+dynamics.getLoudness());
            tv.getFout().println("Гучність: "+dynamics.getLoudness());
        }else {
            System.out.println("Вже стоїть максимальна гучність");
            tv.getFout().println("Вже стоїть максимальна гучність");
        }
        tv.getFout().flush();

    }
    public void change_volume_vol_minus(TV tv){
        if (dynamics.getLoudness() > 0){
            dynamics.setLoudness((byte) (dynamics.getLoudness()-5));
            System.out.println("Гучність: "+dynamics.getLoudness());
            tv.getFout().println("Гучність: "+dynamics.getLoudness());
        }else {
            System.out.println("Вже стоїть мінімальна гучність");
            tv.getFout().println("Вже стоїть мінімальна гучність");
        }
        tv.getFout().flush();
    }
    public void switchСhannel(TV tv) throws FileNotFoundException {
        if (channel == new TV().getChannelTV().length ) {
            channel = 0;
        }
        System.out.println("Канал: "+ new TV().getChannelTV()[channel]);
        tv.getFout().println("Канал: "+ new TV().getChannelTV()[channel]);
        tv.getFout().flush();
        channel++;

    }
    public void ChannelList(TV tv) throws FileNotFoundException {
        byte num = 1;
        System.out.println("--<Список каналів>--");
        tv.getFout().println("--<Список каналів>--");
        for (String el: new TV().getChannelTV()){
            System.out.println("\t"+num+". " + el);
            tv.getFout().println("\t"+num+". " + el);
            num++;
        }
        tv.getFout().flush();
    }
}


