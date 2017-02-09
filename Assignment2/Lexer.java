package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

import javax.net.ssl.SSLContext;

public class Lexer {

	private static Scanner scanner;
	public String word;
	String arguments; 
	public int counter = -1;
	private ArrayList<Character> charInput;
	
	public Lexer()
	{
		
		charInput = new ArrayList<Character>();
<<<<<<< HEAD
		scanner = new Scanner(System.in);
		String arguments;
		while(scanner.hasNextLine() && !( arguments = scanner.nextLine() ).equals( "" ))
		{
			for(int i = 0; i < arguments.length(); i++)
			{
				charInput.add(arguments.charAt(i));
			}
		}
		
		/*int i = 1;
		for(char c: charInput)
		{	
			System.out.println(i + " " + c);
			i += 1;
		}*/
	}
		//System.out.println(System.in);
		/*input = new ArrayList<String>();
		scanner = new Scanner(System.in);
		while(scanner.hasNextLine() &&  !(arguments = scanner.nextLine() ).equals(""))
		{
			input.add(arguments); 
			for(int i = 0; i < input.size(); i++)
			{
				System.out.println(input.get(i));
			}
		}
		
		words = new ArrayList<String>();
		for(String arg : input)
=======
		scanner = new Scanner(System.in);
		String arguments;
		while(scanner.hasNextLine() && !( arguments = scanner.nextLine() ).equals( "" ))
>>>>>>> 73794daa7c0e5b50054d1c432d414ebe9acc927f
		{
			for(int i = 0; i < arguments.length(); i++)
			{
<<<<<<< HEAD
				if(s.contains(";") || s.contains("(") || s.contains("-") || s.contains(")"))
				{
					String[] numb = s.split(";");
					System.out.println(numb[0]);
					words.add(numb[0]);
					words.add(";");
				}
				else
				{
					words.add(s);
				}
				
=======
				charInput.add(arguments.charAt(i));
>>>>>>> 73794daa7c0e5b50054d1c432d414ebe9acc927f
			}
		}
<<<<<<< HEAD
		System.out.println(words);
	}*/
	
	public Token nextToken()
	{   
		counter++;
		if(Character.isWhitespace(charInput.get(counter)))
		{
			//System.out.println("WHITESPACE");				
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
			if(Character.isWhitespace(charInput.get(counter)) || charInput.get(counter).equals(')'))
			{
				return new Token(Token.TokenCode.ID, string);
			}
			else if(string.equals("print"))
			{
				return new Token(Token.TokenCode.PRINT, string);
			}
			else if(string.equals("end"))
			{
				return new Token(Token.TokenCode.END, string);
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
		//word = input.get(0);
		//input.remove(0);
		//splita word svo hægt sé að gefa viðeigandi token :)
		
		
		
		
		   
		//System.out.println(word);
		/*if(isInteger(word))
		{			
			return new Token(Token.TokenCode.INT, word);
=======
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
					
>>>>>>> 73794daa7c0e5b50054d1c432d414ebe9acc927f
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
<<<<<<< HEAD
		else if(word == "end")
		{
			return new Token(Token.TokenCode.END, word);
		}	
		if(word.matches(".*[a-z].*") || word.matches(".*[A-Z].*"))
		{
			return new Token(Token.TokenCode.ID, word);
		}			
		*/
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
=======
		
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
		


		
>>>>>>> 73794daa7c0e5b50054d1c432d414ebe9acc927f
