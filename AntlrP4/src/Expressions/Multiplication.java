package Expressions;

public class Multiplication extends Expression {
	Expression left;
	Expression right;
	String Op;
	
	public Multiplication(Expression left, Expression right, String Op) {
		this.left = left;
		this.right = right;
		this.Op = Op;
	}
	
	@Override
	public String toString() {
		return left.toString() + Op + right.toString();
	}
}