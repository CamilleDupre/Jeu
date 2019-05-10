package Visualisation;
import java.applet.Applet;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;

import Modele.train;

public class Vue extends Applet{

	private static final long serialVersionUID = 1L;

	public void init() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		//setFont(new Font("SansSerif", Font.PLAIN, 14));
		setLayout(gridbag);
		train t =new train();
		VueTrain vueT = new VueTrain(t);
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 1;
		c.gridy = 1;
		gridbag.setConstraints(vueT, c);
		add(vueT, c);

		//création des bouttons 

		c.gridx = 0;
		c.gridy = 0;
		makebutton("Action !", gridbag, c);

		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 2;
		c.gridy = 3;
		makebutton("Gauche", gridbag, c);

		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 3;
		c.gridy = 2;
		makebutton("Haut", gridbag, c);

		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 3;
		c.gridy = 4;
		makebutton("Bas", gridbag, c);

		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 4;
		c.gridy = 3;
		makebutton("Droite", gridbag, c);
		
		c.fill = GridBagConstraints.VERTICAL;
		c.gridx = 3;
		c.gridy = 3;
		makebutton("Ramasse", gridbag, c);

		setSize(100, 500);	

	}

	protected void makebutton(String name,
			GridBagLayout gridbag, GridBagConstraints c) {
		JButton button = new JButton(new Boutton_Action(name));
		button.setVerticalTextPosition(AbstractButton.CENTER);
		button.setHorizontalTextPosition(AbstractButton.CENTER);
		button.setActionCommand(name);

		gridbag.setConstraints(button, c);
		add(button);
	}
	public class Boutton_Action extends AbstractAction {
		
		private static final long serialVersionUID = 1L;

		public Boutton_Action(String texte){
			super(texte);
		}

		public void actionPerformed(ActionEvent e) { 
			
			Modele.Actions.deplacement(e.getActionCommand(), train.bandit);
			Modele.Actions.attrape(train.bandit , train.marshall);  // 
			Modele.Actions.deplaceMarchall(train.marshall);
			Modele.Actions.attrape(train.bandit , train.marshall); //il peut attrapper avant et apres
			
		//	System.out.println(train.bandit.coordonnea()+ " " + train.bandit.coordonneb()); // pour voir les coord
		}
	} 


	public static void main(String[] args) throws InterruptedException {
		JFrame fenetre = new JFrame ("Colt Express Cam & Flo");
		Vue f = new Vue();
		f.init();
		fenetre.add(f);
		fenetre.pack();
		fenetre.setSize(fenetre.getPreferredSize());
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible(true);
		fenetre.setLocation(100, 10);  // placement de la fenetre sur l'écran




	}
}

