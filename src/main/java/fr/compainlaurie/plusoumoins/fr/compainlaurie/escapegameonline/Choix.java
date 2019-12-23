package fr.compainlaurie.escapegameonline;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Choix {
	
	private static Logger logger = LogManager.getLogger(Choix.class);
	Scanner sc2 = new Scanner(System.in);

	public char choixModeJeux() {
		boolean isValid = false;
		char mode = ' ';
		while (!isValid) {
			logger.info("Taper le chiffre correspondant au mode de jeux souhaité" + "\n" + "1. Mode Challenger"
					+ "\n" + "2. Mode défenseur" + "\n" + "3. Mode duel" + "\n"
					+ "4. J'ai changé d'avis, je ne veux pas jouer");
			mode = sc2.nextLine().charAt(0);

			if (mode != '1' && mode != '2' && mode != '3' && mode != '4') {
				logger.info("le mode choisi n'existe pas !");
			} else {
				isValid = true;
			}
		}
		return mode;
	}

	public char choixEndGame() {
	boolean isValid = false;
	char fin = ' ';
	while(!isValid)
	{
		logger.info("Souhaitez-vous" + "\n" + "1. Rejouer avec le même mode"
				+ "\n" + "2. choisir un nouveau mode" + "\n" + "3. Arrêter le jeu");
		fin = sc2.nextLine().charAt(0);

		if (fin != '1' && fin != '2' && fin != '3') {
			logger.info("le choix n'est pas valide !");
		} else {
			isValid = true;
		}
		if(fin =='3') {
			logger.info("Bye-Bye");
		}
	}return fin;
}

}
