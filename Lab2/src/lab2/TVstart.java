package lab2;

import java.io.FileNotFoundException;

public class TVstart {

    private static TV tv4;
    private static TV tv5;
    private static TV tv6;
    private static TV tv7;
    private static TV tv8;
    private static TV tv9;
    private static TV tv10;

    public static void main(String[] args) throws FileNotFoundException {
        boolean ss = true;
        System.out.println(!ss);
        TV tv1 = new TV(TV.Type.OLED, "LG1");
        TV tv2 = new TV(TV.Type.LCD, "LG2");
        TV tv3 = new TV(TV.Type.OLED, "LG3");
        main1();


    }



    public static void main1() throws FileNotFoundException {
        TV tv4 = new TV(TV.Type.OLED, "LG4");
        TV tv5 = new TV(TV.Type.LCD, "LG5");
        TV tv6 = new TV(TV.Type.OLED, "LG6");
        TV tv7 = new TV(TV.Type.LCD, "LG51");
        TV tv8 = new TV(TV.Type.LCD, "LG52");
        TV tv9 = new TV(TV.Type.LCD, "LG53");
        TV tv10 = new TV(TV.Type.LCD, "LG54");
       TV tv11 = new TV(TV.Type.LCD, "LG5111111");
        TV tv111 = new TV(TV.Type.LCD, "LG5111111");
    }
}
