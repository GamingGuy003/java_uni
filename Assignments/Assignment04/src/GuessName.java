import java.util.Scanner;

public class GuessName {
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
