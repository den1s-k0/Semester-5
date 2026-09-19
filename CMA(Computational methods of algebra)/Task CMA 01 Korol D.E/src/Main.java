public class Main {
    public static void main(String[] args) {
        HilbertMatrix A = new HilbertMatrix(3);
        A.showMatrix();
        A.lowZeros();
        A.showMatrix();
        A.upZeros();
        A.showMatrix();
        A.showResult(A.xResults());
    }
}