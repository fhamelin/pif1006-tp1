import java.io.Console;


public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// --------------------------------------------------------------------
		// Additionner des matrices
		// --------------------------------------------------------------------
		afficherTitre("Additionner des matrices");
		double[][] add1 = {{5,0,2},{6,-4,4},{1,4,1}};
		double[][] add2 = {{1,2,3},{4,5,6}};
		double[][] add3 = {{4,1,0},{4,-4,3},{2,-8, 1}};
		Matrice matAdd1 = new Matrice(add1);
		Matrice matAdd2 = new Matrice(add2);
		Matrice matAdd3 = new Matrice(add3);

		// 1ere operation
		System.out.println("1ere operation\n");
		matAdd1.afficherMatrice();
		matAdd2.afficherMatrice();
		System.out.println("L'addition de ces deux matrices est égal à: \n");
		Matrice matAdd4 = matAdd1.additionner(matAdd2); // Err: pas même format
		afficherEspace();
		
		// 2eme operation
		System.out.println("2ere operation\n");
		matAdd1.afficherMatrice();
		matAdd3.afficherMatrice();
		System.out.println("L'addition de ces deux matrices est égal à: \n");
		Matrice matAdd5 = matAdd1.additionner(matAdd3); // Succès
		matAdd5.afficherMatrice(); // Affiche le contenu de la matrice
		afficherEspace();
		
		// --------------------------------------------------------------------
		// Faire produit scalaire
		// --------------------------------------------------------------------
		afficherTitre("Faire produit scalaire");
		double[][] prodScal = {{1,2,3},{1,2,3}};
		double scalaire = 2;
		Matrice matScal1 = new Matrice(prodScal);
		Matrice matScal2 = matScal1.faireProduitScalaire(scalaire);

		matScal1.afficherMatrice();
		System.out.println("Scalaire: " + scalaire + "\n");
		System.out.println("La multiplication de la matrice ci-haute avec le scalaire donne ceci: \n");
		matScal2.afficherMatrice();
		afficherEspace();
	
		// --------------------------------------------------------------------
		// Faire produit matricielle
		// --------------------------------------------------------------------
		afficherTitre("Faire le produit matricielle");
		double[][] prodMatC = {{7,2,3},{-1,0,-4}};
		double[][] prodMatD = {{2,4},{-5,1},{-1, 0}};
		double[][] prodMatE = {{8,6},{-6,-7}};
		Matrice matProdC  = new Matrice(prodMatC);
		Matrice matProdD  = new Matrice(prodMatD);
		Matrice matProdE  = new Matrice(prodMatE);

		// 1ere operation
		System.out.println("1ere operation");
		matProdC.afficherMatrice();
		matProdD.afficherMatrice();
		System.out.println("Le produit de ces deux matrices est égal à :\n");
		Matrice matProdCD = matProdC.faireProduitMatriciel(matProdD);
		matProdCD.afficherMatrice();
		System.out.println("-----------------------------------------------\n");
		
		// 2ere operation
		System.out.println("2eme operation");
		matProdD.afficherMatrice();
		matProdE.afficherMatrice();
		System.out.println("Le produit de ces deux matrices est égal à :\n");
		Matrice matProdDE = matProdD.faireProduitMatriciel(matProdE);
		matProdDE.afficherMatrice();
		System.out.println("-----------------------------------------------\n");
		
		// 3ere operation
		System.out.println("3eme operation");
		matProdE.afficherMatrice();
		matProdD.afficherMatrice();
		System.out.println("Le produit de ces deux matrices est égal à :\n");
		Matrice matProdED = matProdE.faireProduitMatriciel(matProdD);
		System.out.println("-----------------------------------------------\n");
		
		// --------------------------------------------------------------------
		// Faire la trace
		// --------------------------------------------------------------------
		afficherTitre("Faire la trace");
		double[][] traceA = {{1,2,3},{4,5,6}};
		double[][] traceB = {{1,2,3},{4,5,6},{7,8,9}};
		
		Matrice matTraceA = new Matrice(traceA);
		Matrice matTraceB = new Matrice(traceB);
		
		// 1ere operation
		System.out.println("1ere operation");
		matTraceA.afficherMatrice();
		System.out.println("Le trace de cette matrice est :\n");
		matTraceA.getTrace();
		System.out.println("-----------------------------------------------\n");
		
		// 2eme opeation
		System.out.println("2eme operation");
		matTraceB.afficherMatrice();
		System.out.println("Le trace de cette matrice est : \n");
		System.out.println(matTraceB.getTrace());
		System.out.println("-----------------------------------------------\n");
		
		// --------------------------------------------------------------------
		// Calculer déterminant
		// --------------------------------------------------------------------
		afficherTitre("Calculer déterminant");
		double[][] detA = {{9}};
		double[][] detB = {{5,3,4},{8,1,5},{3,5,6}};
		double[][] detC = {{4,2,8,3},{5,1,7,5},{8,0,8,5},{3,2,3,8}};
		
		Matrice matDetA = new Matrice(detA); 
		Matrice matDetB = new Matrice(detB);
		Matrice matDetC = new Matrice(detC);
		
		// 1ere operation
		matDetA.afficherMatrice();
		System.out.println("Le determinant de cette matrice est : \n");
		System.out.println(matDetA.getDeterminant());
		System.out.println("-----------------------------------------------\n");
		
		// 2eme operation
		matDetB.afficherMatrice();
		System.out.println("Le determinant de cette matrice est : \n");
		System.out.println(matDetB.getDeterminant());
		System.out.println("-----------------------------------------------\n");
		
		// 3eme operation
		matDetC.afficherMatrice();
		System.out.println("Le determinant de cette matrice est : \n");
		System.out.println(matDetC.getDeterminant());
		System.out.println("-----------------------------------------------\n");
		
		// --------------------------------------------------------------------
		// Faire la transposée
		// --------------------------------------------------------------------
		afficherTitre("Faire la transposée");
		double[][] transA = {{1,2,4}, {2,3,2}};
		double[][] transB = {{2,3,5},{7,8,9},{1,3,5}};
		double[][] transC = {{24,-11,2},{16,-10,-8},{22,-23,13}};
		
		Matrice matTransA = new Matrice(transA); 
		Matrice matTransB = new Matrice(transB);
		Matrice matTransC = new Matrice(transC);
		
		// 1ere operation
		System.out.println("1ere operation");
		matTransA.afficherMatrice();
		System.out.println("Le transposée de cette matrice est :\n");
		matTransA.getTransposee();
		System.out.println("-----------------------------------------------\n");
		
		// 2eme operation
		System.out.println("2eme operation");
		matTransB.afficherMatrice();
		System.out.println("Le transposée de cette matrice est :\n");
		Matrice matTransD = matTransB.getTransposee();
		matTransD.afficherMatrice();
		System.out.println("-----------------------------------------------\n");
		
		// 3eme operation 
		System.out.println("3eme operation");
		matTransC.afficherMatrice();
		System.out.println("Le transposée de cette matrice est :\n");
		Matrice matTransE = matTransC.getTransposee();
		matTransE.afficherMatrice();
		System.out.println("-----------------------------------------------\n");
		
		
		// --------------------------------------------------------------------
		// Faire la CoMatrice
		// --------------------------------------------------------------------
		afficherTitre("Faire la CoMatrice");
		double[][] comA = {{1,2,-1},{-2,1,1},{0,3,-3}};
		double[][] comB = {{1,2,3},{0,1,2},{-1,-4,-1}};
		
		Matrice matCom = null;
		Matrice matComA = new Matrice(comA);
		Matrice matComB = new Matrice(comB);
		
		// 1ere operation
		System.out.println("1ere operation");
		matComA.afficherMatrice();
		System.out.println("La CoMatrice de cette matrice est :\n");
		matCom = matComA.getCoMatrice();
		matCom.afficherMatrice();
		System.out.println("-----------------------------------------------\n");
		
		// 2eme operation
		System.out.println("2eme operation");
		matComB.afficherMatrice();
		System.out.println("La CoMatrice de cette matrice est :\n");
		matCom = matComB.getCoMatrice();
		matCom.afficherMatrice();
		System.out.println("-----------------------------------------------\n");
		
		
		// --------------------------------------------------------------------
		// Faire la CoMatrice
		// --------------------------------------------------------------------
		afficherTitre("Faire la matrice inverse");
		double[][] comC = {{1,3,0},{4,-1,2},{-2,-6,0}};
		
		Matrice matInv = null;
		
		/*
		double[][] arrJ = {{5,3,4},{8,1,5},{3,5,6}};
		double[][] arrK = {{1,1,-2},{4,-1,2},{2,-6,3}};
		
		double[][] arrL = {{4,2,8},{5,1,7},{8,0,8}};
		
		double[][] arrM = {{4,2,8,3}, {5,1,7,5}, {8,0,8,5}, {3,2,3,8}};
		
		
		double[][] arrN = {{3,6,9},{0,5,4},{0,0,1}}; // Triangulaire supérieur
		double[][] arrO = {{8,0,0},{4,6,0},{1,2,4}}; // Triangulaire inférieure
		double[][] arrP = {{0,6,9},{0,0,4},{0,0,0}}; // Triangulaire supérieur stricte
		double[][] arrQ = {{0,0,0},{4,0,0},{1,2,0}}; // Triangulaire inférieure stricte
		// NIMPORTE SUPERIEUR INFERIEUR
		
		double[][] arrR = {{-2,4},{1,3}}; // Inversion Ordre 2
		double[][] arrS = {{1,2,-1},{-2,1,1},{0,3,-3}}; // Inversion Ordre N
		double[][] arrT = {{3,0,0},{0,2,0},{0,0,4}}; 	// Inversion diagonale
		
		double[][] arrU = {{2,1,3},{1,-2,1},{1,1,-2}};  // Inverion matricielle

		Matrice matA = new Matrice(arrU);
		//Syteme sys = new System(arrU,arrU);
		
	//	Matrice matB = matA.getMatriceInverse();
		
		//matB.afficherMatrice();
		 
		 */
	}
	
	public static void afficherTitre(String _str) {
		System.out.println(_str);
		System.out.println("-----------------------------------------------------------------------");
	}
	
	public static void afficherEspace() {
		System.out.println("\n");
	}

}
