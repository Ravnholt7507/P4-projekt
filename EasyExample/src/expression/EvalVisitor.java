package expression;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import org.antlr.v4.runtime.Token;
import antlr.ExprBaseVisitor;
import antlr.ExprParser;
import antlr.ExprParser.Add_dataContext;
import antlr.ExprParser.AdditiveOpContext;
import antlr.ExprParser.DeclContext;
import antlr.ExprParser.DoubleContext;
import antlr.ExprParser.EqualityExprContext;
import antlr.ExprParser.Neural_networkContext;
import antlr.ExprParser.PrintContext;
import antlr.ExprParser.ReadContext;
import antlr.ExprParser.Read_dataContext;
import antlr.ExprParser.Read_image_dataContext;
import antlr.ExprParser.RelationalExprContext;
import antlr.ExprParser.SetupContext;
import antlr.ExprParser.StringContext;
import antlr.ExprParser.TrainContext;
import antlr.ExprParser.VariableContext;
import antlr.ExprParser.While_statContext;
import antlr.ExprParser.Condition_blockContext;
import antlr.ExprParser.DatasetContext;
import antlr.ExprParser.If_statContext;
import antlr.ExprParser.IntContext;
import antlr.ExprParser.MultiOpContext;
import antlr.ExprParser.AndExprContext;
import antlr.ExprParser.BoolContext;
import antlr.ExprParser.OrExprContext;
import antlr.ExprParser.ParExprContext;
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
	
	public EvalVisitor() {
		memory = new HashMap<String, Expression>();
		semanticErrors = new ArrayList<String>();
	}
	
    @Override
    public Expression visitDecl(DeclContext ctx) {
        String id = ctx.ID().getText();
        Expression value = this.visit(ctx.expr());
        
		if (memory.containsKey(id)) {
			memory.replace(id, value);
		}
        
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
    
    @SuppressWarnings("deprecation")
	@Override
    public Expression visitRelationalExpr(RelationalExprContext ctx) {
        Expression left = this.visit(ctx.expr(0));
        Expression right = this.visit(ctx.expr(1));
        
        
        switch(ctx.op.getType()) 
        {
        case ExprParser.LT:
        	if (left.isDouble() && right.isDouble())
        		return new RelationalExpr(left.asDouble() < right.asDouble());
        	if (left.isInteger() && right.isInteger())
            	return new RelationalExpr(left.asInt() < right.asInt());
        	if (left.isDouble() && right.isInteger())
        		return new RelationalExpr(left.asDouble() < right.asInt());
        	if (left.isInteger() && right.isDouble())
        		return new RelationalExpr(left.asInt() < right.asDouble());

        case ExprParser.LTEQ: 
        	if (left.isDouble() && right.isDouble())
        		return new RelationalExpr(left.asDouble() <= right.asDouble());
        	if (left.isInteger() && right.isInteger())
            	return new RelationalExpr(left.asInt() <= right.asInt());
        	if (left.isDouble() && right.isInteger())
        		return new RelationalExpr(left.asDouble() <= right.asInt());
        	if (left.isInteger() && right.isDouble())
        		return new RelationalExpr(left.asInt() <= right.asDouble());

        case ExprParser.GT: 
        	if (left.isDouble() && right.isDouble())
        		return new RelationalExpr(left.asDouble() > right.asDouble());
        	if (left.isInteger() && right.isInteger())
            	return new RelationalExpr(left.asInt() > right.asInt());
        	if (left.isDouble() && right.isInteger())
        		return new RelationalExpr(left.asDouble() > right.asInt());
        	if (left.isInteger() && right.isDouble())
        		return new RelationalExpr(left.asInt() > right.asDouble());

        case ExprParser.GTEQ: 
        	if (left.isDouble() && right.isDouble())
        		return new RelationalExpr(left.asDouble() >= right.asDouble());
        	if (left.isInteger() && right.isInteger())
            	return new RelationalExpr(left.asInt() >= right.asInt());
        	if (left.isDouble() && right.isInteger())
        		return new RelationalExpr(left.asDouble() >= right.asInt());
        	if (left.isInteger() && right.isDouble())
        		return new RelationalExpr(left.asInt() >= right.asDouble());

        default:
            throw new RuntimeException("unknown operator: " + ExprParser.tokenNames[ctx.op.getType()]);
    	}
    }

    @SuppressWarnings("deprecation")
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
        	else if (left.isBool() && right.isBool())
        		return new RelationalExpr(left.asBoolean() == right.asBoolean());
        	else if (left.isString() && right.isString())
        		return new RelationalExpr(left.asString() == right.asString());
        	else if (!left.isDouble() && !right.isDouble())
        		return new RelationalExpr(left.asInt() == right.asInt());
        	else if (left.isDouble() && !right.isDouble())
        		return new RelationalExpr(Math.abs(left.asDouble() - right.asInt()) < SMALL_VALUE);
        	else if (!left.isDouble() && right.isDouble())
        		return new RelationalExpr(Math.abs(left.asInt() - right.asDouble()) < SMALL_VALUE);		
        case ExprParser.NEQ: 
        	if (left.isDouble() && right.isDouble()) 
        		return new RelationalExpr(Math.abs(left.asDouble() - right.asDouble()) >= SMALL_VALUE);
        	else if (left.isBool() && right.isBool())
        		return new RelationalExpr(left.asBoolean() != right.asBoolean());
        	else if (left.isString() && right.isString())
        		return new RelationalExpr(left.asString() != right.asString());
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
	public Expression visitMultiOp(MultiOpContext ctx) {

        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        
        String operator = ctx.op.getText();   
        
        if (operator == "*"){
        	if (left.isDouble() && right.isDouble())
        		return new Multiplication(left.asDouble()  * right.asDouble());
	        else if (left.isDouble() && !right.isDouble())
	        	return new Multiplication(left.asDouble() * right.asInt());
	        else if (!left.isDouble() && right.isDouble())
	        	return new Multiplication(left.asInt() * right.asDouble());
	        else
	        	return new Multiplication(left.asInt() * right.asInt());
	    }
        else if (operator == "/") {
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
        return null;
	}
	
	@Override
	public Expression visitAdditiveOp(AdditiveOpContext ctx) {

        Expression left = visit(ctx.expr(0)); // 5
        Expression right = visit(ctx.expr(1)); // (1+2)
    
        int operator = ctx.op.getType();
        //Different typecasts for additions of types int, doubles or strings.
        if (operator == ExprParser.ADD){
	        if (left.isDouble() && right.isDouble())
	        	return new Addition(left.asDouble() + right.asDouble());
	        
	        else if (left.isDouble() && !right.isDouble())
	        	return new Addition(left.asDouble() + right.asInt());
	        
	        else if (!left.isDouble() && right.isDouble()) 
	        	return new Addition(left.asInt() + right.asDouble());
	        
	        else if (left.isString() && right.isString())
	            return new Addition(left.toString() + right.toString());
	        
	        else if (!left.isString() && right.isString())
	        	throw new RuntimeException("Strings skal l�gges til strings");
	        
	        else if (left.isString() && !right.isString())
	        	throw new RuntimeException("Strings skal l�gges til strings");
	        else 
	        	return new Addition(left.asInt() + right.asInt());
        }
        
        else if (operator == ExprParser.SUB) {
	        if (left.isDouble() && right.isDouble())
	        	return new Subtraction(left.asDouble()  - right.asDouble());
	        
	        else if (left.isDouble() && !right.isDouble())
	        	return new Subtraction(left.asDouble() - right.asInt());
	        
	        else if (!left.isDouble() && right.isDouble())
	        	return new Subtraction(left.asInt() - right.asDouble());
	        
	        else
	        	return new Subtraction(left.asInt() - right.asInt());
	    }
		return null;
	}

	@Override
	public Expression visitVariable(VariableContext ctx) {
        String id = ctx.getText();
        Expression value = memory.get(id);
        
        if(value == null) {
            throw new RuntimeException("No variables in memory with that name: " + id);
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

        Condition_blockContext condition = ctx.condition_block();

        boolean evaluatedBlock = false;
        Expression evaluated = this.visit(condition.expr());

        if((Boolean) evaluated.value) {
            evaluatedBlock = true;
            // evaluate this block whose expr==true
            this.visit(condition.getChild(3));
        }
        

        if(!evaluatedBlock && ctx.stat_block() != null) {
            // evaluate the else-stat_block (if present == not null)
            this.visit(ctx.getChild(3));
        }

        return If_stat.VOID;
    }
    
    // expr overrides
    @Override
    public Expression visitParExpr(ParExprContext ctx) {
        return this.visit(ctx.expr());
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
    	int input = Integer.valueOf(ctx.expr(0).getText());
    	int hidden = Integer.valueOf(ctx.expr(1).getText());
    	int output = Integer.valueOf(ctx.expr(2).getText());
    	
    	Expression NeuralNetwork = new NN(input, hidden, output);
    	
    	return memory.put(id, NeuralNetwork);
    }
    
    @Override
    public Expression visitSetup(SetupContext ctx) {
    	    	
    	String ActFunc = ctx.ACTFUNC().getText();
    	String NetworkId = ctx.ID(0).getText();
    	String DatasetId = ctx.ID(1).getText();
    	double LearningRate = Double.valueOf(ctx.expr().getText());
    	
    	Dataset set = (Dataset) memory.get(DatasetId);
    	NN Network = (NN) memory.get(NetworkId);
    	
    	try {
        	if (set.targets.get(0).length != Network.getOutputSize())
        	{
        		System.out.println(set.targets.get(0).length);
        		System.out.println(Network.getOutputSize());
        		throw new Exception();
        	}
    	}
    	catch (Exception e) {
    		System.out.println("Warning: Output dimension from neural network does not match target file");
    	}

    	Network.setup(set, LearningRate, ActFunc);
    	
    	memory.replace(NetworkId, Network);
    	return set; 
    }
    
    @Override
    public Expression visitTrain(TrainContext ctx) {

		Token tokenid = ctx.getStart();
		int line = tokenid.getLine();
		
    	System.out.println("Starting to train... ");
        int epochs = Integer.valueOf(ctx.expr().getText());
        String id = ctx.ID(0).getText();
        
        //Helper vars
        double temp_epoch = 0;
        double hitRateCounter = 0;
        
        //get neural network from memory
        NN Network = (NN) memory.get(id);
        
		if (ctx.ID(1) != null) {
			String SetId = ctx.ID(1).getText();
	        //get Dataset from memory
	        Dataset set = (Dataset) memory.get(SetId);
	        Network.changeSet(set);
		}
        
        try {
		if (Network.currentSet == null) 
			throw new Exception();
		}
        catch(Exception e) {
        	System.out.println("Exception on line " + line + ", " + " Dataset is empty ");
        	System.out.println("Program Terminating");
        	System.exit(0);
        }
        
        int DataInputs = Network.currentSet.inputs.size();

        DecimalFormat numberFormat = new DecimalFormat("#");
        double DEpochs = epochs;
        
        List<double[]> inputs = todouble(Network.currentSet.inputs);
        List<double[]> targets= todouble(Network.currentSet.targets);
        
        // Trains the dataset for each epoch
      	for (int j = 1; j<epochs; j++) {
      		for (int m = 0; m<DataInputs; m++) {
      			Network.train(inputs.get(m), targets.get(m), j);
      			if(temp_epoch != j/DEpochs*100) {
                    System.out.println(numberFormat.format(j/DEpochs*100) + "%");
                    temp_epoch = j/DEpochs*100;
                }      		
      		}
      	}

      	memory.replace(id, Network);
        for (int i = 0; i<DataInputs; i++) {
	  		if (GetHit(helper(targets.get(i)), Network.feedforward(inputs.get(i))) == true) 
	  			hitRateCounter += 1;
  		} 
      	System.out.println("TRAINING HITRATE:  " + (hitRateCounter / (double) (DataInputs))*100 );
      	
        return super.visitTrain(ctx);
    }
        
    public boolean GetHit(int expected, double[] actual) {
    	int guess = 0;
    	double max = 0;
    	
	if (actual.length == 1) {
    	     return expected == Math.round(actual[0]*10);
    	}
	    
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
    
    public void PrettyPrintGuess(double[] ds) {
    	double Sum = 0;
    	int guess = 0;
    	double max = 0;
	    
	    	//Pretty print for single output node
    	if (ds.length == 1) {
	    	System.out.print("Prediction: " + Math.round(ds[0]*10) + "     ");
    	}
    	
    	
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
    	System.out.print("\n");
    }
    
    public int helper(double[] ds) {
    	//If the output is already a single number, we use that number.
    	if (ds.length == 1)
    		return (int) Math.round(ds[0]*10);
    	
    	//If output is string of 0 / 1's we convert it to the corresponding number.
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
        double hitRateCounter = 0;
        
        String SetId = ctx.ID(1).getText();
        Dataset Data = (Dataset) memory.get(SetId);  
        
        List<double[]> TestInput = todouble(Data.inputs);
        List<double[]> testLabels = todouble(Data.targets);
    	//Make sure dimensions for input and label match
	    try {
	    	if (TestInput.size() != testLabels.size())
	    		throw new Exception();
	    }
	    catch(Exception e) {
	    	System.out.println("Warning: Input size must match output size in predict");
	    	System.out.println("Could not perform predict");
	    	return Network;
	    }
	    //Make sure output dimensions match neural network
    	try {
        	if (testLabels.get(0).length != Network.getOutputSize())
        		throw new Exception();
    	}
    	catch (Exception e) {
    		System.out.println("Warning: Output dimension from neural network does not match target file in prediction");
	    	return Network;
    	}
    	
    	//Print 10 first predictions
		for (int j=0; j<10; j++) {
			System.out.print("Expected: " + helper(testLabels.get(j)) + "        ");
			System.out.print(" ");
			PrettyPrintGuess(Network.feedforward(TestInput.get(j))); 	
		}
    	
    	//Get and print hitRate
        for (int i = 0; i<TestInput.size(); i++) {
    		if (GetHit(helper((testLabels.get(i))), Network.feedforward(TestInput.get(i))) == true) {
    			hitRateCounter += 1;
    		}
        } 
      	System.out.println("TEST HITRATE:  " + (hitRateCounter / (double) TestInput.size()) * 100);

    	return Network;
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
    	
    	memory.replace(id, set);
    	
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
    public Expression visitBool(BoolContext ctx) {
    	String boolText = ctx.getText();
    	switch(boolText) {
    		case "true": return new Boolean_Type(true);
    		case "TRUE": return new Boolean_Type(true);
    		case "false": return new Boolean_Type(false);
    		case "FALSE": return new Boolean_Type(false);
    		default: return null;
    	}
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
    
    public List<double[]> todouble(List<Double[]> List) 
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
