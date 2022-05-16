package expression;

import java.util.ArrayList;
import java.util.Arrays;

import org.antlr.v4.tool.ErrorSeverity;

import Types.Dataset;

public class NN extends Expression{
	
	private int input_nodes;
	private int hidden_nodes;
	private int output_nodes;
	
	public Dataset currentSet;
	
	public Matrix weights_ih;
	private Matrix weights_ho;
	private Matrix bias_h;
	private Matrix bias_o;
	
	private double learning_rate;

	public Function actfunc;
	
	public NN(int input_nodes, int hidden_nodes, int output_nodes) 
	{
		super();
	    this.input_nodes = input_nodes;
	    this.hidden_nodes = hidden_nodes;
	    this.output_nodes = output_nodes;

	    this.weights_ih = new Matrix(this.hidden_nodes, this.input_nodes);
	    this.weights_ho = new Matrix(this.output_nodes, this.hidden_nodes);
	    
	    this.weights_ih.randomize();
	    this.weights_ho.randomize();

	    this.bias_h = new Matrix(this.hidden_nodes, 1);
	    this.bias_h.randomize();
	    
	    this.bias_o = new Matrix(this.output_nodes, 1);
	    this.bias_o.randomize();
	    this.learning_rate = 0.1;   
	    
	//    System.out.print(this.weights_ho.ToString());
	}
	
	public NN(Type type) {
		super(type);
	}

	public void setup(Dataset Data, double learningRate, Function func) {
		this.currentSet = Data;
		this.learning_rate = learningRate;
		this.actfunc = func;
	}
	
	public double[] feedforward(double[] input_array) {
	// Generating the Hidden Outputs
	    Matrix inputs = Matrix.fromArrayToMatrix(input_array);
	    Matrix hidden = Matrix.DotProduct(this.weights_ih, inputs);
	    hidden.add(this.bias_h);
	
	    // activation function!
	    hidden.Sigmoid();
	
	    // Generating the output's output!
	    Matrix output = Matrix.DotProduct(this.weights_ho, hidden);
	    output.add(this.bias_o);
	    output.Sigmoid();

	    // Sending back to the caller!
	    return output.toArray();
  	}
	
	public void train(double[] input_array, double[] target_array, int epoch) {
		// Generating the Hidden Outputs
	    Matrix inputs = Matrix.fromArrayToMatrix(input_array);
	    Matrix hidden = Matrix.DotProduct(this.weights_ih, inputs);
	    hidden.add(this.bias_h);
	
	    // activation function!
	    hidden.Sigmoid();
	
	    // Generating the output's output!
	    Matrix output = Matrix.DotProduct(this.weights_ho, hidden);
	    output.add(this.bias_o);
	    output.Sigmoid();
	    // Feedforward done
	    
	    // Begin Backpropagatation
	    // Convert array to matrix object
	    Matrix targets = Matrix.fromArrayToMatrix(target_array);

	    // Calculate the error
	    // ERROR = TARGETS - OUTPUTS
	    Matrix output_errors = Matrix.subtract(targets, output);
	    
	    // let gradient = outputs * (1 - outputs);
	    // Calculate gradient
	    Matrix gradients = Matrix.dSigmoid(output);
	    gradients.multiply(output_errors);
	    gradients.multiply(this.learning_rate);    
	    
	    // Calculate deltas 
	    Matrix hidden_T = Matrix.transpose(hidden);
	    Matrix weight_ho_deltas = Matrix.DotProduct(gradients, hidden_T);

	    // Adjust the weights by deltas
	    this.weights_ho.add(weight_ho_deltas);
	    
	    // Adjust the bias by its deltas (which is just the gradients)
	    this.bias_o.add(gradients);

	    // Calculate the hidden layer errors
	    Matrix who_t = Matrix.transpose(this.weights_ho);
	    Matrix hidden_errors = Matrix.DotProduct(who_t, output_errors);

	    // Calculate hidden gradient
	    Matrix hidden_gradient = Matrix.dSigmoid(hidden);
	    hidden_gradient.multiply(hidden_errors);
	    hidden_gradient.multiply(this.learning_rate);

	    // Calcuate input->hidden deltas
	    Matrix inputs_T = Matrix.transpose(inputs);
	    Matrix weight_ih_deltas = Matrix.DotProduct(hidden_gradient, inputs_T);
	    
	    this.weights_ih.add(weight_ih_deltas);

	    // Adjust the bias by its deltas (which is just the gradients)
	    this.bias_h.add(hidden_gradient);
	  }
}









/*NeuralNetwork ourModel(10,20,1)

Dataset swag;

swag.addData(Array[1,0,0,0,0,0,0,0,0,0], Array[0.1] ; Array[0,1,0,0,0,0,0,0,0,0], Array[0.2]; 
			 Array[0,0,1,0,0,0,0,0,0,0], Array[0.3] ; Array[0,0,0,1,0,0,0,0,0,0], Array[0.4];
			 Array[0,0,0,0,1,0,0,0,0,0], Array[0.5] ; Array[0,0,0,0,0,1,0,0,0,0], Array[0.6]; 
			 Array[0,0,0,0,0,0,1,0,0,0], Array[0.7] ; Array[0,0,0,0,0,0,0,1,0,0], Array[0.8];
			 Array[0,0,0,0,0,0,0,0,1,0], Array[0.9]);
			 

ourModel.setup(Dataset swag);

ourModel.train(100000)


*/
