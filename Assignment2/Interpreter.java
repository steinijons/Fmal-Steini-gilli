package Assignment2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.*;

public class Interpreter {
	
	private static Stack<String> stack;
	private static Map<String, Integer> memory;
	private static Scanner scanner;
	
	public static void main(String[] args) 
	{
		stack = new Stack<String>();
		memory = new HashMap<String, Integer>();	
		scanner = new Scanner(System.in);
		
		String arguments = "";
		String first, second = "";
		
		while(scanner.hasNextLine())
		{
			arguments = scanner.nextLine();
			//System.out.println(arguments);
			if(arguments.equals("PRINT"))
			{
				String look = stack.peek();
				if(memory.containsKey(look))
				{
					System.out.println(memory.get(look));
				}
				else
				{
					System.out.println(stack.peek());
				}
			}
			else if(arguments.equals("ASSIGN"))
			{
				first = stack.pop();
				second = stack.pop();
				memory.put(second, Integer.parseInt(first));
			}
			else if(arguments.equals("SUB"))
			{
				first = stack.pop();
				second = stack.pop();
				if(memory.containsKey(first) || memory.containsKey(second))
				{
					Integer x = memory.get(first);
					Integer y = memory.get(second);
					if(x == null)
					{
						stack.push(Integer.toString(y - Integer.parseInt(first)));
					}
					else if(y == null)
					{
						stack.push(Integer.toString(Integer.parseInt(second) - x));
					}
					else
					{
						stack.push(Integer.toString(y - x));
					}
				}
				else
				{
					stack.push(Integer.toString(Integer.parseInt(second) - Integer.parseInt(first)).toString());
				}
			}
			else if(arguments.equals("MULT"))
			{
				first = stack.pop();
				second = stack.pop();
				if(memory.containsKey(first) || memory.containsKey(second))
				{
					Integer x = memory.get(first);
					Integer y = memory.get(second);
					if(x == null)
					{
						stack.push(Integer.toString(y * Integer.parseInt(first)));
					}
					else if(y == null)
					{
						stack.push(Integer.toString(Integer.parseInt(second) * x));
					}
					else
					{
						stack.push(Integer.toString(y * x));
					}
				}
				else
				{
					stack.push(Integer.toString(Integer.parseInt(second) * Integer.parseInt(first)).toString());					
				}

			}
			else if(arguments.equals("ADD"))
			{
				first = stack.pop();
				second = stack.pop();
				if(memory.containsKey(first) || memory.containsKey(second))
				{
					Integer x = memory.get(first);
					Integer y = memory.get(second);
					if(x == null)
					{
						stack.push(Integer.toString(y * Integer.parseInt(first)));
					}
					else if(y == null)
					{
						stack.push(Integer.toString(Integer.parseInt(second) * x));
					}
					else
					{
						stack.push(Integer.toString(Integer.parseInt(second) + Integer.parseInt(first)).toString());
					}
				}
			}
			else 
			{
				//System.out.println("from:" + arguments.substring(5, arguments.length()));
				String input = arguments.substring(5, arguments.length());
				stack.push(input);
				/*String temp = "[0-9]+";
				Pattern pattern = Pattern.compile(temp);
				Matcher matcher = pattern.matcher(input);
				if(matcher.find())
				{
					stack.push(input);
					break;
				}
				temp = "[a-zA-Z]+";
				pattern = Pattern.compile(temp);
				matcher = pattern.matcher(input);
				if(matcher.find())
				{
					stack.push(input);
					break;
				}
				System.out.println("Error for operator: " + input);
				System.exit(1);
				*/
			}
		}		
	}
}