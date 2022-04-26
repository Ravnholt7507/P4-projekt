package expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;

import antlr.ExprBaseVisitor;
import antlr.ExprParser;
import antlr.ExprParser.AdditionContext;
import antlr.ExprParser.DeclContext;
import antlr.ExprParser.DivisionContext;
import antlr.ExprParser.DoubleContext;
import antlr.ExprParser.EqualityExprContext;
import antlr.ExprParser.MultiplicationContext;
import antlr.ExprParser.PrintContext;
import antlr.ExprParser.RelationalExprContext;
import antlr.ExprParser.SubtractionContext;
import antlr.ExprParser.TrainContext;
import antlr.ExprParser.VariableContext;
import antlr.ExprParser.While_statContext;
import antlr.ExprParser.Condition_blockContext;
import antlr.ExprParser.If_statContext;
import antlr.ExprParser.IntContext;
import antlr.ExprParser.AndExprContext;
import antlr.ExprParser.OrExprContext;

import ArithmaticOperations.*;
import BooleanOperations.*;
import Statements.If_stat;
import Statements.While_stat;
import Types.*;

public class EvalVisitor extends ExprBaseVisitor<Expression> {
    // store variables (there's only one global scope!)
    private Map<String, Expression> memory = new HashMap<String, Expression>();

	public List<String> semanticErrors;
	
	public EvalVisitor() {
		memory = new HashMap<String, Expression>();
		semanticErrors = new ArrayList<String>();
	}
	
    @Override
    public Expression visitDecl(DeclContext ctx) {
        String id = ctx.ID().getText();
        Expression value = this.visit(ctx.expr());
        return memory.put(id, value);
    }

    
    
    //Boolean operations visitor
    @Override
    public Expression visitAndExpr(AndExprContext ctx) {
        Expression left = this.visit(ctx.expr(0));
        Expression right = this.visit(ctx.expr(1));
        return new AndExpr(left.asBoolean() && right.asBoolean());
    }

    @Override
    public Expression visitOrExpr(OrExprContext ctx) {
        Expression left = this.visit(ctx.expr(0));
        Expression right = this.visit(ctx.expr(1));
        return new OrExpr(left.asBoolean() || right.asBoolean());
    }
    
    @Override
    public Expression visitRelationalExpr(RelationalExprContext ctx) {
        Expression left = this.visit(ctx.expr(0));
        Expression right = this.visit(ctx.expr(1));
        
        switch(ctx.op.getType()) 
        {
        case ExprParser.LT: 
        	return new RelationalExpr(left.asDouble() < right.asDouble());
        case ExprParser.LTEQ: 
        	return new RelationalExpr(left.asDouble() <= right.asDouble());
        case ExprParser.GT: 
        	return new RelationalExpr(left.asDouble() > right.asDouble());
        case ExprParser.GTEQ: 
        	return new RelationalExpr(left.asDouble() >= right.asDouble());
        default:
            throw new RuntimeException("unknown operator: " + ExprParser.tokenNames[ctx.op.getType()]);
        }
    }

    @Override
    public Expression visitEqualityExpr(EqualityExprContext ctx) {
        Expression left = this.visit(ctx.expr(0));
        Expression right = this.visit(ctx.expr(1));
        
        switch(ctx.op.getType()) 
        {
        case ExprParser.EQ: 
        	return new RelationalExpr(left.asDouble() == right.asDouble());
        case ExprParser.NEQ: 
        	return new RelationalExpr(left.asDouble() != right.asDouble());
        default:
            throw new RuntimeException("unknown operator: " + ExprParser.tokenNames[ctx.op.getType()]);
        }
    }
    
    
    //Arithmetic operations visitor
	@Override
	public Expression visitMultiplication(MultiplicationContext ctx) {

        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        
        if (left.isDouble() && right.isDouble())
        	return new Multiplication(left.asDouble()  * right.asDouble());
        
        else if (left.isDouble() && !right.isDouble())
        	return new Multiplication(left.asDouble() * right.asInt());
        
        else if (!left.isDouble() && right.isDouble())
        	return new Multiplication(left.asInt() * right.asDouble());
        
        else
        	return new Multiplication(left.asInt() * left.asInt());
	}

	@Override
	public Expression visitAddition(AdditionContext ctx) {

        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        
        if (left.isDouble() && right.isDouble())
        	return new Addition(left.asDouble()  + right.asDouble());
        
        else if (left.isDouble() && !right.isDouble())
        	return new Addition(left.asDouble() + right.asInt());
        
        else if (!left.isDouble() && right.isDouble())
        	return new Addition(left.asInt() + right.asDouble());
        
        else
        	return new Addition(left.asInt() + left.asInt());
	}
	
	@Override
	public Expression visitDivision(DivisionContext ctx) {

        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        
        
        
        if (left.isDouble() || right.isDouble()) {
        	if (right.asDouble() == 0)
        	{
        		throw new RuntimeException("Man m� ikke dividere med 0");
        	}
        	return new Division(left.asDouble() / right.asDouble());
        }
        else
        	if (right.asInt() == 0)
        	{
        		throw new RuntimeException("Man m� ikke dividere med 0");
        	}
        return new Division(left.asInt() / right.asInt());
	}
	
	@Override
	public Expression visitSubtraction(SubtractionContext ctx) {

        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        
        if (left.isDouble() && right.isDouble())
        	return new Subtraction(left.asDouble()  - right.asDouble());
        
        else if (left.isDouble() && !right.isDouble())
        	return new Subtraction(left.asDouble() - right.asInt());
        
        else if (!left.isDouble() && right.isDouble())
        	return new Subtraction(left.asInt() - right.asDouble());
        
        else
        	return new Subtraction(left.asInt() - left.asInt());
	}

	@Override
	public Expression visitVariable(VariableContext ctx) {
        String id = ctx.getText();
        Expression value = memory.get(id);
        
        if(value == null) {
            throw new RuntimeException("Ingen variabler i hukommelsen med det navn: " + id);
        }
        return value;
    }
	
	
    // log override
    @Override
    public Expression visitPrint(PrintContext ctx) {
        Expression value = this.visit(ctx.expr());
        System.out.println(value.value);
        return value;
    }
	
    
    // if override
    @Override
    public Expression visitIf_stat(If_statContext ctx) {

        List<Condition_blockContext> conditions = ctx.condition_block();

        boolean evaluatedBlock = false;

        for(Condition_blockContext condition : conditions) {

            Expression evaluated = this.visit(condition.expr());

            if((Boolean) evaluated.value) {
                evaluatedBlock = true;
                // evaluate this block whose expr==true
                this.visit(condition.stat_block());
                break;
            }
        }

        if(!evaluatedBlock && ctx.stat_block() != null) {
            // evaluate the else-stat_block (if present == not null)
            this.visit(ctx.stat_block());
        }

        return If_stat.VOID;
    }
    
    // while override
    public Expression visitWhile_stat(While_statContext ctx) {

        Expression value = this.visit(ctx.expr());

        while(value.asBoolean()) {

            // evaluate the code block
            this.visit(ctx.stat_block());

            // evaluate the expression
            value = this.visit(ctx.expr());
        }

        return While_stat.VOID;
    }
    
    
    //basic atom overrides
    @Override
    public Expression visitInt(IntContext ctx) {
        return new Number(Integer.valueOf(ctx.getText()));
    }
    
    
    @Override
    public Expression visitDouble(DoubleContext ctx) {
        return new Number(Double.valueOf(ctx.getText()));
    }
	
    @Override
    public Expression visitTrain(TrainContext ctx) {

        String actfunc = ctx.trainParams().ACTFUNC().getText();
        int epochs = Integer.valueOf(ctx.trainParams().epochs().getText());
        Object input_array[] = ctx.trainParams().array().getTokens(ctx.trainParams().array().getChildCount()).toArray();
        
        System.out.print("test");

        Object weight_array[];
        weight_array = new Object[input_array.length];
        
        for (int i = 0; i < input_array.length; i++){
            weight_array[i] = 0.5;
        }
        System.out.print(epochs);
        for(int i = 0; i < epochs; i++){
            feedforward(input_array, weight_array);
            //backpropagate()
        }
        return super.visitTrain(ctx);
    }
    public double feedforward(Object[] input_array, Object[] weight_array){
        double result = 0;
        result = Sigmoid(Dotproduct(input_array, weight_array));
        System.out.print("ff");
        return result;  
    }
        public double Sigmoid(Object dotProduct){
        	 System.out.print("sigmoid");
        return (1/( 1 + Math.pow(Math.E,(-1*(double)dotProduct))));
    }
    public double Dotproduct(Object[] a, Object[] b){
        if (a.length != b.length) {
            throw new IllegalArgumentException(
                    "Error computing dotProduct in Utilities.dotProduct: arrays should have the same length");
        }
        double sp = 0;
        for (int i = 0; i < a.length; i++) {
            for(int j = 0; j < b.length; j++) {
                sp += (double) a[i] * (double) b[j];
            }
        }
        System.out.print("dotp");
        return sp;
    }
}

