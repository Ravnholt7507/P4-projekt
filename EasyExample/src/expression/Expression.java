package expression;

public abstract class Expression {
	Object value;
	
    public Expression(Object value) {
        this.value = value;
    }
    
    public Double asDouble() {
        return (Double) value;
    }
    
    public Boolean asBoolean() {
        return (Boolean) value;
    }
}
