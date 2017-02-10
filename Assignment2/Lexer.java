package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.*;

public class Lexer {

	private static Scanner scanner;
	private String lex;
	private int counter = 0;
	private ArrayList<Character> charInput;
	
	public Lexer()
	{
		charInput = new ArrayList<Character>();
		scanner = new Scanner(System.in);
		String arguments;
		while(scanner.hasNextLine())
		{
			arguments = scanner.nextLine();
			for(int i = 0; i < arguments.length(); i++)
			{
				charInput.add(arguments.charAt(i));
			}
			if(arguments.equals("end"))
			{
				break;
			}
		}
	}
	
	public Token nextToken()
	{   
		//System.out.println(counter);
		//System.out.println(charInput.get(0));
		lex = "";
		if(counter >= charInput.size())
		{
			return new Token(Token.TokenCode.ERROR, "");
		}
		//System.out.println("counter: " + counter);
		//System.out.println(charInput.size());
		if(Character.isWhitespace(charInput.get(counter)))
		{		
			counter++;
		}
		//System.out.println("Element: " + charInput.get(counter));
		//System.out.println("Current Element: " + word);
		if(charInput.get(counter).equals('+') || charInput.get(counter).equals('-') || charInput.get(counter).equals('*') || charInput.get(counter).equals('=') || charInput.get(counter).equals('(') || charInput.get(counter).equals(')') || charInput.get(counter).equals(';'))
		{
			lex = charInput.get(counter).toString();
			counter++;
		}
		else if(Character.isLetter(charInput.get(counter)) || Character.isDigit(charInput.get(counter)))
		{	
			//System.out.println("Fer inn isletter");
			while(counter < charInput.size() && (Character.isLetter(charInput.get(counter)) || Character.isDigit(charInput.get(counter))))
			{
				lex += charInput.get(counter).toString();
				counter++;
			}
		}
		//System.out.println(lex);
		if(lex.equals("+")) {return new Token(Token.TokenCode.ADD, lex);}
		if(lex.equals("-")) {return new Token(Token.TokenCode.SUB, lex);}
		if(lex.equals("*")) {return new Token(Token.TokenCode.MULT, lex);}
		if(lex.equals("(")) {return new Token(Token.TokenCode.LPAREN, lex);}
		if(lex.equals(")")) {return new Token(Token.TokenCode.RPAREN, lex);}
		if(lex.equals(";")) {return new Token(Token.TokenCode.SEMICOL, lex);}
		if(lex.equals("=")) {return new Token(Token.TokenCode.ASSIGN, lex);}
		if(lex.equals("print")){return new Token(Token.TokenCode.PRINT, lex);}
		if(lex.equals("end")){return new Token(Token.TokenCode.END, lex);}
		
		String temp = "[0-9]+";
		Pattern pattern = Pattern.compile(temp);
		Matcher matcher = pattern.matcher(lex);
		
		if(matcher.find())
		{
			return new Token(Token.TokenCode.INT, lex);
		}
		temp = "[a-zA-Z]+";
		pattern = Pattern.compile(temp);
		matcher = pattern.matcher(lex);
		if(matcher.find()) 
		{
			return new Token(Token.TokenCode.ID, lex);
		}
		
		return new Token(Token.TokenCode.ERROR, lex);	

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
		


		