package Statements;

import expression.Expression;
import expression.Type;

public class While_stat extends Expression {

	public static Expression VOID = new While_stat(new Object());
	
	public While_stat(Object value) {
		super(value);
	}
	
	public While_stat(Type type) {
		super(type);
	}

}
