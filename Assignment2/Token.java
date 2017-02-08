package Assignment2;

public class Token {
	public String lexeme;
	public TokenCode tCode;
	
	enum TokenCode { ID, ASSIGN, SEMICOL, INT, ADD, SUB,
		MULT, LPAREN, RPAREN, PRINT, END, ERROR }
	
}
