package Statements;

import expression.Expression;

public class While_stat extends Expression {

	public static Expression VOID = new While_stat(new Object());
	
	public While_stat(Object value) {
		super(value);
	}

}
