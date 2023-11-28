import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assignment05HellBjoernFelix {
    public static void main(String[] args) {
        InfiniteName in = new InfiniteName();
        // in.infiniteFor("Hell Björn Felix");
        // in.infiniteWhile("Hell Björn Felix");

        Scanner sc = new Scanner(System.in);
        System.out.print("Day: ");
        new WeekJokes().tellJoke(sc.nextLine());

        System.out.print("Date: (dd.mm.yyyy) ");
        new DateJoke().dateJoke(sc.nextLine());
        String[] strings = {};
        new OnlineOrder().mainMenu(sc);
    }
}

class InfiniteName {
    public void infiniteFor(String name) {
        for (;;) {
            System.out.println(name);
        }
    }

    public void infiniteWhile(String name) {
        while (true) {
            System.out.println(name);
        }
    }
}

class WeekJokes {
    public void tellJoke(String day) {

        switch (day.toLowerCase()) {
            case "monday" -> {
                System.out.println("The joke of the day for Monday is: ");
                System.out.println(randomJoke(0));
            }
            case "tuesday" -> {
                System.out.println("The joke of the day for Tuesday is: ");
                System.out.println(randomJoke(1));
            }
            case "wednesday" -> {
                System.out.println("The joke of the day for Wednesday is: ");
                System.out.println(randomJoke(2));
            }
            case "thursday" -> {
                System.out.println("The joke of the day for Thursday is: ");
                System.out.println(randomJoke(3));
            }
            case "friday" -> {
                System.out.println("The joke of the day for Friday is: ");
                System.out.println(randomJoke(4));
            }
            case "saturday" -> {
                System.out.println("The joke of the day for Saturday is: ");
                System.out.println(randomJoke(5));
            }
            case "sunday" -> {
                System.out.println("The joke of the day for Sunday is: ");
                System.out.println(randomJoke(6));
            }
            default -> System.out.println("Not a valid weekday");
        }


    }

    public String randomJoke(int weekday) {
        String[][] jokes = {
                {
                        "Why did the programmer go broke ?\nBecause he used up all his cache!",
                        "What's a skeleton's least favorite room?\nThe living room.",
                        "Why did the scarecrow become a successful motivational speaker?\nBecause he was outstanding in his field!"
                },
                {
                        "Why was the math book sad?\nBecause it had too many problems.",
                        "What did one plate say to another?\nLunch is on me!",
                        "Why did the bicycle fall over?\nIt was two-tired."
                },
                {
                        "Why don't scientists trust atoms?\nBecause they make up everything.",
                        "What do you call a fake noodle?\nAn impasta.",
                        "Why did the paper clip go to therapy?\nIt had too many attachment issues."
                },
                {
                        "Why did the coffee file a police report?\nIt got mugged.",
                        "What's a vampire's favorite fruit?\nA blood orange.",
                        "Why don't skeletons fight each other?\nThey don't have the guts."
                },
                {
                        "What did the janitor say when he jumped out of the closet?\nSupplies!",
                        "Why did the computer take up gardening?\nIt wanted to improve its root system.",
                        "Why did the tomato turn red?\nBecause it saw the salad dressing!"
                },
                {
                        "What's a dog's favorite kind of pizza?\nPupperoni.",
                        "Why did the belt go to jail?\nIt was holding up a pair of pants!",
                        "How do you organize a space party?\nYou planet."
                },
                {
                        "What did one ocean say to the other?\nNothing, they just waved.",
                        "Why don't eggs tell each other secrets?\nBecause they might crack up.",
                        "What did the sun say to the coffee?\nYou really help me percolate!"
                }
        };

        return jokes[weekday][new Random().nextInt(3)];
    }
}

class DateJoke {
    public void dateJoke(String date) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new SimpleDateFormat("dd.MM.yyyyy").parse(date));
            new WeekJokes().tellJoke(intToWeekday(calendar.get(Calendar.DAY_OF_WEEK)));
        } catch (Exception e) {
            System.out.println("Invalid date input, could not parse: " + e);
        }

    }

    String intToWeekday(int number) {
        return switch (number) {
            case Calendar.SUNDAY -> "Sunday";
            case Calendar.MONDAY -> "Monday";
            case Calendar.TUESDAY -> "Tuesday";
            case Calendar.WEDNESDAY -> "Wednesday";
            case Calendar.THURSDAY -> "Thursday";
            case Calendar.FRIDAY -> "Friday";
            case Calendar.SATURDAY -> "Saturday";
            default -> "Invalid day";
        };
    }
}

class OnlineOrder {
    public void mainMenu(Scanner sc) {
        String[] carry = {};
        String[] mainMenu = {
                "Appetizer",
                "Pizza",
                "Pasta",
                "Meat",
                "Dessert",
                "Purchase",
                "Abort",
        };
        while (true) {
            String input = getUserChoice(sc, mainMenu);
            switch (input) {
                case "Appetizer" -> carry = appetizerMenu(sc, carry);
                case "Pizza" -> carry = pizzaMenu(sc, carry);
                case "Pasta" -> carry = pastaMenu(sc, carry);
                case "Meat" -> carry = meatMenu(sc, carry);
                case "Dessert" -> carry = dessertMenu(sc, carry);
                case "Purchase" -> purchaseMenu(sc, carry);
                case "Abort" -> System.exit(0);
            }
        }

    }

    String[] appetizerMenu(Scanner sc, String[] carry) {
        String[] appetizerMenu = {
                "Bruschetta 4.50 EU",
                "Stuffed Mushrooms 5.50 EU",
                "Calamari 6.50 EU",
                "Caprese Salad 7 EU",
                "Back"
        };
        String input = getUserChoice(sc, appetizerMenu);
        if (input.equals("Back")) {
            return carry;
        }
        String[] tmp = new String[carry.length + 1];
        System.arraycopy(carry, 0, tmp, 0, carry.length);
        tmp[carry.length] = input;
        return tmp;
    }

    String[] pizzaMenu(Scanner sc, String[] carry) {
        String[] pizzaMenu = {
                "Margherita 6.50 EU",
                "Quattro Stagioni 8 EU",
                "Capricciosa 7 EU",
                "Calzone 9 EU",
                "Marinara 6 EU",
                "Back"
        };
        String input = getUserChoice(sc, pizzaMenu);
        if (input.equals("Back")) {
            return carry;
        }
        String[] tmp = new String[carry.length + 1];
        System.arraycopy(carry, 0, tmp, 0, carry.length);
        tmp[carry.length] = input;
        return tmp;
    }

    String[] pastaMenu(Scanner sc, String[] carry) {
        String[] pastaMenu = {
                "Spaghetti alla Carbonara 10 EU",
                "Risotto ai Funghi 11 EU",
                "Tortellini al Burro 9 EU",
                "Risotto al nero di Seppia 12 EU",
                "Back"
        };
        String input = getUserChoice(sc, pastaMenu);
        if (input.equals("Back")) {
            return carry;
        }
        String[] tmp = new String[carry.length + 1];
        System.arraycopy(carry, 0, tmp, 0, carry.length);
        tmp[carry.length] = input;
        return tmp;
    }

    String[] meatMenu(Scanner sc, String[] carry) {
        String[] meatMenu = {
                "Filet Mignon 18 EU",
                "Grilled Chicken 14 EU",
                "Lamb Chops 16 EU",
                "Pork Tenderloin 15.50 EU",
                "Back"
        };
        String input = getUserChoice(sc, meatMenu);
        if (input.equals("Back")) {
            return carry;
        }
        String[] tmp = new String[carry.length + 1];
        System.arraycopy(carry, 0, tmp, 0, carry.length);
        tmp[carry.length] = input;
        return tmp;
    }

    String[] dessertMenu(Scanner sc, String[] carry) {
        String[] dessertMenu = {
                "Tiramisu 6.50 EU",
                "Chocolate Lava Cake 5.50 EU",
                "Cheesecake 7.50 EU",
                "Fruit Sorbet 4.50 EU",
                "Back"
        };
        String input = getUserChoice(sc, dessertMenu);
        if (input.equals("Back")) {
            return carry;
        }
        String[] tmp = new String[carry.length + 1];
        System.arraycopy(carry, 0, tmp, 0, carry.length);
        tmp[carry.length] = input;
        return tmp;
    }

    void purchaseMenu(Scanner sc, String[] carry) {
        String[] purchaseMenu = {
                "Purchase",
                "Decline Purchase",
                "Back"
        };
        System.out.println("Your order consists of the following items: ");
        for (String item: carry) {
            System.out.println(item);
        }
        System.out.println("Your total is: " + getTotal(carry) + " EU");
        String input = getUserChoice(sc, purchaseMenu);

        switch (input) {
            case "Decline Purchase" -> {
                System.out.println("Purchase declined!");
                System.exit(0);
            }
            case "Back" -> {
                System.out.println("Thank you for your purchase!");
                System.exit(0);
            }
        }
    }

    // reads the user input until it is within defined range, then returns input - 1 for use with arrays
    int readChoice(Scanner sc, int min, int max) {
        while (true) {
            System.out.print("(" + min + " - " + max + ")> ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice >= min && choice <= max) {
                    System.out.println();
                    return choice -1;
                }
                System.out.println("Input out of range");
            } catch (Exception e) {
                System.out.println("Not a number");
            }
        }
    }

    // prints the users choices with a number
    void printChoices(String[] choices) {
        for (int i = 1; i <= choices.length; i++) {
            System.out.println(i + " " + choices[i - 1]);
        }
    }

    // reads user input and returns the element selected
    String getUserChoice(Scanner sc, String[] content) {
        printChoices(content);
        return content[readChoice(sc, 1, content.length)];
    }

    // calculates total price from string array
    double getTotal(String[] carry) {
        Pattern pattern = Pattern.compile("\\d+(\\.\\d{1,2})?");
        double total = 0.0;
        for (String item: carry) {
            Matcher matcher = pattern.matcher(item);
            if (matcher.find()) {
                total += Double.parseDouble(matcher.group());
            }
        }
        return total;
    }

}