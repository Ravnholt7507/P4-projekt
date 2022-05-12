package expression;

public class Type extends Expression  {
	private byte Kind;
	
	public static final byte
	Bool = 0, Int = 1, Double = 2, Error = -1;
	
	public Type(Byte kind) {
		this.Kind = kind;
	}
	
	@Override
	public boolean equals(Object obj) {
	 	return super.equals(obj);
	}
	
	public static Type boolT = new Type(Bool);
	public static Type IntT = new Type(Int);
	public static Type ErrorT = new Type(Error);
	public static Type DoubleT = new Type(Double);
}