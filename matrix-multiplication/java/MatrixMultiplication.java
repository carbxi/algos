public class MatrixMultiplication{
  public static int dot(int[] a1, int[] a2){
    int res = 0;
    for(int i = 0; i < a1.length; i++){
      res += a1[i]*a2[i];
    }
    return res;
  }

  private static int[] column(int[][] array, int column){
    int[] res = new int[array.length];
    for(int i = 0; i < array.length; i++){
      res[i] = array[i][column];
    }
    return res;
  }

  public static int[][] matrixMult(int[][] m1, int[][] m2){
    int[][] res = new int[m1.length][m2[0].length];
    for(int i = 0; i<m1.length; i++){
      for(int j = 0; j<m2[0].length; j++){
        res[i][j] = dot(m1[i], column(m2, j));
      }
    }
    return res;
  }

	private static void printArray(int[][] data){
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[i].length; j++){
				System.out.print(data[i][j] + "\t");
			}
			System.out.println();
		}
	}

  public static void main(String[] args){
    int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}};
    int[][] matrix2 = {{1, 2}, {3, 4}, {5, 6}};
    printArray(matrixMult(matrix1, matrix2));
  }
}
