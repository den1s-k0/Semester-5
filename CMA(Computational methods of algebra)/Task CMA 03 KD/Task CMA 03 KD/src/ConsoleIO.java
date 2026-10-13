import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleIO {
    public static int enterNum() {
        Scanner in = new Scanner(System.in);
        int n;
        while (true) {
            System.out.print("Enter Number: ");
            try {
                n = in.nextInt();
                if (n > 0) {
                    break;
                }
                System.out.println("Number must be > 0");
            } catch (InputMismatchException e) {
                System.out.println("It must be a number");
                in.nextLine();
            }
        }
        return n;
    }
}
