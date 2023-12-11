import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        MultiplicationTable mt = new MultiplicationTable(inputNumber("Input n: "), inputNumber("Input m: "));

        int[][] multTable = new int[n][m];


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(multTable[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int inputNumber(String message) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.print("Not a number, try again");
            }
        }
    }
}

class MultiplicationTable {
    int[][] table;
    MultiplicationTable(int n, int m) {
        this.table = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                this.table[i][j] = (j + 1) * (i + 1);
            }
        }
    }
}