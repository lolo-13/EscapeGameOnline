package fr.compainlaurie.escapegameonline.gamemode.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import fr.compainlaurie.escapegameonline.Combinaison;
import fr.compainlaurie.escapegameonline.gamemode.Jeux;

public class Duel extends Jeux {

	private static Logger logger = LogManager.getLogger(Duel.class);
	
	public Duel() {
		this.nom = "DUEL";
		this.but = "Sois le premier � trouver";
	}

	@Override
	public void gameLoop() {
		// TODO Auto-generated method stub

		logger.info("Veuillez saisir un nombre � " + nombreChiffre + " chiffres");
		nombreTentatives = 0;		
		Combinaison nombreJoueur = new Duel().nombreJoueur();
		Combinaison nombreIA = new Combinaison();
		Combinaison tourJoueur;
		Combinaison tourIA = new Combinaison();
		String resultatJoueur, resultatIA;
		if (modeDev)
			logger.info("la solution est: " + nombreIA.afficheCombinaison());
		do {
			nombreTentatives++;
			logger.info("tour joueur");
			tourJoueur = new Duel().nombreJoueur();
			resultatJoueur = nombreIA.compare(tourJoueur);
			logger.info("R�sultat Joueur: " + resultatJoueur);
			resultatIA = nombreJoueur.compare(tourIA);
			logger.info("Tour IA " + nombreTentatives + " : " + tourIA.getValue()[0] + "/" + tourIA.getValue()[1] + "/"
					+ tourIA.getValue()[2] + "/" + tourIA.getValue()[3]);
			logger.info("R�sultat IA " + resultatIA);
			tourIA = new Combinaison(resultatIA, tourIA);
		} while (!tourIA.equals(nombreJoueur) && !tourJoueur.equals(nombreIA) && nombreTentatives <= nombreTour);
		String joueur = "";
		if (resultatJoueur.contentEquals("====")) {
			joueur = "l'humain";
		}
		if (nombreJoueur.compare(tourIA).contentEquals("====")) {
			joueur = "L'IA";
			nombreTentatives = nombreTentatives + 1;			
			logger.info("Tour IA " + nombreTentatives + ": " + tourIA.getValue()[0] + "/" + tourIA.getValue()[1] + "/" + tourIA.getValue()[2] + "/"
					+ tourIA.getValue()[3]);
		}
		if (!nombreJoueur.compare(tourIA).contentEquals("====") && !nombreIA.compare(tourJoueur).contentEquals("====")) {
			joueur = "Personne";
		}
		endGame(joueur, nombreTentatives, nombreIA, nom);
	}
}
