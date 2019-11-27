package fr.univ_amu.physic_engine;

import fr.univ_amu.utils.Shape2D;

public class Collision {

	static boolean checkCollision(Shape2D shape1, Shape2D shape2) {
		boolean droite = (shape1.getxPosition() + shape1.getWidth()) >= shape2.getxPosition();
		boolean gauche = (shape1.getxPosition() <= (shape2.getxPosition() + shape2.getWidth()));
		boolean haut   = (shape1.getyPosition() <= (shape2.getyPosition() + shape2.getHeigth()));
		boolean bas    = (shape1.getyPosition() + shape1.getHeigth()) >= shape2.getyPosition();
		
		//Si un seul true, return true
		return (droite || gauche || haut || bas);
	}
}
