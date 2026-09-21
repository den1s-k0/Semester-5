package math;

public class GaussianMethod {
    public static double[] gaussianMethod(double[][] matrix, int ind) {
        int size = matrix.length;
        double[][] matr = new double[size][size];
        for (int i = 0; i < size; i++) {
            matr[i] = matrix[i].clone();
        }
        double[] addition = new double[size];
        addition[ind - 1] = 1.0;
        for (int i = 0; i < size; i++) {
            double a = matr[i][i];
            for (int j = i; j < size; j++) {
                matr[i][j] /= a;
                if (Double.isInfinite(matr[i][j]) || Double.isNaN(matr[i][j])) {
                    System.out.println("Division by zero");
                }
            }
            addition[i] /= a;
            for (int k = i + 1; k < size; k++) {
                double b = matr[k][i];
                for (int t = i; t < size; t++) {
                    matr[k][t] -= (matr[i][t] * b);
                }
                addition[k] -= (addition[i] * b);
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                addition[k] -= (addition[i] * matr[k][i]);
                matr[k][i] = 0;
            }
        }
        return addition;
    }
}
