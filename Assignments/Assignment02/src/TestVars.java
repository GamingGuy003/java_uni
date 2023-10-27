import java.util.Scanner;

public class TestVars {
    public void runMe() {
        int x = 0;
        int y = 6;
        int z = 10;
        System.out.println("z = " + z);

        z++; // z should be 11
        System.out.println("z = " + z);
        z = 10;

        ++z; // z should be 11 again
        System.out.println("z = " + z);

        x = ++y; // x and y should be 7
        System.out.println("x = " + x);

        x = 0;
        y = 6;

        z = 6;
        System.out.println("z = " + ++z); // if the blank space gets removed, java throws an error as the three plus signs confuse it
        z = 6;
        System.out.println("z = " + z ++); // the difference between this and the statement above is that here, z would be incremented after being added to the string, since the language gets interpreted left to right

        // this does not work with the values set in the exercise as it results in a division by 0
        /*
        x = 0;
        z = 6;
        System.out.println(y + " / " + x + " = " + y / x);
         */

        x = 14;
        y = 4;
        System.out.println(x + " / " + y + " = " + x / y + " " + x % y + "R");

        float float_x = 14.0f;
        float float_y = 4.0f;
        System.out.println(float_x + " / " + float_y + " = " + float_x / float_y + " " + float_x % float_y + "R");

        String myStrangeString = + 1 + - - + - - + + + + + - 1 + " "; // i think this works because since it is just a bunch of math which is then being concatenated into a string; I think it results in the string "0 "
        System.out.println(myStrangeString);

        String s1 = "Andrea"; // we are declaring a string with the value "Andrea"
        int i1 = 2, i2 = 1; // we are declaring two integers with the values 2 and 1

        System.out.println("Result: " + s1 + (i1 + i2) ); // we are concatenating the string andrea to the end of Result: and then the result of i1 + i2 resulting in Andrea 3
        System.out.println("Result: " + s1 + i1 + i2); // we are concatenating the string andrea to the end of Result: and then the two appending the two numbers 2 and 1 resulting in Andrea 21
        System.out.println(i1 + - + i2 + " is the result!"); // we are adding -(i2) to i1 resulting in 1
        //System.out.println(i1 + - + " is the result!"); // this statement does not work as we are trying to subtract from a string

        int strangeResult = 07 + 010; // this results in octal integers, so we are adding 7 to 8 which results in 15
        System.out.println("strangeResult has value " + strangeResult);
        int strangeSum = 0x7A + 0x10; // we are making the sum between two hex values (120 + 18 = 138)
        System.out.println("strangeSum has value " + strangeSum);

        // int giveMeTroubles = 09; // since 9 does not fit into octal numbers, this will not work
        // System.out.println("giveMeTroubles has value " + giveMeTroubles);
        // int giveMeOtherTroubles = 0x9FL; // this would define 0x9F as long but it will not work since we are trying to assign it to an int
        // System.out.println("giveMeOtherTroubles has value " + giveMeOtherTroubles);

        Scanner sc = new Scanner(System.in); // we are creating a new scanner and giving it the system.in stream to read from
        System.out.print("Enter your age: "); // we are outputting a prompt
        int age = sc.nextInt(); // we are reading the users input as an integer
        System.out.println("So, you are " + age + " years old"); //printing out the age

//        System.out.print("Enter your age: ");
//        int age_new = sc.nextInt();
//        System.out.print("Enter your height (cm): ");
//        int height = sc.nextInt();
//        System.out.print("Enter your weight (kg): ");
//        int weight = sc.nextInt();
//        System.out.print("Enter your first initial: ");
//        char init1 = sc.next().charAt(0);
//        System.out.print("Enter your second initial: ");
//        char init2 = sc.next().charAt(0);
//        System.out.print("Enter your address: ");
//        String address = sc.next();
//        // String address = sc.nextLine(); // This line for some reason does not seem to wait for the users input?
//        System.out.println("age = " + age_new + ", height = " + height + ", weight = " + weight + ", initials = " + init1 + ", " + init2 + ", address = " + address);

        // 6a)
        // a 5
        // b 10
        // c 60
        int a = 5;
        int b = 10;
        int c = ++a * b--;
        System.out.println("a " + a);
        System.out.println("b " + b);
        System.out.println("c " + c);

        // 6b)
        // 1 + 2 = 12
        // 1 + 2 = 3
        System.out.println("1 + 2 = " + 1 + 2);
        System.out.println("1 + 2 = " + (1 + 2));

        // 6c)
        // 3 = 1 + 2
        // 1 + 2 =  12
        System.out.println(1 + 2 + " = 1 + 2");
        System.out.println("1 + 2 = " + 1 + 2);


    }


}
