package fr.compainlaurie.escapegameonline.gamemode;

import fr.compainlaurie.escapegameonline.gamemode.impl.Challenger;
import fr.compainlaurie.escapegameonline.gamemode.impl.Defenseur;
import fr.compainlaurie.escapegameonline.gamemode.impl.Duel;

public class GameFactory {

	public static Jeux instanciate(char choixMenu) {
		if (choixMenu == '1') {
			return new Challenger();
		} else if (choixMenu == '2') {
			return new Defenseur();
		} else if (choixMenu == '3') {
			return new Duel();
		}
		return null;
	}
}