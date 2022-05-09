package Types;

import expression.Expression;
import expression.NN;

public class NN_Type extends Expression {

	public NN_Type(Object value) {
		super(value);
	}
	
	int input;
	int hidden;
	int output;
}
