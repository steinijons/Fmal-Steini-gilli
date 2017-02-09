package Assignment2;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lexer {
	
	private int currentToken = -1;
	private BufferedReader reader;
	public char[] charInput;
	public String word = "";

	public Lexer() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();
        int length = tmp.length();
        charInput = new char[length];
        tmp.getChars(0, length, charInput, 0);
        CharArrayReader input1 = new CharArrayReader(charInput);
        int i;
        System.out.print("input is:");
        while ((i = input1.read()) != -1) 
        {
            System.out.print((char) i);
        } 
	}
	
	public Token nextToken() throws IOException
	{    
		CharArrayReader input1 = new CharArrayReader(charInput);
		int i;
    	System.out.print("now from nextToken():");
    	while ((i = input1.read()) != -1) 
    	{
    		System.out.print((char) i);
    	} 
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
		


		