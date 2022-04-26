package expression;

public abstract class Expression {
	Object value;
	
    public Expression(Object value) {
        this.value = value;
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
    
    public Boolean asBoolean() {
        return (Boolean) value;
    }
    
    @Override
    public String toString() {
		return value.toString();
    }
}