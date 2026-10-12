package math;

public class TridiagonalMatrixMethod {

    public static double[] solve(double[][] matrix, double[] rhs) {
        validate(matrix, rhs);

        int size = matrix.length;
        double[][] a = new double[size][size];
        for (int i = 0; i < size; i++) {
            a[i] = a[i].clone();
        }
        double[] x = new double[size];
        double[] aMas = new double[size + 1];
        double[] bMas = new double[size + 1];

        aMas[1] = -1 * a[0][1] / a[0][0];
        bMas[1] = rhs[0] / a[0][0];
        for (int i = 1; i < size - 1; i++) {
            aMas[i + 1] = -1 * a[i][i + 1] / (a[i][i] + a[i][i - 1] * aMas[i]);
            bMas[i + 1] = (rhs[i] - a[i][i - 1] * bMas[i]) / (a[i][i] + a[i][i - 1] * aMas[i]);
        }
        bMas[size] = (rhs[size - 1] - a[size - 1][size - 2] * bMas[size - 1])
                / (a[size - 1][size - 1] + a[size - 1][size - 2] * aMas[size - 1]);

        x[size - 1] = bMas[size];
        for (int i = size - 2; i >= 0; i--) {
            x[i] = x[i + 1] * aMas[i + 1] + bMas[i + 1];
        }
        return x;
    }
    private static void validate(double[][] matrix, double[] rhs) {
        if (matrix == null || rhs == null) {
            throw new IllegalArgumentException("RHS or/and matrix must not be null");
        }

        int n = matrix.length;
        if (n == 0) {
            throw new IllegalArgumentException("Matrix must not be empty");
        }

        if (rhs.length != n) {
            throw new IllegalArgumentException("RHS and matrix sizes must be equal");
        }

        for (double[] doubles : matrix) {
            if (doubles.length != n) {
                throw new IllegalArgumentException("Matrix must be square");
            }
        }
    }
}
