package Expressions;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.tool.Grammar;

import antlr.GrammarBaseVisitor;
import antlr.GrammarParser.AdditiveContext;
import antlr.GrammarParser.AtomContext;
import antlr.GrammarParser.DeclarationContext;
import antlr.GrammarParser.FloatContext;
import antlr.GrammarParser.FloatDeclarationContext;
import antlr.GrammarParser.IdContext;
import antlr.GrammarParser.IntContext;
import antlr.GrammarParser.IntDeclarationContext;
import antlr.GrammarParser.MultiplicationContext;
import antlr.GrammarParser.ParContext;
import antlr.GrammarParser.PowContext;
import antlr.GrammarParser.TypeDenContext;
import antlr.GrammarParser.UnaryMinusContext;
import antlr.GrammarBaseVisitor;

public class TypeChecker extends GrammarBaseVisitor<Expression> {
	// Given that all visit_* methods are called in a top down fashion
	// We can be sure that the order in which we add declared variables
	// in the 'vars' is identical to how they are declared in input program
	
	private List<String> vars; // stores all variable in program so far
	private List<String> semanticErrors; // 1. Duplicate declarations 2. Reference to undeclared variable 

	public TypeChecker(List<String> semanticErrors) {
		vars = new ArrayList<>();
		this.semanticErrors = semanticErrors;
	}
	
	
	
	@Override
	public Expression visitDeclaration(DeclarationContext ctx) {

		Token idToken = ctx.ID().getSymbol(); // equivalent to: ctx.getChild(0).getSymbol()
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		
		Type vType = (Type) visit(ctx.getChild(1));
		Type eType = (Type) visit(ctx.getChild(3));
		
		String id = ctx.ID().getText();
		// maintaining the vars list for semantic error reporting
		
		if (!eType.equals(vType)){
			semanticErrors.add("Error: ID does not match type at decleration on line" + line+", " + column + ")");
		}
		
		else if (vars.contains(id))
			semanticErrors.add("Error: variable " + id + " already declared ("+ line + ", " + column + ")");
		
		
		else if (eType.equals(vType) && !vars.contains(id)) {
			vars.add(id);
		}
		return null;
	}
	
	public Expression visitTypeDen(TypeDenContext ctx) {
		Expression type = visit(ctx.getChild(0));
		
		return type;
	}
	
	
	
	
	
	@Override
	public Expression visitMultiplication(MultiplicationContext ctx) {
		Expression left = (Type) visit(ctx.getChild(0)); 
		Expression right = (Type) visit(ctx.getChild(2));
		
        if (ctx.op == null) {
            throw new UnsupportedOperationException("An operator of / or * is required to perform the operation");
        }
        String operator = ctx.op.getText();

        if (operator == "/") {
        	Multiplication myMult = new Multiplication(left, right, "/");
        	myMult.type = returnType(left, right);
        	return myMult;
        }
        else {
        	Multiplication myMult = new Multiplication(left, right, "*");
        	myMult.type = returnType(left, right);
        	return myMult;
        }
	}
	
	public Type returnType(Expression left, Expression right) {
		
		if (left == Type.FloatT || right == Type.FloatT) {
			return Type.FloatT;
		}
		else {
			return Type.IntT;
		}
	}
	
	
	
	
	@Override
	public Expression visitAdditive(AdditiveContext ctx) {

        Expression left = this.visit(ctx.getChild(0));
        Expression right = this.visit(ctx.getChild(1));

        if (ctx.op.getType() == Grammar.) {
            Grammar.PLUS: return new Additive(left, right, "+");
        }
        else {
            Grammar.MINUS: return new Additive(left, right, "-");
        }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	public Expression visitPar(ParContext ctx) {
		Expression Child = visit(ctx.getChild(0));
		return new ParExpr(Child);
	}
	
	public Expression visitAtom(AtomContext ctx) {
		Expression Child = visit(ctx.getChild(0));
		return new Atom(Child);
	}
	
	@Override
	public Expression visitId(IdContext ctx) {
		
		Token idToken = ctx.ID().getSymbol(); 
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		
		String id = ctx.getChild(0).getText(); 
	//	String Type = RetrieveSymbol(id).getType; //Retrieve id & type from symbol table
 		if(!vars.contains(id)) {
			semanticErrors.add("Error: variable " + id + " not declared ("+ line + ", " + column + ")");
		}
		return new Variable(id);
	}

	@Override
	public Expression visitPow(PowContext ctx) {
		Expression right = visit(ctx.getChild(0)); 
		Expression left = visit(ctx.getChild(0)); 
		return new Power(left, right);
	}
	
	@Override
	public Expression visitUnaryMinus(UnaryMinusContext ctx) {
		Expression child = visit(ctx.getChild(0)); 
		return new UnaryMinus(child);
	}
	
	@Override
	public Expression visitInt(IntContext ctx) {
		String numText = ctx.getChild(0).getText();
		int num =  Integer.parseInt(numText);
		return new Int_Type(num);
	}
	
	@Override
	public Expression visitFloat(FloatContext ctx) {
		String numText = ctx.getChild(0).getText();
		float num = Float.valueOf(numText);	
		return new Float_Type(num);
	}
}