package InstrumentsPackage;

public class Corda extends Instrument {

	// CONSTRUCTORS
	public Corda(String nom, float preu) {
		super(nom, preu);
		// S'executa cada cop que es crea una instància
		System.out.println("CLASSE 'Corda': 	Constructor. 	Nom instancia: " + nom);
	}
	
	static {
		// S'executa 1 sol cop
		// En la creació de la primera instància
		System.out.println("CLASSE 'Corda': 	bloc estatic");
	}
	{
		// S'executa vàris cops 
		// En cada instància abans del constructor
		System.out.println("CLASSE 'Corda': 	bloc {}. 	Nom instancia: " + super.nom);
	}

	// METODES
	@Override
	public void tocar() {
		System.out.println("Està sonant un instrument de corda");		
	}

}