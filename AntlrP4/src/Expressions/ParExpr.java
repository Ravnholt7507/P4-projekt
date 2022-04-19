package Expressions;

public class ParExpr extends Expression {
	Expression Child;
	public ParExpr(Expression child) {
		this.Child = child;
	}
}
