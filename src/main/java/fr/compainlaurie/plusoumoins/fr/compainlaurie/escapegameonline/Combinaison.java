package fr.compainlaurie.escapegameonline;

import fr.compainlaurie.escapegameonline.configuration.Configuration;

public class Combinaison {

	private int[] value;
	private int nombreChiffre=Configuration.nombreChiffre;
	

	public Combinaison() {
		this.value = new int[nombreChiffre];
			
		for (int i = 0; i < this.value.length; i++) {
			this.value[i] = 0 + (int)(Math.random() * ((9 - 0) + 1));
		}
	}

	public Combinaison(String input) {
		this.value = new int[nombreChiffre];
		for (int i = 0; i < this.value.length; i++) {
			this.value[i] = Character.getNumericValue(input.charAt(i));
		}
	}

	public Combinaison(String comparaison, Combinaison old) {
		char[] resultat = comparaison.toCharArray();
		this.value = new int[nombreChiffre];
		for (int i = 0; i < resultat.length; i++) {
			if (resultat[i] == '=')
				this.value[i] = old.getValue()[i];
			else if (resultat[i] == '+')
				this.value[i] = old.getValue()[i] + 1;
			else
				this.value[i] = old.getValue()[i] - 1;
		}

	}

	public int[] getValue() {
		return value;
	}

	public String compare(Combinaison combinaison) {

		String comparaison = "";

		for (int i = 0; i < this.value.length; i++) {
			if (this.value[i] == combinaison.getValue()[i])
				comparaison = comparaison + "=";
			else if (this.value[i] > combinaison.getValue()[i])
				comparaison = comparaison + "+";
			else
				comparaison = comparaison + "-";
		}
		return comparaison;
	}

	@Override
	public boolean equals(Object o) {
		// If the object is compared with itself then return true
		if (o == this) {
			return true;
		}
		/*
		 * Check if o is an instance of Complex or not "null instanceof [type]" also
		 * returns false
		 */
		if (!(o instanceof Combinaison)) {
			return false;
		}
		// typecast o to Complex so that we can compare data members
		Combinaison c = (Combinaison) o;
		// Compare the data members and return accordingly
		for (int i = 0; i < c.getValue().length; i++) {
			if (c.getValue()[i] != this.value[i])
				return false;
		}
		return true;
	}
	public String afficheCombinaison() {
	String	solution="";
	for (int i = 0; i <nombreChiffre; i++)
	solution = solution+this.value[i];
	return solution;
	}
}
