package fr.compainlaurie.escapegameonline.configuration;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConfigReader {

	public String line = "";
	private static Logger logger= LogManager.getLogger(ConfigReader.class);

	public void read() {

		File file = new File("src/main/ressources/config.properties");
		Scanner reader = null;

		try {
			final String separateur = "=";
			reader = new Scanner(file);
			while (reader.hasNext()) {
				String line = reader.next();
				String[] para = line.split(separateur);
				if(para[0].contentEquals("modeDev")) {
					Configuration.modeDev = Boolean.getBoolean(para[1]);
				}
				if(para[0].contentEquals("nombreTour")) {
					Configuration.nombreTour = Integer.parseInt(para[1]);
				}
				if(para[0].contentEquals("nombreChiffre")) {
					Configuration.nombreChiffre = Integer.parseInt(para[1]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Fichier properties introuvable");
			
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
}
