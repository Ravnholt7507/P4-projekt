package Statements;

import expression.Expression;
import expression.Type;

public class If_stat extends Expression {

	 public static Expression VOID = new If_stat(new Object());
	 
	 public If_stat(Object result) {
		 super(result);
	 }
	 
	 public If_stat(Type type) {
		 super(type);
	 }
}
