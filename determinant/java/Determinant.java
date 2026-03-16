//Not happy with this, will improve later
public class Determinant{

  public static double[][] minor(double[][] matrix, int row, int col){
    int rowOff = 0;
    int colOff = 0;
    double[][] res = new double[matrix.length - 1][matrix[0].length - 1];
    for(int i = 0; i < matrix.length; i++){
      if(i == row){
        rowOff = 1;
        continue;
      }
      for(int j = 0; j < matrix[0].length; j++){
        if(j==col){
          colOff = 1;
          continue;
        }
        res[i - rowOff][j - colOff] = matrix[i][j];
      }
    }
    return res;
  }

  private static double determinant(double[][] matrix){
    if(matrix.length == 1){
      return matrix[0][0];
    }
    double res = 0;
    for(int i = 0; i < matrix.length; i++){
      double term = matrix[0][i]*determinant(minor(matrix, 0, i));
      if(i % 2 == 0){
        res += term;
      } else{
        res -= term;
      }
    }
    return res;
  }

	private static void printArray(double[][] data){
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
	}

  public static void main(String[] args){
    double[][] matrix = {{1, 2}, {3,4}};
    System.out.println(determinant(matrix));
  }
}
