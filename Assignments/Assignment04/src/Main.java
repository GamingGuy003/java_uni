import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GuessName gn = new GuessName();
        gn.runMe("Testname");

        try {
            // Argument count check
            if (args.length != 2) {
                System.out.println("Did not provide two values");
                System.exit(-1);
            }
            // Integer check
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            Table mt = new Table();
            mt.printOUtTable(n, m);

        } catch (Exception e) {
            System.out.println("Provided arguments were not integers: " + e);
            System.exit(-1);
        }

        CalculatePrimes cp = new CalculatePrimes();
        cp.calculatePrimes();

        Gambling g = new Gambling();
        g.gamble();

        NameGenerator ng = new NameGenerator();
        System.out.println("Name generated: " + ng.generateName());
    }
}
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