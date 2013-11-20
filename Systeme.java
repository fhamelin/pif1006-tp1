
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
		double detA = matriceA.getDeterminant();
		
		Matrice result = new Matrice(new double[matriceB.getLignes()][matriceB.getColonnes()]);
		
		if (detA == 0) {
			System.out.println("La matrice a un déterminant égal à 0.");
			return result;
		}
		
		for (int currentCol = 0; currentCol < matriceA.getColonnes();currentCol++) {
			Matrice matriceAn = new Matrice(new double[matriceA.getLignes()][matriceA.getColonnes()]);
			
			for (int ligne = 0; ligne < matriceA.getLignes(); ligne++) {
				for (int colonne = 0; colonne < matriceA.getColonnes(); colonne++) {
					if (colonne == currentCol){
						matriceAn.setElement(ligne, colonne, matriceB.getElement(ligne, colonne));
					}
					else {
						matriceAn.setElement(ligne, colonne, matriceA.getElement(ligne, colonne));
					}
				}
			}
			
			double detAn = matriceAn.getDeterminant();
			
			result.setElement(currentCol, 0, detAn / detA);
		}
		
		return result;
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
