package math.matrix;

public class MatrixUtils {

    private static void forwardStroke(double[][] matrix, double[][] invMatrix, int i, double eps) {
        int size = matrix.length;
        double aii = matrix[i][i];
        if (Math.abs(aii) < eps) {
            throw new ArithmeticException("Matrix is singular or nearly singular at column " + i);
        }
        for (int j = 0; j < size; j++) {
            matrix[i][j] /= aii;
            invMatrix[i][j] /= aii;
            if (Double.isInfinite(matrix[i][j]) || Double.isNaN(matrix[i][j])) {
                throw new ArithmeticException("Division by zero");
            }
        }

        for (int k = i + 1; k < size; k++) {
            double aki = matrix[k][i];
            for (int t = 0; t < size; t++) {
                matrix[k][t] -= (matrix[i][t] * aki);
                invMatrix[k][t] -= (invMatrix[i][t] * aki);
            }
        }
    }

    private static void backStroke(double[][] matrix, double[][] invMatrix) {
        int size = matrix.length;
        for (int i = size - 1; i >= 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                for (int j = 0; j < size; j++) {
                    invMatrix[k][j] -= (invMatrix[i][j] * matrix[k][i]);
                }
                matrix[k][i] = 0;
            }
        }
    }

    public static double[][] inverseMatrix(double[][] matrix, double eps) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix must not be null");
        }

        int n = matrix.length;
        if (n == 0) {
            throw new IllegalArgumentException("Matrix must not be empty");
        }

        for (double[] doubles : matrix) {
            if (doubles.length != n) {
                throw new IllegalArgumentException("Matrix must be square");
            }
        }

        int size = matrix.length;
        double[][] a = new double[size][size];
        double[][] invA = new double[size][size];
        for (int i = 0; i < size; i++) {
            a[i] = matrix[i].clone();
            invA[i][i] = 1;
        }

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

                bufferStr = invA[i].clone();
                invA[i] = invA[pivotRow];
                invA[pivotRow] = bufferStr;
            }

            forwardStroke(a, invA, i, eps);
        }

        backStroke(a, invA);
        return invA;
    }
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

    public static double cubicNorm(double[][] matrix) {
        double maxSumAbs = 0;
        for (double[] row : matrix) {
            double sumAbs = 0;
            for ( double elem : row) {
                sumAbs += Math.abs(elem);
            }
            if (sumAbs > maxSumAbs) {
                maxSumAbs = sumAbs;
            }
        }
        return maxSumAbs;
    }

    public static double octahedralNorm(double[][] matrix) {
        double maxSumAbs = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            double sumAbs = 0;
            for (int j = 0; j < matrix.length; j++) {
                sumAbs += Math.abs(matrix[j][i]);
            }
            if (sumAbs > maxSumAbs) {
                maxSumAbs = sumAbs;
            }
        }
        return maxSumAbs;
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

    public static void showMatrix02F(double[][] matrix) {
        for (double[] i : matrix) {
            for (double j : i ) {
                System.out.printf("%-10.2f", j);
            }
            System.out.println();
        }
        System.out.println();
    }

}

