package Expressions;

public class UnaryMinus extends Expression {
	Expression UnaryOp;
	
	public UnaryMinus(Expression UnaryOp) {
		this.UnaryOp = UnaryOp;
	}
}
