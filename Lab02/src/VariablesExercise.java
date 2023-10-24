public class VariablesExercise {

	public static void main(String[] args) {



		/* PRIMITIVE DATA TYPES
		 - PRIMITIVE or ATOMIC DATA TYPES represent
		   the "smallest" unit for data in Java.
		 - There are data types for different purposes:
		 	- boolean values
		 	- integer values with 4 different word sizes (= bit sizes)
		 	- floating point values with 2 precision levels
		 - A composed data type is the text "string"s
		 - The "size" of Variables in java is determined by
		    how much space they need in memory.
		 - See also:
		   https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

		 - You need to "uncomment" code make it executable.
		   Mark that code, and hit CTRL+SHIFT+/  to remove single line comments (//)

		 -TIYS: Try It by YourSelf  = Hands on Exercises
		*/

		/* 1.) BOOLEAN: has two values: "true" or "false" */
		boolean earthIsASphere= true;
		System.out.println("It is "+earthIsASphere+ ", earth is a sphere. ");
		/* hint: type "sysout" and CTRL+space as a fast shortcut */

		/* boolean values can be inverted: */
		earthIsASphere = !earthIsASphere;
		System.out.println("No, this is absolutely "+ earthIsASphere);

		/* TIYS:
		 - store whether you like eating in McDonalds in a boolean variable.
		 - print a sentence with it on screen.
		 - change your mind
		 - print a sentence with it on screen.
		*/

		boolean mces = true;
		System.out.println("Someone said I liked eating at Mc Donalds, that was obviously " + mces);
		mces = !mces;
		System.out.println("Actually I think that was " + mces);


		/* 2.) BYTE: is one byte long. Ranges from -128 to 127 */
		byte t = 25;
		System.out.println("Current temperature: " + t + "°C");

		t++; 		// increase temperature by one
		t=(byte)(t+5); // increase temperature by five. Note the "cast" to byte
		t+=5; 		// same, for lazy programmers
		System.out.println("It gets hotter: " + t + "°C");

//		/* A fire breaks out */
//		t+=100;
//		System.out.println("Actually, it is pretty cold now: " + t + "°C. Why?");
//
//
//		/* TIYS
//		A v4 IP-Address is defined by 4 bytes.
//		Declare 4 variables a1 to a4 of type byte and attribute the values of your IP-Address
//		--> https://whatismyipaddress.com/
//		Print your address in the format "a1.a2.a3.a4"
//		 */
//
//
//		/* 3.) INTEGER: is 32bit = 4 bytes wide.
//		Ranges from -2^31 to 2^31-1  (-2147483648 to 2147483647)
//		Mostly used data type for integer numbers
//		Calculations with types of byte, char, short and int are _all_ performed in integer!
//		 */
//		int i= 0;
//		i= i + 5; // no "cast" required
//		i++;      // +1
//		++i;      // +1
//		int remainder = i % 2;    //  "modulo" operator calculates integer remainder
//		System.out.println(i+"/2 = " +i/2+ "  r="+ remainder);
//
//
//		/* 4.) CHAR: is 16bit = 2 bytes wide. The only "unsigned" data typ
//		Ranges from 0 to 2^16-1  (0 to 65535)
//		Mostly used for single characters of the (international) alphabet
//		 */
//		char c='A', ae='ä', euro='€';
//		System.out.println("0- Character: "+c);
//		System.out.println("1- Character next of "+c+" is not "+ c+1 );
//		System.out.println("2- Character next of "+c+" is not "+ (c+1) );
//		System.out.println("3- Character next of "+c+" is "+ (char)(c+1) );
//
//		/* TIYS
//		 * Find the ASCII value of the character 'X' and store it in an
//		 * variable named "asciiValue."
//		 * Print this character on screen.
//		 * print the previous and next character stored in "asciiValue".
//		 */
//
//
//		/* 5.) LONG: is 64bit = 8 bytes wide.
//		Ranges from -2^63 to 2^63-1 (-9223372036854775808 to 9223372036854775807)
//		Needs an "L" as postfix
//		Calculations with types of long are performed in long!
//		*/
//		long prettyBig= 10000000000L;
//		prettyBig= prettyBig * 2L;
//		prettyBig= prettyBig * 2;    // any difference
//
//		/* TIYS
//	    Initialize a long variable "population" with a large number, with the world's
//	    population in billions.
//	    Print it on screen.
//		*/
//
//		/* 6.) FLOAT and DOUBLE
//		 * Are "floating point" numbers
//		 * Internal format: a*x^b
//		 * Has 4 (float) or 8 (double) bytes
//		 * float needs "f" as postfix, double may need "d" as postfix.
//		 *
//		 */
//		double n1= 2.5, n2=3.0, n3= 5.0;
//		double average= (n1+n2+n3)/3;
//		System.out.println("average is: "+average);
//		System.out.println("average is bigger than 1: "+ (average > 1) ); // boolean expression
//
//		/* TIYS
//		 * - Store the number pi in a variable named "pi"
//		 * - calculate the surface of a typical pizza in square-centimeters and store this in "pizzasize"
//		 * - print result.
//		 */
//
//
//
//		/* 7.) STRING.
//		Contains text.
//		"String" is not a primitive (atomic) datatype:
//		Every String is composed by zero to many "char"acters.
//		*/
//
//		String w1= "dogs";
//		String w2= "cats";
//		String sentence= w1 + " and " + w2;   // note the "+"operator concatenates two Strings.
//		String longSentence= "many "+sentence+ ", and even more "+ sentence;
//		System.out.println(longSentence);
//
//
//		/*
//		 * TIYS: Swapping the contents of two glasses of wine. How to do it?
//		 */
//		/* Algorithmic thinking 1: */
//
//        /* Declare two wine glasses and their content */
//        String caliceUno = "Chianti";
//        String caliceDue = "Bardolino";
//
//        System.out.println("Before swapping:");
//        System.out.println("Bicchiere di Vino 1 contains: " + caliceUno);
//        System.out.println("Bicchiere di Vino 2 contains: " + caliceDue);
//
//        /* Swap the content of the Italian wine glasses */
//        /* ...insert your code here */
//
//        System.out.println("After swapping:");
//        System.out.println("Bicchiere di Vino 1 contains: " + caliceUno);
//        System.out.println("Bicchiere di Vino 2 contains: " + caliceDue);
//
//
//
//        /* TIYS: ################################################### */
//        /*    Algorithmic thinking  - The big exercise               */
//        /*########################################################## */
//        /* Create an algorithm for decimal --> binary conversion. */
//        /*
//        Step 1:
//        Reiterate the algorithm with "pen and paper", e.g.
//        Convert decimal number n=22 to base 2 step by step:
//			22/2= 11 r 0
//			11/2= 5 r 1
//			5/2= 2 r 1
//			2/2= 1 r 0
//			1/2= 0 r 1
//
//        Step 2:
//        Write pseudocode in your own words.
//        You may need some variables to store
//        There will be a "loop", with a decision after whether to repeat that loop or not.
//
//        Step 3:
//        Write java code for it!
//        In java, a loop with post-decisions:
//	        do {
//	          do something;
//	        while (condition is met)
//        Example:
//	        int n=0;
//	        do {
//	        	System.out.println(n++);
//	        } while (n < 100);   // repeat loop as long as condition is met.
//		*/
	}

}
