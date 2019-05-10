package Modele;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class testdeplacement {
	
	@Test
	public void testAction() {
		Bandit b1 = new Bandit("Flo");
		String d1 = "Droite";
		String d2 = "Gauche";
		String d3 = "Haut";
		String d4 = "Bas";
		
		Actions.deplacement (d2, b1);
		assertEquals(1, b1.coord[0]);
		assertEquals(0, b1.coord[1]);
		
		Actions.deplacement (d1, b1);
		assertEquals(1, b1.coord[0]);
		assertEquals(1, b1.coord[1]);
		
		Actions.deplacement (d3, b1);
		assertEquals(1, b1.coord[0]);
		assertEquals(1, b1.coord[1]);
		
		Actions.deplacement (d4, b1);
		Actions.deplacement (d4, b1);
		Actions.deplacement (d1, b1);
		assertEquals(0, b1.coord[0]);
		assertEquals(2, b1.coord[1]);
		
		Actions.deplacement (d3, b1);
		Actions.deplacement (d1, b1);
		Actions.deplacement (d1, b1);
		assertEquals(1, b1.coord[0]);
		assertEquals(3, b1.coord[1]);
		
		Actions.deplacement (d2, b1);
		assertEquals(1, b1.coord[0]);
		assertEquals(2, b1.coord[1]);
	}

}