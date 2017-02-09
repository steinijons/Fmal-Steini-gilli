package Assignment2;

public class Parser {
		
	private Lexer lex;
	private Token nextToken;
	
	public Parser(Lexer lex)
	{
		this.lex = lex;
	}
	public void parse() 
	{
		nextToken = lex.nextToken();
		//System.out.println(nextToken);
		Statements();
	}
	
	// Statement ; Statements | end
	
	public void Statements()
	{
		
		if(nextToken.tCode == Token.TokenCode.END)
		{
			return;
		}
		else if(nextToken.tCode != Token.TokenCode.END)
		{
			Statement();
			if(nextToken.tCode == Token.TokenCode.SEMICOL)
			{
				nextToken = lex.nextToken();
				Statements();
			}
			else
			{
				Error();
			}
		}
		else
		{
			Error();
		}
	}
	// id = Expr | print id
	
	public void Statement()
	{
		if(nextToken.tCode == Token.TokenCode.ID)
		{
			System.out.println(nextToken.lexeme);
			nextToken = lex.nextToken();
			
			if(nextToken.tCode == Token.TokenCode.ASSIGN)
			{
				Expr();
				System.out.println("ASSIGN");
			}
			else
			{
				Error();
			}
		}
		else if(nextToken.tCode == Token.TokenCode.PRINT)
		{
			nextToken = lex.nextToken();
			System.out.println("PRINT");
			if(nextToken.tCode == Token.TokenCode.ID)
			{
				System.out.println(nextToken.lexeme);
				nextToken = lex.nextToken();
			}
			else
			{
				Error();
			}
		}
		else
		{
			Error();
		}
	}
	
	//Term | Term + Expr | Term - Expr
	
	public void Expr()
	{
		Term();
		if(nextToken.tCode == Token.TokenCode.ADD)
		{
			nextToken = lex.nextToken();
			Expr();
			System.out.println("ADD");
		}
		else if(nextToken.tCode == Token.TokenCode.SUB)
		{
			nextToken = lex.nextToken();
			Expr();
			System.out.println("ADD");
		}
		else
		{
			Error();
		}
	}
	
	//Factor | Factor * Term
	
	public void Term()
	{
		Factor();
		if(nextToken.tCode == Token.TokenCode.MULT)
		{
			nextToken = lex.nextToken();
			Term();
			System.out.println("MULT");
		}
	}
	
	//int | id | ( Expr )
	public void Factor()
	{
		if(nextToken.tCode == Token.TokenCode.INT)
		{
			System.out.println("PUSH" + nextToken.lexeme);
			nextToken = lex.nextToken();
		}
		else if(nextToken.tCode == Token.TokenCode.ID)
		{
			System.out.println("PUSH" + nextToken.lexeme);
		}
		else if(nextToken.tCode == Token.TokenCode.LPAREN)
		{
			Expr();
			nextToken = lex.nextToken();
			if(nextToken.tCode == Token.TokenCode.RPAREN)
			{
				nextToken = lex.nextToken();
			}
			else
			{
				Error();
			}
		}
		else
		{
			Error();
		}
	}
	
	public void Error()
	{
		System.out.println("ERROR!");
	}
}
