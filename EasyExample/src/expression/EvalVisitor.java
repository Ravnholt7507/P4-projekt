package expression;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import antlr.ExprBaseVisitor;
import antlr.ExprParser;
import antlr.ExprParser.Add_dataContext;
import antlr.ExprParser.AdditionContext;
import antlr.ExprParser.DeclContext;
import antlr.ExprParser.DivisionContext;
import antlr.ExprParser.DoubleContext;
import antlr.ExprParser.EqualityExprContext;
import antlr.ExprParser.ExprContext;
import antlr.ExprParser.MultiplicationContext;
import antlr.ExprParser.Neural_networkContext;
import antlr.ExprParser.PrintContext;
import antlr.ExprParser.ReadContext;
import antlr.ExprParser.Read_dataContext;
import antlr.ExprParser.Read_image_dataContext;
import antlr.ExprParser.RelationalExprContext;
import antlr.ExprParser.SetupContext;
import antlr.ExprParser.StringContext;
import antlr.ExprParser.SubtractionContext;
import antlr.ExprParser.TrainContext;
import antlr.ExprParser.ValueContext;
import antlr.ExprParser.VariableContext;
import antlr.ExprParser.While_statContext;
import antlr.ExprParser.Condition_blockContext;
import antlr.ExprParser.DatasetContext;
import antlr.ExprParser.If_statContext;
import antlr.ExprParser.IntContext;
import antlr.ExprParser.AndExprContext;
import antlr.ExprParser.ArraydeclContext;
import antlr.ExprParser.OrExprContext;
import antlr.ExprParser.PredictContext;
import ArithmaticOperations.*;
import BooleanOperations.*;
import Statements.If_stat;
import Statements.Read;
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
    
    
    //Language Specific Overrides
    
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
    	
    	String ActFunc = ctx.ACTFUNC().getText();
    	String NetworkId = ctx.ID(0).getText();
    	String DatasetId = ctx.ID(1).getText();
    	double LearningRate = Double.valueOf(ctx.DOUBLE().getText());
    	
    	Dataset set = (Dataset) memory.get(DatasetId);
    	NN Network = (NN) memory.get(NetworkId);
    	Network.setup(set, LearningRate);
    	
    	memory.replace(NetworkId, Network);
    	
    	return set; 
    }
    
    @Override
    public Expression visitTrain(TrainContext ctx) {

    	System.out.println("Starting to train... ");
        int epochs = Integer.valueOf(ctx.epochs().INT().getText());
        String id = ctx.ID().getText();
        
        NN Network = (NN) memory.get(id);
        double hitRateCounter = 0;
        
        int DataInputs = 1;
        
        DecimalFormat numberFormat = new DecimalFormat("#");
        double DEpochs = epochs;
        
        List<double[]> inputs = fromDouble2(Network.currentSet.inputs);
        List<double[]> targets= fromDouble2(Network.currentSet.targets);

        // Træner datasættet per epoke 
      	for (int j = 1; j<epochs; j++) {
      		for (int m = 0; m<DataInputs; m++)
      		Network.train(inputs.get(m), targets.get(m), j);
      		System.out.println(numberFormat.format(j/DEpochs*100) + "%");
      	}

      	
      	memory.replace(id, Network);
      	
/*        for (int i = 0; i<DataInputs; i++) {
	  		if (GetHit(helper(fromDouble(Network.currentSet.targets.get(i))), Network.feedforward(fromDouble(Network.currentSet.inputs.get(i)))) == true) 
	  			hitRateCounter += 1;
  		} 
      	System.out.println("Hitrate:  " + hitRateCounter / (double) DataInputs * 100); */
      	
        return super.visitTrain(ctx);
    }
    
    
    public boolean GetHit(int expected, double[] actual) {
    	int guess = 0;
    	double max = 0;
    	
    	for (int i =0; i < actual.length; i++) {	
    		if (actual[i] > max) 
    		{
    			max = actual[i];
    			guess = i;
    	    }
    	}
    	if (guess == expected)
    		return true;
    	else 
    		return false;
    }
    
    public int PrettyPrintGuess(double[] ds) {
    	int hit = 0;
    	double Sum = 0;
    	int guess = 0;
    	double max = 0;
    	
    	for (int i =0; i < ds.length; i++) {
    		Sum += ds[i];
    		
    		if (ds[i] > max) 
    		{
    			max = ds[i];
    			guess = i;
    	    }
    	}
    	System.out.print("Prediction: " + guess+"       |  " );
    	
    	for(int j =0; j < ds.length; j++) {
    		ds[j] = ds[j]/Sum*100;
    		System.out.printf("     " + j+ " : " + "%2d", Math.round((ds[j])/1)*1);
    		System.out.print("%");

    	}
		return hit;
    }
    
    public int helper(double[] ds) {
    	for (int i =0; i < ds.length; i++) {
    		if (ds[i] == 1.0)
    			return i;
    	}
		return 0;
    }

    @Override
    public Expression visitDataset(DatasetContext ctx) {
    	String id = ctx.ID().getText();
    	Expression NewDataSet = new Dataset();
    	return memory.put(id, NewDataSet);
    }
        
    @Override
    public Expression visitAdd_data(Add_dataContext ctx) {
    	String id = ctx.ID().getText();
		Dataset set = (Dataset) memory.get(id);
    	int TupleCount = ctx.array().size() / 2;
    	
    	System.out.print(TupleCount);
    	
    	List<Double[]> input = new ArrayList<Double[]>();
    	List<Double[]> output = new ArrayList<Double[]>();
    		
    	for (int i = 0; i < ctx.array().size(); i=i+2) {
    		Double[] TempInput = new Double[ctx.array(i).value().size()];
    		Double[] TempOutput = new Double[ctx.array(i+1).value().size()]; 
    		
    		for (int j=0; j<ctx.array(i).value().size(); j++) {
    			TempInput[j] = Double.valueOf(ctx.array(i).value(j).getText());
    		}
    		
    		for (int j=0; j<ctx.array(i+1).value().size(); j++) {
    			TempOutput[j] = Double.valueOf(ctx.array(i+1).value(j).getText());
    		}
    		
    		input.add(TempInput);
    		output.add(TempOutput);
    	}
    	
		set.addData(input, output);
		
		memory.replace(id, set);
		
    	return set;
    }
    
    @Override 
    public Expression visitPredict(PredictContext ctx) {
        String id = ctx.getChild(0).getText();
        NN Network = (NN) memory.get(id);  
        //If input is a an id
    	String path = ctx.getChild(4).getText();  	
    	Expression DataPath = memory.get(path);
    	
    	List<double[]> TestInput = fromDouble2(Dataset.ReadData((String) DataPath.value, "@", ","));
    	
    	for ( double[] input: TestInput) {
    		System.out.println(PrettyPrintGuess(Network.feedforward(input))); 
    	}
    	return Network;
    }

    @Override
    public Expression visitArraydecl(ArraydeclContext ctx) {
    	String id = ctx.ID().getText();
    
    	Double[] numbers = new Double[ctx.array().value().size()];
    	
    	for(int i = 0;i < ctx.array().value().size();i++)
    	{
    	    numbers[i] = Double.parseDouble(ctx.array().value(i).getText());
    	}

    	Expression array = new ArrayDouble_Type(numbers);
    	
    	return memory.put(id, array);
    }
    

    @Override
    public Expression visitRead_data(Read_dataContext ctx) {
    	
    	String idFile1 = ctx.getChild(4).getText();  	
    	Expression filePath1 = memory.get(idFile1);

    	String idFile2 = ctx.getChild(6).getText();  	
    	Expression filePath2 = memory.get(idFile2);
    	
    	String Delimiter1 = ctx.getChild(8).getText();
    	String Delimiter2 = ctx.getChild(10).getText();
    	
    	String id = ctx.ID(0).getText();
		Dataset set = (Dataset) memory.get(id);
		
		set.ReadDataInput((String) filePath1.value, Delimiter1, Delimiter2, "in");
		set.ReadDataInput((String) filePath2.value, Delimiter1, Delimiter2, "out");
		
    	return null;
    }
  
    
    @Override 
    public Expression visitRead_image_data(Read_image_dataContext ctx) {
    	
    	String idFile1 = ctx.ID(1).getText();  	
    	Expression filePath1 = memory.get(idFile1);

    	String idFile2 = ctx.ID(2).getText();  	
    	Expression filePath2 = memory.get(idFile2);
    	
    	String Delimiter1 = ctx.STRING(0).getText();
    	
    	String Delimiter2 = ctx.STRING(1).getText();
    	
    	String id = ctx.ID(0).getText();
		Dataset set = (Dataset) memory.get(id);
    	
    	set.Run((String) filePath1.value, (String) filePath2.value, Delimiter1, Delimiter2);
    	
    	return null;
    }
    
    @Override
    public Expression visitRead(ReadContext ctx) {
        try {
            String Directory = ctx.getChild(2).getText();
            String StringDelimiter = ctx.getChild(4).getText();
            String DoubleDelimiter = ctx.getChild(6).getText();
            Directory = Directory.substring(1,Directory.length()-1);
            StringDelimiter = StringDelimiter.substring(1,StringDelimiter.length()-1);
            DoubleDelimiter = DoubleDelimiter.substring(1, DoubleDelimiter.length()-1);

            File myFile = new File(Directory);
            Scanner myFileReader = new Scanner(myFile);
            myFileReader.useDelimiter(StringDelimiter);

            List<double[]> Inputdata = new ArrayList<double[]>();

            while(myFileReader.hasNextLine())
            {
                List<Double> innerList = new ArrayList<Double>();

                String ReadNext = new String(myFileReader.next());
                String[] SplitLine = ReadNext.split(DoubleDelimiter);

                for ( int i = 0; i < SplitLine.length; i++) 
                {
                    innerList.add(Double.parseDouble(SplitLine[i]));
                }
                double[] ToarraY = innerList.stream().mapToDouble(d -> d).toArray();;
                Inputdata.add(ToarraY);
            }
            myFileReader.close();
            Expression myRead = new Read();
            
        return myRead;
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
        return new String_type(value);
    }
    
    @Override
    public Expression visitDouble(DoubleContext ctx) {
        return new Number(Double.valueOf(ctx.getText()));
    }
    

    //Helper functions
    public double[] ToArray(List<Double> list) {
		return list.stream().mapToDouble(d -> d).toArray();
    }
    
    public double[] fromDouble(Double[] arr) 
    {
		return Stream.of(arr).mapToDouble(Double::doubleValue).toArray();
    }
    
    public List<double[]> fromDouble2(List<Double[]> List) 
    {
    	List<double[]> result = new ArrayList<double[]>();
    	for (Double[] arrayElement : List) {
		 result.add(Stream.of(arrayElement).mapToDouble(Double::doubleValue).toArray());
    	}
    	return result;
    }
    
    public static int getRandom(int length) {
        int rnd = new Random().nextInt(length);
        return rnd;
    }
    
}


//	   double expected = helper(fromDouble(Network.currentSet.targets.get(i)));
/* 	   if(PrettyPrintGuess(Network.feedforward(fromDouble(Network.currentSet.inputs.get(i))), expected) == 1)
   {
   	hitRateCounter += 1;
   }
} 
	System.out.println("hitrate: " + hitRateCounter / (double) epochs*100 + "% ");
	System.out.println(hitRateCounter);
*/
