package Assignment2;

public class Compiler {

	public static void main(String[] args)
	{
		Lexer myLexer = new Lexer(args);
		myLexer.writeArguments();
		//Parser myParser = new Parser(myLexer);
		
		//myParser.parse();
	}
}
