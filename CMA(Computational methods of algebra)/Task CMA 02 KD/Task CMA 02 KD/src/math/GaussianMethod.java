package math;

public class GaussianMethod {

    private static void forwardStroke(double[][] matrix, double[] rhs, int i, double eps) {
        int size = matrix.length;
        double aii = matrix[i][i];
        if (Math.abs(aii) < eps) {
            throw new ArithmeticException("Matrix is singular or nearly singular at column " + i);
        }

        for (int j = i; j < size; j++) {
            matrix[i][j] /= aii;
            if (Double.isInfinite(matrix[i][j]) || Double.isNaN(matrix[i][j])) {
                throw new ArithmeticException("Division by zero");
            }
        }
        rhs[i] /= aii;
        if (Double.isInfinite(rhs[i]) || Double.isNaN(rhs[i])) {
            throw new ArithmeticException("Division by zero");
        }

        for (int k = i + 1; k < size; k++) {
            double aki = matrix[k][i];
            for (int t = i; t < size; t++) {
                matrix[k][t] -= (matrix[i][t] * aki);
            }
            rhs[k] -= (rhs[i] * aki);
        }
    }

    private static void backStroke(double[][] matrix, double[] rhs, double eps) {
        int size = matrix.length;
        for (int i = size - 1; i >= 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                rhs[k] -= (rhs[i] * matrix[k][i]);
                matrix[k][i] = 0;
            }
        }
    }

    public static double[] solve(double[][] matrix, double[] rhs, double eps) {
        validate(matrix, rhs);

        int size = matrix.length;
        double[][] a = new double[size][size];
        for (int i = 0; i < size; i++) {
            a[i] = matrix[i].clone();
        }
        double[] x = rhs.clone();

        for (int i = 0; i < size; i++) {
            forwardStroke(a, x, i, eps);
        }

        backStroke(a, x, eps);
        return x;
    }

    public static double[] columnSolve(double[][] matrix, double[] rhs, double eps) {
        validate(matrix, rhs);

        int size = matrix.length;
        double[][] a = new double[size][size];
        for (int i = 0; i < size; i++) {
            a[i] = matrix[i].clone();
        }
        double[] x = rhs.clone();

        int pivotRow;
        double maxAbs;

        for (int i = 0; i < size; i++) {
            pivotRow = i;
            maxAbs = Math.abs(a[pivotRow][pivotRow]);

            for(int c = i + 1; c < size; c++) {
                if (Math.abs(a[c][i]) > maxAbs) {
                    pivotRow = c;
                    maxAbs = Math.abs(a[c][i]);
                }
            }

            if (pivotRow != i) {
                double[] bufferStr = a[i].clone();
                a[i] = a[pivotRow];
                a[pivotRow] = bufferStr;

                double bufferX = x[i];
                x[i] = x[pivotRow];
                x[pivotRow] = bufferX;
            }

            forwardStroke(a, x, i, eps);
        }

        backStroke(a, x,eps);
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
