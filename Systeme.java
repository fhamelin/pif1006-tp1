
public class Systeme {
	private Matrice matriceA;
	private Matrice matriceB;
	
	public Systeme(Matrice a, Matrice b)
	{
		matriceA = a;
		matriceB = b;
	}
	
	public Matrice getMatriceA()
	{
		return matriceA;
	}
	
	public Matrice getMatriceB()
	{
		return matriceB;
	}
	
	public Matrice trouverXParCramer()
	{
		return matriceA;
	}
	
	public Matrice trouverXParInversionMatricielle()
	{
		return matriceA;
	}
	
	public Matrice trouverXParJacobi(double epsilon)
	{
		return matriceA;
	}
}
