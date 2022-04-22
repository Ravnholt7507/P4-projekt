package Expressions;

public class Power extends Expression {
	Expression left;
	Expression right;
	
	public Power(Expression left, Expression right) {
		this.left = left;
		this.right = right;
	}
}
