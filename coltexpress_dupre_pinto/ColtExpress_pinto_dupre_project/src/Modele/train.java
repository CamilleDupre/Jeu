package Modele;

import java.util.ArrayList;
import java.util.Observable;

import Modele.Bandit;


public class train extends Observable {

	public final static int NB_WAGONS = 4 ;
	public final static int NB_BANDITS = 2;
	public final static int NB_ACTIONS = 5;
	public final static String NOM_BANDIT_1 = "Flo" ;
	public final static String NOM_BANDIT_2 = "Cam" ;
	public ArrayList<Bandit> bandits;
	public final static int NB_BOURSE = 3;
	
	//public Marshall marshall;
	public final static double NERVOSITE_MARSHALL = 0.9;
	protected ArrayList<Object> toits= new ArrayList<>();
	protected ArrayList<Object> interieurs= new ArrayList<>();
	
	public static Bandit bandit ;
	public static Marshall marshall ;
	public Bandit bandit_cam ;
	public static ArrayList<Bourse> bourse;
	public static Magot magot ;
	public train (){
		
		bandit = new Bandit (NOM_BANDIT_1);
		bandit_cam = new Bandit (NOM_BANDIT_2);
		marshall = new Marshall();
		bourse = new ArrayList<Bourse>();
		for (int i = 0 ; i < NB_BOURSE ; i++) {
		bourse.add(new Bourse());
		}
		
		magot = new Magot() ;
	}

	//methode
	public Bandit get() {
		return bandit;
	}

	public Marshall getm() {
		return marshall;
	}

	public ArrayList<Bourse> getb() {
		return bourse;
	}

	public Magot getmagot() {
		return magot;
	}

}

