package Assignment2;

import java.io.IOException;

public class Compiler {

	public static void main(String[] args) throws IOException
	{
		Lexer myLexer = new Lexer();
		Parser myParser = new Parser(myLexer);
		myParser.parse();
	}
}
