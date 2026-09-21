import java.util.Scanner;

public class HilbertMatrix {
    private final int rows;
    private final int cols;
    private final double[][] matrix;

    public HilbertMatrix(int n) {
        rows = n;
        cols = rows + 1;
        matrix = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                matrix[i][j] = 1.0 / (i + j + 1);
            }
        }
        matrix[0][cols - 1] = 1;
    }

    public void makeZeros() {
        for (int i = 0; i < rows; i++) {
            double a = matrix[i][i];
            for (int j = i; j < cols; j++) {
                matrix[i][j] /= a;
            }
            for (int k = i + 1; k < rows; k++) {
                double b = matrix[k][i];
                for (int t = i; t < cols; t++) {
                    matrix[k][t] -= (matrix[i][t] * b);
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                matrix[k][cols - 1] -= (matrix[i][cols - 1] * matrix[k][i]);
                matrix[k][i] = 0;
            }
        }
    }

    public double[] xResults() {
        double[] result = new double[rows];
        for (int i = 0; i < rows; i++) {
            result[i] = matrix[i][cols - 1];
        }
        return result;
    }

    public static void completeTask() {
        final double EPS = 1e-9;
        double[] answer = ConsoleIO.enterTask();
        HilbertMatrix A = new HilbertMatrix(answer.length);

        System.out.println("Hilbert matrix: ");
        MatrixUtils.showMatrix(A.matrix);
        A.makeZeros();

        System.out.println("Task result:");
        MatrixUtils.showResult(answer);

        System.out.println("My result:");
        double[] result = A.xResults();
        MatrixUtils.showResult(result);

        System.out.println("Compare result: ");
        MatrixUtils.showComparing(answer, result, EPS);
    }
}
