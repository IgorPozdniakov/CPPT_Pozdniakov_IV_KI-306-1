import java.io.*;

public class Main {
    public static void main(String[] args) {
        int nRows;
        int filler = 2;

        try (RandomAccessFile file = new RandomAccessFile("MyFile.txt", "r")) {
            String sizeString = file.readLine();
            nRows = Integer.parseInt(sizeString.trim());
        } catch (IOException e) {
            System.out.println("Не вдалося зчитати розмір матриці з файлу.");
            e.printStackTrace();
            return;
        }

        if (nRows % 2 == 1) {
            System.out.println("Непарний розмір матриці");
            return;
        }

        char[][] arr = new char[nRows / 2][nRows];
        for (int i = 0; i < nRows / 2; i++) {
            for (int j = 0; j < nRows; j++) {
                arr[i][j] = (char) (filler + '0');
            }
        }

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                if (i % 2 == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(arr[i / 2][j]);
                }
            }
            System.out.println();
        }
    }
}
