public class Main {
    public static void main(String[] args) {
        String name = "Andrea";
        System.out.println("My name is " + name);
        // int a = Integer.parseInt(name); // This fails due to a NumberFormatException, since "Andrea" cannot be converted to a number. This is, because the function can only convert numbers written as Strings back to an Integer, not letters.
        // System.out.println("My variable a has value " + a);

        String ageString = "23";
        System.out.println("My age is " + ageString);
        int myAge = Integer.parseInt(ageString);
        int yourAge = 27;
        int totalAge = myAge + yourAge;
        System.out.println("Our combined ages amount to " + totalAge + " years");

        System.out.println("I am " + myAge + " years old while you are " + yourAge);
        System.out.println("I am " + ageString + " years old while you are " + yourAge);

        numbers.multip(3, 5);
        numbers.primes(-32);
    }
}