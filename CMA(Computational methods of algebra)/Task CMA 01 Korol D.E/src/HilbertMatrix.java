import java.util.Scanner;

public class HilbertMatrix {
    private int sizeVert;
    private int sizeGor;
    private double[][] matrix;

    public HilbertMatrix(int n) {
        sizeVert = n;
        sizeGor = sizeVert + 1;
        matrix = new double[sizeVert][sizeGor];

        for (int i = 0; i < sizeVert; i++) {
            for (int j = 0; j < sizeGor - 1; j++) {
                matrix[i][j] = 1.0 / (i + j + 1);
            }
        }
        matrix[0][sizeGor - 1] = 1;
    }

    public void showMatrix() {
//        System.out.println("SIZE: " + Integer.toString(sizeVert));
        for (double[] i : matrix) {
            for (double j : i ) {
                System.out.printf("%-12.4f", j);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void lowZeros() {
        for (int i = 0; i < sizeVert; i++) {
            double a = matrix[i][i];
            for (int j = i; j < sizeGor; j++) {
                matrix[i][j] /= a;
            }
            for (int k = i + 1; k < sizeVert; k++) {
                double b = matrix[k][i];
                for (int t = i; t < sizeGor; t++) {
                    matrix[k][t] -= (matrix[i][t] * b);
                }
            }
        }
    }

    public void upZeros() {
        for (int i = sizeVert - 1; i >= 0; i--) {
            for (int k = i - 1; k >= 0; k--) {
                matrix[k][sizeGor - 1] -= (matrix[i][sizeGor - 1] * matrix[k][i]);
                matrix[k][i] -= (matrix[i][i] * matrix[k][i]);
            }
        }
    }

    public double[] xResults() {
        double[] result = new double[sizeVert];
        for (int i = 0; i < sizeVert; i++) {
            result[i] = matrix[i][sizeGor - 1];
        }
        return result;
    }

    public static void showResult(double[] result) {
        System.out.println("Result: ");
        for (double i : result) {
            System.out.printf("%-12.4f", i);
        }
        System.out.print("\n");
    }

    public static double[] enterTask(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter matrix size: ");
        int size = in.nextInt();
        System.out.print("Enter " + Integer.toString(size) + " answers: ");
        double[] answer = new double[size];
        for(int i = 0; i < size; i++) {
            answer[i] = in.nextDouble();
        }
        return answer;
    }

        public static void completeTask() {
            final double EPS = 1e-9;
            double[] answer = HilbertMatrix.enterTask();
            HilbertMatrix A = new HilbertMatrix(answer.length);

            System.out.println("Hilbert matrix: ");
            A.showMatrix();
            A.lowZeros();
    //        A.showMatrix();
            A.upZeros();
    //        A.showMatrix();

            System.out.print("Task ");
            HilbertMatrix.showResult(answer);

            System.out.print("My ");
            double[] result = A.xResults();
            HilbertMatrix.showResult(result);

            System.out.println("Compare: ");
            for (int i = 0; i < answer.length; i++) {
                System.out.printf("%-12s", (Math.abs(answer[i] - result[i]) < EPS) ? "equal" : "not equal");
            }

    }
}
