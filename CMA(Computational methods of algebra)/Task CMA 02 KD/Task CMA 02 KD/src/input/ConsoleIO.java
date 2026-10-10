package input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIO {
    public static int enterNum() {
        Scanner in = new Scanner(System.in);
        int n;
        while (true) {
            System.out.print("Enter Number: ");
            try {
                n = in.nextInt();
                if (n >= 0) {
                    break;
                }
                System.out.println("Number must be >= 0");
            } catch (InputMismatchException e) {
                System.out.println("It must be a number");
                in.nextLine();
            }
        }
        return n;
    }

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

    public static double[][] enterMatrix() {
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
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter " + size + " elements of " + i + " row: ");
            for (int j = 0; j < size; j++) {
                while (true) {
                    try {
                        matrix[i][j] = in.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Value must be a number");
                        in.nextLine();
                    }
                }
            }
        }
        return matrix;
    }
}
