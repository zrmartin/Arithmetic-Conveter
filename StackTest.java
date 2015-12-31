/*
 * Zachary Martin (zrmartin@calpoly.edu)
 * 10/8/2015
 * Project 1
 */

import java.util.EmptyStackException;
import java.util.Scanner;

/*
 * StackTest is a driver class to test the performance of my MyStack ADT
 * The class consists of a single main class that prints out a menu listing
 * each method or operation of MyStack to use
 */
public class StackTest 
{
	public static void main(String [] args)
	{
		MyStack<String> stack = new MyStack<>();
		Scanner in = new Scanner(System.in);  //**DO NOT CREATE A NEW SCANNER**
		String greeting = ("Choose one of the following opperations:\n"
				+ "-push/add (enter the letter a)\n"
				+ "-pop/delete (eneter the letter d)\n"
				+ "-peek (enter the letter p)\n"
				+ "-check if the list is empty (enter the letter e)\n"
				+ "-Quit (enter the letter q)\n");
		System.out.println(greeting);
		//mainloop is used to terminate the program when the user presses q
		mainloop: 
		while(in.hasNext())
		{
			String choice = in.next().toLowerCase();
			switch(choice)
			{
				case "a":
				{
					in.nextLine();
					System.out.println("input a value");
					String value = in.nextLine();
					stack.push(value);
					System.out.println(value + " pushed in");
					break;
				}
				
				case "d":
				{
					in.nextLine();
					try
					{
						String value = stack.pop();
						System.out.println(value + " popped out");
						break;
					}
					catch(EmptyStackException e)
					{
						System.out.println("Invalid opperation on an empty stack");
						break;
					}
				}
				
				case "p":
				{
					in.nextLine();
					try
					{
						System.out.println(stack.peek() + " on the top");
						break;
					}
					catch(EmptyStackException e)
					{
						System.out.println("Invalid opperation on an empty stack");
						break;
					}
				}
				
				case "e":
				{
					if(stack.isEmpty())
					{
						System.out.println("empty");
					}
					else
					{
						System.out.println("not empty");
					}
					break;
				}
				
				case "q":
				{
					System.out.println("Quitting program, have a nice day!");
					//using a normal break loop would only break out of the switch clause
					break mainloop;
				}
				
				default:
				{
					System.out.println("Invalid choice");				
				}
			}
		}
		
	}

}
