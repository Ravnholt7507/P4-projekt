package Expressions;

import java.util.ArrayList;
import java.util.List;

public class ParExpr extends Expression {
	List<Expression> Expressions;
	
	public ParExpr(List<Expression> Expressions) {
		this.Expressions = Expressions;
	}
	
	public ParExpr(Expression Expression) {
		this.Expressions = new ArrayList<Expression>();
		Expressions.add(Expression);
	}
}
