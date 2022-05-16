package expression;

public class Type extends Expression  {
	public int Kind;
	
	public static final byte
	Bool = 0, Int = 1, Double = 2, String = 3, Dataset=4, Network =5, Error = -1;
	
	public Type(Byte kind) {
		this.Kind = kind;
	}

	public String toString(){
		int result = this.Kind;
		return Integer.toString(result);
	}
	
    // Overriding equals() to compare two Type objects
    @Override
    public boolean equals(Object o) {
    	
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
        
        /* Check if o is an instance of Type or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Type)) {
            return false;
        }
         
        // typecast o to Type so that we can compare data members
        Type c = (Type) o;
         
        // Compare the data members and return accordingly
        return Integer.compare(Kind, c.Kind) == 0;
    }
    
	public static Type BoolT = new Type(Bool);
	public static Type IntT = new Type(Int);
	public static Type ErrorT = new Type(Error);
	public static Type DoubleT = new Type(Double);
	public static Type StringT = new Type(String);
	public static Type DataSetT = new Type(Dataset);
	public static Type NetworkT = new Type(Network);
}
