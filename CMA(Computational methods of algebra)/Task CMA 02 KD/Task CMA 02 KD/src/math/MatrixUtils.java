package math;

public class MatrixUtils {

    public static void showMatrix(double[][] matrix) {
        for (double[] i : matrix) {
            for (double j : i ) {
                System.out.printf("%-20.6e", j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showResult(double[] result) {
        for (double i : result) {
            System.out.printf("%-20.8e", i);
        }
        System.out.println("\n");
    }

    public static void showResult(String str, double[] result) {
        System.out.printf("%-30s", str);
        for (double i : result) {
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
        System.out.printf("%-30s", str);
        for (int i = 0; i < mas1.length; i++) {
            System.out.printf("%-20s", (Math.abs(mas1[i] - mas2[i]) < eps) ? "equal" : "not equal");
        }
        System.out.println("\n");
    }
}

