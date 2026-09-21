package math;

public class MatrixUtils {

    public static void showMatrix(double[][] matrix) {
        for (double[] i : matrix) {
            for (double j : i ) {
                System.out.printf("%-12.4f", j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showResult(double[] result) {
        for (double i : result) {
            System.out.printf("%-12.4f", i);
        }
        System.out.println();
    }

    public static void showComparing(double[] mas1, double[] mas2, double eps) {
        for (int i = 0; i < mas1.length; i++) {
            System.out.printf("%-12s", (Math.abs(mas1[i] - mas2[i]) < eps) ? "equal" : "not equal");
        }
        System.out.println();
    }
}

