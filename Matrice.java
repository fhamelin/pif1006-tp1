
class Matrice {
	private double[][] matrice;
	
	public Matrice(double[][] matrice)
	{
		this.matrice = matrice;
	}
	
	public double getElement(int ligne, int colonne)
	{
		return matrice[ligne][colonne];
	}
	
	public void setElement(int ligne, int colonne, double element)
	{
		matrice[ligne][colonne] = element;
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
		if (memeFormat(matrice)){
			// TODO : throw exception à venir
		}
		
		double[][] elements = new double[getLignes()][getColonnes()];
		
		for (int ligne = 0;ligne < getLignes();ligne++) {
			for (int colonne = 0; colonne < getColonnes();colonne++) {
				elements[ligne][colonne] = getElement(ligne, colonne) + matrice.getElement(ligne, colonne);
			}
		}
		
		return new Matrice(elements);
	}
	
	public Matrice faireProduitScalaire(Double nombre)
	{
		return this;
	}
	
	public Matrice faireProduitMatriciel(Matrice matrice)
	{
		return this;
	}
	
	public double getTrace()
	{
		return 1;
	}
	
	public double getDeterminant()
	{
		return 1;
	}
	
	public Matrice getTransposee()
	{
		return this;
	}
	
	public Matrice getCoMatrice()
	{
		return this;
	}
	
	public Matrice getMatriceInverse()
	{
		return this;
	}
	
	public boolean estCarre()
	{
		return true;
	}
	
	public boolean estTriangulaire()
	{
		return true;
	}
	
	public boolean estReguliere()
	{
		return true;
	}
	
	public boolean memeFormat(Matrice matrice)
	{
		if (this.getLignes() == matrice.getLignes() && this.getColonnes() == matrice.getColonnes())	{
			return true;
		}
		
		return false;
	}
}
