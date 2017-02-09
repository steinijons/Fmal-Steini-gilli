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
		System.out.println("statements()");
		if(nextToken.tCode == Token.TokenCode.END)
		{
			return;
		}
		else
		{
			statement();
			if(nextToken.tCode == Token.TokenCode.SEMICOL)
			{
				System.out.println("SEMICOL");
				nextToken = lex.nextToken();
				statements();
			}
			else
			{
				System.out.println("SEMICOLERROR");
				error();
			}
		}
		System.out.println("statemenst()ERROR");
		error();
		
	}
	// id = Expr | print id
	
	public void statement() 
	{
		System.out.println("statement()");
		if(nextToken.tCode == Token.TokenCode.ID)
		{
			System.out.println("INNÍ ID");
			System.out.println("PUSH " + nextToken.lexeme);
			nextToken = lex.nextToken();
			if(nextToken.tCode == Token.TokenCode.ASSIGN)
			{
				System.out.println("INNÍ ASSIGN");
				nextToken = lex.nextToken();
				expr();
				System.out.println("ASSIGN");
			}
			else
			{
				System.out.println("ASSIGNMENT ERROR");
				error();
			}
		}
		else if(nextToken.tCode == Token.TokenCode.PRINT)
		{
			System.out.println("INNÍ PRINT");
			nextToken = lex.nextToken();
			//System.out.println("PRINT");
			if(nextToken.tCode == Token.TokenCode.ID)
			{
				System.out.println("INNÍ PRINT ID");
				System.out.println("PUSH " + nextToken.lexeme);
				nextToken = lex.nextToken();
			}
			else
			{
				System.out.println("PRINT EKKI ID ERROR");
				error();
			}
			System.out.println("PRINT");
		}
		else
		{
			System.out.println("STATEMENT ERROR");
			error();
		}
	}
	
	//Term | Term + Expr | Term - Expr
	
	public void expr()
	{
		System.out.println("expr()");
		term();
		if(nextToken.tCode == Token.TokenCode.ADD)
		{
			System.out.println("INNÍ ADD");
			nextToken = lex.nextToken();
			expr();
			//System.out.println("ADD");
		}
		else if(nextToken.tCode == Token.TokenCode.SUB)
		{
			System.out.println("INNÍ SUB");
			nextToken = lex.nextToken();
			expr();
			System.out.println("SUB");
		}
	}
	
	//Factor | Factor * Term
	
	public void term()
	{
		System.out.println("TERM()");
		factor();
		if(nextToken.tCode == Token.TokenCode.MULT)
		{
			System.out.println("INNÍ MULT");
			nextToken = lex.nextToken();
			term();
			//System.out.println("MULT");
		}
	}
	
	//int | id | ( Expr )
	public void factor()
	{
		System.out.println("FACTOR()");
		if(nextToken.tCode == Token.TokenCode.INT)
		{
			System.out.println("FACTOR() INNÍ INT");
			System.out.println("PUSH " + nextToken.lexeme);
			nextToken = lex.nextToken();
		}		
		else if(nextToken.tCode == Token.TokenCode.ID)
		{
			System.out.println("FACTOR() INNÍ INT");
			System.out.println("PUSH " + nextToken.lexeme);
			System.out.println(nextToken.lexeme);
			nextToken = lex.nextToken();
			System.out.println(nextToken.lexeme);
		}
		else if(nextToken.tCode == Token.TokenCode.LPAREN)
		{
			System.out.println("FACTOR() INNÍ LPAREN");
			nextToken = lex.nextToken();
			expr();
			System.out.println("HÉR ER ÉG!!!!!!!");
			System.out.println(nextToken.lexeme);
			
			if(nextToken.tCode == Token.TokenCode.RPAREN)
			{
				System.out.println("FACTOR() INNÍ RPAREN");
				nextToken = lex.nextToken();
			}
			else
			{
				System.out.println("FACTOR() EKKI LPAREN NÉ RPAREN");
				error();
			}
		}
		else
		{
			System.out.println("FACTOR() ERROR");
			error();
		}
	}
	
	public void error()
	{
		System.out.println("Syntax error!");
		System.exit(1);
	}
}