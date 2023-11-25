import java.util.Scanner;

public class CalculatePrimes {
    public void calculatePrimes() {
        Scanner sc = new Scanner(System.in);
        int start = 0;
        while (true) {
            try {
                System.out.print("Input number: ");
                start = Integer.parseInt(sc.nextLine());
                // make positive
                if (start < 0) {
                    start = start * -1;
                }
                break;
            } catch (Exception e) {
                System.out.println("Input not a number, try again");
            }
        }
        // until reaches the limit input
        for (int i = 2; i <= start; i++) {
            boolean prime = true;
            // until reaching the current element
            for (int j = 2; j < i; j++) {
                // if current limit can be divided by current element, it is not a prime
                if (i % j == 0) {
                    prime = false;
                }
            }
            if (prime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
