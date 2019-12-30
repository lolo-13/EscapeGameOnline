package fr.compainlaurie.escapegameonline.gamemode.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import fr.compainlaurie.escapegameonline.Combinaison;
import fr.compainlaurie.escapegameonline.gamemode.Jeux;

public class Defenseur extends Jeux {
	private static Logger logger = LogManager.getLogger(Defenseur.class);

	public Defenseur() {
		this.nom = "Defenseur";
		this.but = "Proposes";
	}

	public void gameLoop() {		
		logger.info("Veuillez saisir un nombre à " + nombreChiffre + " chiffres");
		nombreTentatives = 0;
		Combinaison nombreJoueur = new Defenseur().nombreJoueur();
		Combinaison nombreIA = new Combinaison();
		String resultat;
		String joueur = "";

		while (!nombreIA.equals(nombreJoueur) && nombreTentatives <= nombreTour) {
			nombreTentatives++;			
			resultat = nombreJoueur.compare(nombreIA);			
			logger.info("Tour IA " + nombreTentatives + " : " + nombreIA.getValue()[0] + "/" + nombreIA.getValue()[1]
					+ "/" + nombreIA.getValue()[2] + "/" + nombreIA.getValue()[3]);
			logger.info("résultat: " + resultat);
			nombreIA = new Combinaison(resultat, nombreIA);			
		}
		logger.info("Tour IA " + nombreTentatives + " : " + nombreIA.getValue()[0] + "/" + nombreIA.getValue()[1] + "/"
				+ nombreIA.getValue()[2] + "/" + nombreIA.getValue()[3]);
		logger.info("résultat: " + nombreJoueur.compare(nombreIA));
		if (nombreJoueur.compare(nombreIA).contentEquals("====")) {
			joueur = "L'IA";
		} else {
			joueur = "l'humain";
		}
		endGame(joueur, nombreTentatives, nombreIA, nom);
	}
}
