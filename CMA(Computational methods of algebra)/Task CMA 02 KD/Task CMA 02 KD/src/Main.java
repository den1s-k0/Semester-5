import input.ConsoleIO;
import math.VectorUtils;
import math.matrix.DiagonallyDominationMatrix;
import math.GaussianMethod;
import math.matrix.HilbertMatrix;
import math.matrix.MatrixUtils;

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

        VectorUtils.showVector("Task result:", xAnswer);

        double[] rhs = MatrixUtils.matrixVectorMultiply(matrix1, xAnswer);
        double[] defaultResult = GaussianMethod.solve(matrix1, rhs, eps1);
        VectorUtils.showVector("My default solve result:", defaultResult);

        VectorUtils.showComparing("Compare solve result: ", xAnswer, defaultResult, eps);

        double[] columnResult = GaussianMethod.columnSolve(matrix1, rhs, eps1);
        VectorUtils.showVector("Select by column solve result:", columnResult);

        VectorUtils.showComparing("Compare column solve result: ", xAnswer, columnResult, eps);

        double[] rowResult = GaussianMethod.rowSolve(matrix1, rhs, eps1);
        VectorUtils.showVector("Select by row solve result:", rowResult);

        VectorUtils.showComparing("Compare row solve result: ", xAnswer, rowResult, eps);

        VectorUtils.showNorms("Default solve: ", defaultResult, xAnswer);

        VectorUtils.showNorms("Column solve: ", columnResult, xAnswer);

        VectorUtils.showNorms("Row solve: ", rowResult, xAnswer);

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

        VectorUtils.showNormsForTable("Default solve: ", defaultResult, xAnswer);

        VectorUtils.showNormsForTable("Column solve: ", columnResult, xAnswer);

        VectorUtils.showNormsForTable("Row solve: ", rowResult, xAnswer);
    }

    public static void completeTask5() {
        DiagonallyDominationMatrix diagonallyDominationMatrix = new DiagonallyDominationMatrix(ConsoleIO.enterSize());
        double[][] matrix = diagonallyDominationMatrix.getMatrix();

        MatrixUtils.showMatrix02F(matrix);
    }

    public static void completeTask6() {
        final double eps = 1e-15;
        double[][] matrix = ConsoleIO.enterMatrix();

        double cubicCond = MatrixUtils.cubicCond(matrix, eps);

        System.out.printf("Condition number in cubic norm: %-20.3f%n", cubicCond);

        double octahedralCond = MatrixUtils.octahedralCond(matrix, eps);

        System.out.printf("Condition number in octahedral norm: %-20.3f%n", octahedralCond);

        double sphericalCond = MatrixUtils.sphericalCond(matrix, eps);

        System.out.printf("Condition number in spherical norm: %-20.3f%n", sphericalCond);
    }

    public static void main(String[] args) {
        int n = -1;
        while (n != 0) {
            switch(n = ConsoleIO.enterNum()) {
                case 0:
                    break;
                case 1:
                    completeTask1();
                    break;
                case 2:
                    completeTask34();
                    break;
                case 3:
                    completeTask5();
                    break;
                case 4:
                    completeTask6();
                    break;
                default:
                    System.out.println("Enter different number");
                    break;
            }
        }
    }
}