package Types;

import expression.Expression;

public class ArrayDouble_Type extends Expression {
	
	Object[] values;
	
	public ArrayDouble_Type(Object value) {
		super(value);
	}
	
	public ArrayDouble_Type(Object[] values) {
		super(values);
	}
	
    public Double[] asDoubleArray() {
        return (Double[]) values;
    }
}
