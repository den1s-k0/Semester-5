import input.ConsoleIO;
import math.DiagonallyDominationMatrix;
import math.GaussianMethod;
import math.HilbertMatrix;
import math.MatrixUtils;

import java.util.Arrays;

public class Main {

    public static void completeTask1() {
        final double eps = 1e-10;
        final double eps1 = 1e-30;
        double[] xAnswer = ConsoleIO.enterX();
        HilbertMatrix hilbertMatrix = new HilbertMatrix(xAnswer.length);
        double[][] matrix1 = hilbertMatrix.getMatrix();

        System.out.println("Hilbert matrix: ");
        MatrixUtils.showMatrix(matrix1);

        MatrixUtils.showVector("Task result:", xAnswer);

        double[] rhs = MatrixUtils.matrixVectorMultiply(matrix1, xAnswer);
        double[] defaultResult = GaussianMethod.solve(matrix1, rhs, eps1);
        MatrixUtils.showVector("My default solve result:", defaultResult);

        MatrixUtils.showComparing("Compare solve result: ", xAnswer, defaultResult, eps);

        double[] columnResult = GaussianMethod.columnSolve(matrix1, rhs, eps1);
        MatrixUtils.showVector("Select by column solve result:", columnResult);

        MatrixUtils.showComparing("Compare column solve result: ", xAnswer, columnResult, eps);

        double[] rowResult = GaussianMethod.rowSolve(matrix1, rhs, eps1);
        MatrixUtils.showVector("Select by row solve result:", rowResult);

        MatrixUtils.showComparing("Compare row solve result: ", xAnswer, rowResult, eps);

        MatrixUtils.showNorms("Default solve: ", defaultResult, xAnswer);

        MatrixUtils.showNorms("Column solve: ", columnResult, xAnswer);

        MatrixUtils.showNorms("Row solve: ", rowResult, xAnswer);

    }

    public static void completeTask34() {
        int[] nVec = {3, 7, 11, 15, 19};
        for (int i : nVec) {
            System.out.println(i);
            System.out.printf("%-15s%-20s%-20s%-20s%n", "", "Cubic Norm",
                    "Octahedral Norm", "Spherical Norm");
            completeHilbertMatrix(i);
            System.out.println();
        }
    }

    public static void completeHilbertMatrix(int n) {
        final double eps1 = 1e-30;
        double[] xAnswer = new double[n];
        Arrays.fill(xAnswer, 1);
        HilbertMatrix hilbertMatrix = new HilbertMatrix(xAnswer.length);
        double[][] matrix1 = hilbertMatrix.getMatrix();

        double[] rhs = MatrixUtils.matrixVectorMultiply(matrix1, xAnswer);
        double[] defaultResult = GaussianMethod.solve(matrix1, rhs, eps1);
        double[] columnResult = GaussianMethod.columnSolve(matrix1, rhs, eps1);
        double[] rowResult = GaussianMethod.rowSolve(matrix1, rhs, eps1);

        MatrixUtils.showNormsForTable("Default solve: ", defaultResult, xAnswer);

        MatrixUtils.showNormsForTable("Column solve: ", columnResult, xAnswer);

        MatrixUtils.showNormsForTable("Row solve: ", rowResult, xAnswer);
    }

    public static void completeTask5() {
        DiagonallyDominationMatrix diagonallyDominationMatrix = new DiagonallyDominationMatrix(ConsoleIO.enterSize());
        double[][] matrix = diagonallyDominationMatrix.getMatrix();

        MatrixUtils.showMatrix02F(matrix);
    }

    public static void main(String[] args) {
        completeTask5();
    }
}