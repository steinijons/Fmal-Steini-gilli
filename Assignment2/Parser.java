package Assignment2;

import java.io.IOException;

public class Parser {
		
	private Lexer lex;
	private Token nextToken;
	
	public Parser(Lexer lex)
	{
		this.lex = lex;
	}
	public void parse() throws IOException 
	{
		nextToken = lex.nextToken();
		statements();
	}
	
	// Statement ; Statements | end
	
	public void statements() 
	{
		if(nextToken.tCode == Token.TokenCode.END)
		{
			return;
		}
		else
		{
			statement();
			if(nextToken.tCode == Token.TokenCode.SEMICOL)
			{
				nextToken = lex.nextToken();
				statements();
			}
			else
			{
				error();
			}
		}
		error();
		
	}
	// id = Expr | print id
	
	public void statement() 
	{
		if(nextToken.tCode == Token.TokenCode.ID)
		{
			System.out.println("PUSH " + nextToken.lexeme);
			nextToken = lex.nextToken();
			if(nextToken.tCode == Token.TokenCode.ASSIGN)
			{
				
				nextToken = lex.nextToken();
				expr();
			}
			else
			{
				error();
			}
		}
		else if(nextToken.tCode == Token.TokenCode.PRINT)
		{
			nextToken = lex.nextToken();
			System.out.println("PRINT");
			if(nextToken.tCode == Token.TokenCode.ID)
			{
				//System.out.println(nextToken.lexeme);
				nextToken = lex.nextToken();
			}
			else
			{
				error();
			}
		}
		else
		{
			error();
		}
	}
	
	//Term | Term + Expr | Term - Expr
	
	public void expr()
	{
		term();
		if(nextToken.tCode == Token.TokenCode.ADD)
		{
			nextToken = lex.nextToken();
			expr();
			System.out.println("ADD");
		}
		else if(nextToken.tCode == Token.TokenCode.SUB)
		{
			nextToken = lex.nextToken();
			expr();
			System.out.println("ADD");
		}
		else
		{
			error();
		}
	}
	
	//Factor | Factor * Term
	
	public void term()
	{
		factor();
		if(nextToken.tCode == Token.TokenCode.MULT)
		{
			nextToken = lex.nextToken();
			term();
			System.out.println("MULT");
		}
	}
	
	//int | id | ( Expr )
	public void factor()
	{
		if(nextToken.tCode == Token.TokenCode.INT)
		{
			System.out.println("PUSH " + nextToken.lexeme);
			nextToken = lex.nextToken();
		}
		else if(nextToken.tCode == Token.TokenCode.ID)
		{
			System.out.println("PUSH" + nextToken.lexeme);
		}
		else if(nextToken.tCode == Token.TokenCode.LPAREN)
		{
			expr();
			nextToken = lex.nextToken();
			if(nextToken.tCode == Token.TokenCode.RPAREN)
			{
				nextToken = lex.nextToken();
			}
			else
			{
				error();
			}
		}
		else
		{
			error();
		}
	}
	
	public void error()
	{
		System.out.println("ERROR!");
	}
}
