

public class TridiagonalMatrix {
    private final int size;
    private final double[][] matrix;

    public TridiagonalMatrix(double[] a, double[] c, double[] b) {
        if (a.length != c.length || b.length != c.length) {
            throw new IllegalArgumentException("A, B and C sizes must be equal");
        }
        size = c.length;
        matrix = new double[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = c[i];
            if (i != 0) {
                matrix[i][i - 1] = a[i];
            }
            if (i != size - 1) {
                matrix[i][i + 1] = b[i];
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
}
