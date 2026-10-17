public class VectorUtils {
    public static void showVector(double[] vector) {
        for (double i : vector) {
            System.out.printf("%-20.8e", i);
        }
        System.out.println("\n");
    }

    public static void showVector(String str, double[] vector) {
        System.out.printf("%-13s", str);
        for (double i : vector) {
            System.out.printf("%-20.8e", i);
        }
        System.out.println("\n");
    }

    public static void showDifference(String str, double[] vector1, double[] vector2) {
        System.out.printf("%-13s", str);
        for (int i = 0; i < vector1.length; i++) {
            System.out.printf("%-20.8e", vector1[i] - vector2[i]);
        }
        System.out.println("\n");
    }
}
