/*
 * Zachary Martin (zrmartin@calpoly.edu)
 * 10/8/2015
 * Project 1
 */

import java.util.Scanner;

/*
 * ConTest is a driver class to test the performance of my Converter class.
 * This class consists of a single main class that prints a menu, showing all 
 * of the operations available to use on a converter.
 */

public class ConTest 
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner(System.in);
		String greeting = "Choose one of the following operations\n" 
						+ "-Infix to postix conversion (enter the letter i)\n"
						+ "-Postfix expression evaluation (enter the letter p)\n"
						+ "-Arithmatic expression evaluation (enter the letter a)\n"
						+ "-Quit the program (enter the letter q)\n";
		System.out.println(greeting);
		
		/*
		 * Used to break out of the while loop and terminate the program
		 * when the user enters "q"
		 */
		mainloop:
		while(in.hasNext())
		{
			String choice = in.next();
			switch(choice)
			{
				case "i":
				{
					in.nextLine();
					System.out.println("Enter an expression to convert");
					String expression = in.nextLine();
					String result = Converter.infixToPostfix(expression);
					System.out.println("The postfix expression is " + result);
					break;
				}
				case "p":
				{
					in.nextLine();
					System.out.println("Enter a postfix expression to evaluate");
					double result = Converter.postfixValue(in.nextLine());
					System.out.println("The value of the postfix expression is " + result);
					break;
				}
				case "a":
				{
					in.nextLine();
					System.out.println("Enter an infix expression to convert and evaluate");
					String expression =  in.nextLine();
					String result = Converter.infixToPostfix(expression);
					double answer = Converter.postfixValue(result);
					System.out.println("the value of the arithmetic expression is " + answer);
					break;
				}
				case "q":
				{
					System.out.println("Have a nice day!");
					//breaks out of the while loop and terminates the program
					break mainloop;
				}
			
				default:
				{
					System.out.println("Invalid Choice");
					break;
				}
			}
		}
		in.close();
	}

}
