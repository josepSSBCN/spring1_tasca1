package MainPackage;

import java.util.ArrayList;
import NoticiesPackage.*;
import RedaccioPackage.*;

public class Main {

	public static void main(String[] args) {
		// DEFINICIO VARIABLES
		Redaccio redaccio = new Redaccio();

		// ACCIONS
		// Mètode x afegir dades a les llistes i no començar des de 0
		redaccio = ToolsLcl.afegirInfoProva();

		// S'inicia el programa
		menuPrincipal(redaccio);

		// SORTIDA
		System.out.println("Programa finalitzat.");

	}

	// METODES PRIVATS PRINCIPALS
	private static void menuPrincipal(Redaccio redaccio) {
		// DEFINICIÓ VARIABLES
		boolean sortir = false;
		int opcioSeleccionada = -1;
		String text;

		do {
			// 1) MENU PRINCIPAL
			text = "****MENÚ PRINCIPAL****\r\n" + "1.- Introduir redactor.\r\n" + "2.- Eliminar redactor.\r\n"
					+ "3.- Introduir notícia a un redactor.\r\n" + "4.- Eliminar notícia.\r\n"
					+ "5.- Mostrar totes les notícies per redactor.\r\n" + "6.- Calcular puntuació de la notícia.\r\n"
					+ "7.- Calcular preu-notícia.\r\n" + "8.- Mostrar tots els redactors.\r\n"
					+ "0.- Sortir del programa." + "\r\n";
			System.out.println(text);

			// 2) ESPERA SELECCIO DE L'USUARI
			opcioSeleccionada = ToolsGlbl.scannerInt("Selecciona una opció");

			// 3) CRIDA AL METODE SELECCIONAT
			switch (opcioSeleccionada) {
			case 0:
				sortir = true;
				break;
			case 1:
				redaccio = afegirRedactor(redaccio);
				break;
			case 2:
				redaccio = eliminarRedactor(redaccio);
				break;
			case 3:
				redaccio = novaNoticia(redaccio);
				break;
			case 4:
				redaccio = eliminarNoticia(redaccio);
				break;
			case 5:
				mostrarTotesNoticiesRedacotr(redaccio);
				break;
			case 6:
				redaccio = calcularPuntuacioNoticia(redaccio);
				break;
			case 7:
				redaccio = calcularPreuNoticia(redaccio);
				break;
			case 8:
				mostrarRedactors(redaccio);
				break;
			default:
				break;
			}
		} while (!sortir);
	}

	private static Redaccio afegirRedactor(Redaccio redaccio) {
		// DEFINICIÓ VARIABLES
		String nom = "", dni = "", text = "";
		Redactor nouRedactor;

		// ACCIONS
		System.out.println("\r\nOPCIÓ 1: Afegir redactor.");
		// 1) INTRODUEIX DADES DEL NOU REDACOTR
		nom = ToolsGlbl.scannerStrg("Nom del nou redactor...", true);
		dni = ToolsGlbl.scannerStrg("DNI del nou redactor...", true);
		nouRedactor = new Redactor(nom, dni);

		// 2) S'AFEGEIX A LA LLISTA DE REDACTORS
		if (redaccio.afegirRedactor(nouRedactor)) {
			text = String.format("El redactor '%s' amb DNI '%s', s'ha afegit correctament!!", nom, dni);
		} else {
			text = String.format("Aquest redactor, ja existeix en la redacció.");
		}

		// SORTIDA
		System.out.println(text + "\r\n\r\n");
		ToolsGlbl.polsarTeclaPerContinuar();
		return redaccio;
	}

	private static Redaccio eliminarRedactor(Redaccio redaccio) {
		// DEFINIR VARIABLES
		int idRedactor;
		String text = "";

		// ACCIONS
		System.out.println("\r\nOPCIÓ 2: Eliminar redactor.");
		// 1) Usuari selecciona el redactor
		text = "Introdueix el nº del redactor que vols eliminar...";
		idRedactor = seleccionarRedactor(text, redaccio);
		if (idRedactor != -1) {
			// 2) S'elimina el redactor
			if (redaccio.eliminarRedactor(idRedactor)) {
				text = String.format("El redactor s'ha eliminat correctament.");
			} else {
				text = String.format("Error en el procés per eliminar el redactor.");
			}
		} else {
			text = "Error en la selecció del redactor a eliminar.";
		}

		// SORTIDA
		System.out.println(text + "\r\n\r\n");
		ToolsGlbl.polsarTeclaPerContinuar();
		return redaccio;

	}

	private static Redaccio novaNoticia(Redaccio redaccio) {
		// DEFINIR VARIABLES
		boolean resultat = false;
		int idRedactor = -1, idNoticia = -1;
		String text = "";

		// ACCIONS
		System.out.println("\r\nOPCIÓ 3: Introduir nova notícia.");
		// 1) Usuari selecciona el redactor
		text = "Introdueix el nº del redactor que vols afeger-li la notícia...";
		idRedactor = seleccionarRedactor(text, redaccio);
		if (idRedactor != -1) {
			// 2) Usuari entra dades notícia
			idNoticia = seleccionarTipusNoticia();
			if (idNoticia != -1) {
				// 3) S'afegeix la notícia al redactor
				redaccio = afegirNoticia(idRedactor, idNoticia, redaccio);
				resultat = true;
			}
		}

		// SORTIDA
		if (resultat) {
			text = "Noticia afegida correctament.";
		} else {
			text = "No s'ha pogut afegir la notícia.";
		}
		System.out.println("\r\n" + text + "\r\n\r\n");
		ToolsGlbl.polsarTeclaPerContinuar();
		return redaccio;

	}

	private static Redaccio eliminarNoticia(Redaccio redaccio) {
		// DEFINICIO VARIABLES
		boolean resultat;
		int idRedactor, idNoticia;
		String text = "";

		// ACCIONS
		System.out.println("\r\nOPCIÓ 4: Eliminar notícia.");
		// 1) Usuari selecciona el redactor
		text = "Introdueix el nº del redactor del qui vols eliminar la notícia...";
		idRedactor = seleccionarRedactor(text, redaccio);
		if (idRedactor != -1) {
			// 2) Usuari selecciona notícia
			idNoticia = seleccionarNoticiaRedactor(idRedactor, false, redaccio);
			if (idNoticia != -1) {
				// 3) S'elimina la notícia
				resultat = redaccio.eliminarNoticia(idRedactor, idNoticia);
				if (resultat) {
					text = "notícia eliminada correctament.";
				} else {
					text = "Error en el procés d'eliminació de la notícia.";
				}
			} else {
				text = "Error en la selecció de la notícia i no s'ha pogut eliminar.";
			}
		} else {
			text = "Error en la selecció del redactor i no s'ha pogut eliminar la notícia.";
		}

		// SORTIDA
		System.out.println(text + "\r\n\r\n");
		ToolsGlbl.polsarTeclaPerContinuar();
		return redaccio;

	}

	private static Redaccio mostrarTotesNoticiesRedacotr(Redaccio redaccio) {
		// DEFINICIO VARIABLES
		String text = "";

		// ACCIONS
		// 1) Es crida al mètode de redacció que crea el text
		text = redaccio.mostrarNoticies();

		// SORTIDA
		System.out.println(text);
		ToolsGlbl.polsarTeclaPerContinuar();
		return redaccio;

	}

	private static Redaccio calcularPuntuacioNoticia(Redaccio redaccio) {
		// DEFINICIO VARIABLES
		int puntsNoticia, idRedactor, idNoticia;
		String text = "";

		// ACCIONS
		System.out.println("\r\nOPCIO 6: Calcular puntuació de la notícia.");
		// 1) Usuari selecciona el redactor
		text = "Introdueix el nº del redactor...";
		idRedactor = seleccionarRedactor(text, redaccio);
		if (idRedactor != -1) {
			// 2) Usuar selecciona noticia del redactor
			idNoticia = seleccionarNoticiaRedactor(idRedactor, false, redaccio);
			if (idNoticia != -1) {
				// 3) Calcula puntuació
				puntsNoticia = redaccio.calcularPuntsNoticia(idRedactor, idNoticia);
				if (puntsNoticia != -1) {
					text = String.format("La notícia té una puntuació de %s punts", puntsNoticia);
				} else {
					text = "Error en el procés de càlcul dels punts de la notícia.";
				}
			} else if (idNoticia == -2) {
				text = "Aquest redactor no te noticies.";
			} else {
				text = "Error en la selecció de la notícia i no s'ha pogut calcular els punts de la notícia.";
			}
		} else {
			text = "Error en la selecció del redactor i no s'ha pogut calcular els punts de la notícia.";
		}

		// SORTIDA
		System.out.println(text + "\r\n\r\n");
		ToolsGlbl.polsarTeclaPerContinuar();
		return redaccio;

	}

	private static Redaccio calcularPreuNoticia(Redaccio redaccio) {
		// DEFINICIO VARIABLES
		int preuNoticia, idRedactor, idNoticia;
		String text = "";

		// ACCIONS
		System.out.println("\r\nOPCIO 7: Calcular preu de la notícia.");
		// 1) Usuari selecciona redactor
		text = "Introdueix el nº del redactor...";
		idRedactor = seleccionarRedactor(text, redaccio);
		if (idRedactor != -1) {
			// 2) Usuari selecciona noticia
			idNoticia = seleccionarNoticiaRedactor(idRedactor, false, redaccio);
			if (idNoticia != -1) {
				// 3) Càlcul preu noticia 
				preuNoticia = redaccio.calcularPreuNoticia(idRedactor, idNoticia);
				if (preuNoticia != -1) {
					text = String.format("La notícia té un preu de %s €.", preuNoticia);
				} else {
					text = "Error indeterminat i no s'ha pogut calcular el preu de la notícia.";
				}
			} else {
				text = "Error en la selecció de la notícia i no s'ha pogut calcular el preu de la notícia.";
			}
		} else {
			text = "Error en la selecció del redactor i no s'ha pogut calcular el preu de la notícia.";
		}

		// SORTIDA
		System.out.println(text + "\r\n\r\n");
		ToolsGlbl.polsarTeclaPerContinuar();
		return redaccio;

	}

	private static Redaccio mostrarRedactors(Redaccio redaccio) {
		// DEFINICIÓ VARIABLES
		String text;

		// ACCIONS
		System.out.println("\r\nOPCIO 8: Mostrar tots els redactors.");
		text = redaccio.mostrarRedactors();
		if (text.length() == 0) {
			text = "No hi ha redactors en la redaccio.";
		}

		// SORTIDA
		System.out.println(text + "\r\n\r\n");
		ToolsGlbl.polsarTeclaPerContinuar();
		return redaccio;

	}

	// METODES PRIVATS SECUNDARIS
	/**
	 * 
	 * @return Posició del redactor en la llista de redactors (de 0 a X)
	 */
	private static int seleccionarRedactor(String missatge, Redaccio redaccio) {
		// DEFINIR VARIABLES
		String text = "";
		int idRedactor = 0;
		ArrayList<Redactor> redactors = redaccio.getRedactors();

		// ACCIONS
		if (redactors.size() != 0) {
			text = missatge;
			text = text + redaccio.mostrarRedactors();
			idRedactor = ToolsGlbl.scannerInt(text) - 1;
			if (idRedactor == -1) {
				text = "Has de seleccionar el nº d'un dels redactors de la llista.";
			} else {
				text = "";
			}
		} else {
			text = "No hi ha redactors per afegir la notícia.";
		}

		// SORTIDA
		System.out.println(text);
		return idRedactor;
	}

	private static int seleccionarTipusNoticia() {
		// DEFINICIÓ DE VARIABLES
		int tipusNoticia = -1;
		String text = "";

		// ACCIONS
		text = "Introdueix el nº del tipus de notícia que vols crear\r\n";
		text = text + ToolsLcl.mostrarTipusNoticies();
		tipusNoticia = ToolsGlbl.scannerInt(text) - 1;
		if (tipusNoticia != -1) {
			text = "";
		} else {
			text = "Has de seleccionar el nº d'una de les noticies de la llista.";
		}

		// SORTIDA
		System.out.println(text);
		return tipusNoticia;

	}

	/**
	 * 
	 * @param idRedactor Posició del redactor en la
	 * @return Posició de la notícia en l'array de noticies del redacotr, -1 hi ha
	 *         algun problema
	 */
	private static int seleccionarNoticiaRedactor(int idRedactor, boolean mostrarMissatge, Redaccio redaccio) {
		// DEFINIR VARIABLES
		String text = "";
		int idNoticia = -1;

		// ACCIONS
		// 1) Mostra les noticies del redactor
		text = redaccio.mostrarNoticiesRedactor(idRedactor, mostrarMissatge);
		if (text.length() > 0) {
			text = String.format("Introdueix el ID de la notícia\r\n%s", text);
			idNoticia = ToolsGlbl.scannerInt(text) - 1;
		} else {
			idNoticia = -2;
		}

		// SORTIDA
		return idNoticia;

	}

	private static Redaccio afegirNoticia(int idRedactor, int idNoticia, Redaccio redaccio) {
		// DEFINICIÓ VARIABLES
		String titularNoticia = "", textNoticia = "";
		ToolsLcl.enumNoticia tipusNovaNoticia;

		// ACCIONS
		// 1) Es demana la informació general de la noticia
		titularNoticia = ToolsGlbl.scannerStrg("INTRODUEIX EL TITULAR DE LA NOTICIA", true);
		textNoticia = ToolsGlbl.scannerStrg("INTRODUEIX EL TEXT DE LA NOTICIA", true);

		// 2) S'afegeix la noticia al redactor
		tipusNovaNoticia = ToolsLcl.enumNoticia.values()[idNoticia];
		switch (tipusNovaNoticia) {
		case Futbol:
			Futbol futbol = new Futbol(titularNoticia, textNoticia);
			redaccio.afegirNoticia(idRedactor, futbol);
			break;
		case Basquet:
			Basquet basquet = new Basquet(titularNoticia, textNoticia);
			redaccio.afegirNoticia(idRedactor, basquet);
			break;
		case Tenis:
			Tenis tenis = new Tenis(titularNoticia, textNoticia);
			redaccio.afegirNoticia(idRedactor, tenis);
			break;
		case F1:
			F1 f1 = new F1(titularNoticia, textNoticia);
			redaccio.afegirNoticia(idRedactor, f1);
			break;
		case Motociclisme:
			Motociclisme motociclisme = new Motociclisme(titularNoticia, textNoticia);
			redaccio.afegirNoticia(idRedactor, motociclisme);
			break;
		}

		// SORTIDA
		return redaccio;
	}

}