package Visualisation;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import Modele.Bandit;
import Modele.Bourse;
import Modele.Magot;
import Modele.Marshall;
import Modele.train;


public class VueTrain extends JPanel implements Observer{
	private static final long serialVersionUID = 1L;

	//Attributs
	private train train;
	
	private final int WIDTH = 300;  // taille fenetre
	private final int HEIGHT = 200;

	
	public VueTrain(Modele.train t) {
		this.train = t;
		
		//Train.addObserver(this);
		Dimension dim = new Dimension(100 + WIDTH*train.NB_WAGONS, 50 + HEIGHT * 2);
		this.setPreferredSize(dim);
	}
	

	public void update() { 
		repaint(); 
	}
		
	public void paintComponent(Graphics g){
		super.repaint();
		
		Bandit bandit = this.train.get();
		Marshall marshall = this.train.getm();
		ArrayList<Bourse> bourse = this.train.getb() ;
		Magot magot = this.train.getmagot();
		int compteur = 0;
		for (int i = 25; i < train.NB_WAGONS*WIDTH + 4 * 5; i = i + WIDTH + 5) {
			int compteur1 = 1;
			for (int j = 15; j < 2*HEIGHT + 10; j = j + HEIGHT + 10) {
				paint(g, i, j);
				if (bandit.coordonnea()== compteur1 && bandit.coordonneb()== compteur ) {  // on parcourd tous les emplacement
			         paintBandit(g, i+10, j+150);
		         }
				if (marshall.coordonne()== compteur && compteur1 == 0 ) {  // on parcourd tous les emplacement
					paintMarshall(g, i+250, j+150);
		         }
				
				for ( Bourse b : bourse) {
				if (b.coordonne()== compteur && compteur1 == 0 ) {  // on parcourd tous les emplacement
					paintBourse(g, i+200, j+180);
		         }
				}
				 
				if (magot.coordonne()== compteur && compteur1 == 0 ) {  // on parcourd tous les emplacement
					paintMagot(g, i+160, j+170);
		         }
				compteur1--;
			}
			compteur++;
		}
		update();
		 
	}


	public void paint(Graphics g, int x, int y){
		g.setColor(Color.GRAY);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	public void paintBandit(Graphics g, int x, int y){
		g.setColor(Color.RED);
		g.fillRect(x, y, 20, 50);
	}
	public void paintMarshall(Graphics g, int x, int y){
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, 20, 50);
	}
	public void paintBourse(Graphics g, int x, int y){
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 20, 20);
	}
	public void paintMagot(Graphics g, int x, int y){
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, 60, 30);
	}
}