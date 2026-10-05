import input.ConsoleIO;
import math.GaussianMethod;
import math.HilbertMatrix;
import math.MatrixUtils;

public class Main {

    public static void completeTask() {
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

    public static void main(String[] args) {
        completeTask();
    }
}