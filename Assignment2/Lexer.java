package Assignment2;

import Assignment2.Token.TokenCode;

public class Lexer {

	String word = "";
	public TokenCode nextToken(String input)
	{
		input = "a"; 
		
		
		if(input.equals("print")) {return Token.TokenCode.PRINT;}
		if(input.equals("end")) {return Token.TokenCode.END;}
		else if(input.equals("+")) {return Token.TokenCode.ADD;}
		else if(input.equals("-")) {return Token.TokenCode.SUB;}
		else if(input.equals("*")) {return Token.TokenCode.MULT;}
		else if(input.equals("(")) {return Token.TokenCode.LPAREN;}
		else if(input.equals(")")) {return Token.TokenCode.RPAREN;}
		else if(input.equals(";")) {return Token.TokenCode.SEMICOL;}
		else if(input.matches("[0-9]+")) {return Token.TokenCode.INT;}
		else if(input.matches(".*[a-z].*") || input.matches(".*[A-Z].*")) {return Token.TokenCode.ID;}		
		
	
		return null;
		
	}
		
}

/*if(Character.isLetter(input))
{
word += input;

if(input == '\n' || input == ' ')
{
	word = "";
}	
else if(word == "print")
{
	return Token.TokenCode.PRINT;				
}
else if(word == "end")
{
	return Token.TokenCode.END;
}
}
else if(input == '+') {return Token.TokenCode.ADD;}
else if(input == '-') {return Token.TokenCode.SUB;}
else if(input == '*') {return Token.TokenCode.MULT;}
else if(input == '(') {return Token.TokenCode.LPAREN;}
else if(input == ')') {return Token.TokenCode.RPAREN;}
else if(input == ';') {return Token.TokenCode.SEMICOL;}
else if(Character.isDigit(input)) {return Token.TokenCode.INT;}
else if(Character.toString(input).matches(".*[a-z]*.") || Character.toString(input).matches(".*[A-Z]*.")) 
{
return Token.TokenCode.ID;
}		*/