package modele;

import java.util.ArrayList;

import modele.Bandit.Direction;

public class train {

	private final int NB_WAGONS = 4 ;
	private final String NOM_BANDIT_1 = "flo" ;
	
	private Wagon Train[][] = new Wagon[NB_WAGONS][2]  ;  // 4 wagon et haut + bas
	private Bandit bandit ;
	
	public train(Wagon[][] t){
		this.Train = t;		
	}
	
	public void déplacement(Bandit b , Direction d )	{
		
		if (d == Direction.Avant && b.coordonne(b)[0] == NB_WAGONS-1 ){
			System.out.println(b.nom(b) + "est déja dans le wagon de tete");
		}
		
		if (d == Direction.Arriere && b.coordonne(b)[0] == 0 ){
			System.out.println(b.nom(b) + "est déja dans le dernier wagon");
		}
		
	}
	
	
			

}

