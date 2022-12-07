package MainPackage;

import Telefons.*;

public class Main {

	public static void main(String[] args) {
		// DEFINICIO DE VARIABLES
		Smartphone galaxyS20 = new Smartphone("SAMSUNG", "Galaxy S20 Plus Ultra");

		// ACCIONS
		System.out.println("CRIDA AL MÈTODE: trucar()");
		galaxyS20.trucar("601020204");
		System.out.println("\nCRIDA AL MÈTODE: fotografiar()");
		galaxyS20.fotografiar();
		System.out.println("\nCRIDA AL MÈTODE: alarma()");
		galaxyS20.alarma();

	}
}
