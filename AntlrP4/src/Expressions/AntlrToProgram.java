package Expressions;

import java.util.ArrayList;

import java.util.List;

import antlr.GrammarParser.ProgramContext;
import antlr.GrammarBaseVisitor;


public class AntlrToProgram extends GrammarBaseVisitor<Program> {

	public List<String> semanticErrors; // to be accessed by the main application program
	
	@Override
	public Program visitProgram(ProgramContext ctx) {
		Program prog = new Program();
		
		semanticErrors = new ArrayList<>();
		TypeChecker exprVisitor = new TypeChecker(semanticErrors);
		// a helper  visitor for transforming each subtree into an Expression object
		
		for(int i = 0; i< ctx.getChildCount(); i++)
		{
			if (i == ctx.getChildCount() - 1)
			{
				/* last child of the start symbol program is EOF 
				 * Do not visit this child and attempt to convert it to expression object*/
			}
			else 
			{
				prog.addExpression(exprVisitor.visit(ctx.getChild(i)));
			}
		}
		return prog;
	}
}
