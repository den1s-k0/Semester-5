public class VectorUtils {
    public static void showVector(double[] vector) {
        for (double i : vector) {
            System.out.printf("%-20.8e", i);
        }
        System.out.println("\n");
    }

    public static void showVector(String str, double[] vector) {
        System.out.printf("%-5s", str);
        for (double i : vector) {
            System.out.printf("%-20.8e", i);
        }
        System.out.println("\n");
    }
}
