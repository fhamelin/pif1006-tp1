import java.io.Console;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[][] arrA = {{7,2,3},{-1,0,-4}};
		double[][] arrB = {{2,4},{-5,1},{-1,0}};
		double[][] arrC = {{2,4},{-5,1},{-1,0}};
		double[][] arrD = {{8,6},{-6,-7}};
		
		double[][] arrE = {{1,3,4},{3,5,-4},{4,7,-2}};
		double[][] arrF = {{1,2,3},{4,5,6},{7,8,9}};
		double[][] arrG = {{1,2,3,4,5},{6,7,8,9,10},
				          {11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		double[][] arrH = {{9}};
		double[][] arrI = {{4,2,8,3},{5,1,7,5},{8,0,8,5},{3,2,3,8}};
		double[][] arrJ = {{5,3,4},{8,1,5},{3,5,6}};
		double[][] arrK = {{1,1,-2},{4,-1,2},{2,-6,3}};
		
		double[][] arrL = {{4,2,8},{5,1,7},{8,0,8}};
		
		double[][] arrM = {{4,2,8,3}, {5,1,7,5}, {8,0,8,5}, {3,2,3,8}};
		
		Matrice matA = new Matrice(arrI);
		Matrice matB = matA.getCoMatrice(); 
		
		System.out.println(matA.getDeterminant());
	}

}
