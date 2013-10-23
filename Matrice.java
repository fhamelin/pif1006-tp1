
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
	
	public Matrice additionner(Matrice matrice)
	{
		return this;
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
}
