import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        MultiplicationTable mt = new MultiplicationTable();
        mt.run();
    }
}

class MultiplicationTable {
    int[][] table;
    int n, m;
    MultiplicationTable() {
        n = inputNumber("Input n: ");
        m = inputNumber("Input m: ");
        this.table = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                this.table[i][j] = (j + 1) * (i + 1);
            }
        }
    }

    void printTable() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void run() {
        while (true) {
            printTable();
            int x = inputNumber("row " + "[1.." + table.length + "] (exit to quit): ") - 1;
            int y = inputNumber("column" + "[1.." + table[0].length + "]  (exit to quit): ") - 1;
            try {
                table[x][y] = inputNumber("Value at (" + (x + 1) + "," + (y + 1) + ") is " + table[x][y] + ". Replace with (exit to quit): ");
            } catch (Exception e) {
                System.out.println("Input out of bounds, try again");
            }
        }
    }

    int inputNumber(String message) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            try {
                return exit(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Not a number, try again");
            }
        }
    }

    int exit(String input) throws Exception {
        if (input.equals("exit")) {
            System.out.println("Exiting...");
            System.exit(0);
        }

        return Integer.parseInt(input);
    }

}