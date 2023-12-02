package lab4;

public class EquationsApp {
    public static void main(String[] args) {
        CalculateTheEquationInterface calc = new CalculateTheEquation();
        System.out.println("  y=cos/tg(2x)  = " + calc.doCalculation(300));
        System.out.println("  y=cos/tg(2x)  = " + calc.doCalculation(70));

        System.out.println("  y=cos/tg(2x)  = " + calc.doCalculationWithInputInside());
    }
}
