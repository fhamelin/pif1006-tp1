class Matrice {
	private double[][] matrice;
	
	public Matrice(double[][] matrice)
	{
		this.matrice = matrice;
	}
	
	public double getElement(int ligne, int colonne)
	{
		return this.matrice[ligne][colonne];
	}
	
	public void setElement(int ligne, int colonne, double element)
	{
		this.matrice[ligne][colonne] = element;
	}
	
	public int getLignes()
	{
		return matrice.length;
	}
	
	public int getColonnes()
	{
		return matrice[0].length;
	}
	
	public Matrice additionner(Matrice matrice)
	{
		double[][] elements = new double[getLignes()][getColonnes()];
		
		if (memeFormat(matrice)){
			for (int ligne = 0;ligne < getLignes();ligne++) {
				for (int colonne = 0; colonne < getColonnes();colonne++) {
					elements[ligne][colonne] = getElement(ligne, colonne) + matrice.getElement(ligne, colonne);
				}
			}
		}
		else {
			System.out.println("Addition impossible, les matrices sont de format différent");
		}
		
		return new Matrice(elements);
	}
	
	public Matrice faireProduitScalaire(double scalaire)
	{
		double[][] elements = new double[getLignes()][getColonnes()];
		
		for (int ligne = 0;ligne < getLignes();ligne++) {
			for (int colonne = 0; colonne < getColonnes();colonne++) {
				elements[ligne][colonne] = getElement(ligne, colonne) *	scalaire;
			}
		}
		
		return new Matrice(elements);
	}
	
	public Matrice faireProduitMatriciel(Matrice matrice)
	{
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
	
	public double getTrace()
	{
		// Si la matrice n'est pas carré, on retourne 0
		if (!estCarre()) {
			System.out.println("Trace impossible, la matrice doit être carré!");
			return 0;
		}
		
		double trace = 0;
		
		for (int ligne=0; ligne < getLignes(); ligne++) {
			for (int colonne=0; colonne < getColonnes(); colonne++) {
				if (ligne==colonne) {
					// On additionne la diagonale
					trace += getElement(ligne,colonne);
				}
			}
		}
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
	
	public Matrice getTransposee()
	{
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
	
	public Matrice getCoMatrice()
	{
		Matrice mat = new Matrice(new double[getLignes()][getColonnes()]);
		double determinant = 0;
		boolean estPair = false;
		
		if (!estCarre()) {
			System.out.println("Comatrice impossible, la matrice doit être carre.");
			return mat;
		}
		
		for (int ligne = 0; ligne < getLignes(); ligne++)
			for (int colonne = 0; colonne < getColonnes(); colonne++){
				estPair = estPair(ligne+colonne);
				determinant = getComplementAlgebrique(ligne, colonne);
				
				if ( (estPair && determinant < 0) || (!estPair && determinant > 0))
					determinant *= -1;
				
				mat.setElement(ligne, colonne, determinant);
			}
		
		return mat;
	}
	
	public Matrice getMatriceInverse()
	{
		return this;
	}
	
	public boolean estCarre()
	{
		if (getLignes() == getColonnes())
			return true;
		else
			return false;
	}
	
	public boolean estTriangulaire()
	{
		return true;
	}
	
	public boolean estReguliere()
	{
		return true;
	}
	
	private boolean memeFormat(Matrice matrice)
	{
		if (this.getLignes() == matrice.getLignes() && this.getColonnes() == matrice.getColonnes())
			return true;
		
		return false;
	}
	
	private boolean memeLigneColonne(Matrice matrice) 
	{
		if (this.getColonnes() == matrice.getLignes())
			return true;
		
		return false;
	}
	
	public String afficherMatrice()
	{
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
	
	private double getDetOrdre2()
	{		
		return getElement(0,0)*getElement(1,1) 
				- getElement(1,0)*getElement(0,1); 
	}
	
	private double getDetOrdreN()
	{
		if (getLignes() == 2 && getColonnes() == 2)
			return getDetOrdre2();
		
		double determinant = 0, detLigne = 0;
		
		for (int colonne=0; colonne < getColonnes(); colonne++) {	
			detLigne = getElement(0, colonne) * getComplementAlgebrique(0, colonne);
			
			if (!estPair(colonne)) 
				detLigne *= -1;
			
			determinant += detLigne;
		}
		
		return determinant;
	}
	
	private double getComplementAlgebrique(int ln, int col)
	{
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
	
	
	private boolean estPair(int nbr)
	{
		if (nbr%2 == 0)
			return true;
		else
			return false;
	}
}
