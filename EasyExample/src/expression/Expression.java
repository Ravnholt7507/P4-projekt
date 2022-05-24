package expression;

public abstract class Expression {
	Object value;
	public Type type;
	
    public Expression(Object value) {
        this.value = value;
    }
    
    public Expression() {
    }
    
    
    public Expression(Type type) {
        this.type = type;
    }
    
    
    
    
    
    
    public Boolean asBoolean() {
        return (Boolean) value;
    }
    
    public Double asDouble() {
        return (Double) value;
    }
    
    public Integer asInt() {
        return (Integer) value;
    }
    
    public String asString() {
        return (String) value;
    }
    
    
    public boolean isDouble() {
        return value instanceof Double;
    }
    
    public boolean isInteger() {
        return value instanceof Integer;
    }
    
    public boolean isString() {
        return value instanceof String;
    }
    
    public boolean isBool() {
    	return value instanceof Boolean;
    }
    
    
    @Override
    public String toString() {
		return value.toString();
    }
}
