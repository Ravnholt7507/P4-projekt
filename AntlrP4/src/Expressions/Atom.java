package Expressions;

public class Atom extends Expression {
	Expression child;
	
	public Atom(Expression child) {
		this.child = child;
	}
}
