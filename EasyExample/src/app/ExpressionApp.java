package app;

import java.io.IOException;
import java.util.ArrayList;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import antlr.ExprLexer;
import antlr.ExprParser;
import expression.EvalVisitor;
import expression.MyErrorListener;
import expression.TypeChecker;

public class ExpressionApp {

	public static void main(String[] args) {
	    long startTime = System.nanoTime();
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
	        	 
	        	 TypeChecker Checkervisitor = new TypeChecker(new ArrayList<String>());
	        	 Checkervisitor.visit(antlrAST);
	        	 
	             if(Checkervisitor.semanticErrors.isEmpty()) {
	                 System.out.println("worked");
	                
		             EvalVisitor visitor = new EvalVisitor();
		             visitor.visit(antlrAST);     
	             }
	             else {
	                 for(String err: Checkervisitor.semanticErrors) {
	                     System.out.println(err);
	                 }
	             } 
	         }
	    }
	    long endTime   = System.nanoTime();
	    long totalTime = endTime - startTime;
	    System.out.println("Seconds elapsed: " + totalTime / 1000000000);
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