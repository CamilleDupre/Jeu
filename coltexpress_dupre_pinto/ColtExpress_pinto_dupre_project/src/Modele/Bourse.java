package Modele;

public class Bourse {

	public int coord ;
	int butin ;
		
	public Bourse(){
		this.coord = (int) (Math.random() * ( 3 - 0 )) ;
		this.butin = (int) (Math.random() * ( 300 - 100 )) ;		
	}

	public int coordonne(){
		return this.coord;
	}
}
