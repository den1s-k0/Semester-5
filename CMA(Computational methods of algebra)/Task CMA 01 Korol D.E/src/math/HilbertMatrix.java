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
        final double eps = 1e-9;
        double[] answer = ConsoleIO.enterTask();
        HilbertMatrix hilbertMatrix = new HilbertMatrix(answer.length);
        double[][] matrix1 = hilbertMatrix.getMatrix();

        System.out.println("Hilbert matrix: ");
        MatrixUtils.showMatrix(matrix1);

        System.out.println("Task result:");
        MatrixUtils.showResult(answer);

        System.out.println("My result:");
        double[] rsh = new double[hilbertMatrix.getSize()];
        rsh[0] = 1;
        double[] result = GaussianMethod.solve(matrix1, rsh);
        MatrixUtils.showResult(result);

        System.out.println("Compare result: ");
        MatrixUtils.showComparing(answer, result, eps);
    }
}
