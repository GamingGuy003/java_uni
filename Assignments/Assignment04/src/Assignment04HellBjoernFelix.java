import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Assignment04HellBjoernFelix {
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
class CalculatePrimes {
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
                    break;
                }
            }
            if (prime) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

class Gambling {
    public void gamble() {
        List<Integer> numbersSelected = new ArrayList<Integer>();
        Random generator = new Random();

        for (int i = 0; i < 6;) {
            int random = generator.nextInt(90);

            // if number is already present, roll again
            if (numbersSelected.contains(random)) {
                continue;
            }
            System.out.print(random + "\t");
            numbersSelected.add(random);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.print("Exception while waiting: " + e);
            }
            i++;
        }
        System.out.println("---\t" + generator.nextInt(90));
    }
}

class GuessName {
    public static final int C_Max_Trials = 10;
    public void runMe(String name) {
        Scanner sc = new Scanner(System.in);
        int current = 0;
        while (current < C_Max_Trials) {
            System.out.print("Input a guess: ");
            String input = sc.nextLine();
            if (input.equals(name)) {
                System.out.println("You guessed right, good job!");
                break;
            }
            System.out.println("Wrong guess, try again!");
            current++;
        }
        if (current == C_Max_Trials) {
            System.out.println("Sorry, out of trials");
            System.exit(-1);
        }
    }
}

class NameGenerator {
    public String generateName() {
        int length = new Random().nextInt(2, 12);
        // counts consecutive consonants
        int consonantCount = 0;
        String name = "";

        // vowels
        List<Character> vowels = new ArrayList<>(List.of('a', 'e', 'i', 'o', 'u'));

        // alphabet is all letters + special letters
        List<Character> alphabet = new ArrayList<>(List.of('å', 'æ', 'ø'));
        for (char ch = 'a'; ch <= 'z'; ++ch) {
            alphabet.add(ch);
        }

        // consonants are alphabet - vowels
        List<Character> consonants = new ArrayList<>(alphabet);
        consonants.removeAll(vowels);

        for (int i = 0; i < length;) {
            Character letter = alphabet.get(new Random().nextInt(0, alphabet.size() - 1));
            // increment consecutive consonants or reset of letter was not a consonant
            if (consonants.contains(letter)) {
                consonantCount++;
            } else {
                consonantCount = 0;
            }

            // unless this is the 4th consonant in a row, add to name
            if (consonantCount <= 3) {
                name = name + letter;
                i++;
            }
        }
        return name;
    }
}

class Table {
    public void printOUtTable(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }
}