import java.util.*;

public class Main {
    public static void main(String[] args) {
        int decimal = 3478;
        Vector<Integer> out = new Vector<>();
        for (int i = 0; true; i++) {
            int rest = decimal % 2;
            decimal = decimal / 2;

            if (decimal + rest == 0) {
                Collections.reverse(out);
                for (Integer integer : out) {
                    System.out.print(integer);
                }
                break;
            }

            out.add(rest);
        }

    }
}