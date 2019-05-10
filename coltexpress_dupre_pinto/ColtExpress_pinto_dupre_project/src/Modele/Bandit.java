package Modele;

public class Bandit {

	public int[] coord = new int[2]  ;;
	String nom;
	int butin = 0;
	int balle = 6;
	
	public Bandit(String Name){
		this.coord[0] = 1 ;
		this.coord[1]= 0;
		this.nom = Name;


	}

	public int coordonnea(){
		return this.coord[0];
	}
	
	public int coordonneb(){
		return this.coord[1];
	}

	public String nom(){
		return this.nom;
	}

}


