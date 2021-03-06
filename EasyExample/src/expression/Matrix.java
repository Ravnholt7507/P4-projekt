package expression;

import java.util.Arrays;

class Matrix {
	  
	int rows;
	int cols;
	double[][] data;
	
	public Function func = (p1) -> { return p1; }; 

  public Matrix(int rows, int cols) {
    this.rows = rows;
    this.cols = cols;
    this.data = new double[rows][cols];

    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        this.data[i][j] = 0;
      }
    }
  }

  public static Matrix fromArrayToMatrix(double[] arr) {
    Matrix m = new Matrix(arr.length, 1);
    for (int i = 0; i < arr.length; i++) {
      m.data[i][0] = arr[i];
    }
    return m;
  }
  
  public static Matrix subtract(Matrix a, Matrix b) {
    // Return a new Matrix a-b
    Matrix result = new Matrix(a.rows, a.cols);
    for (int i = 0; i < result.rows; i++) {
      for (int j = 0; j < result.cols; j++) {
        result.data[i][j] = a.data[i][j] - b.data[i][j];
      }
    }
    return result;
  }
  
  public static Matrix Quadratic(Matrix a, Matrix b) {
	    // Return a new Matrix a-b
	    Matrix result = new Matrix(a.rows, a.cols);
	    for (int i = 0; i < result.rows; i++) {
	      for (int j = 0; j < result.cols; j++) {
	        result.data[i][j] = Math.pow(a.data[i][j] - b.data[i][j],2)/(result.rows*result.cols);
	      }
	    }
	    return result;
	  }

  public double[] toArray() {
    double[] arr = new double[this.data.length*this.data[0].length];
    int local = 0;
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        arr[local] = this.data[i][j];
        local++;
      }
    }
    return arr;
  }

  
  public void Softmax() {
      double[] exps = new double[this.rows];
      double sum = 0;

      for (int i = 0; i < this.rows; i++) {
          exps[i] = Math.exp(this.data[i][0]);
          sum += exps[i];
      }

      for (int i = 0; i < this.rows; i++) {
          this.data[i][0] = exps[i] / sum ;
      }
  }
  
  public void randomize() {
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
         this.data[i][j] = (Math.random() * 2 - 1);
      }
    }
  }

  public void add(Matrix n) {
      for (int i = 0; i < this.rows; i++) {
        for (int j = 0; j < this.cols; j++) {
          this.data[i][j] += n.data[i][j];
        }
     }
  }
    
  public void add(Double n) {
      for (int i = 0; i < this.rows; i++) {
        for (int j = 0; j < this.cols; j++) {
          this.data[i][j] += n;
        }
     }
  }

  public static Matrix transpose(Matrix m) {
    Matrix result = new Matrix(m.cols, m.rows);
    for (int i = 0; i < m.rows; i++) {
      for (int j = 0; j < m.cols; j++) {
        result.data[j][i] = m.data[i][j];
      }
    }
    return result;
  }

  public static Matrix DotProduct(Matrix a, Matrix b) {
    if (a.cols != b.rows) {
      System.out.print("Columns of A must match rows of B.");
      return null;
    }
    Matrix result = new Matrix(a.rows, b.cols);
    for (int i = 0; i < result.rows; i++) {
      for (int j = 0; j < result.cols; j++) {
        // Dot product of values in column
        double sum = 0;
        for (int k = 0; k < a.cols; k++) {
          sum += a.data[i][k] * b.data[k][j];
        }
        result.data[i][j] = sum;
      }
    }
    return result;
  }

  public void multiply(Matrix m) {
      // hadamard product
      for (int i = 0; i < this.rows; i++) {
        for (int j = 0; j < this.cols; j++) {
          this.data[i][j] *= m.data[i][j];
        }
      }
   }
  
  public void multiply(Double n) {
      // Scalar product
      for (int i = 0; i < this.rows; i++) {
        for (int j = 0; j < this.cols; j++) {
          this.data[i][j] *= n;
        }
      }
    }
  
  public void Sigmoid(){
      for (int i = 0; i < this.rows; i++) {
	      for (int j = 0; j < this.cols; j++) {
	        this.data[i][j] = (1/( 1 + Math.pow(Math.E,(-1*this.data[i][j]))));
	      }
      }
  }
  
  public static Matrix dSigmoid(Matrix m){
	  Matrix result = new Matrix(m.rows, m.cols);
      for (int i = 0; i < m.rows; i++) {
	      for (int j = 0; j < m.cols; j++) {
	    	double val = m.data[i][j];
	        result.data[i][j] = val*(1-val);
	      }
      }
      return result;
  }
  
  public static Matrix MSE(Matrix actual, Matrix prediction) {

	    Matrix Tempresult = new Matrix(actual.rows, actual.cols);
	    for (int i = 0; i < Tempresult.rows; i++) {
	      for (int j = 0; j < Tempresult.cols; j++) {
	          Tempresult.data[i][j] = (Math.pow((actual.data[i][j] - prediction.data[i][j]),2));
	      }
	    }
	 //   double mean = Mean(Tempresult);
	 //   MSE.data[0][0] = mean;
	    return Tempresult;
	  }

  public static double Mean(Matrix a) {
      double mean = 0;
      for(int i= 0; i < a.rows; i++) {
          mean += a.data[i][0];
      }
      return mean / a.rows;
  }
  
  public void Relu(){
      for (int i = 0; i < this.rows; i++) {
	      for (int j = 0; j < this.cols; j++) {
	        this.data[i][j] = this.data[i][j] <= 0 ? 0.1 * this.data[i][j] : this.data[i][j];
	      }
      }
  }
  public static Matrix dRelu(Matrix m){
	  Matrix result = new Matrix(m.rows, m.cols);
      for (int i = 0; i < m.rows; i++) {
	      for (int j = 0; j < m.cols; j++) {
	        result.data[i][j] =  result.data[i][j] <= 0 ? 0.1 : 1;
	      }
      }
      return result;
  }
  
  public static Matrix dLeakyRelu(Matrix m){
	  Matrix result = new Matrix(m.rows, m.cols);
      for (int i = 0; i < m.rows; i++) {
	      for (int j = 0; j < m.cols; j++) {
	        result.data[i][j] =  result.data[i][j] <= 0 ? 0.01 : 1;
	      }
      }
      return result;
  }
  
  public void LeakyRelu(){
      for (int i = 0; i < this.rows; i++) {
	      for (int j = 0; j < this.cols; j++) {
	        this.data[i][j] = this.data[i][j] <= 0 ? 0.01 * this.data[i][j] : this.data[i][j];
	      }
      }
  }
  
  public void SoftMax(){
      for (int i = 0; i < this.rows; i++) {
	      for (int j = 0; j < this.cols; j++) {
	        this.data[i][j] = Math.log(1.0 + Math.exp(this.data[i][j]));
	      }
      }
  }

  public static Matrix dSoftMax(Matrix m){
	  Matrix result = new Matrix(m.rows, m.cols);
      for (int i = 0; i < m.rows; i++) {
	      for (int j = 0; j < m.cols; j++) {
	    	double val = m.data[i][j];
	        result.data[i][j] = val*(1-val);
	      }
      }
      return result;
  }
  
  public String ToString() 
  {
	  String string = "";
	  for (int i = 0; i < this.rows; i++) 
	  {
	  string += Arrays.toString(this.data[i]) + " \n";
	  }
	  return string;
  } 
  
  public void map(Function fn) {
      for (int y = 0; y < rows; y++)
          for (int x = 0; x < cols; x++)
              data[y][x] = fn.apply(data[y][x]);
  }
}