package Assignment2;

import Assignment2.Token.TokenCode;

public class Lexer {

	
	public TokenCode nextToken()
	{
		char input = 'a'; 
		
		if(input == '+') {return Token.TokenCode.ADD;}
		else if(input == '-') {return Token.TokenCode.SUB;}
		else if(input == '*') {return Token.TokenCode.MULT;}
		else if(input == '(') {return Token.TokenCode.LPAREN;}
		else if(input == ')') {return Token.TokenCode.RPAREN;}
		else if(input == ';') {return Token.TokenCode.SEMICOL;}
		else if(Character.isDigit(input)) {return Token.TokenCode.INT;}
		else if(Character.toString(input).matches(".*[a-z]*.") || Character.toString(input).matches(".*[A-Z]*.")) 
		{
			return Token.TokenCode.ID;
		}
		else if(input == ' ') {return Token.TokenCode.END;}
		if(input ==  )
		

	
		return null;
		
	}
		
}
