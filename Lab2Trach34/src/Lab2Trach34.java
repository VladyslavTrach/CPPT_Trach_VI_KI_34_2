import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.IOException;

/**
 * Клас Lab2 реалізує приклад програми до лабораторної роботи №2
 *
 * @author Vladyslav trach
 * @version 1.0
 * @since version 1.0
 *
 */

public class Lab2Trach34 {
    /**
     * Статичний метод main є точкою входу в програму
     *
     * @param args
     * @throws FileNotFoundException
     *
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter size of matrix : ");
        int size = scan.nextInt();

        String s;
        System.out.print("Enter symbol-filler : ");
        s = scan.next();
        char symbol = s.charAt(0);

        if (s.length() != 1){
            System.out.println("Error! Symbol filler is longer/shorter than 1");
            System.exit(0);
        }


        char [][] arr1  = new char[size][size];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if(arr1.length % 2 == 0) {
                    if (i < arr1.length / 2) {
                        if (j <= i) {
                            arr1[i][j] = symbol;
                            arr1[arr1.length - j - 1][arr1.length - i - 1] = symbol;
                        }
                    }
                }
                else {
                    if (i <= arr1.length / 2) {
                        if (j <= i) {
                            arr1[i][j] = symbol;
                            arr1[arr1.length - j - 1][arr1.length - i - 1] = symbol;
                        }
                    }
                }
            }
        }


        char [][] arr2  = new char [size][];
        if (arr2.length % 2 == 0){
            for (int i = 0; i < size / 2; i++){
                arr2[i] = new char[i + 1];
            }
            for (int i = size / 2; i < size; i++){
                arr2[i] = new char[i - size / 2 + 1];
            }

            for (int i = 0; i < size / 2; i++) {
                for (int j = 0; j <= i; j++) {
                    arr2[i][j] = symbol;
                }
            }
            for (int i = size / 2; i < size; i++) {
                for (int j = 0; j <= i - size / 2; j++) {
                    arr2[i][j] = symbol;
                }
            }
        } else {
            for (int i = 0; i < size / 2 + 1; i++){
                arr2[i] = new char[i + 1];
            }
            for (int i = size / 2 + 1; i < size; i++){
                arr2[i] = new char[i - size / 2 + 1];
            }

            for (int i = 0; i < size / 2 + 1; i++) {
                for (int j = 0; j <= i; j++) {
                    arr2[i][j] = symbol;
                }
            }
            for (int i = size / 2 + 1; i < size; i++) {
                for (int j = 0; j <= i - size / 2; j++) {
                    arr2[i][j] = symbol;
                }
            }
        }

        System.out.println("Ragged array :");
        for (char[] row: arr2) {
            System.out.println(Arrays.toString(row));
        }


        System.out.println("\n Quad Matrix :");
        for (int i = 0; i < arr1.length; i++){
            for (int j = 0; j < arr1.length; j++){
                System.out.print(arr1[i][j] + " ");
            }
            System.out.print("\n");
        }



        try {
            File file = new File("Lab_2.txt");
            if(!file.exists()) {
                file.createNewFile();
            }
            PrintWriter pw =  new PrintWriter(file);
            pw.println("Enter size of matrix : " + size);
            pw.println("Enter symbol-filler : " + symbol);
            pw.println("Ragged array : ");
            for (char[] row: arr2) {
                pw.println(Arrays.toString(row));
            }
            pw.close();
        } catch (IOException e){
            System.out.print("Error! : " + e);
        }
    }
}