package app;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ExprLexer;
import antlr.ExprParser;
import expression.EvalVisitor;
import expression.MyErrorListener;

public class ExpressionApp {

	public static void main(String[] args) {
		if(args.length != 1) {
			System.err.print("Usage: file name");
		}
		else {
			String fileName = args[0];
			ExprParser parser = getParser(fileName);
			
			//Tell antlr to build a parse tree
			// parse from the start symbol 'prog'
			 ParseTree antlrAST = parser.prog();
			 
			 if(MyErrorListener.hasError) {
				 /* let syntax error be reported */
			 }
			 else {
				 // Create a visitor for converting the 
				 //parse tree into expression/program objects
				 EvalVisitor visitor = new EvalVisitor();
				 visitor.visit(antlrAST);
				 
				 if(visitor.semanticErrors.isEmpty()) {
			         System.out.println("worked");
					
				 }
				 else {
					 for(String err: visitor.semanticErrors) {
						 System.out.println(err);
					 }
				 } 
			 }
		}
	}

	/*
	 * Here the types of parser and
	 * lexer are specific to grammar name expr.g4
	 */
	private static ExprParser getParser(String fileName) {
		ExprParser parser = null;
		try {
			CharStream input = CharStreams.fromFileName(fileName);
			ExprLexer lexer = new ExprLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			parser = new ExprParser(tokens);
			
			// syntax error handling 
			parser.removeErrorListeners();
			parser.addErrorListener(new MyErrorListener());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parser;
	}
}