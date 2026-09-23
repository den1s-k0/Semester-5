package math;

public class GaussianMethod {
    private final static double eps = 1e-15;

    public static double[] aX(double[][] matrix, double[] x) {
        int size = matrix.length;
        double[] rsh = new double[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rsh[i] += matrix[i][j] * x[j];
            }
        }
        return rsh;
    }

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
            if (aii < eps) {
                throw new ArithmeticException("Matrix is singular or nearly singular at column " + i);
            }

            for (int j = i; j < size; j++) {
                a[i][j] /= aii;
                if (Double.isInfinite(a[i][j]) || Double.isNaN(a[i][j])) {
                    throw new ArithmeticException("Division by zero");
                }
            }
            x[i] /= aii;
            if (Double.isInfinite(x[i]) || Double.isNaN(x[i])) {
                throw new ArithmeticException("Division by zero");
            }

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

    public static double[] pivotSolve(double[][] matrix, double[] rhs) {
        validate(matrix, rhs);

        int size = matrix.length;
        double[][] a = new double[size][size];
        for (int i = 0; i < size; i++) {
            a[i] = matrix[i].clone();
        }
        double[] x = rhs.clone();

        int pivotStr;
        double maxAbs;

        for (int i = 0; i < size; i++) {
            pivotStr = i;
            maxAbs = Math.abs(a[pivotStr][pivotStr]);

            for(int c = i + 1; c < size; c++) {
                if (Math.abs(a[c][i]) > maxAbs) {
                    pivotStr = c;
                    maxAbs = Math.abs(a[c][i]);
                }
            }

            if (maxAbs < eps) {
                throw new ArithmeticException("Matrix is singular or nearly singular at column " + i);
            }

            if (pivotStr != i) {
                double[] bufferStr = a[i].clone();
                a[i] = a[pivotStr];
                a[pivotStr] = bufferStr;

                double bufferX = x[i];
                x[i] = x[pivotStr];
                x[pivotStr] = bufferX;
            }

            double aii = a[i][i];
            for (int j = i; j < size; j++) {
                a[i][j] /= aii;
                if (Double.isInfinite(a[i][j]) || Double.isNaN(a[i][j])) {
                    throw new ArithmeticException("Division by zero");
                }
            }
            x[i] /= aii;
            if (Double.isInfinite(x[i]) || Double.isNaN(x[i])) {
                throw new ArithmeticException("Division by zero");
            }

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
