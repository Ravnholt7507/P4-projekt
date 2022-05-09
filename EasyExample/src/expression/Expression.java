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
    
    public Double asDouble() {
        return (Double) value;
    }
    
    public Integer asInt() {
        return (Integer) value;
    }
    
    public boolean isDouble() {
        return value instanceof Double;
    }
    
    public boolean isString() {
        return value instanceof String;
    }
    
    public Boolean asBoolean() {
        return (Boolean) value;
    }
    
    @Override
    public String toString() {
		return value.toString();
    }
}
