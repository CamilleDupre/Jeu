package Modele;

import Modele.Bandit;
import Modele.train;

public class Actions {

	//Methods

	public static void deplacement (String direction, Bandit bandit) {
		if (direction == "Droite") {
			if (bandit.coord[1] == train.NB_WAGONS-1){
				System.out.println(bandit.nom() + " est deja sur la locomotive");
			}
			else {
				bandit.coord[1] ++; 
				System.out.println(bandit.nom() + " avance d'un wagon");
			}
		}
		if (direction == "Gauche") {
			if (bandit.coord[1] == 0){
				System.out.println(bandit.nom() + " est deja sur le dernier wagon");
			}
			else {
				bandit.coord[1] --; 
				System.out.println(bandit.nom() + " recule d'un wagon");
			}
		}

		if (direction == "Haut") {
			if (bandit.coord[0] == 1){
				System.out.println(bandit.nom() + " est deja sur le toit");

			}
			else {
				bandit.coord[0] = 1; 
				System.out.println(bandit.nom() + " monte sur le toit");
			}
		}

		if (direction == "Bas") {
			if (bandit.coord[0] == 0){
				System.out.println(bandit.nom() + " est deja à l'intérieur");
			}
			else {
				bandit.coord[0] = 0; 
				System.out.println(bandit.nom() + " descend dans le wagon ");
			}
		}

		if (direction == "Ramasse" ) {
			for(Bourse b : train.bourse) {
			if (bandit.coord[1] == b.coord && bandit.coord[0] == 0){
				bandit.butin += b.butin ;
				System.out.println(bandit.nom() + " a ramassé une bourse : " + bandit.butin);  // pour voir si l'argent monte 
				// il faut supprimer la bourse
				//train.bourse.remove(b); 
				b.coord = train.NB_WAGONS +1 ; // on les sort du plateau
				break;
			}
			if ( bandit.coord[1] == train.magot.coord && bandit.coord[0] == 0){
				bandit.butin += train.magot.butin ;
				System.out.println(bandit.nom() + " c'est emparé du magot ! : " + bandit.butin );// pour voir si l'argent monte
				// supprimer le magot
				train.magot.coord = train.NB_WAGONS +1 ;
			}
			}
		}
	}
	public static void attrape(Bandit bandit , Marshall marshall) {
		if (bandit.coord[1] == marshall.coord && bandit.coord[0] == 0){
			System.out.println(bandit.nom() + " a été attrapé par le Marshall");
			bandit.coord[0] = 1 ;
			bandit.coord[1]= 0;
		}
	}

	public static void deplaceMarchall (Marshall marshall) {
		// faire le déplacement du marshall
		if (Math.random() <= train.NERVOSITE_MARSHALL ) {
			if (Math.random() < 0.5) {
				if (marshall.coord <= train.NB_WAGONS-1 && marshall.coord > 0){
					marshall.coord -- ;
					System.out.println("Le Marshall bouge attention !! ");
				}
			}
			else if (Math.random() > 0.5) {
				if (marshall.coord < train.NB_WAGONS-1 && marshall.coord >= 0 ){
					marshall.coord ++ ;
				}
			}
		}
	}
}