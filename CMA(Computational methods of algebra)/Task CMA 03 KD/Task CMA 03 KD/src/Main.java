import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void completeTask3() {
        int n = ConsoleIO.enterNum();

        double[] a = new double[n];
        double[] c = new double[n];
        double[] b = new double[n];
        double[] d = new double[n];
        double[] y;
        for (int i = 0; i < n; i++) {
            a[i] = 1.0;
            c[i] = (1.0 + i) / (n * n) - 2;
            b[i] = 1.0 - (double) i / (n * n);
            d[i] = (4.0 - (double) (i * i) / (n * n)) / (n * n);
        }
        TridiagonalMatrix TridiagonalMatrix = new TridiagonalMatrix(a, c, b);
        y = TridiagonalMatrixMethod.solve(TridiagonalMatrix.getMatrix(), d);

        VectorUtils.showVector("Y: ", y);
    }

    public static void main(String[] args) {
        completeTask3();
    }
}