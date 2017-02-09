package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Lexer {

	private static Scanner scanner;
	private ArrayList<String> input;
	private ArrayList<String> words;
	public String word;
	String arguments; 
	public Lexer()
	{
		//System.out.println(System.in);
		input = new ArrayList<String>();
		scanner = new Scanner(System.in);
		while(scanner.hasNextLine() &&  !(arguments = scanner.nextLine() ).equals(""))
		{
			input.add(arguments); 
		}
		words = new ArrayList<String>();
		for(String arg : input)
		{
			String[] temp = arg.split("\\s+");
			for(String s : temp)
			{
				words.add(s);
			}
			
		}
		System.out.print(words);
	}
	
	public Token nextToken()
	{   
		word = input.get(0); 
		input.remove(0);
		//splita word svo hægt sé að gefa viðeigandi token :)
		System.out.println("word: " + word);
		if(word.equals("+")) {return new Token(Token.TokenCode.ADD, word);}
		else if(word.equals("-")) {return new Token(Token.TokenCode.SUB, word);}
		else if(word.equals("*")) {return new Token(Token.TokenCode.MULT, word);}
		else if(word.equals("(")) {return new Token(Token.TokenCode.LPAREN, word);}
		else if(word.equals(")")) {return new Token(Token.TokenCode.RPAREN, word);}
		else if(word.equals(";")) {return new Token(Token.TokenCode.SEMICOL, word);}
		else if(word.equals("=")) {return new Token(Token.TokenCode.ASSIGN, word);}
		
		//System.out.println(word);
		if(word.matches("[0-9]+") || word.matches(".*[a-z].*") || word.matches(".*[A-Z].*"))
		{
			
			return new Token(Token.TokenCode.INT, word);
		}
		else if(word == "print")
		{
			return new Token(Token.TokenCode.PRINT, word);				
		}
		else if(word == "end")
		{
			return new Token(Token.TokenCode.END, word);
		}	
		if(word.matches(".*[a-z].*") || word.matches(".*[A-Z].*"))
		{
			return new Token(Token.TokenCode.ID, word);
		}			
		
		return new Token(Token.TokenCode.SEMICOL, word);	
	}				
		
}
		


		