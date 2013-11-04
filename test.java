import java.io.Console;


public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[][] arrA = {{2,4},{5,7},{8,9}};
		double[][] arrB = {{1,7},{3,4}};
		double[][] arrC = {{2,2},{2,2},{2,2}};
		
		double[][] arrD = {{2,4,3},{5,7,9},{8,9,4},{7,7,2}};
		double[][] arrE = {{1,4},{2,5},{3,6}};
		
		Matrice matriceA = new Matrice(arrD);
		Matrice matriceB = new Matrice(arrE);
		
		Matrice matriceC = matriceA.faireProduitMatriciel(matriceB);
		
	    System.out.print(matriceC.afficherMatrice());
		
	}

}
