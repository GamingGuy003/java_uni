public class TestVars {

    /*
    public void runMe() {
        System.out.println("Hi Felix!");

        int charToInt = (char)'A'; // 4a) The character gets converted to unicode, with a capital A resolving to the number 65
        short intToShort = (int) 32767; // 4b) This cast will work as long as the int does not exceed -23768 or 32767 as those are the maximum values a short can store
        int shortToInt = (short) Short.MAX_VALUE; // 4c) This cast will work even with the maximum value short can hold. The number simply gets extended into an Integer.
        // int intTooLong = 200000000000000000000;  // 4d) This will not work as the number exceeds the maximum value an Integer can hold (2147483647)
        double doubleTooLong = 200000000000000000000d; // 4e) This assignment works but accessing the double might yield an imprecise number when doing calculations
    }
    */

    // 5
    public void runMe() {
        System.out.println("Hi, this is my entry point in runMe()");
        short a = 5,
                b = 12,
                c;
        // c = a + b; // 5a) This statement yields to an incompatible type error, as the conversion between the two Integers to the short might be lossy, due to implicit conversion due to the Integer being the default return type for arithmetic operations
        System.out.println("Result 0: " + (a+b) ); // 5b) This does not throw up any issues as the operations yields an Integer which can simply be appended to the String
        System.out.println("Result 1: " + 100000*(2000000000/500000));
        System.out.println("Result 2: " + (100000*2000000000)/500000);
        /*
        5c) Result 1 and 2 are different due to the differing use of brackets; Result 1 yields 100000 * 4000 = 400000000,
            whereas Result 2 yields 200000000000000 * 500000, which exceeds the Integer maximum size, therefor only returning 1105

        5d) Result 1 would be correct, as it does not defy any of Java's constraints
         */

        System.out.println("Result 3: " + (2-2.0) / (5-5.00)); // 5e) This returns NaN (Not a Number), as we are trying to divide by (int) zero
        System.out.println("Result 4: " + (2-1.0) / (0.00)); // 5f) This returns Infinity, as we are trying to divide by (double) zero, which is imprecise, therefor not being exactly 0, but a very small number instead which when used to divide 1 results in a number too large to handle for Java
        // System.out.println("Result 5: " + c); // 5g) This results in a compilation error as c has not been initialized
    }
}
