package InstrumentsPackage;

public abstract class Instrument {
	// ATTRIBUTS
	protected String nom;
	protected float preu;

	// CONSTRUCTOR
	public Instrument(String nom, float preu) {
		this.nom = nom;
		this.preu = preu;
		
		System.out.println("CLASSE 'Instrument':	Constructor");
	}

	static {
		// S'executa 1 sol cop
		// En la creació de la primera instància de qualsevol de les filles
		System.out.println("CLASSE 'Instrument':	bloc estatic");
	}
	{
		// S'executa vàris cops
		// En la primera instància de cada filla, després del seu bloc estàtic
		System.out.println("CLASSE 'Instrument': 	bloc {}.");
	}

	// METODES
	public abstract void tocar();

}
