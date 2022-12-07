package RedaccioPackage;

import java.util.ArrayList;

import NoticiesPackage.Noticia;

public class Redaccio {
	// ATRIBUTS
	private ArrayList<Redactor> redactors;

	// CONSTRUCTORA
	public Redaccio() {
		redactors = new ArrayList<Redactor>();
	}

	// GETTERS & SETTERS
	public ArrayList<Redactor> getRedactors() {
		return redactors;
	}

	public void setRedactors(ArrayList<Redactor> redactors) {
		this.redactors = redactors;
	}

	// METODES
	public boolean afegirRedactor(Redactor nouRedactor) {
		// DEFINICIO VARIABLES
		boolean resultat = false;
		int index = 0;

		// ACCIONS
		// Comprovem si ja existeix
		index = cercarRedactor(nouRedactor);
		if (index == -1) {
			this.redactors.add(nouRedactor);
			resultat = true;
		}

		// SORTIDA
		return resultat;

	}

	/**
	 * S'afegeix una noticia al redactor
	 * @param idRedactor  Nº de la posició del redactor en l'array
	 * @param novaNoticia Classe noticia
	 * @return true=s'ha afegit correctament; false= no s'ha pogut afegir
	 */
	public boolean afegirNoticia(int idRedactor, Noticia novaNoticia) {
		// DEFINICIÓ VARIABLES
		boolean resultat = false;

		// ACCIONS
		// 1) es comprova que el index existeixi
		if (redactors.size() >= idRedactor) {
			// 2) Crida al mètode que afegeix la noticia
			resultat = redactors.get(idRedactor).afegirNoticia(novaNoticia);
		}

		// SORTIDA
		return resultat;
	}

	public int calcularPuntsNoticia(int idRedactor, int idNoticia) {
		// DEFINICIO VARIABLES
		int resultat = -1;

		// ACCIONS
		resultat = redactors.get(idRedactor).calcularPuntsNoticia(idNoticia);

		// SORTIDA
		return resultat;
	}

	public int calcularPreuNoticia(int idRedactor, int idNoticia) {
		// DEFINICIO VARIABLES
		int resultat = -1;

		// ACCIONS
		resultat = redactors.get(idRedactor).calcularPreuNoticia(idNoticia);

		// SORTIDA
		return resultat;
	}

	public boolean eliminarRedactor(int idRedactor) {
		// ATRIBUTS
		boolean resultat = false;

		// ACCIONS
		if (redactors.size() > idRedactor) {
			this.redactors.remove(idRedactor);
			resultat = true;
		}

		// SORTIDA
		return resultat;
	}

	public boolean eliminarNoticia(int idRedactor, int idNoticia) {
		// DEFINIR VARIABLES
		boolean resultat = false;

		// ACCIONS
		resultat = redactors.get(idRedactor).eliminarNoticia(idNoticia);

		// SORTIDA
		return resultat;

	}

	public String mostrarRedactors() {
		// DEFINICIO VARIABLES
		String resultat = "";

		// ACCIONS
		for (int i = 0; i < this.redactors.size(); i++) {
			resultat = resultat + String.format("\r\n%d.- %s %s", i + 1,
					this.redactors.get(i).getNom(), this.redactors.get(i).getDNI());
		}

		// SORTIDA
		return resultat;

	}

	public String mostrarNoticies() {
		// DEFINICIO VARIABLES
		String text = "", text2 = "";

		// ACCIONS
		for (int i = 0; i < redactors.size(); i++) {
			// Crea el redactor
			text = text + String.format("NOTICIES DEL REDACTOR '%s'", redactors.get(i).getNom());
			text2 = redactors.get(i).mostrarNoticies();
			if (text2.length() != 0) {
				text = text + "\r\n" + text2 + "\r\n\r\n";
			} else {
				text = text + "\r\n" + "Aquest redactor no te noticies actualment." + "\r\n\r\n";
			}
		}

		// SORTIDA
		return text;

	}

	/**
	 * Mètode per crear un text amb les noticies i el id
	 * 
	 * @param idRedactor
	 * @return
	 */
	public String mostrarNoticiesRedactor(int idRedactor, boolean mostrarMissatge) {
		// DEFINICIO VARIABLES
		String text = "";
		ArrayList<Noticia> noticies = new ArrayList<>();

		// ACCIONS
		if (redactors.size() >= idRedactor) {
			noticies = redactors.get(idRedactor).getNoticies();
			if (noticies.size() > 0) {
				if (mostrarMissatge) {
					text = String.format("NOTICIES DEL REDACTOR '%s'\r\n", redactors.get(idRedactor).getNom());
				}
				for (int i = 0; i < noticies.size(); i++) {
					text = String.format("%s %s.- %s\r\n", text, i + 1, noticies.get(i).getTitular());
				}
			}
		} else {
			text = "";
		}

		// SORTIDA
		return text;

	}

	/**
	 * Mètode per comprovar si el redactor està en la llista de redactors
	 * 
	 * @param redactor Elredactor en questió que hem de cercar
	 * @return L'index de la posició en l'array de redacotrs.
	 */
	private int cercarRedactor(Redactor redactor) {
		// DEFINICIÓ VARIABLES
		boolean resultat = false;
		int index = 0;

		// ACCIONS
		while (!resultat && index < this.redactors.size()) {
			if (this.redactors.get(index).getDNI() == redactor.getDNI()) {
				resultat = true;
			} else {
				index++;
			}
		}
		// SORTIDA
		return (resultat) ? index : -1;
	}
}
