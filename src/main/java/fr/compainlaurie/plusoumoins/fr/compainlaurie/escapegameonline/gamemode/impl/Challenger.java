package fr.compainlaurie.escapegameonline.gamemode.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import fr.compainlaurie.escapegameonline.Combinaison;
import fr.compainlaurie.escapegameonline.gamemode.Jeux;

public class Challenger extends Jeux {
	private static Logger logger = LogManager.getLogger(Challenger.class);

	public Challenger() {
		this.nom = "Challenger";
		this.but = "Trouves";
	}

	public void gameLoop() {

		nombreTentatives = 0;
		Combinaison nombreIA = new Combinaison();
		Combinaison nombreJoueur;
		String resultatJoueur;
		String joueur = "";
		if (modeDev)
			logger.info("la solution est: " + nombreIA.afficheCombinaison());
		do {
			nombreTentatives++;
			logger.info("Tour " + nombreTentatives + "\n" + "Veuillez saisir un nombre à " + nombreChiffre + " chiffres");
			nombreJoueur = new Challenger().nombreJoueur();
			resultatJoueur = nombreIA.compare(nombreJoueur);
			logger.info("résultat: "+resultatJoueur);
			if(resultatJoueur.contentEquals("====")) {
				joueur="l'humain";
			}else {
				joueur="L'IA";
			}			
			// } while (!resultat.contentEquals("===="));
		} while (!nombreIA.equals(nombreJoueur) && nombreTentatives < nombreTour);		
		endGame(joueur, nombreTentatives, nombreIA, nom);
	}

}
