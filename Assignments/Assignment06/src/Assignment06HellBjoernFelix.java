import java.util.Random;
import java.util.Scanner;

public class Assignment06HellBjoernFelix {

    static final float C_USD_TO_EU = 0.912942F;
    static final float C_GBP_TO_EU = 1.15363F;
    static final float C_JPY_TO_EU = 0.00614587F;
    static final float C_LIRE_TO_EU =  0.000516457F;
    static final float C_DKK_TO_EU = 0.134125F;

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Invalid arg count. Expected three (<Number>... <Origin Currency> <Target Currency>)");
            System.exit(1);
        }

        String target = args[args.length - 1].toUpperCase();
        String source = args[args.length - 2].toUpperCase();

        for (int i = 0; i < args.length - 2; i++) {
            try {
                float current = Float.parseFloat(args[i]);
                System.out.println(current + " " +  source + " = " + convert(source, target, current) + " " + target);
            } catch (Exception e) {
                System.out.println("Invalid input: " + args[i] + ". Could not convert to number.");
                System.exit(1);
            }
        }

        NumberGuesser ng = new NumberGuesser();
        ng.guessNumber(0, 10);
    }

    static float convert(String source, String target, float amount) {
        float toEU = conversionValue(source);
        float toTarget = conversionValue(target);
        return (amount * toEU) / toTarget;
    }

    static float conversionValue(String currency) {
        float value = 0;
        switch (currency.toUpperCase()) {
            case "USD" -> value = C_USD_TO_EU;
            case "GBP" -> value = C_GBP_TO_EU;
            case "JPY" -> value = C_JPY_TO_EU;
            case "LIRE" -> value = C_LIRE_TO_EU;
            case "DKK" -> value = C_DKK_TO_EU;
            case "EU" -> value = 1;
            default -> {
                System.out.println("Invalid currency " + currency + ". Valid ones are: EU, USD, GBP, JPY, LIRE and DKK");
                System.exit(1);
            }
        }
        return value;
    }
}

class NumberGuesser {

    static final int MAX_GUESSES = 10;

    public void guessNumber(int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number = new Random().nextInt(min, max + 1);

        for (int i = 0; i < MAX_GUESSES;) {
            try {
                System.out.print("Input your guess: ");
                int guess = Integer.parseInt(sc.nextLine());
                if (guess == number) {
                    System.out.println("You guessed right!");
                    System.exit(0);
                }
                System.out.println("Wrong guess, try again");
                i++;
            } catch (Exception e) {
                System.out.println("Input was not a number");
            }

        }
        System.out.println("You did not guess the number. It was " + number);
    }
}