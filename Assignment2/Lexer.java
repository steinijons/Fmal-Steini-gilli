package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Lexer {

	private static Scanner scanner;
	public String word;
	String arguments; 
	public int counter = -1;
	private ArrayList<Character> charInput;
	
	public Lexer()
	{
		
		charInput = new ArrayList<Character>();
		scanner = new Scanner(System.in);
		String arguments;
		while(scanner.hasNextLine() && !( arguments = scanner.nextLine() ).equals( "" ))
		{
			for(int i = 0; i < arguments.length(); i++)
			{
				charInput.add(arguments.charAt(i));
			}
		}
	}
	public Token nextToken()
	{   
		counter++;
		System.out.println("Element: " + charInput.get(counter));
		if(Character.isWhitespace(charInput.get(counter)))
		{		
			nextToken();
		}
		
		String string = "";
		word = charInput.get(counter).toString();
		//System.out.println("Current Element: " + word);
		
		if(Character.isLetter(charInput.get(counter)))
		{
			//System.out.println("Fer inní isletter");
			while(true)
			{
				if(Character.isLetter(charInput.get(counter)))
				{
					string += charInput.get(counter).toString();
				}
				else
				{
					break;
				}		
				counter++;
			}
			if(string.equals("print"))
			{
				counter--;
				return new Token(Token.TokenCode.PRINT, string);
			}
			else if(string.equals("end"))
			{
				counter--;
				return new Token(Token.TokenCode.END, string);
			}
			else if(Character.isWhitespace(charInput.get(counter)) || charInput.get(counter).equals(')'))
			{
				counter--;
				return new Token(Token.TokenCode.ID, string);
			}
					
		}
		else
		{
			if(word.equals("+")) {return new Token(Token.TokenCode.ADD, word);}
			else if(word.equals("-")) {return new Token(Token.TokenCode.SUB, word);}
			else if(word.equals("*")) {return new Token(Token.TokenCode.MULT, word);}
			else if(word.equals("(")) {return new Token(Token.TokenCode.LPAREN, word);}
			else if(word.equals(")")) {return new Token(Token.TokenCode.RPAREN, word);}
			else if(word.equals(";")) {return new Token(Token.TokenCode.SEMICOL, word);}
			else if(word.equals("=")) {return new Token(Token.TokenCode.ASSIGN, word);}
			else if(isInteger(word))
			{			
				return new Token(Token.TokenCode.INT, word);
			}
		}
		
		return new Token(Token.TokenCode.ERROR, word);	
	}	
	
	public boolean isInteger(String input)
	{
	   try
	   {
	      Integer.parseInt(input);
	      
	   }
	   catch(NumberFormatException nfe)
	   {
	      return false;
	   }
	   return true;
	}
		
}
		


		