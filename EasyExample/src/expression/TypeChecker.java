package expression;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import BooleanOperations.OrExpr;
import antlr.ExprBaseVisitor;
import antlr.ExprParser.OrExprContext;


public class TypeChecker extends ExprBaseVisitor<Expression> {
	// Given that all visit_* methods are called in a top down fashion
	// We can be sure that the order in which we add declared variables
	// in the 'vars' is identical to how they are declared in input program
	
	private SymbolTable ST;
	
	private List<String> vars; // stores all variable in program so far
	private List<String> semanticErrors; // 1. Duplicate declarations 2. Reference to undeclared variable 

	public TypeChecker(List<String> semanticErrors) {
		vars = new ArrayList<>();
		this.semanticErrors = semanticErrors;
		ST = new SymbolTable();
	}
	
	
	@Override
	public Expression visitOrExpr(OrExprContext ctx) {
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
		
		if (left.type == Type.boolT && right.type == Type.boolT) {
			return new OrExpr(Type.boolT);
		}
		semanticErrors.add("expressions on either side of || or && must evaluate to true");
		
		return Type.ErrorT;
	}
	
	@Override
	public Expression visitAndExpr(AndExprContext ctx) {
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
		
		if (left.type == Type.boolT && right.type == Type.boolT) {
			Expression AndExpr = new AndExpr(left, right);
			AndExpr.type = Type.boolT;
			return AndExpr;
		}
		semanticErrors.add("expressions on either side of || or && must evaluate to true");
		
		return Type.ErrorT;
	}
	
	public Expression visitequalityExpr(EqualityExprContext ctx) {
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
		
		if (left.type.equals(right.type)) {
			EqualityExpr EqExpr = new EqualityExpr(left, right);
			EqExpr.type = Type.boolT;
			return EqExpr;
		}
		semanticErrors.add("values used in equality expressions must be of the same type");
		
		return Type.ErrorT;
	}
	
	public Expression visitRelationalExpr(RelationalExprContext ctx) {
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
		
		if ((left.type == Type.FloatT || left.type == Type.IntT) && (right.type == Type.FloatT || right.type == Type.IntT)) {
			
			RelationalExpr ReExpr = new RelationalExpr(left, right); 
			ReExpr.type = Type.boolT;
			return ReExpr;
		}
		semanticErrors.add("values used in relational expressions must be of type int or float");
		
		return Type.ErrorT;
	}
	
	@Override
	public Expression visitDeclaration(DeclarationContext ctx) {

		Token idToken = ctx.ID().getSymbol(); // equivalent to: ctx.getChild(0).getSymbol()
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		
		Expression V = visit(ctx.ID());
		Expression E = visit(ctx.expr());
		
		if (V instanceof Int_Type)
		{
			
		}
		Type vType = (Type) V;
		Type eType = (Type) E;
		
		String id = ctx.ID().getText();
		// maintaining the vars list for semantic error reporting
	
		if (!eType.equals(vType))
			semanticErrors.add("Error: ID does not match type at decleration on line" + line+", " + column + ")");
		
		else if (vars.contains(id))
			semanticErrors.add("Error: variable " + id + " already declared ("+ line + ", " + column + ")");
		
		else if (eType.equals(vType) && !vars.contains(id)) {
			ST.enterNode((Variable) V);
		}
		
		return Type.ErrorT;
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
        	Multiplication mydiv = new Multiplication(left, right, "/");
        	mydiv.type = returnType(left, right);
        	return mydiv;
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
		
		
        Expression left = (Type) visit(ctx.getChild(0));
        Expression right = (Type) visit(ctx.getChild(2));
        
        if (ctx.op == null) {
            throw new UnsupportedOperationException("An operator of + or - is required to perform the operation");
        }
        String operator = ctx.op.getText();

        if (operator == "+") {
        	Additive myAdd = new Additive(left, right, "+");
        	myAdd.type = returnType(left, right);
        	return myAdd;
        }
        else {
        	Additive mySub = new Additive(left, right, "-");
        	mySub.type = returnType(left, right);
        	return mySub;
        }
	}

	public Expression visitAtom(AtomContext ctx) {
		Token idToken = ((TerminalNode) ctx.getChild(0)).getSymbol(); // equivalent to: ctx.getChild(0).getSymbol()
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		Expression Child = (Type) visit(ctx.getChild(0));
		
		System.out.print("Tester!!!");
		
		Atom myAtom = new Atom(Child);
		
		if(Child.type == Type.IntT)
			myAtom.type = Type.IntT;
		
		else if(Child.type == Type.FloatT)
			myAtom.type = Type.FloatT;
		
		else if(Child.type == Type.boolT)
			myAtom.type = Type.boolT;
		else
			semanticErrors.add("Token does not consist of valid type line:" + line + " column: " + column);

		return myAtom;
	}

	public Expression visitPar(ParContext ctx) {
	List<Expression> myExpr = new ArrayList<Expression>();
	int count = 0;
	
		if (ctx.getChildCount() == 1) {
			Expression Expr = (Type) visit(ctx.getChild(0));
			ParExpr myParExpr = new ParExpr(Expr);
			myParExpr.type = Expr.type;
			return myParExpr;
		}
		else {
			for(int i=0; i < ctx.getChildCount()-1; i++) 
			{
				Expression Expr = (Type) visit(ctx.getChild(i));
				myExpr.add(Expr);
			}	
			for (int i = 0; i < ctx.getChildCount()-2; i++ ) {
				if (myExpr.get(i).type == myExpr.get(i++).type) {
					count++;
				}
			}
			if (count == ctx.getChildCount()-1) {
				ParExpr myParExpr = new ParExpr(myExpr);
				myParExpr.type = myExpr.get(0).type;
			}
			else {
				if (myExpr.contains(Type.FloatT)) {
					ParExpr myParExpr = new ParExpr(myExpr);
					myParExpr.type = Type.FloatT;
					myParExpr.toString();
					return myParExpr;
				}
			}
		}
		return Type.ErrorT;
	}

    @Override
    public Expression visitUnaryMinus(UnaryMinusContext ctx) {
        Expression child = (Type) visit(ctx.getChild(0));
        UnaryMinus myUminus = new UnaryMinus(child);

        if (child == Type.FloatT) {
            myUminus.type = Type.FloatT;
            return myUminus;
        }
        else if (child == Type.IntT) {
            myUminus.type = Type.IntT;
            return myUminus;
        }
        
        semanticErrors.add("unary minus only on floats or ints");
        return Type.ErrorT;
    }

	@Override
	public Expression visitPow(PowContext ctx) {
        Expression right = (Type)visit(ctx.getChild(0)); 
        Expression left = (Type)visit(ctx.getChild(0));

        if (right != null && left != null) {
            Power myPower = new Power(left, right);
            myPower.type = returnType(left, right);
            return myPower;
        }
    return Type.ErrorT;
    }

	@Override
	public Expression visitId(IdContext ctx) {
		
		Token idToken = ctx.ID().getSymbol(); 
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		
		String id = ctx.getChild(0).getText(); 
		Type vType = ST.retrieveNode(id).type ; //Retrieve id & type from symbol table
 		if(!vars.contains(id)) {
			semanticErrors.add("Error: variable " + id + " not declared ("+ line + ", " + column + ")");
		}
 		Variable myVar = new Variable(id);
	    myVar.type = vType; // decoration
	    
	    System.out.print("!");
 		
		return myVar;
	}

	@Override
	public Expression visitInt(IntContext ctx) {
		String numText = ctx.getChild(0).getText();
		int num =  Integer.parseInt(numText);
		
		Int_Type myInt = new Int_Type(num);
		
		
	     myInt.type = Type.IntT;  // decoration
	     return myInt;

	}

	@Override
	public Expression visitFloat(FloatContext ctx) {
		String numText = ctx.getChild(0).getText();
		float num =  Float.valueOf(numText);
		
	    Float_Type myFloat = new Float_Type(num);
		
		
	     myFloat.type = Type.FloatT;  // decoration
	     return myFloat;
	}
}