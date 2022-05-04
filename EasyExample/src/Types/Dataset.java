package Types;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Statements.Read;
import expression.Expression;

public class Dataset extends Expression {
	
	public List<Double[]> inputs;
	public List<Double[]> targets;
	
	public Dataset(Object value) {
		super(value);
	}

	public Dataset() {
		super();
	}
	
	public Dataset(List<Double[]> in, List<Double[]> out) {
		super();
		this.inputs = in;
		this.targets = out;
	}
	
	public void addData(List<Double[]> in, List<Double[]> out) {
		this.inputs = in;
		this.targets = out;
	}
	
	public void ReadDataInput(String path, String Delimiter1, String Delimiter2, String InOrOut) {
	       try {
	            String Directory = path;
	            String StringDelimiter = Delimiter1;
	            String DoubleDelimiter = Delimiter2;
	            Directory = Directory.substring(1,Directory.length()-1);
	            StringDelimiter = StringDelimiter.substring(1, StringDelimiter.length()-1);
	            
	            DoubleDelimiter = DoubleDelimiter.substring(1, DoubleDelimiter.length()-1);

	            File myFile = new File(Directory);
	            Scanner myFileReader = new Scanner(myFile);
	            myFileReader.useDelimiter(StringDelimiter);

	            List<Double[]> Inputdata = new ArrayList<Double[]>();
	            int count =0;
	            while(myFileReader.hasNextLine())
	            {
	            	count = count + 1;  
	                List<Double> innerList = new ArrayList<Double>();

	                String ReadNext = new String(myFileReader.next());
	                String[] SplitLine = ReadNext.split(DoubleDelimiter);
	                
	                for ( int i = 0; i < SplitLine.length; i++) 
	                {
	                    innerList.add(Double.parseDouble(SplitLine[i]));

	                }
	                
	                Double[] ToarraY = innerList.toArray(new Double[innerList.size()]);
	                
	                System.out.print(innerList);
	                
	                Inputdata.add(ToarraY);
	                
	                System.out.println("fsdaf");
	            }
	            
	            
	            
	            if (InOrOut == "In")
	            	this.inputs = Inputdata;
	            else if (InOrOut == "Out") 
	            	this.targets = Inputdata;
	            myFileReader.close();

	        }
	        catch (FileNotFoundException e) {
	            System.out.println("Filen findes ikke");
	        }
	}
}
