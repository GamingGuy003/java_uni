import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class AHellBjoernFelixBzGuessGame {


    public static void main(String[] args) {
        new GuessGame().run();
    }


}

// the class containing all the game code
class GuessGame {
    // the characters that can be used to generate the code
    char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
    int codeLength = 4;

    // the secret code
    String code = "";

    int maxTries = 20;

    String history = "";

    Scanner sc = new Scanner(System.in);

    // function to generate a code with a set length from the chars array; will not generate new code if old one is still
    // set; this lets us preset a code which will not be overwritten as long as we clear the old code after a game is over
    void generateCode() {
        if (!this.code.isEmpty()) {
            return;
        }

        Random r = new Random();

        // generates a random sequence
        for (int i = 0; i < this.codeLength; i++) {
            while (true) {
                char current = chars[r.nextInt(chars.length)];
                if (i != 0 || current != '!') {
                    this.code += current;
                    break;
                }
            }
        }
    }

    void run() {
        System.out.println("Welcome to the BzGuessGame!");
        while (true) {
            mainMenu();
        }

    }

    void mainMenu() {
        String[] entries = {
                "play",
                "config",
                "quit",
        };
        switch (getUserChoice(entries)) {
            case "play" -> {
                gameLoop();
            }
            case "config" -> {
                configure();
            }
            case "quit" -> {
                System.exit(0);
            }
        }
    }

    void configure() {
        System.out.println("Mostly experimental, be careful here");
        String[] entries = {
                "length",
                "valid chars",
                "preset",
                "max tries",
                "back"
        };

        switch (getUserChoice(entries)) {
            case "length" -> {
                while (true) {
                    System.out.print("Input the length of the generated code (current is " + this.codeLength + "): ");
                    this.codeLength = readNumber();
                    if (this.codeLength >= 1) {
                        break;
                    }
                    System.out.println("Input too small, must be >= 1;");
                }
            }
            case "valid chars" -> {
                while (true) {
                    System.out.print("Input characters that can be used for code generation as a single string with no spaces: ");
                    this.chars = sc.nextLine().trim().replace(" ", "").toCharArray();
                    if (this.chars.length > 0) {
                        break;
                    }
                    System.out.println("Cannot set chars to empty array, input at least one character;");
                }
            }
            case "preset" -> {
                while (true) {
                    System.out.print("Preset the code to a specific sequence (only for next game), leave empty to reset: ");
                    this.code = sc.nextLine();
                    if (!this.code.isEmpty()) {
                        this.codeLength = this.code.length();
                    }
                    // makes you try again if code starts with !
                    if (!this.code.startsWith("!")) {
                        break;
                    }
                    System.out.println("Cannot prefix code with ! due to conflict with in-game commands");
                }
            }
            case "max tries" -> {
                while (true) {
                    System.out.print("Change the maximum number of tries to (current is " + this.maxTries + "): ");
                    this.maxTries = readNumber();
                    if (this.maxTries >= 1) {
                        break;
                    }
                    System.out.println("Input too small, must be >= 1;");
                }
            }
            case "back" -> { return; }
        }
        System.out.println("Applied changes!");
    }

    void gameLoop() {
        int currentTry = 0;
        generateCode();
        this.history = "";

        System.out.println("Programmed by Hell Bjoern Felix");
        System.out.println("Available commands are: !new, !help, !buy, !h, !r, !p, !quit");

        while (true) {
            // if tries are used up, print this
            if (currentTry >= this.maxTries) {
                System.out.println("You did not guess the code in time!");
                System.out.println("Code was " + this.code);
                this.code = "";
                break;
            }

            System.out.print(this.maxTries - currentTry + ">");
            String input = sc.nextLine();
            // command handling
            if (input.startsWith("!")) {
                switch (input) {
                    case "!new" -> {
                        System.out.println("Starting new game...");
                        currentTry = 0;
                        this.code = "";
                        generateCode();
                        continue;
                    }
                    case "!help" -> {
                        System.out.println("Enter a guess or a command by prefixing it with '!'");
                        System.out.println("When guessing, an 'X' means one of the guessed characters is in the correct place");
                        System.out.println("A '-' means, it exists in the code, but not at the same position");
                        System.out.println("No feedback means the character does not exist in the code");
                        System.out.println("The order of X and - does not give any information to which of your characters they concern");
                        System.out.println("Commands are: ");
                        System.out.println("'!new': Start over a new game"); // done
                        System.out.println("'!help': Show this help prompt"); // done
                        System.out.println("'!buy': Reveals one character at a cost of 5 tries"); // done
                        System.out.println("'!h': Shows history of all guesses and evaluations");
                        System.out.println("'!r': (Debug) reveals secret code"); //done
                        System.out.println("'!p': (Debug) presets the secret code just like config > preset"); // done
                        System.out.println("'!quit': Reveal the solution and quit the game"); // done
                        continue;
                    }
                    case "!buy" -> {
                        int index = new Random().nextInt(this.codeLength);
                        String out = ".".repeat(index) + this.code.charAt(index) + ".".repeat(this.codeLength - index - 1);

                        this.history += (this.maxTries - currentTry) + ">!buy\n" + out + "\n";
                        System.out.println(out);
                        currentTry += 5;
                        continue;
                    }
                    case "!h" -> {
                        System.out.println(this.history);
                        continue;
                    }
                    case "!r" -> {
                        System.out.println(this.code);
                        continue;
                    }
                    case "!p" -> {
                        // runs until input is valid
                        while (true) {
                            System.out.print("Preset the code to a specific sequence (only for this game), do not leave empty: ");
                            this.code = sc.nextLine();
                            if (this.code.isEmpty()) {
                                System.out.println("Cannot leave code empty");
                                continue;
                            }
                            this.codeLength = this.code.length();
                            if (!this.code.startsWith("!")) {
                                break;
                            }
                            System.out.println("Cannot prefix code with ! due to conflict with in-game commands");
                        }
                        continue;
                    }
                    case "!quit" -> {
                        System.out.println("Code was " + this.code);
                        System.out.println("Quitting...");
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Invalid command, enter !help to list commands");
                        continue;
                    }
                }
            }
            // gameplay handling
            if (input.length() != codeLength) {
                System.out.println("Invalid input, enter " + codeLength + " characters");
                continue;
            }
            currentTry += 1;

            String judgement = compareInputCode(input);
            this.history += (this.maxTries - currentTry) + ">" + input + " " + judgement + "\n";
            System.out.println(judgement);

            // if the resulting judgement is as long as the code has to be and only consists of Xs we trigger the win condition
            if (judgement.length() == this.codeLength && judgement.replace("X", "").length() == 0) {
                System.out.println("You guessed the code in " + currentTry + " tries!");
                this.code = "";
                break;
            }
        }
        System.out.println("-".repeat(20));
    }

    // evaluates the users input and returns the string consisting of Xs and -'
    String compareInputCode(String input) {
        String correct = "";
        String misplaced = "";
        char[] in = input.toCharArray();
        // list of characters in code to ignore
        List<Integer> ignoreChecked = new ArrayList<>();

        for (int i = 0; i < this.codeLength; i++) {
            // if char exists at same index
            if (code.charAt(i) == in[i] && !ignoreChecked.contains(i)) {
                correct += "X";
                ignoreChecked.add(i);
            }
        }

        for (int i = 0; i < this.codeLength; i++) {
            int index = code.indexOf(in[i]);
            // does the current character exist in the input at all and should we ignore it
            if (index != -1 && !ignoreChecked.contains(index)) {
                misplaced += "-";
            }
        }
        return correct + misplaced;
    }

    // checks the users input for validity and returns chosen menu entry on success
    String getUserChoice(String[] entries) {
        printEntries(entries);
        return entries[readChoice(1, entries.length)];
    }

    // outputs the menu entries in a neat format
    void printEntries(String[] entries) {
        for (int i = 1; i <= entries.length; i++) {
            System.out.println(i + " " + entries[i - 1]);
        }
    }

    // reads the users input and returns
    int readChoice(int min, int max) {
        while (true) {
            System.out.print("(" + min + " - " + max + ")> ");
            int choice = readNumber();
            if (choice >= min && choice <= max) {
                return choice -1;
            }
            System.out.println("Input out of range");
        }
    }

    int readNumber() {
        while (true) {
            try {
                int input = Integer.parseInt(sc.nextLine());
                return input;
            } catch (Exception e) {
                System.out.println("Not a number, try againa");
            }
        }
    }

}
