package expression;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.ExprBaseVisitor;
import antlr.ExprParser;
import antlr.ExprParser.AdditionContext;
import antlr.ExprParser.DeclContext;
import antlr.ExprParser.DivisionContext;
import antlr.ExprParser.DoubleContext;
import antlr.ExprParser.EqualityExprContext;
import antlr.ExprParser.MultiplicationContext;
import antlr.ExprParser.Neural_networkContext;
import antlr.ExprParser.PrintContext;
import antlr.ExprParser.ReadContext;
import antlr.ExprParser.RelationalExprContext;
import antlr.ExprParser.SetupContext;
import antlr.ExprParser.StringContext;
import antlr.ExprParser.SubtractionContext;
import antlr.ExprParser.TrainContext;
import antlr.ExprParser.ValueContext;
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
	
	private Map<String, TrainingSet> DataSets = new HashMap<String, TrainingSet>();
	
	
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

        // used to compare floating point numbers
        final double SMALL_VALUE = 0.00000000000001;

        switch(ctx.op.getType()) 
        {
        case ExprParser.EQ: 
        	if (left.isDouble() && right.isDouble())
        		return new RelationalExpr(Math.abs(left.asDouble() - right.asDouble()) < SMALL_VALUE);
        	else if (!left.isDouble() && !right.isDouble())
        		return new RelationalExpr(left.asInt() == right.asInt());
        	else if (left.isDouble() && !right.isDouble())
        		return new RelationalExpr(Math.abs(left.asDouble() - right.asInt()) < SMALL_VALUE);
        	else if (!left.isDouble() && right.isDouble())
        		return new RelationalExpr(Math.abs(left.asInt() - right.asDouble()) < SMALL_VALUE);			
        case ExprParser.NEQ: 
        	if (left.isDouble() && right.isDouble()) 
        		return new RelationalExpr(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE);
        	else if (!left.isDouble() && !right.isDouble())
        		return new RelationalExpr(left.asInt() == right.asInt());
        	else if (left.isDouble() && !right.isDouble())
        		return new RelationalExpr(Math.abs(left.asDouble() - right.asInt()) < SMALL_VALUE);
        	else if (!left.isDouble() && right.isDouble())
        		return new RelationalExpr(Math.abs(left.asInt() - right.asDouble()) < SMALL_VALUE);
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
        
        else if (left.isString() && right.isString())
            return new Addition(left.toString() + right.toString());

        else if (!left.isString() && right.isString())
        throw new RuntimeException("Strings skal lægges til strings");

        else if (left.isString() && !right.isString())
        throw new RuntimeException("Strings skal lægges til strings");
        
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
        		throw new RuntimeException("Man må ikke dividere med 0");
        	}
        	return new Division(left.asDouble() / right.asDouble());
        }
        else
        	if (right.asInt() == 0)
        	{
        		throw new RuntimeException("Man må ikke dividere med 0");
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
    
    public static double[] getRandom(double[][] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    
    public static double[] getExpected(double[] array) {
    	double[][] Expected = {{0.1,0.3,0.5}, {0.2,0.4,0.6}, {0.1,0.5,0.9}, {0.2,0.5,0.7}};
        if (array[0] == 1 && array[1] == 0)
        	return Expected[0];
        else if  (array[0] == 0 && array[1] == 1)
        	return Expected[1];
        else if (array[0] == 1 && array[1] == 1)
        	return Expected[2];
        else if (array[0] == 0 && array[1] == 0)
        	return Expected[3];
		return null;
    }
    
    @Override
    public Expression visitNeural_network(Neural_networkContext ctx) {
    	String id = ctx.ID().getText();
    	int input = Integer.valueOf(ctx.INT(0).getText());
    	int hidden = Integer.valueOf(ctx.INT(1).getText());
    	int output = Integer.valueOf(ctx.INT(2).getText());
    	
    	Expression NeuralNetwork = new NN(input, hidden, output);
    	
    	return memory.put(id, NeuralNetwork);
    }
    
    @Override
    public Expression visitSetup(SetupContext ctx) {
    	
    	List<Double> Inputs = new ArrayList <Double>();
    	List<Double> Expected = new ArrayList <Double>();
    	
    	for (int i = 0; ctx.array(0).value().size() > i; i++)
    		Inputs.add(Double.valueOf(ctx.array(0).value(i).getText()));
    		
    	for (int i = 0; ctx.array(1).value().size() > i; i++)
			Expected.add(Double.valueOf(ctx.array(1).value(i).getText()));
    	
    	String actfunc = ctx.ACTFUNC().getText();
    	String id = ctx.ID().getText();
    	
    	TrainingSet mySet = new TrainingSet(Inputs, Expected);
    	
    	return DataSets.put(id, mySet); 
    }
    
    public double[] ToArray(List<Double> list) {
		return list.stream().mapToDouble(d -> d).toArray();
    }
    
    
    @Override
    public Expression visitTrain(TrainContext ctx) {
        int epochs = Integer.valueOf(ctx.epochs().INT().getText());
        String id = ctx.ID().getText();
        NN NeuralNetwork = (NN) memory.get(id);
        
        double[] input = ToArray(DataSets.get(id).input);
        double[] target = ToArray(DataSets.get(id).target);
        
       
          	for (int j = 0; j<epochs; j++) {
    		
            NeuralNetwork.train(input, target);		
    	}
    	
        for (int i = 0; i<1; i++) {
    	   System.out.println("input:" + Arrays.toString(input) + " expected: " +
    	   Arrays.toString(target) + " Output: " + Arrays.toString(NeuralNetwork.feedforward(input)));
       }
        return super.visitTrain(ctx);
    }


    public Expression visitRead(ReadContext ctx) {
        try {
            String left = ctx.getChild(2).getText();
            String right = ctx.getChild(4).getText();
            left = left.substring(1,left.length()-1);
            right = right.substring(1, right.length()-1);
            File myFile = new File(left);

            Scanner myFileReader = new Scanner(myFile);
            myFileReader.useDelimiter(right);
            int index = 0;
            List Inputdata = new ArrayList<Double>();


            while(myFileReader.hasNextLine())
            {
                Inputdata.add(Double.parseDouble(myFileReader.next()));
                System.out.println(Inputdata.get(index));
                index++;
            }
            System.out.println(Inputdata.get(4).getClass());
            myFileReader.close();
        return null;
        }
        catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke");
        return null;
        }
    }
    
    //basic atom overrides
    @Override
    public Expression visitInt(IntContext ctx) {
        return new Number(Integer.valueOf(ctx.getText()));
    }
    
    @Override
    public Expression visitString(StringContext ctx) {
        String value = ctx.getText();
        value = value.substring(1, value.length() - 1).replace("\"\"", "\"");
        return new String_type(value);
    } 

    
    @Override
    public Expression visitDouble(DoubleContext ctx) {
        return new Number(Double.valueOf(ctx.getText()));
    }

}

/*
double[][] Input = {{1,0}, {0,1}, {1,1}, {0,0}};

double[][] Expected = {{0.1,0.3,0.5}, {0.2,0.4,0.6}, {0.1,0.5,0.9}, {0.2,0.5,0.7}};

NN NeuralNetwork = new NN(2,3,3);
*/



