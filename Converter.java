/*
 * Zachary Martin (zrmartin@calpoly.edu)
 * 10/8/2015
 * Project 1
 */

import java.util.Scanner;

/*
 * Converter is a class that has two main static methods.
 * Both methods can be used in converting infix expressions into
 * postfix expressions and evaluating it with an algorithm.
 * */

public class Converter 
{
	/* 
	 * infixToPostfix takes in a string and returns it's postfix component
	 * with parenthesis removed, using a MyStack ADT
	 * @param expression: is a string with operands and operators. 
	 * @return String: is the original expression converted into 
	 */
	public static String infixToPostfix(String expression)
	{
		MyStack<String> stack = new MyStack<>();
		Scanner in = new Scanner(expression);
		String operators = ("+ - * / ( )"); 
		String result = "";
		while(in.hasNext())
		{
			String element = in.next();
			
			if(operators.contains(element))
			{
				if(stack.isEmpty())
				{
					stack.push(element);
				}
				else if(element.equals(")"))
				{
					while(!stack.peek().equals("("))
					{
						result += (stack.pop() + " ");
					}
					stack.pop(); //Popping the open parenthesis without printing it
				}
				else if(element.equals("("))
				{
					stack.push(element);
				}
				else
				{
					int onHandOrder = findOrder(element);
					int stackOrder = findOrder(stack.peek());
					while(stackOrder >= onHandOrder)
					{
						result += (stack.pop() + " ");
						if (!stack.isEmpty())
						{
							stackOrder = findOrder(stack.peek());
						}
						else
						{
							break;
						}
					}
					stack.push(element);
				}
			}
			else
			{
				result += element + " ";
			}
		}
		while(!stack.isEmpty())
		{
			result += stack.pop() + " ";
		}
		in.close();
		return result;
	}

	/*
	 * postfixValue utilizes a MyStack ADT and scanner to read in a postfix expression
	 * and evaluate it to obtain an answer
	 * @return double: the result of the given postfix expression evaluated
	 * @param expression: is a string containing operands and operators in postfix notation
	 */
	public static double postfixValue(String expression)
	{
		MyStack<Double> stack = new MyStack<>();
		Scanner in = new Scanner(expression);
		while(in.hasNext())
		{
			while(in.hasNextDouble())
			{
				stack.push(in.nextDouble());
			}
			
			String operator = in.next();
			double rhs = stack.pop();
			double lhs = stack.pop();
			switch(operator)
			{
				case "+":
				{
					stack.push(lhs + rhs);
				}
				break;
				case "-":
				{
					stack.push(lhs - rhs);
				}
				break;
				case "*":
				{
					stack.push(lhs * rhs);
				}
				break;
				case "/":
				{
					stack.push(lhs / rhs);
				}
				break;
			}
		}
		in.close();
		return stack.pop();
	}
	
	/*
	 * findOrder is a private static helper class used to determine the 
	 * order of precedence of operators for the algorithm used in
	 * the infixToPostfix method
	 * @return int: is the order of precedence of the given operator
	 * @param element: is any mathematical operator 
	 */
	private static int findOrder(String element)
	{
		int order = 0; //for open parenthesis

		if(element.equals("+") || element.equals("-"))
		{
			order = 1;
		}
		else if(element.equals("*") || element.equals("/"))
		{
			order = 2;
		}
		return order;
	}

}
