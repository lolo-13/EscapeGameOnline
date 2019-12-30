package fr.compainlaurie.escapegameonline.gamemode;

import java.util.Scanner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import fr.compainlaurie.escapegameonline.Combinaison;
import fr.compainlaurie.escapegameonline.configuration.Configuration;

public abstract class Jeux {

	public String nom;
	public String but;
	public String comparaison;
	public String resultatJoueur = "";
	public String resultatIA = "";
	public Combinaison tourIA;
	public Combinaison tourJoueur;
	public int nombreTentatives = 0;
	public Combinaison nombreIA;
	public Combinaison nombreJoueur;
	public int nombreChiffre = Configuration.nombreChiffre;
	public boolean modeDev = Configuration.modeDev;
	public int nombreTour = Configuration.nombreTour;
	private static Logger logger = LogManager.getLogger(Jeux.class);

	// public Jeux () {

	// }

	public Combinaison nombreJoueur() {
		Scanner sc2 = new Scanner(System.in);
		boolean goodLength = false;
		String nombre = null;
		while (!goodLength) {
			nombre = sc2.nextLine();
			if (nombre.length() != nombreChiffre)
				logger.info("\n" + "le nombre saisi ne contient pas le nombre de chiffre");
			else
				goodLength = true;				
		}
		return new Combinaison(nombre);
	}

	public void textPresentation() {
		logger.info("Mode " + nom + "\n" + "=============" + "\n" + but + " la combinaison");
	}

	public void endGame(String joueur, int nombreTentatives, Combinaison nombreIA) {
		String solution = "";
		if (joueur == "l'humain") {
			solution = nombreIA.afficheCombinaison();
			if (nombreTentatives < nombreTour) {
				logger.info(joueur + " a trouvé la combinaison en " + nombreTentatives + " tour(s)" + "\n"
						+ joueur + " a gagné");
			} else {
				logger.info(joueur + " a perdu" + "\n" + "la solution est: " + solution);
			}
		} else {
			if (nombreTentatives < nombreTour) {
				logger.info(joueur + " a trouvé la combinaison en " + nombreTentatives + " tour(s)" + "\n"
						+ joueur + " a gagné");
			} else
				logger.info(joueur + " a perdu");
		}
	}

	public abstract void gameLoop();

}