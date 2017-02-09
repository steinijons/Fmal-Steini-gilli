package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class Lexer {

	private static Scanner scanner;
	
	private int currentToken = -1;
	private ArrayList<Character> charInput;
	public String word;

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
			//charInput.add(' '); 
		}
		/*System.out.println("Reading in input stream done");
		for(char c: charInput)
		{
			System.out.println(c);
		}*/
	}
	
	private void remove(int size)
	{
		//System.out.println("Word size: " + size);

		//System.out.println("Remove: ");
		charInput.subList(0, size).clear();
		/*
		for(char c : charInput)
		{
			System.out.print(Character.toString(c));
		}*/
	}
	
	public Token nextToken()
	{   
		word = ""; 
		for(char c : charInput)
		{
			word += Character.toString(c);
			
			if(c == ' ')
			{
				break;
			}		
		}
		remove(word.length());			
		System.out.println("word: " + word);
		if(word.equals("+")) {return new Token(Token.TokenCode.ADD, word);}
		else if(word.equals("-")) {return new Token(Token.TokenCode.SUB, word);}
		else if(word.equals("*")) {return new Token(Token.TokenCode.MULT, word);}
		else if(word.equals("(")) {return new Token(Token.TokenCode.LPAREN, word);}
		else if(word.equals(")")) {return new Token(Token.TokenCode.RPAREN, word);}
		else if(word.equals(";")) {return new Token(Token.TokenCode.SEMICOL, word);}
		else if(word.equals("=")) {return new Token(Token.TokenCode.ASSIGN, word);}
		
		//System.out.println(word);
		if(word.matches("[0-9]+"))
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
		


		