package Expressions;

public class Variable extends Expression {
	String id;
//	String Type;
	
	public Variable(String id) {
		this.id = id;
//		this.Type = Type;
	}
	
	@Override
	public String toString() {
		return id;
	}
}
