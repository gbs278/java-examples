// notice that this package is the same as that of SecondClassClass, but different from that of ThirdClassClass
package edu.nyu.cs.fb1258.method_examples;

import java.util.Random;

/**
 * Exploring the various settings that can be applied to methods to control its visibility, belongingness, return type, and parameters.
 * @author Foo Barstein
 * @version 1
 */

public class FirstClassClass {

	/**
	 * Returns a String based on a char array
	 * @param charArray the char array
	 * @return the String we created from the char array
	 */
	public static String getStringFromCharArray(char[] charArray) {
		// instantiate a new string from the char array
		String myString = new String(charArray);
		return myString;		
	}
	
	/**
	 * Returns a pseudo-random int between 1 and 10, inclusive.
	 * @return the random int, of course
	 */
	public static int getARandomNumber() {
		// construct a pseudo-random number generating object
		Random randomGenerator = new Random();
		
		// set a hard-coded seed .. doing so would always produce the same sequence of pseudo-random numbers, which may or may not be desireable
		//randomGenerator.setSeed(10);
		
		//generate a random number between 1 and 10, inclusive
		int rand = randomGenerator.nextInt(10); // get a random number between 0 and 9
		rand += 1; // shift the range to be between 1 and 10

		// return this value
		return rand;
	}
	
	
	/**
	 * The main method always looks like this and is the only method that is automatically called by the JVM (JRE).
	 * @param args any command line arguments, stored as a String array
	 */
	public static void main(String[] args) {
		
		// loop through the list of arguments that were supplied to this method from the command-line
		System.out.println("Here is a list of the arguments supplied to the main function:");
		for (int i=0; i < args.length; i++) {
		    // output each element of the array, one at a time
		    System.out.println(args[i]);
		}
		if (args.length == 0) {
			// output a nice message if there were no command line arguments
			System.out.println("** Sorry, no command line arguments were supplied.");
		}
		
		// call our custom method/function
		int rand1 = getARandomNumber(); // call the method and receive its return value into a variable, so we can use it later
		System.out.println("\nThe random number generated by the random number generator is " + rand1 + ".");
		
		// call our custom method/function but in a slightly more explicit syntax, since it's static the method belongs to the class and can be written prefixed with the class name
		int rand2 = FirstClassClass.getARandomNumber();
		System.out.println("\nThe random number generated by the random number generator is " + rand2 + ".");

		// call our custom method/function that creates a string from a char array
		char[] myChars = {'b', 'a', 'n', 'a', 'n', 'a'};
		String myString = getStringFromCharArray(myChars); // send the char array as an argument to the method
		System.out.println("\nThe string returned by the getStringFromCharArray method is " + myString + ".");
		
		// call a method in a different class
		int larger = SecondClassClass.whichIsLarger(5, 10); // notice the class name prefixes the method name, since it's a static method
		System.out.println("\nThe larger value of 5 and 10 is " + larger + ".");
		
		// pretend like we're trying to call a non-static method as if it belongs to the class, which it doesn't
		//SecondClassClass.doNothing(); // can't do this, since doNothing is not a static method, and does not belong to the SecondClassClass class.
		
		// pretend like we're trying to call a private method in another class, which doesn't work
		//SecondClassClass.printSomethingUseless();
		
		// call a protected method in the other class that is in the same package
		SecondClassClass.printAQuote();

		// call a protected method in the other class that is in a different package... you can't do this!
		//ThirdClassClass.printSomethingUseless();
	}

}
