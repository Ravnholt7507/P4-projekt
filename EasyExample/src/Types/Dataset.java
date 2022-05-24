package Types;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.imageio.ImageIO;

import Statements.Read;
import expression.Expression;
import expression.FilenameComparator;
import expression.Type;

public class Dataset extends Expression {
	
	public List<Double[]> inputs;
	public List<Double[]> targets;
	
	//Constructors
	public Dataset(Object value) {
		super(value);
	}
	
	public Dataset(Type type) {
		super(type);
	}

	public static List<Double[]> readImages(String folderPath) {
	    folderPath = folderPath.substring(1, folderPath.length()-1);
	    File f = new File(folderPath);
	    List<Double[]> Inputdata = new ArrayList<Double[]>();
	    
	    File[] files = f.listFiles();
	    
	    Arrays.sort(files, Comparator.comparing(File::getName, new FilenameComparator()));
	    
	    for (int k = 0; k < files.length; k++) {
	        try {
	            if (files[k].isFile()) {
	                
	                BufferedImage img = ImageIO.read(files[k]);
	                
	                int width = img.getWidth();
	                int height = img.getHeight();
	                double[][] imgArr = new double[width][height];
	                Raster raster = img.getData();
	                
	                for (int i = 0; i < width; i++) {
	                    for (int j = 0; j < height; j++) {
	                        imgArr[i][j] = raster.getSample(j, i, 0);
	                        if (imgArr[i][j] > 1)
		                        imgArr[i][j] = 1;  
	                    }
	                }
	                double[] array = Stream.of(imgArr).flatMapToDouble(DoubleStream::of).toArray();
	                Double[] inputarr = copyFromdoubleArray(array);
	                Inputdata.add(inputarr); 
	            }
	        }
	        
	        catch (Exception e) {
	            //TODO: handle exception
	        }
	    }
	    System.out.println("Loading complete");
	    return Inputdata;
	}
    	

	
	public Dataset() {
		super();
	}
	
	public Dataset(List<Double[]> in, List<Double[]> out) {
		super();
		this.inputs = in;
		this.targets = out;
	}
	
	//Add arrays manually
	public void addData(List<Double[]> in, List<Double[]> out) {
		this.inputs = in;
		this.targets = out;
	}
	
	//Methods for reading arrays online
	public void ReadDataInput(String path, String Delimiter1, String Delimiter2, String inOut) {
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
	                
	                Inputdata.add(ToarraY);
	            }
	            if (inOut == "in")
	            	this.inputs = Inputdata;
	            else if (inOut == "out")
	            	this.targets = Inputdata;
	            myFileReader.close();

	        }
	        catch (FileNotFoundException e) {
	            System.out.println("Filen findes ikke");
	        }
	}
 
	
	public void Run(String filepath1, String filepath2, String Delimiter, String Delimiter2) {
	    System.out.println("Loading data... ");
	    
	    List<Double[]> Input = readImages(filepath1);
	    List<Double[]> Expected = readResultFile(filepath2, Delimiter, Delimiter2);
	    
	    try {
	    	if (Input.size() != Expected.size())
	    		throw new Exception();
	    }
	    catch(Exception e) {
	    	System.out.println("Error: Input size must match output size (In read data)");
	    	System.out.println("Termination program");
	    	System.exit(0);
	    }
	    
	    this.inputs = Input;
	    this.targets = Expected;
	}

	public static int countFiles(String folderPath) {
	    File f = new File(folderPath);
	    int count = 0;
	    for (File file : f.listFiles()) {
	            if (file.isFile()) {
	                    count++;
	            }
	    }
	    System.out.println("Number of files: " + count);
	    return count;
	}

	public static Double[] copyFromIntArray(int[] source) {
	    Double[] dest = new Double[source.length];
	    for(int i=0; i<source.length; i++) {
	        dest[i] = (double) source[i];
	    }
	    return dest;
	}
	
	public static Double[] copyFromdoubleArray(double[] source) {
	    Double[] dest = new Double[source.length];
	    for(int i=0; i<source.length; i++) {
	        dest[i] = source[i];
	    }
	    return dest;
	}
	
    public List<Double[]> readResultFile(String folderPath, String inputDel, String inputDel2){
        //IMPORTANT: If newline is input delimiter there must be a "space" at the end of the last input, and no empty newlines below it
        try {
            String Directory = folderPath.substring(1, folderPath.length() -1);
            String StringDelimiter1 = inputDel;
            String StringDelimiter2 = inputDel2;
            
            StringDelimiter1 = inputDel.substring(1,StringDelimiter1.length()-1);
            StringDelimiter2 = inputDel2.substring(1,StringDelimiter2.length()-1);
            
            File myFile = new File(Directory);
            Scanner myFileReader = new Scanner(myFile);
            myFileReader.useDelimiter(StringDelimiter2);

            List<Double[]> Inputdata = new ArrayList<Double[]>();
            
            //Reads each line, gets relevant int and adds it to Inputdata
            while(myFileReader.hasNextLine())
            {
                int DelimitPlace = 0;
                String ReadNext = new String(myFileReader.next());
                String ReadNextSubstringed;
                
                DelimitPlace = ReadNext.indexOf(StringDelimiter1) + 1;
                ReadNextSubstringed = ReadNext.substring(DelimitPlace, ReadNext.length()-1);
                Double[] currentArrayInput = new Double[ReadNextSubstringed.length()];
                
                for (int i = 0; currentArrayInput.length > i; i++) {
                	currentArrayInput[0] = 0.0; }
                
                String[] SplitLine = ReadNextSubstringed.split("");
                
                for ( int j = 0; j < SplitLine.length; j++) {
                     currentArrayInput[j] = (Double.parseDouble(SplitLine[j])); }
                
                Inputdata.add(currentArrayInput);
            }
            myFileReader.close();
            
            return Inputdata;
        }
        catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke");
            
        }
        //In case try fails, return trash list
        List<Double[]> blabla = new ArrayList<Double[]>();
        return blabla;
    }

	//Methods for reading arrays online
	public static List<Double[]> ReadData(String path, String Delimiter1, String Delimiter2) {
	       try {
	            String Directory = path;
	            String StringDelimiter = Delimiter1;
	            String DoubleDelimiter = Delimiter2;
	            
	            Directory = Directory.substring(1,Directory.length()-1);
	            
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
	                
	                Inputdata.add(ToarraY);
	            }
	            myFileReader.close();
	            
	            return Inputdata;
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("Filen findes ikke");
	        }
	       return null;
	}

    public static List<Double[]> LoadTestLabels(String folderPath, String inputDel, String inputDel2){
	        //IMPORTANT: If newline is input delimiter there must be a "space" at the end of the last input, and no empty newlines below it
	        try {
	        	String dir = folderPath.substring(1, folderPath.length()-1);
	            String StringDelimiter1 = inputDel;
	            String StringDelimiter2 = inputDel2;
	            
	            File myFile = new File(dir);
	            Scanner myFileReader = new Scanner(myFile);
	            myFileReader.useDelimiter(StringDelimiter2);

	            List<Double[]> Inputdata = new ArrayList<Double[]>();
	           
	            int count = 0;
	            //Reads each line, gets relevant int and adds it to Inputdata
	            while(myFileReader.hasNextLine())
	            {
	            	System.out.println(count);
	                int DelimitPlace = 0;
	                String ReadNext = new String(myFileReader.next());
	                String ReadNextSubstringed;
	                
	                DelimitPlace = ReadNext.indexOf(StringDelimiter1) + 1;
	                
	                ReadNextSubstringed = ReadNext.substring(DelimitPlace, ReadNext.length()-1);
	             
	                Double[] currentArrayInput = new Double[ReadNextSubstringed.length()];
	                
	                for (int i = 0; currentArrayInput.length > i; i++) {
	                	currentArrayInput[0] = 0.0; }
	                
	                String[] SplitLine = ReadNextSubstringed.split("");
	                
	                for ( int j = 0; j < SplitLine.length; j++) {
	                     currentArrayInput[j] = (Double.parseDouble(SplitLine[j])); }
	                
	                Inputdata.add(currentArrayInput);
	                count += 1;
	            }
	            myFileReader.close();
	            
	            return Inputdata;
	        }
	        catch (FileNotFoundException e) {
	            System.out.println("Filen findes ikke");
	            
	        }
	        //In case try fails, return trash list
	        List<Double[]> blabla = new ArrayList<Double[]>();
	        return blabla;
	        
	    }

}















/*
public static List<Double[]> readImages(String folderPath, int new_height, int new_width){


    File f = new File(folderPath);
    List<Double[]> Inputdata = new ArrayList<Double[]>();

    for (File file : f.listFiles()) {
        try {
            if (file.isFile()) {

                BufferedImage img = ImageIO.read(file);

                BufferedImage resizedImage = new BufferedImage(new_width, new_height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics2D = resizedImage.createGraphics();
                graphics2D.drawImage(img, 0, 0, new_width, new_height, null);
                graphics2D.dispose();

                //Test save images
       //         File test = new File("MyFile.png");
       //         ImageIO.write(resizedImage, "PNG", test);

                int width = resizedImage.getWidth();
                int height = resizedImage.getHeight();
                int[][] imgArr = new int[width][height];
                Raster raster = resizedImage.getData();

                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        imgArr[i][j] = raster.getSample(i, j, 0);
                    }
                }

                int[] array = Stream.of(imgArr).flatMapToInt(IntStream::of).toArray();
                Double[] inputarr = copyFromIntArray(array);
                Inputdata.add(inputarr); 
            }
        } 

        catch (Exception e) {
            //TODO: handle exception
        }
    }
    return Inputdata;
}

*/

