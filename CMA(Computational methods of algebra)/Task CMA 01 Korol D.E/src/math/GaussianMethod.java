package math;

public class GaussianMethod {
    public static double[] solve(double[][] matrix, double[] rhs) {
        validate(matrix, rhs);
        int size = matrix.length;
        double[][] a = new double[size][size];
        for (int i = 0; i < size; i++) {
            a[i] = matrix[i].clone();
        }
        double[] x = rhs.clone();
        for (int i = 0; i < size; i++) {
            double aii = a[i][i];
            for (int j = i; j < size; j++) {
                a[i][j] /= aii;
                if (Double.isInfinite(a[i][j]) || Double.isNaN(a[i][j])) {
                    throw new ArithmeticException("Division by zero");
                }
            }
            x[i] /= aii;
            for (int k = i + 1; k < size; k++) {
                double aki = a[k][i];
                for (int t = i; t < size; t++) {
                    a[k][t] -= (a[i][t] * aki);
                }
                x[k] -= (x[i] * aki);
            }
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                x[k] -= (x[i] * a[k][i]);
                a[k][i] = 0;
            }
        }
        return x;
    }

    private static void validate(double[][] matrix, double[] rhs) {
        if (matrix == null || rhs == null) {
            throw new IllegalArgumentException("RSH or/and matrix must not be null");
        }

        int n = matrix.length;
        if (n == 0) {
            throw new IllegalArgumentException("Matrix must not be empty");
        }

        if (rhs.length != n) {
            throw new IllegalArgumentException("RSH and matrix sizes must be equal");
        }

        for (double[] doubles : matrix) {
            if (doubles.length != n) {
                throw new IllegalArgumentException("Matrix must be square");
            }
        }
    }
}
