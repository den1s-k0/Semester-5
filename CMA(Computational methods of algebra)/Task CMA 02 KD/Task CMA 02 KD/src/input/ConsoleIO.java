package input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIO {
    public static double[] enterX(){
        Scanner in = new Scanner(System.in);
        int size;
        while (true) {
            System.out.print("Enter matrix size: ");
            try {
                size = in.nextInt();
                if (size > 0) {
                    break;
                }
                System.out.println("Size must be > 0");
            } catch (InputMismatchException e) {
                System.out.println("Size must be a number");
                in.nextLine();
            }
        }
        System.out.print("Enter " + size + " x: ");
        double[] x = new double[size];
        for(int i = 0; i < size; i++) {
            while (true) {
                try {
                    x[i] = in.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Value must be a number");
                    in.nextLine();
                }
            }
        }
        return x;
    }

    public static int enterSize(){
        Scanner in = new Scanner(System.in);
        int size;
        while (true) {
            System.out.print("Enter matrix size: ");
            try {
                size = in.nextInt();
                if (size > 0) {
                    break;
                }
                System.out.println("Size must be > 0");
            } catch (InputMismatchException e) {
                System.out.println("Size must be a number");
                in.nextLine();
            }
        }
        return size;
    }
}
