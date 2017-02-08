package Assignment2;

import Assignment2.Token.TokenCode;

public class Lexer {
	
	private String[] arguments;
	private int currentToken = -1;

	public void writeArguments() 
	{
		
		for(String arg: arguments)
		{
			System.out.println(arg);
		}
	}

	public Lexer(String[] args)
	{
		arguments = args;
	}
	
	public TokenCode nextToken()
	{   
		currentToken++;
		if(arguments[currentToken].equals("print")) {return Token.TokenCode.PRINT;}
		if(arguments[currentToken].equals("end")) {return Token.TokenCode.END;}
		else if(arguments[currentToken].equals("+")) {return Token.TokenCode.ADD;}
		else if(arguments[currentToken].equals("-")) {return Token.TokenCode.SUB;}
		else if(arguments[currentToken].equals("*")) {return Token.TokenCode.MULT;}
		else if(arguments[currentToken].equals("(")) {return Token.TokenCode.LPAREN;}
		else if(arguments[currentToken].equals(")")) {return Token.TokenCode.RPAREN;}
		else if(arguments[currentToken].equals(";")) {return Token.TokenCode.SEMICOL;}
		else if(arguments[currentToken].matches("[0-9]+")) {return Token.TokenCode.INT;}
		else if(arguments[currentToken].matches(".*[a-z].*") || arguments[currentToken].matches(".*[A-Z].*")) {return Token.TokenCode.ID;}		
			
		return Token.TokenCode.ERROR;			
	
		
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