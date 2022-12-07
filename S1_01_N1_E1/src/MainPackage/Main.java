package MainPackage;

import InstrumentsPackage.*;

public class Main {

	public static void main(String[] args) {
		// S'executa primer els blocs estàtics i després els contructors
		System.out.println("INSTANCIA TIPUS 'CORDA'");
		Corda guitarra = new Corda("Guitarra", 192.25f);
		System.out.println("\r\nINSTANCIA TIPUS 'VENT'");
		Vent flauta = new Vent("Flauta", 49.50f);
		System.out.println("\r\nINSTANCIA TIPUS 'PERCUCIO'");
		Percucio timbal = new Percucio("Timbal", 75.99f);

		// Si tornem a crear la instància, no s'executen els blocs estàtics
		System.out.println("\r\nRE-INSTANCIA TIPUS 'CORDA'");
		guitarra = new Corda("Guitarra", 150.25f);

		// Si es crea una nova instància, tampoc s'executen els blocs estàtics
		System.out.println("\r\nSEGONA INSTANCIA TIPUS 'CORDA'");
		Corda violi = new Corda("Violí", 200.99f);

		// CRIDA ALS DIFERENTS MÈTODES
		System.out.println("\r\nCRIDA ALS MÈTODES 'TOCAR'");
		guitarra.tocar();
		flauta.tocar();
		timbal.tocar();
		violi.tocar();

	}

}
