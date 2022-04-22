package Driver;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.GrammarLexer;
import antlr.GrammarParser;
import Expressions.AntlrToProgram;
import Expressions.MyErrorListener;

public class App {
	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.print("Can only take one parameter after filename");
		}
		else {
			GrammarParser Parser = getParser(args[0]);
			
			//Tell antler to build a parse tree
			// parse from the start symbol 'prog'
			ParseTree Tree = Parser.prog();
			
			 if(MyErrorListener.hasError) {
				 /* let syntax error be reported */
			 }
			 else {
				 // Create a visitor for converting the 
				 //parse tree into expression/program objects
				 
				 AntlrToProgram progVisitor = new AntlrToProgram();
				 progVisitor.visit(Tree);
			 }
		}
	/*
	 * Here the types of parser and
	 * lexer are specific to grammar name Grammar.g4
	 */
	}
	
	
	
	private static GrammarParser getParser(String fileName) {
		GrammarParser parser = null;
		try {
			CharStream input = CharStreams.fromFileName(fileName);
			GrammarLexer lexer = new GrammarLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new GrammarParser(tokens);
			
			// syntax error handling 
			parser.removeErrorListeners();
			parser.addErrorListener(new MyErrorListener());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parser;
	}

}
