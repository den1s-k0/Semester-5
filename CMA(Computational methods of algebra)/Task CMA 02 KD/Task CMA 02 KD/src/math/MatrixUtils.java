package math;

public class MatrixUtils {
    public static double[] matrixVectorMultiply(double[][] matrix, double[] x) {
        int size = matrix.length;
        double[] rsh = new double[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rsh[i] += matrix[i][j] * x[j];
            }
        }
        return rsh;
    }

    public static void showMatrix(double[][] matrix) {
        for (double[] i : matrix) {
            for (double j : i ) {
                System.out.printf("%-20.6e", j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showVector(double[] vector) {
        for (double i : vector) {
            System.out.printf("%-20.8e", i);
        }
        System.out.println("\n");
    }

    public static void showVector(String str, double[] vector) {
        System.out.printf("%-35s", str);
        for (double i : vector) {
            System.out.printf("%-20.8e", i);
        }
        System.out.println("\n");
    }

    public static void showComparing(double[] mas1, double[] mas2, double eps) {
        for (int i = 0; i < mas1.length; i++) {
            System.out.printf("%-20s", (Math.abs(mas1[i] - mas2[i]) < eps) ? "equal" : "not equal");
        }
        System.out.println("\n");
    }

    public static void showComparing(String str, double[] mas1, double[] mas2, double eps) {
        System.out.printf("%-35s", str);
        for (int i = 0; i < mas1.length; i++) {
            System.out.printf("%-20s", (Math.abs(mas1[i] - mas2[i]) < eps) ? "equal" : "not equal");
        }
        System.out.println("\n");
    }
}

