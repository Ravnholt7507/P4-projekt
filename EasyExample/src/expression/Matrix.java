package expression;

import java.util.ArrayList;
import java.util.Arrays;

class Matrix {
	  
	int rows;
	int cols;
	double[][] data;

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

  public void randomize() {
    for (int i = 0; i < this.rows; i++) {
      for (int j = 0; j < this.cols; j++) {
        this.data[i][j] = (Math.round((Math.random() * 2 - 1)*100.0)/100.0);
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
  
  public String ToString() 
  {
	  String string = "";
	  for (int i = 0; i < this.rows; i++) 
	  {
	  string += Arrays.toString(this.data[i]) + " \n";
	  }
	  return string;
  }  
}
	  
	  /*
	  public void map(func) {
		    // Apply a function to every element of matrix
		    for (int i = 0; i < this.rows; i++) {
		      for (int j = 0; j < this.cols; j++) {
		        double val = this.data[i][j];
		        this.data[i][j] = func(val);
		      }
		    }
		  }

		  static map(matrix, func) {
		    let result = new Matrix(matrix.rows, matrix.cols);
		    // Apply a function to every element of matrix
		    for (let i = 0; i < matrix.rows; i++) {
		      for (let j = 0; j < matrix.cols; j++) {
		        let val = matrix.data[i][j];
		        result.data[i][j] = func(val);
		      }
		    }
		    return result;
		  }
	  */