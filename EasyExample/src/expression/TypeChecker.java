package expression;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.TerminalNode;

import ArithmaticOperations.Multiplication;
import BooleanOperations.AndExpr;
import BooleanOperations.EqualityExpr;
import BooleanOperations.OrExpr;
import BooleanOperations.RelationalExpr;
import Types.Boolean_Type;
import Types.Dataset;
import Types.Double_Type;
import Types.Error_Type;
import Types.Int_Type;
import Types.NN_Type;
import Types.String_type;
import antlr.ExprBaseVisitor;
import antlr.ExprParser.AndExprContext;
import antlr.ExprParser.BoolContext;
import antlr.ExprParser.DatasetContext;
import antlr.ExprParser.DeclContext;
import antlr.ExprParser.DoubleContext;
import antlr.ExprParser.EqualityExprContext;
import antlr.ExprParser.FunctionDeclContext;
import antlr.ExprParser.If_statContext;
import antlr.ExprParser.IntContext;
import antlr.ExprParser.MultiOpContext;
import antlr.ExprParser.Neural_networkContext;
import antlr.ExprParser.OrExprContext;
import antlr.ExprParser.PredictContext;
import antlr.ExprParser.Read_image_dataContext;
import antlr.ExprParser.RelationalExprContext;
import antlr.ExprParser.SetupContext;
import antlr.ExprParser.StringContext;
import antlr.ExprParser.TrainContext;
import antlr.ExprParser.VariableContext;
import antlr.ExprParser.While_statContext;
import antlr.ExprParser.AdditiveOpContext;;


public class TypeChecker extends ExprBaseVisitor<Expression> {
	// Given that all visit_* methods are called in a top down fashion
	// We can be sure that the order in which we add declared variables
	// in the 'vars' is identical to how they are declared in input program

	private Map<String, Expression> SymbolTable = new HashMap<String, Expression>();
	public List<String> semanticErrors; // 1. Duplicate declarations 2. Reference to undeclared variable 

	public TypeChecker(ArrayList<String> semanticErrors) {
		this.semanticErrors = semanticErrors;
	}
	
	@Override
	public Expression visitOrExpr(OrExprContext ctx) {
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();

		if (left.type == Type.BoolT && right.type == Type.BoolT) {
			return new OrExpr(Type.BoolT);
		}
		semanticErrors.add("Error: Expressions on either side of || or && must be of type bool (" + "Line: " + line + ", " + "Col: " + col + ")");
		
		return new Error_Type(Type.ErrorT);
	}
	
	@Override
	public Expression visitAndExpr(AndExprContext ctx) {
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		if (left.type == Type.BoolT && right.type == Type.BoolT) {
			return new AndExpr(Type.BoolT);
		}
		semanticErrors.add("Expressions on either side of || or && must be of type bool (" + line + ", " + col + ")");
		
		return new Error_Type(Type.ErrorT);
	}
	
	public Expression visitEqualityExpr(EqualityExprContext ctx) {
		Expression left = visit(ctx.getChild(0));		
		Expression right = visit(ctx.getChild(2));
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		if (left.type.equals(right.type)) {
			return new EqualityExpr(Type.BoolT);
		}
		
		if ((left.type == Type.DoubleT && right.type == Type.IntT)) {
			return new EqualityExpr(Type.BoolT);
		}
		
		if ((left.type == Type.IntT && right.type == Type.DoubleT)) {
			return new EqualityExpr(Type.BoolT);
		}
		
		if(left.type == Type.StringT && right.type == Type.StringT) {
			return new EqualityExpr(Type.BoolT);
		}
		semanticErrors.add("Error: Values used in equality are not compatible (" + line + ", " + col+")");
		return new Error_Type(Type.ErrorT);
	}
	
	public Expression visitRelationalExpr(RelationalExprContext ctx) {
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		Expression left = visit(ctx.getChild(0));
		Expression right = visit(ctx.getChild(2));
	
		if ((left.type == Type.DoubleT || left.type == Type.IntT) && (right.type == Type.DoubleT || right.type == Type.IntT)) {
			return new RelationalExpr(Type.BoolT);
		}
		semanticErrors.add("Error: Values used in relational expressions must be of type int or float (" + line +", " + col + ")"  );
		
		return new Error_Type(Type.ErrorT);
	}
	
	@Override
	public Expression visitDecl(DeclContext ctx) {
		Token idToken = ctx.ID().getSymbol(); // equivalent to: ctx.getChild(0).getSymbol()
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		
		Expression Expr = visit(ctx.expr());		
		String id = ctx.ID().getText();
		
		Variable var = new Variable(Expr.type);

		if (SymbolTable.containsKey(id)) {
			if (!Expr.type.equals(SymbolTable.get(id).type)) {
				semanticErrors.add("Error: variable " + id + " already declared ("+ line + ", " + column +")" 
								   + "\n implicit type conversion illegal");				
			}		
		}
		
		SymbolTable.put(id, var);
		
		return null;
	}
	
	@Override
	public Expression visitMultiOp(MultiOpContext ctx) {
		Expression left = (Type) visit(ctx.getChild(0));
		Expression right = (Type) visit(ctx.getChild(2));
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		if(!(left.type == Type.DoubleT || left.type == Type.IntT) || !(right.type == Type.DoubleT || right.type == Type.IntT)) {
			semanticErrors.add("Error: values used in must be of type int or float (" + "Line: " + line + ", " + "Col: " + col + ")");
		}
		
        if (ctx.op == null) {
            throw new UnsupportedOperationException("Error: An operator of / or * is required to perform the operation (" +"Line: "+ line + ", " + "Col: "+ col);
        }
        String operator = ctx.op.getText();    
        if (operator == "/") {
        	return Type.DoubleT;
        }
        else {
        	return returnType(left, right);
        }
	}

	public Expression returnType(Expression left, Expression right) {

		if (left.type == Type.DoubleT || right.type == Type.DoubleT)
			return new Double_Type(Type.DoubleT);
		if(left.type == Type.IntT || right.type == Type.IntT)
			return new Int_Type(Type.IntT);
		if (left.type.equals(right.type))
			return new Double_Type(Type.DoubleT);
		
		return new Error_Type(Type.ErrorT);
	}
	
	@Override
	public Expression visitAdditiveOp(AdditiveOpContext ctx) {
        Expression left = visit(ctx.getChild(0));
        Expression right = visit(ctx.getChild(2));
        
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
        
        if (ctx.op == null) {
            throw new UnsupportedOperationException("Error: An operator of + or - is required to perform the operation ( "+"Line: "+line+", "+" Col: "+ col+")");
        }
        
        // Make sure left and right expressions are correct
        if (!left.type.equals(Type.IntT) && !left.type.equals(Type.DoubleT) && !left.type.equals(Type.StringT) && 
        	!right.type.equals(Type.IntT) && !right.type.equals(Type.DoubleT) && !right.type.equals(Type.StringT)) {
        	semanticErrors.add("Error: Types for arithmetic operation not correct (" +"Line: " + line + ", " + "Col: " + col + ")");
        	return new Error_Type(Type.ErrorT);
        }
        else {
        	return returnType(left, right);
        }
	}
	
	public Expression visitIf_stat(If_statContext ctx) {
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		Expression expr = visit(ctx.condition_block(0).expr());
	    if (! expr.type.equals(Type.BoolT)) // Find expression type 
	        semanticErrors.add("Error: Boolean expression expected here ( " + "Line: " + line + ", " + "Col: " + col + ")");
	    visit(ctx.condition_block(0).stat_block()); //Visit first command from if
	    if (ctx.stat_block() != null)
	    	visit(ctx.stat_block()); //Visit second command from else (if it exists)
		return null;
	}
	
	public Expression visitWhile_stat(While_statContext ctx) {
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
	    Expression expr = visit(ctx.expr());
	    if (!expr.type.equals(Type.BoolT)) // Conditional expression must evaluate to bool type
	      semanticErrors.add("Error: Boolean expression expected here ( " + "Line: " + line + ", "+ "Col: " + col + ")");
	    visit(ctx.stat_block());
	    return null;
	}
 	
	public Expression visitDataset(DatasetContext ctx) {
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
    	String id = ctx.ID().getText();
    	Expression Set = new Dataset(Type.DataSetT);
    	
		if(SymbolTable.containsKey(id)) {
			semanticErrors.add("Error: Dataset " + id + " already declared ( " + "Line: " + line + ", " + "Col: " + col + ")");
		}
		if(!SymbolTable.containsKey(id)) {
			SymbolTable.put(id,Set);
		}
		return null;
	}
	
	public Expression visitRead_image_data(Read_image_dataContext ctx) {
		String DatasetID = ctx.ID().getText();
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		if (!SymbolTable.containsKey(DatasetID)) {
			semanticErrors.add("Error: Neural network with id: " + DatasetID + "not declared ( " + "Line: " + line + ", " + "Col: " + col + ")");
		}
		Expression DataSet =  SymbolTable.get(DatasetID);
		if (!DataSet.type.equals(Type.DataSetT)) {
			semanticErrors.add("Error: incompatible types: ReadImageData must be used with type Network( " + "Line: " + line + ", " + "Col: " + col + ")");
		}
		String InputStringID = ctx.atom(0).getText();
		String OutputStringID = ctx.atom(1).getText();
		
		Expression InputExpr = SymbolTable.get(InputStringID);
		Expression OutputExpr = SymbolTable.get(OutputStringID);
		
		if (!(InputExpr.type.equals(Type.StringT) && OutputExpr.type.equals(Type.StringT)))
			semanticErrors.add("Error: First two parameters must be of type string ( " + "Line: " + line + ", " + "Col: " + col + ")");	
		return null;
	}
	
	@Override
	public Expression visitNeural_network(Neural_networkContext ctx) {
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		String id = ctx.ID().getText();
		Expression left = visit(ctx.atom(0));
		Expression middle = visit(ctx.atom(1));
		Expression right = visit(ctx.atom(2));  
		
		if(SymbolTable.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " already declared ( " + "Line: " + line + ", " + "Col: " + col + ")");
		}
		
		if(left.type != Type.IntT || middle.type != Type.IntT || right.type != Type.IntT){
			semanticErrors.add("Error: Values in neural network must be of type int ( " + "Line: " + line + ", " + "Col: " + col + ")");
		}
		
		Expression network = new NN_Type(Type.NetworkT);		

		SymbolTable.put(id,network);
		
		return null;
	}
	
	public Expression visitSetup(SetupContext ctx) {
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		String modelID =  ctx.ID().getText();
		String datasetID = ctx.atom(0).getText();
		Expression learningRate = visit(ctx.atom(1));

		if(!SymbolTable.containsKey(modelID) || !SymbolTable.containsKey(datasetID))
			semanticErrors.add("Error: Both Neural Network and Dataset must be defined ( " + "Line: " + line + ", " + "Col: " + col + ")");
		
		if(!SymbolTable.get(modelID).type.equals(Type.NetworkT)) 
			semanticErrors.add("Error: Variable" + modelID + "Must be of type model ( " + "Line: " + line + ", " + "Col: " + col + ")" );		
		
		if (!SymbolTable.get(datasetID).type.equals(Type.DataSetT))
			semanticErrors.add("Error: Variable" + datasetID + "Must be of type dataset ( " + "Line: " + line + ", " + "Col: " + col + ")" );	
		
		if(!learningRate.type.equals(Type.DoubleT)) {
			semanticErrors.add("Error: Value must be of type double ( " + "Line: " + line + ", " + "Col: " + col + ")");
		}
		
		return null;
	}
	
	public Expression visitTrain(TrainContext ctx) {
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		String id =  ctx.ID().getText();
		Expression epochs = visit(ctx.expr());

		if(!SymbolTable.containsKey(id)) {
			semanticErrors.add("Error: Neural Network must be defined for train command ( " + "Line: " + line + ", " + "Col: " + col + ")");
		}

		if(!epochs.type.equals(Type.IntT)) {
			semanticErrors.add("Error: Value must be of type int ( " + "Line: " + line + ", " + "Col: " + col + ")");
		}
		
		return null;
	}
	
	public Expression visitPredict(PredictContext ctx) {
		String modelid = ctx.ID().getText();
		String left = ctx.atom(0).getText();
		String right = ctx.atom(1).getText();
		
		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		int col = tokenid.getCharPositionInLine();
		
		
		if(!SymbolTable.containsKey(modelid) || !SymbolTable.containsKey(left) || !SymbolTable.containsKey(right)){
			semanticErrors.add("Error: Both Neural Network and Datasets  must be defined ( " + "Line: " + line + ", " + "Col: " + col + ")");
		}
		return null;
	}
	
	public Expression visitFunctionDecl(FunctionDeclContext ctx) {
		
		return null;
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
	public Expression visitVariable(VariableContext ctx) {
		Token idToken = ctx.ID().getSymbol(); 
		int line = idToken.getLine();
		int column = idToken.getCharPositionInLine() + 1;
		
		String id = ctx.getChild(0).getText(); 
 		if(!SymbolTable.containsKey(id)) {
			semanticErrors.add("Error: variable " + id + " not declared ("+ line + ", " + column + ")");
			return new Error_Type(Type.ErrorT);
		}
	    return SymbolTable.get(id); //Retrieve id & type from symbol table
	}

	@Override
	public Expression visitInt(IntContext ctx) {
		String numText = ctx.getChild(0).getText();
		
		try {
			int num =  Integer.parseInt(numText);	
		}
        catch (Exception e) {
            System.out.println("Type error");
            return new Error_Type(Type.ErrorT);
        }
		return new Int_Type(Type.IntT);
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
            return new Error_Type(Type.ErrorT);
        }
		return new Double_Type(Type.DoubleT);
	}
	
	@Override
	public Expression visitBool(BoolContext ctx) {
		String numText = ctx.getChild(0).getText();
		if (numText.equals("true") || numText.equals("TRUE") || numText.equals("false") || numText.equals("FALSE")) {
			return new Boolean_Type(Type.BoolT);
		}
        semanticErrors.add("Type error");
        return new Error_Type(Type.ErrorT);
	}
	
	@Override
	public Expression visitString(StringContext ctx) {
		String Text = ctx.getChild(0).getText();
		if (!(Text instanceof String)) {
	        semanticErrors.add("Type error");
	        return new Error_Type(Type.ErrorT);
		}
		return new String_type(Type.StringT);
	}
}