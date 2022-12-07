package MainPackage;

public class Cotxe {
	// ATRIBUTS
	protected static final String marca = "CUPRA";
	protected static String model = "FORMENTOR";
	protected final int potencia;

	// CONSTRUCTOR
	public Cotxe(String modelIn, int potencia) {
		model = modelIn;
		this.potencia = potencia;
	}

	// METODES
	public static void frenar() {
		System.out.println("El vehicle està frenant");
	}

	public void accelerar() {
		System.out.println("El vehicle està accelerant");
	}
}
