public class numbers {
    public static void multip(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    public static void primes(int n) {
        if (n < 0) {
            n = n * -1;
        }
        for (int i = 2; i <= n; i++) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                }
            }
            if (prime) {
                System.out.print(i + " ");
            }
        }
    }
}
