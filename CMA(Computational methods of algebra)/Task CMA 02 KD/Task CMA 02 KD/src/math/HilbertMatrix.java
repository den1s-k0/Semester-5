package math;

import input.ConsoleIO;

public class HilbertMatrix {
    private final int size;
    private final double[][] matrix;

    public HilbertMatrix(int n) {
        size = n;
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive, got: " + size);
        }
        matrix = new double[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = 1.0 / (i + j + 1);
            }
        }
    }

    public double[][] getMatrix() {
        double[][] copy = new double[size][size];
        for (int i = 0; i < size; i++) {
            copy[i] = matrix[i].clone();
        }
        return copy;
    }

    public int getSize() {
        return size;
    }

    public static void completeTask() {
        final double eps = 1e-10;
        double[] xAnswer = ConsoleIO.enterX();
        HilbertMatrix hilbertMatrix = new HilbertMatrix(xAnswer.length);
        double[][] matrix1 = hilbertMatrix.getMatrix();

        System.out.println("Hilbert matrix: ");
        MatrixUtils.showMatrix(matrix1);

        MatrixUtils.showVector("Task result:", xAnswer);

        double[] rsh = MatrixUtils.matrixVectorMultiply(matrix1, xAnswer);
        double[] defaultResult = GaussianMethod.solve(matrix1, rsh);
        MatrixUtils.showVector("My default solve result:", defaultResult);

        MatrixUtils.showComparing("Compare solve result: ", xAnswer, defaultResult, eps);

        double[] columnResult = GaussianMethod.columnSolve(matrix1, rsh);
        MatrixUtils.showVector("Select by column solve result:", defaultResult);

        MatrixUtils.showComparing("Compare column solve result: ", xAnswer, columnResult, eps);
    }
}
