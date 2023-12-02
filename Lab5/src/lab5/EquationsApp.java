package lab5;

import java.io.IOException;

public class EquationsApp {
    public static void main(String[] args) {
        double valueToWrite = -1.1; // Значення, яке  записую

        // Передаємо значення через конструктор
        CalculateTheEquation calc = new CalculateTheEquation(valueToWrite);

        try {
            // Запис у текстовий файл
            calc.writeResultToTxt("src/txt.txt");
            System.out.println("Значення успішно записано у текстовий файл.");

            // Запис у бінарний файл
            calc.writeResultToBin("src/bin.bin");
            System.out.println("Значення успішно записано у бінарний файл.");
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }

        // Передаємо значення через конструктор
        CalculateTheEquation calc1 = new CalculateTheEquation(0.0);
        try {
            calc1.readResultFromBin("src/bin.bin");
            System.out.println("Result of calculation: " + calc1.doCalculation());
            calc1.writeResultToBin("src/bin.bin");
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            calc1.readResultFromTxt("src/txt.txt");
            System.out.println("Result of calculation: " + calc1.doCalculation());
            calc1.writeResultToTxt("src/txt.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
