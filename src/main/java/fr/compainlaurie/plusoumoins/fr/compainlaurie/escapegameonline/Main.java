package fr.compainlaurie.escapegameonline;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import fr.compainlaurie.escapegameonline.configuration.ConfigReader;
import fr.compainlaurie.escapegameonline.configuration.Configuration;
import fr.compainlaurie.escapegameonline.gamemode.GameFactory;
import fr.compainlaurie.escapegameonline.gamemode.Jeux;


public class Main {

	private static Logger logger = LogManager.getLogger(Choix.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DOMConfigurator.configure("src/main/ressources/log4j.xml");
		// PropertyConfigurator.configure("src/main/ressources/log4j.properties");

		ConfigReader configReader = new ConfigReader();
		configReader.read();
		if (args.length > 0 && args[0].equals("-dev")) {
			Configuration.modeDev = true;
		}
		boolean inGame = true;
		Choix menu = new Choix();
		char rejouer = '1';

		while (inGame && rejouer != '3') {
			rejouer = '1';
			Jeux jeux = GameFactory.instanciate(menu.choixModeJeux());
			if (jeux == null) {
				logger.info("Bye-bye");
				inGame = false;
			} else {
				while (rejouer == '1') {
					jeux.textPresentation();
					jeux.gameLoop();
					rejouer = menu.choixEndGame();
				}
			}

		}
	}
}
