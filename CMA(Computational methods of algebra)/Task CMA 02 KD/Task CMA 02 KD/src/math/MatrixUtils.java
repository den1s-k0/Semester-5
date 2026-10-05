package math;

public class MatrixUtils {
    public static double[] matrixVectorMultiply(double[][] matrix, double[] x) {
        int size = matrix.length;
        double[] rsh = new double[size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rsh[i] += matrix[i][j] * x[j];
            }
        }
        return rsh;
    }

    public static double[] vectorsDifference(double[] mas1, double[] mas2) {
        if (mas1 == null || mas2 == null) {
            throw new IllegalArgumentException("X or X* must not be null");
        }

        int n = mas1.length;
        if (n == 0) {
            throw new IllegalArgumentException("Matrix must not be empty");
        }

        if (mas2.length != n) {
            throw new IllegalArgumentException("RSH and matrix sizes must be equal");
        }

        double[] err = new double[n];

        for (int i = 0; i < n; i++) {
            err[i] = mas1[i] - mas2[i];
        }
        return err;
    }
    public static double cubicNorm(double[] mas) {
        double maxAbs = mas[0];
        for (double ma : mas) {
            if (maxAbs < Math.abs(ma)) {
                maxAbs = Math.abs(ma);
            }
        }
        return maxAbs;
    }

    public static double octahedralNorm(double[] mas) {
        double sum = 0;
        for (double ma : mas) {
            sum += Math.abs(ma);
        }
        return sum;
    }

    public static double sphericalNorm(double[] mas) {
        double sum = 0;
        for (double ma : mas) {
            sum += ma * ma;
        }
        return Math.sqrt(sum);
    }

    public static void showNorms(double[] mas1, double[] mas2) {
        double[] err = MatrixUtils.vectorsDifference(mas1, mas2);
        System.out.printf("%-20s%-20s%-20s%n", "Cubic Norm",
                "Octahedral Norm", "Spherical Norm");
        System.out.printf("%-20.8e%-20.8e%-20.8e%n", MatrixUtils.cubicNorm(err),
                MatrixUtils.octahedralNorm(err), MatrixUtils.sphericalNorm(err));
    }

    public static void showNorms(String str, double[] mas1, double[] mas2) {
        System.out.printf("%-35s%n", str);
        double[] err = MatrixUtils.vectorsDifference(mas1, mas2);
        System.out.printf("%-20s%-20s%-20s%n", "Cubic Norm",
                "Octahedral Norm", "Spherical Norm");
        System.out.printf("%-20.8e%-20.8e%-20.8e%n%n", MatrixUtils.cubicNorm(err),
                MatrixUtils.octahedralNorm(err), MatrixUtils.sphericalNorm(err));
    }

    public static void showMatrix(double[][] matrix) {
        for (double[] i : matrix) {
            for (double j : i ) {
                System.out.printf("%-20.6e", j);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void showVector(double[] vector) {
        for (double i : vector) {
            System.out.printf("%-20.8e", i);
        }
        System.out.println("\n");
    }

    public static void showVector(String str, double[] vector) {
        System.out.printf("%-35s", str);
        for (double i : vector) {
            System.out.printf("%-20.8e", i);
        }
        System.out.println("\n");
    }

    public static void showComparing(double[] mas1, double[] mas2, double eps) {
        for (int i = 0; i < mas1.length; i++) {
            System.out.printf("%-20s", (Math.abs(mas1[i] - mas2[i]) < eps) ? "equal" : "not equal");
        }
        System.out.println("\n");
    }

    public static void showComparing(String str, double[] mas1, double[] mas2, double eps) {
        System.out.printf("%-35s", str);
        for (int i = 0; i < mas1.length; i++) {
            System.out.printf("%-20s", (Math.abs(mas1[i] - mas2[i]) < eps) ? "equal" : "not equal");
        }
        System.out.println("\n");
    }
}

