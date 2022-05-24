package Types;

import expression.Expression;
import expression.Type;

public class NN_Type extends Expression {

	public NN_Type(Object value) {
		super(value);
	}
	
	public NN_Type(Type type) {
		super(type);
	}
	
	int input;
	int hidden;
	int output;
}
