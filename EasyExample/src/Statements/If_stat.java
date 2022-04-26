package Statements;

import expression.Expression;

public class If_stat extends Expression {

	 public static Expression VOID = new If_stat(new Object());
	 
	 public If_stat(Object result) {
		 super(result);
	 }
}
