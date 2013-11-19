/**
 * @author Simon Blanchette
 *
 */

class Matrice {
	private double[][] matrice;
	
	private enum Type {
		TRIANGULAIRE_NIMPORTE, 
		TRIANGULAIRE_INFERIEUR, 
		TRIANGULAIRE_SUPERIEUR
	}
	
	public Matrice(double[][] matrice) {
		this.matrice = matrice;
	}
	
	public double getElement(int ligne, int colonne) {
		return this.matrice[ligne][colonne];
	}
	
	public void setElement(int ligne, int colonne, double element) {
		this.matrice[ligne][colonne] = element;
	}
	
	public int getLignes() {
		return matrice.length;
	}
	
	public int getColonnes() {
		return matrice[0].length;
	}
	
	public Matrice additionner(Matrice matrice) {
		double[][] elements = new double[getLignes()][getColonnes()];
		
		if (memeFormat(matrice))
			for (int ligne = 0;ligne < getLignes();ligne++) 
				for (int colonne = 0; colonne < getColonnes();colonne++) 
					elements[ligne][colonne] = getElement(ligne, colonne) + matrice.getElement(ligne, colonne);
		else 
			System.out.println("Addition impossible, les matrices sont de format différent");
		
		return new Matrice(elements);
	}
	
	public Matrice faireProduitScalaire(double scalaire) {
		double[][] elements = new double[getLignes()][getColonnes()];
		
		for (int ligne = 0;ligne < getLignes();ligne++) 
			for (int colonne = 0; colonne < getColonnes();colonne++) 
				elements[ligne][colonne] = getElement(ligne, colonne) *	scalaire;

		return new Matrice(elements);
	}
	
	public Matrice faireProduitMatriciel(Matrice matrice) {
		double[][] elements = new double[getLignes()][matrice.getColonnes()];
		
		/* Vérifier si le nombre de colonne de la matrice actuelle
		 * est égal au nombre de ligne de la matrice à multiplier */
		if (memeLigneColonne(matrice)) 
			// On parcours chaques lignes de la matrice actuelle 
			for (int ligne = 0; ligne < getLignes(); ligne++) 
				// On parcours chaque colonne de la matrice à multiplier
				for (int colonneB = 0; colonneB < matrice.getColonnes(); colonneB++) 
					// On parcours chaque colonne de la matrice actuelle
					for (int colonneA = 0; colonneA < getColonnes(); colonneA++) 
						 elements[ligne][colonneB] += getElement(ligne,colonneA) * matrice.getElement(colonneA, colonneB);
		else
			System.out.println("Produit impossible!, Le nombre de ligne de la matrice A doit " +
					"être égale au nombre de colonnne de la matrice B");
		
		return new Matrice(elements);
	}
	
	public double getTrace() {
		// Si la matrice n'est pas carré, on retourne 0
		if (!estCarre()) {
			System.out.println("Trace impossible, la matrice doit être carré!");
			return 0;
		}
		
		double trace = 0;
		
		for (int ligne=0; ligne < getLignes(); ligne++) 
			for (int colonne=0; colonne < getColonnes(); colonne++) 
				if (ligne==colonne)
					// On additionne la diagonale
					trace += getElement(ligne,colonne);
		
		return trace;
	}
	
	public double getDeterminant()
	{
		// Si la matrice n'est pas carré, on retourne 0
		if (!estCarre()) {
			System.out.println("Déterminant impossible, la matrice doit être carré!");
			return 0;
		}
			
		int nbLignes = getLignes();
		double determinant = 0;
		
		switch (nbLignes)
		{
			case 1: determinant = getElement(0,0); break;
			default: determinant = getDetOrdreN(); break; 
		}
		
		return determinant;
	}
	
	public Matrice getTransposee() {
		Matrice mat = new Matrice(new double[getLignes()][getColonnes()]);
		
		// Si la matrice n'est pas carré, on retourne une matrice vide
		if (!estCarre()) {
			System.out.println("Transposée impossible, " +
					"la matrice n'est pas carrée!");
			return mat;
		}
		
		for (int ligne = 0; ligne < getLignes(); ligne++)
			for (int colonne = 0; colonne < getColonnes(); colonne++) 
				mat.setElement(colonne, ligne, getElement(ligne,colonne));
		
		return mat;
	}
	
	public Matrice getCoMatrice() {
		Matrice mat = new Matrice(new double[getLignes()][getColonnes()]);
		double determinant = 0;
		int posNeg = 0;
		
		if (!estCarre()) {
			System.out.println("Comatrice impossible, la matrice doit être carre.");
			return mat;
		}
		
		if (getLignes() == 2) {
			mat.setElement(0, 0, getElement(1, 1));
			mat.setElement(0, 1, -1*getElement(1, 0));			
			mat.setElement(1, 0, -1*getElement(0, 1));
			mat.setElement(1, 1, getElement(0, 0));
			return mat;
		}
		
		for (int ligne = 0; ligne < getLignes(); ligne++)
			for (int colonne = 0; colonne < getColonnes(); colonne++){
				determinant = getComplementAlgebrique(ligne, colonne);
				posNeg = getPosNeg(ligne, colonne);
				
//				if ( (posNeg == 1 && determinant < 0) || 
//					 (posNeg == -1 && determinant > 0))
//					determinant *= -1;
				
				mat.setElement(ligne, colonne, determinant);
			}
		
		return mat;
	}
	
	public Matrice getMatriceInverse() {
		Matrice mat = new Matrice(new double[getLignes()][getColonnes()]);
		
		// Si la matrice n'est pas carré, on retourne une matrice vide
		if (!estCarre()) {
			System.out.println("Matrice inverse impossible, car la matrice n'est pas carrée!");
			return mat;
		}
		
		// Si la matrice n'est pas régulière, on retourne une matrice vide
		if (!estReguliere()) {
			System.out.println("Matrice inverse impossible, car la matrice n'est pas réguliere" +
					           " le déterminant soit être différent de 0!");
			return mat;
		}
		
		double det = getDeterminant();
		double valeur = 0;
		mat = getCoMatrice();
		mat = mat.getTransposee();
		
		// Si la matrice est triangulaire
		if (estTriangulaire(Type.TRIANGULAIRE_SUPERIEUR, false) && 
				estTriangulaire(Type.TRIANGULAIRE_INFERIEUR, false)) {
			for (int ligne = 0; ligne < mat.getLignes(); ligne++)
				for (int colonne = 0; colonne < mat.getColonnes(); colonne++) 
					if (ligne==colonne) {
						valeur = 1/mat.getElement(ligne, colonne);
						mat.setElement(ligne, colonne, valeur);
					}
		} 
		else { 	// Autres cas		
			for (int ligne = 0; ligne < mat.getLignes(); ligne++)
				for (int colonne = 0; colonne < mat.getColonnes(); colonne++) { 
					valeur = mat.getElement(ligne, colonne)/det;
					mat.setElement(ligne, colonne, valeur);			
				}
		}
			
		return mat;
	}
	
	public boolean estCarre() {
		return (getLignes() == getColonnes()); 
	}
	
	public boolean estTriangulaire(Type _type, boolean _verifierStricte)
	{
		boolean type    = false;
		boolean stricte = true;
		
		switch (_type) {
			case TRIANGULAIRE_NIMPORTE:  type = verifierTriangulaire(); break;
			case TRIANGULAIRE_INFERIEUR: type = verifierTriangulaireInferieur(); break;
			case TRIANGULAIRE_SUPERIEUR: type = verifierTriangulaireSuperieur();break;
		}
		
		stricte = _verifierStricte ? verifierTriangulaireStricte() : true;
		
		return (type && stricte);
	}
	
	public boolean estReguliere() {
		return (getDeterminant() != 0);
	}
	
	public String afficherMatrice() {
		String output = "";
		for (int ligne=0; ligne < getLignes(); ligne++) {
			
			output += "| ";
			
			for (int colonne=0; colonne < getColonnes(); colonne++) {
				output += this.matrice[ligne][colonne];
				output += " ";
			}
			
			output += "|"+"\n";
		}
		
		return output;
	}
	
	public Type getType(String _type) {
		Type type = Type.TRIANGULAIRE_NIMPORTE;
		
		switch (_type) {
			case "NIMPORTE":  type = Type.TRIANGULAIRE_NIMPORTE; break;
			case "SUPERIEUR": type = Type.TRIANGULAIRE_SUPERIEUR; break;
			case "INFERIEUR": type = Type.TRIANGULAIRE_INFERIEUR; break;
		}
		
		return type;
	}
	
	private boolean memeFormat(Matrice matrice) {
		return (this.getLignes() == matrice.getLignes() && 
			    this.getColonnes() == matrice.getColonnes());
	}
	
	private boolean memeLigneColonne(Matrice matrice)  {		
		return (this.getColonnes() == matrice.getLignes());
	}
	
	private double getDetOrdre2() {		
		return getElement(0,0)*getElement(1,1) 
				- getElement(1,0)*getElement(0,1); 
	}
	
	private double getDetOrdreN() {
		if (getLignes() == 2 && getColonnes() == 2)
			return getDetOrdre2();
		
		double determinant = 0, detLigne = 0;
		
		for (int colonne=0; colonne < getColonnes(); colonne++) {				
			detLigne = getPosNeg(0, colonne)*getElement(0, colonne) * getComplementAlgebrique(0, colonne);					
			determinant += detLigne;
		}
		
		return determinant;
	}
	
	private double getComplementAlgebrique(int ln, int col) {
		int posNewLigne   = 0;
		int posNewColonne = 0;
		boolean isNewLine = false;
		
		Matrice newMat = new Matrice(new double[getLignes() -1][getColonnes() -1]);
		
		for (int ligne=0; ligne < getLignes(); ligne++) {
  			isNewLine = false;
			for (int colonne=0; colonne < getColonnes(); colonne++) {
 				if (ligne != ln && colonne != col) {
					newMat.setElement(posNewLigne, posNewColonne++, getElement(ligne, colonne));
					isNewLine = true;
				}
			}
			posNewColonne = 0;
			
 			if (isNewLine)
				posNewLigne++;
		}
		
		return newMat.getDetOrdreN();
	}
	
	// Fonction qui retourne -1/+1 si impair ou pair de ligne+colonne
	private int getPosNeg(int _ligne, int _colonne) {
		return (int)Math.pow((double)-1,(double)(_ligne+_colonne));
	}

	// Triangulaire supérieur ou inférieur
	private boolean verifierTriangulaire() {
		return (verifierTriangulaireSuperieur() || verifierTriangulaireInferieur());
	}
	
	// Valeurs AU-DESSUS la diagonale NULLES 
	private boolean verifierTriangulaireSuperieur() {
		int ctrLnColZero  = 0; // Compteur du nombre de fois que i > j
		int ctrValeurZero = 0; // Compteur du nombre de fois que c[i,j] = 0

		for (int ligne = 0; ligne < getLignes(); ligne++) 
			for (int colonne = 0; colonne < getColonnes(); colonne++)
				if (ligne > colonne) {
					ctrLnColZero++;
					if (getElement(ligne, colonne) == 0)
						ctrValeurZero++;
				}
				
		return (ctrLnColZero == ctrValeurZero);
	}
	
	// Valeurs SOUS la diagonale NULLES
	private boolean verifierTriangulaireInferieur() {
		int ctrLnColZero  = 0;  // Compteur du nombre de fois que i > j
		int ctrValeurZero = 0; // Compteur du nombre de fois que c[i,j] = 0

		for (int ligne = 0; ligne < getLignes(); ligne++) 
			for (int colonne = 0; colonne < getColonnes(); colonne++)
				if (ligne < colonne) {
					ctrLnColZero++;
					if (getElement(ligne, colonne) == 0)
						ctrValeurZero++;
				}
					
			return (ctrLnColZero == ctrValeurZero);		
		}
	
	private boolean verifierTriangulaireStricte() {
		int ctrLnColZero  = 0; // Compteur du nombre de fois que i == j
		int ctrValeurZero = 0; // Compteur du nombre de fois que c[i,j] = 0
		
		for (int ligne = 0; ligne < getLignes(); ligne++) 
			for (int colonne = 0; colonne < getColonnes(); colonne++)
				if (ligne == colonne) {
					ctrLnColZero++;
					if (getElement(ligne, colonne) == 0)
						ctrValeurZero++;
				}
		
		return (ctrLnColZero == ctrValeurZero);
	}
	
}
