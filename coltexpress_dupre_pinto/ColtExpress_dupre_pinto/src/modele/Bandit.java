package modele;

public class Bandit {

	private int[] coord = new int[2]  ;;
	private int y;
	private String nom;
	
public Bandit (String Name, int x , int y){
	this.coord[0] = x ;
	this.coord[1]= y;
	this.nom = Name;
	
}
	enum Direction{
		Avant,
		Arriere ,
		Haut ,
		Bas
	}

public int [] coordonne(Bandit b){
	return b.coord;
}

public String nom(Bandit b){
	return b.nom;
}
	
	
}
