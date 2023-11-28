import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Assignment07HellBjoernFelix {
    public static void main(String[] args) {
        new SentenceBuilder().buildSentence(args);
        new DoorGame().nDoors(5);
    }
}

class SentenceBuilder {
    public void buildSentence(String[] args) {
        if (args.length == 0) {
            return;
        }

        while (true) {
            String[] out = new String[args.length];
            Random generator = new Random();

            for (int i = 0; i < out.length;) {
                String word = args[generator.nextInt(args.length)];
                boolean outContains = false;
                for (String j: out) {
                    if (j != null && j.equals(word)) {
                        outContains = true;
                        break;
                    }
                }

                if (!outContains) {
                    out[i] = word;
                    i++;
                }
            }

            System.out.println(String.join(" ", out));
            if (Arrays.equals(out, args)) {
                break;
            }
        }

    }
}

class DoorGame {
    public void nDoors(int nDoors) {
        if (nDoors < 2) {
            System.out.println("Too few doors");
            System.exit(1);
        }
        int[] doors = new int[nDoors];
        int rightDoor = new Random().nextInt(1, nDoors + 1);
        int trials = 1;

        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                printDoors(doors);
                System.out.print("Input a door: ");
                int input = Integer.parseInt(sc.nextLine());
                if (input == rightDoor) {
                    doors[input - 1] = 2;
                    System.out.println("You got it right after " + trials + " trials!");
                    break;
                } else {
                    doors[input - 1] = 1;
                    System.out.println("This was not the right door. Try again!");
                }
            } catch (Exception e) {
                System.out.println("Not a valid input, try again.");
            }
            trials++;
        }

        printDoors(doors);

    }

    // 0 unopened, 1 wrong, 2 correct
    void printDoors(int[] doors) {
        System.out.println();
        for (int i = 0; i < doors.length; i++) {
            System.out.print(i + 1  + "\t");
        }
        System.out.println();
        for (int door: doors) {
            if (door == 0) {
                System.out.print("*\t");
            } else if (door == 1) {
                System.out.print("X\t");
            } else if (door == 2) {
                System.out.print("+\t");
            }
        }
        System.out.println();
    }
}