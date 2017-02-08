package Assignment2;

import java.util.Scanner;

public class Lexer {
	
	
	private static Scanner scanner = new Scanner(System.in);
	
	private int currentToken = -1;
	public static char[] charInput;
	public String word = "";



	public Lexer()
	{
		String arguments = "";
		while(scanner.hasNextLine())
		{
			arguments += scanner.hasNextLine();
		}
		charInput = arguments.toCharArray();			
	}
	
	public Token nextToken()
	{  
		currentToken++;				
		if(Character.isLetter(charInput[currentToken]))
		{
			word += charInput[currentToken];
		
			if(charInput[currentToken] == '\n' || charInput[currentToken] == ' ')
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
		else if(charInput[currentToken] == '+') {return new Token(Token.TokenCode.ADD, String.valueOf(charInput[currentToken]));}
		else if(charInput[currentToken] == '-') {return new Token(Token.TokenCode.SUB, String.valueOf(charInput[currentToken]));}
		else if(charInput[currentToken] == '*') {return new Token(Token.TokenCode.MULT, String.valueOf(charInput[currentToken]));}
		else if(charInput[currentToken] == '(') {return new Token(Token.TokenCode.LPAREN, String.valueOf(charInput[currentToken]));}
		else if(charInput[currentToken] == ')') {return new Token(Token.TokenCode.RPAREN, String.valueOf(charInput[currentToken]));}
		else if(charInput[currentToken] == ';') {return new Token(Token.TokenCode.SEMICOL, String.valueOf(charInput[currentToken]));}
		else if(Character.isDigit(charInput[currentToken])) {return new Token(Token.TokenCode.INT, String.valueOf(charInput[currentToken]));}
		
		return null;
		
	}				
		
}
		


		