import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void completeTask3() {
        int n = ConsoleIO.enterNum();
        int size = n + 1;

        double[] a = new double[size];
        double[] c = new double[size];
        double[] b = new double[size];
        double[] d = new double[size];
        double[] y;
        for (int i = 0; i < size; i++) {
            a[i] = 1.0;
            c[i] = (1.0 + i) / (n * n) - 2;
            b[i] = 1.0 - (double) i / (n * n);
            d[i] = (4.0 - (double) (i * i) / (n * n)) / (n * n);
        }
        d[0] -= 2.0;
        d[n - 1] -= 3.0;
        TridiagonalMatrix TridiagonalMatrix = new TridiagonalMatrix(a, c, b);
        y = TridiagonalMatrixMethod.solve(TridiagonalMatrix.getMatrix(), d);

        VectorUtils.showVector("Y: ", y);
    }

    public static void main(String[] args) {
        completeTask3();
    }
}