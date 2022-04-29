package expression;

import java.util.ArrayList;

public class NN {
	
	private int input_nodes;
	private int hidden_nodes;
	private int output_nodes;
	
	private Matrix weights_ih;
	private Matrix weights_ho;
	private Matrix bias_h;
	private Matrix bias_o;
	
	private double learning_rate;

	public NN(int input_nodes, int hidden_nodes, int output_nodes) 
	{
	    this.input_nodes = input_nodes;
	    this.hidden_nodes = hidden_nodes;
	    this.output_nodes = output_nodes;

	    this.weights_ih = new Matrix(this.hidden_nodes, this.input_nodes);
	    this.weights_ho = new Matrix(this.output_nodes, this.hidden_nodes);
	    
	    this.weights_ih.randomize();
	    this.weights_ho.randomize();

	    this.bias_h = new Matrix(this.hidden_nodes, 1);
	    this.bias_o = new Matrix(this.output_nodes, 1);
	    this.bias_h.randomize();
	    this.bias_o.randomize();
	    this.learning_rate = 0.1;   
	}
	
	public double[] feedforward(double[] input_array) {
    // Generating the Hidden Outputs
    Matrix inputs = Matrix.fromArrayToMatrix(input_array);
    
    System.out.println(inputs.ToString());
    System.out.println(weights_ih.ToString());
    
    Matrix hidden = Matrix.DotProduct(this.weights_ih, inputs);
    
    System.out.println(hidden.ToString());
    
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
}
