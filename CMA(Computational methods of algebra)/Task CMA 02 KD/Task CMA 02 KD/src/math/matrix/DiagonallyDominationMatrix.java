package math.matrix;

public class DiagonallyDominationMatrix implements Matrix {
    private final int size;
    private final double[][] matrix;
    private final static int maxAbs = 10000;

    public DiagonallyDominationMatrix(int n) {
        size = n;
        if (size <= 0) {
            throw new IllegalArgumentException("Size must be positive, got: " + size);
        }
        matrix = new double[size][size];

        for (int i = 0; i < size; i++) {
            double sumAbs = 0;
            for (int j = 0; j < size; j++) {
                matrix[i][j] = ((Math.random() * (maxAbs * 2 + 1)) - maxAbs) / 100.0;
                sumAbs += Math.abs(matrix[i][j]);
            }
            matrix[i][i] = (matrix[i][i] >= 0) ? sumAbs : sumAbs * (-1);
        }
    }

    @Override
    public double[][] getMatrix() {
        double[][] copy = new double[size][size];
        for (int i = 0; i < size; i++) {
            copy[i] = matrix[i].clone();
        }
        return copy;
    }

    @Override
    public int getSize() {
        return size;
    }
}
