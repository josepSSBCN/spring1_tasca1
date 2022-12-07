package MainPackage;

import java.util.Scanner;

/**
 * Eines comunes a tots els programes
 * 
 * @author josep
 */
public class ToolsGlbl {
	static Scanner myScanner;

	/**
	 * Mètode per demanar a l'usuari que introdueixi un int
	 * 
	 * @param missatge missatge que es mostrarà a l'usuari
	 * @return Torna el int introduït per l'usuari, si no està torna -1
	 */
	public static int scannerInt(String missatge) {
		// DEFINICIÓ VARIABLES
		boolean correcte = false;
		int myInt = -1;

		// ACCIONS
		System.out.println(missatge);
		while (!correcte) {
			try {
				myScanner = new Scanner(System.in);
				myInt = myScanner.nextInt();

				correcte = true;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		// SORTIDA
		return myInt;

	}

	/**
	 * Mètode per demanar a l'usuari que introdueixi un string
	 * 
	 * @param missatge Què s'ha de mostrar.
	 * @param linia    false=sols 1 paraula; true=fins intro
	 * @return El string que ha afegit l'usuari.
	 */
	public static String scannerStrg(String missatge, boolean linia) {
		// DEFINICIÓ VARIABLES
		boolean correcte = false;
		String myString = "";

		// ACCIONS
		System.out.println(missatge);
		while (!correcte) {
			try {
				myScanner = new Scanner(System.in);
				if (linia) {
					myString = myScanner.nextLine();
				} else {
					myString = myScanner.next();
				}

				correcte = true;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		// SORTIDA
		return myString;

	}

	public static void polsarTeclaPerContinuar() {
		// DEFINICIONS
		String text = "";

		// ACCIONS
		do {
			text = scannerStrg("Per continuar, polsar qualsevol tecla + intro.", false);
		} while (text.length() == 0);

	}

}