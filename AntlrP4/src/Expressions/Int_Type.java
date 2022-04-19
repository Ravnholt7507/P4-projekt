package Expressions;

public class Int_Type extends Expression {
	int num;
	
	public Int_Type(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return Integer.valueOf(num).toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
}
