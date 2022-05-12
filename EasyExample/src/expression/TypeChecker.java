package expression;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import ArithmaticOperations.Multiplication;
import BooleanOperations.AndExpr;
import BooleanOperations.EqualityExpr;
import BooleanOperations.OrExpr;
import BooleanOperations.RelationalExpr;
import antlr.ExprBaseVisitor;
import antlr.ExprParser.AndExprContext;
import antlr.ExprParser.DeclContext;
import antlr.ExprParser.EqualityExprContext;
import antlr.ExprParser.MultiOpContext;
import antlr.ExprParser.Neural_networkContext;
import antlr.ExprParser.OrExprContext;
import antlr.ExprParser.PredictContext;
import antlr.ExprParser.RelationalExprContext;
import antlr.ExprParser.SetupContext;
import antlr.ExprParser.TrainContext;
import antlr.ExprParser.AdditiveOpContext;;


public class TypeChecker extends ExprBaseVisitor<Expression> {
	// Given that all visit_* methods are called in a top down fashion
	// We can be sure that the order in which we add declared variables
	// in the 'vars' is identical to how they are declared in input program
	
	private SymbolTable ST;
	
	private Map<String,Expression> symboltable = new HashMap<String, Expression>();
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
			return Type.boolT;
		}
		semanticErrors.add("Expressions on either side of || or && must be of type bool");
		
		return Type.ErrorT;
	}
	
	@Override
	public Expression visitAndExpr(AndExprContext ctx) {
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
		
		if (left.type == Type.boolT && right.type == Type.boolT) {
			return Type.boolT;
		}
		semanticErrors.add("Expressions on either side of || or && must be of type bool");
		
		return Type.ErrorT;
	}
	
	public Expression visitEqualityExpr(EqualityExprContext ctx) {
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
		
		if (left.type.equals(right.type)) {
			return Type.boolT;
		}
		if ((left.type == Type.DoubleT && right.type == Type.IntT)) {
			return Type.boolT;
		}
		if ((left.type == Type.IntT && right.type == Type.DoubleT)) {
			return Type.boolT;
		}
		if(left.type == Type.StringT && right.type == Type.StringT) {
			return Type.boolT;
		}
		
		semanticErrors.add("Values used in equality are not compatible");
		
		return Type.ErrorT;
	}
	
	public Expression visitRelationalExpr(RelationalExprContext ctx) {
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
	
		if ((left.type == Type.DoubleT || left.type == Type.IntT) && (right.type == Type.DoubleT || right.type == Type.IntT)) {
			return Type.boolT;
		}
		semanticErrors.add("Values used in relational expressions must be of type int or float");
		
		return Type.ErrorT;
	}
	
	@Override
	public Expression visitDecl(DeclContext ctx) {

		Token idToken = ctx.ID().getSymbol(); // equivalent to: ctx.getChild(0).getSymbol()
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		
		Expression V = visit(ctx.ID());
		Expression E = visit(ctx.expr());

		Type eType = (Type) E; // Expr
		Type vType = (Type) E; // ID
		
		String id = ctx.ID().getText();
		// maintaining the vars list for semantic error reporting
	
		if (!eType.equals(vType)) {
			semanticErrors.add("Error: ID does not match type at decleration on line" + line+", " + column + ")");
		}
		else if (symboltable.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " already declared ("+ line + ", " + column + ")");
		}
		else if (eType.equals(vType) && !symboltable.containsKey(id)) {
			ST.enterNode((Variable) V);
			return vType;
		}
		return Type.ErrorT;
	}
	
	@Override
	public Expression visitMultiOp(MultiOpContext ctx) {
		Expression left = (Type) visit(ctx.getChild(0));
		Expression right = (Type) visit(ctx.getChild(2));
		
		if(!(left.type == Type.DoubleT || left.type == Type.IntT) || !(right.type == Type.DoubleT || right.type == Type.IntT)) {
			semanticErrors.add("values used must be of type int or float");
		}
		
        if (ctx.op == null) {
            throw new UnsupportedOperationException("An operator of / or * is required to perform the operation");
        }
        String operator = ctx.op.getText();    
        if (operator == "/") {
        	return Type.DoubleT;
        }
        else {
        	return returnType(left, right);
        }
	}

	public Type returnType(Expression left, Expression right) {
		
		if (left == Type.DoubleT || right == Type.DoubleT) {
			return Type.DoubleT;
		}
		else {
			return Type.IntT;
		}
	}
	
	@Override
	public Expression visitAdditiveOp(AdditiveOpContext ctx) {
		
        Expression left = (Type) visit(ctx.getChild(0));
        Expression right = (Type) visit(ctx.getChild(2));
        
        if (ctx.op == null) {
            throw new UnsupportedOperationException("An operator of + or - is required to perform the operation");
        }
        
        if((left.type != Type.DoubleT || left.type != Type.IntT) || (right.type != Type.DoubleT || right.type != Type.IntT)) {
        	return Type.ErrorT;
        }
        else {
        	return returnType(left, right);
        }
	}
	
	public Expression visitNeuralNetwork(Neural_networkContext ctx) {
		String id = ctx.ID().getText();
		Expression left = (Type) visit(ctx.getChild(4));
		Expression middle = (Type) visit(ctx.getChild(6));
		Expression right = (Type) visit(ctx.getChild(8));
		
		if(id == null){
			semanticErrors.add("Neural Network must be defined");
		}
		if(symboltable.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " already declared");
		}
		if(!symboltable.containsKey(id)) {
			symboltable.put(id,null);
		}
		
		if(left != Type.IntT || middle != Type.IntT || right != Type.IntT){
			semanticErrors.add("Values in neural network must be of type int");
		}
		
	}
	
	public Expression visitSetup(SetupContext ctx) {
		String modelID =  ctx.ID(0).getText();
		String datasetID = ctx.ID(1).getText();
		Expression learningRate = (Type) visit(ctx.DOUBLE());
		
		if(modelID == null || datasetID == null) {
			semanticErrors.add("Neural Network must be defined");
		}
		if(!symboltable.containsKey(modelID) || !symboltable.containsKey(datasetID)) {
			semanticErrors.add("Both Neural Network and Dataset must be defined");
		}
		if(learningRate != Type.DoubleT) {
			semanticErrors.add("Value must be of type double");
		}
	}
	
	public Expression visitTrain(TrainContext ctx) {
		String id =  ctx.ID().getText();
		Expression epochs = (Type) visit(ctx.getChild(4));
		
		if(id == null) {
			semanticErrors.add("Neural Network must be defined");
		}
		if(!symboltable.containsKey(id)) {
			semanticErrors.add("Neural Network must be defined");
		}
		
		if(epochs != Type.IntT) {
			semanticErrors.add("Value must be of type int");
		}
	}
	
	public Expression visitPredict(PredictContext ctx) {
		String modelid = ctx.ID(0).getText();
		String left = ctx.ID(1).getText();
		String right = ctx.ID(2).getText();
		
		if(modelid == null || left == null || right == null) {
			semanticErrors.add("Both Neural Network and datasets  must be defined");
		}
		if(!symboltable.containsKey(modelid) || !symboltable.containsKey(left) || !symboltable.containsKey(right)){
			semanticErrors.add("Both Neural Network and Datasets  must be defined");
		}
	}
//	public Expression visitPar(ParContext ctx) {
//	List<Expression> myExpr = new ArrayList<Expression>();
//	int count = 0;
//	
//		if (ctx.getChildCount() == 1) {
//			Expression Expr = (Type) visit(ctx.getChild(0));
//			ParExpr myParExpr = new ParExpr(Expr);
//			myParExpr.type = Expr.type;
//			return myParExpr;
//		}
//		else {
//			for(int i=0; i < ctx.getChildCount()-1; i++) 
//			{
//				Expression Expr = (Type) visit(ctx.getChild(i));
//				myExpr.add(Expr);
//			}	
//			for (int i = 0; i < ctx.getChildCount()-2; i++ ) {
//				if (myExpr.get(i).type == myExpr.get(i++).type) {
//					count++;
//				}
//			}
//			if (count == ctx.getChildCount()-1) {
//				ParExpr myParExpr = new ParExpr(myExpr);
//				myParExpr.type = myExpr.get(0).type;
//			}
//			else {
//				if (myExpr.contains(Type.DoubleT)) {
//					ParExpr myParExpr = new ParExpr(myExpr);
//					myParExpr.type = Type.DoubleT;
//					myParExpr.toString();
//					return myParExpr;
//				}
//			}
//		}
//		return Type.ErrorT;
//	}
//
//    @Override
//    public Expression visitUnaryMinus(UnaryMinusContext ctx) {
//        Expression child = (Type) visit(ctx.getChild(0));
//        UnaryMinus myUminus = new UnaryMinus(child);
//
//        if (child == Type.DoubleT) {
//            myUminus.type = Type.DoubleT;
//            return myUminus;
//        }
//        else if (child == Type.IntT) {
//            myUminus.type = Type.IntT;
//            return myUminus;
//        }
//        
//        semanticErrors.add("unary minus only on floats or ints");
//        return Type.ErrorT;
//    }
//
//	@Override
//	public Expression visitPow(PowContext ctx) {
//        Expression right = (Type)visit(ctx.getChild(0)); 
//        Expression left = (Type)visit(ctx.getChild(0));
//
//        if (right != null && left != null) {
//            Power myPower = new Power(left, right);
//            myPower.type = returnType(left, right);
//            return myPower;
//        }
//    return Type.ErrorT;
//    }

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
	    return vType;
	}

	@Override
	public Expression visitInt(IntContext ctx) {
		String numText = ctx.getChild(0).getText();
		
		try {
			int num =  Integer.parseInt(numText);	
		}
        catch (Exception e) {
            System.out.println("Type error");
            return null;
        }
		return Type.IntT;
	}

	@Override
	public Expression visitDouble(DoubleContext ctx) {
		String numText = ctx.getChild(0).getText();
		double num =  Double.valueOf(numText);
		
		try {
			num =  Double.parseDouble(numText);	
		}
        catch (Exception e) {
            System.out.println("Type error");
            return null;
        }

	     return Type.DoubleT;
	}
}