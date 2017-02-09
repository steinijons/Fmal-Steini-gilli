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
			arguments.concat(scanner.nextLine());
			for(int i = 0; i < arguments.length(); i++)
			{
				charInput.add(arguments.charAt(i)); 
			}
			charInput.add(' '); 
		}
		System.out.println("Reading in input stream done");
		for(char c: charInput)
		{
			System.out.println(c);
		}
	}
	
	public Token nextToken()
	{  
		currentToken++;				
		if(Character.isLetter(charInput.get(currentToken)))
		{
			System.out.println("inni id");
			word += charInput.get(currentToken);;
			System.out.println(word);
			if(charInput.get(currentToken) == '\n' || charInput.get(currentToken) == ' ')
			{	
				return new Token(Token.TokenCode.ID, word);
			}	
			else if(word == "print")
			{
				return new Token(Token.TokenCode.PRINT, word);				
			}
			else if(word == "end")
			{
				return new Token(Token.TokenCode.END, word);
			}			
		}
		else if(charInput.get(currentToken) == '+') {return new Token(Token.TokenCode.ADD, String.valueOf(charInput.get(currentToken)));}
		else if(charInput.get(currentToken) == '-') {return new Token(Token.TokenCode.SUB, String.valueOf(charInput.get(currentToken)));}
		else if(charInput.get(currentToken) == '*') {return new Token(Token.TokenCode.MULT, String.valueOf(charInput.get(currentToken)));}
		else if(charInput.get(currentToken) == '(') {return new Token(Token.TokenCode.LPAREN, String.valueOf(charInput.get(currentToken)));}
		else if(charInput.get(currentToken) == ')') {return new Token(Token.TokenCode.RPAREN, String.valueOf(charInput.get(currentToken)));}
		else if(charInput.get(currentToken) == ';') {return new Token(Token.TokenCode.SEMICOL, String.valueOf(charInput.get(currentToken)));}
		else if(Character.isDigit(charInput.get(currentToken))) {return new Token(Token.TokenCode.INT, String.valueOf(charInput.get(currentToken)));}
		
		return new Token(Token.TokenCode.SEMICOL, String.valueOf(charInput.get(currentToken)));
		
	}				
		
}
		


		