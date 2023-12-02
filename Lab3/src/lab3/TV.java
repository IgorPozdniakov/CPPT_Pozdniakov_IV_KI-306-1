package lab3;
import lab3.TvTuner;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TV implements TvTuner{

    private byte loudness = 50;
    private PrintWriter fout = new PrintWriter(new FileOutputStream(
            new File("MyTvTuner.txt"),
            true));

    private boolean switchTV = false;
    private byte channel = 0;

    public TV() throws FileNotFoundException {
    }

    public PrintWriter getFout(){
        return fout;
    }


    @Override
    public void include() {
        if (!switchTV){
            switchTV = true;
            System.out.println("Телевізор включився");
            getFout().println("Телевізор включився");
        }else {
            System.out.println("Телевізор вже був включений");
            getFout().println("Телевізор вже був включений");
        }
        getFout().flush();
    }

    @Override
    public void exclude() {
        if (switchTV){
            switchTV = false;
            System.out.println("Телевізор виключили");
            getFout().println("Телевізор виключили");

        }else {
            System.out.println("Телевізор вже був виключений");
            getFout().println("Телевізор вже був виключений");

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
            System.out.println("Звук: "+(--loudness));
            getFout().println("Звук: "+(loudness));
        }else{
            System.out.println("Вже стоїть мінімальна гучність");
            getFout().println("Вже стоїть мінімальна гучність");
        }
        getFout().flush();
    }

}
