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

    public static void completeTask() {
        final double EPS = 1e-9;
        double[] answer = ConsoleIO.enterTask();
        HilbertMatrix A = new HilbertMatrix(answer.length);

        System.out.println("Hilbert matrix: ");
        MatrixUtils.showMatrix(A.matrix);

        System.out.println("Task result:");
        MatrixUtils.showResult(answer);

        System.out.println("My result:");
        double[] result = GaussianMethod.gaussianMethod(A.matrix, 1);
        MatrixUtils.showResult(result);

        System.out.println("Compare result: ");
        MatrixUtils.showComparing(answer, result, EPS);
    }
}
