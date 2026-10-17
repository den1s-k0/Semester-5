import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void completeTask3() {
        int n = ConsoleIO.enterNum();
        int size = n - 1;

        double[] a = new double[size];
        double[] c = new double[size];
        double[] b = new double[size];
        double[] d = new double[size];
        double[] y;

        double h = 1.0 / n;
        for (int j = 0; j < size; j++) {
            int i = j + 1;
            a[j] = 1.0;
            c[j] = (1 + i) * h * h - 2;
            b[j] = 1.0 - i * h * h;
            d[j] = (4.0 - (i * i * h * h)) * (h * h);
        }

        d[0] -= a[0] * 2;
        a[0] = 0;

        d[size - 1] -= b[size - 1] * 3;
        b[size - 1] = 0;

        TridiagonalMatrix TridiagonalMatrix = new TridiagonalMatrix(a, c, b);
        y = TridiagonalMatrixMethod.solve(TridiagonalMatrix.getMatrix(), d);

        double[] yFull = new double[n + 1];
        yFull[0] = 2;
        yFull[n] = 3;
        System.arraycopy(y, 0, yFull, 1, size);

        double[] exactY = new double[n + 1];
        for (int i = 0; i < n + 1; i++) {
            exactY[i] = i * i * h * h + 2;
        }

        VectorUtils.showVector("Y: ", yFull);
        VectorUtils.showVector("exact Y: ", exactY);
        VectorUtils.showDifference("Difference: ", yFull, exactY);

    }

    public static void main(String[] args) {
        completeTask3();
    }
}