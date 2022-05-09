package expression;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingSet extends Expression {
	List<Double[]> input;
	List<Double[]> target;
	
	public Map<Double[], Double[]> myDictionary = new HashMap<Double[], Double[]>();
	
	public TrainingSet(List<Double[]> in, List<Double[]> target) {
		this.input = in;
		this.target = target;
		
		for (int i = 0; i<in.size(); i++)
			this.myDictionary.put(in.get(i), target.get(i));
	}
}