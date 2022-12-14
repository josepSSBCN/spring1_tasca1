package NoticiesPackage;

import MainPackage.ToolsLcl.enumDeportista;
import MainPackage.ToolsLcl.enumNoticia;

public class Tenis extends Noticia{	
	// ATRIBUTS
	protected String competicio = "----";
	protected String tenista;

	
	// CONSTRUCTOR
	public Tenis() {
		super();
	}

	public Tenis(String titular, String text) {
		super(titular, text);
		// Es cerque  el tenista
		cercarElements();
	}
	
	
	// GETTERS & SETTERS
	public String getCompeticio() {
		return competicio;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}

	public String getTenista() {
		return tenista;
	}

	public void setTenista(String tenista) {
		this.tenista = tenista;
	}

	
	// METODES
	@Override
	public int calcularPreuNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.preu = enumNoticia.Tenis.preu;
		// Tenistes
		if (text.contains(enumDeportista.Federer.deportista.toLowerCase())) {
			this.preu += enumDeportista.Federer.preu;
		}
		if (text.contains(enumDeportista.Nadal.deportista.toLowerCase())) {
			this.preu += enumDeportista.Nadal.preu;
		}
		if (text.contains(enumDeportista.Djokovic.deportista.toLowerCase())) {
			this.preu += enumDeportista.Djokovic.preu;
		}

		// SORTIDA
		return this.preu;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.puntuacio = enumNoticia.Tenis.punts;
		// Tenistes
		if (text.contains(enumDeportista.Nadal.deportista.toLowerCase())) {
			this.puntuacio += enumDeportista.Nadal.punts;
		}
		if (text.contains(enumDeportista.Federer.deportista.toLowerCase())) {
			this.puntuacio += enumDeportista.Federer.punts;
		}
		if (text.contains(enumDeportista.Djokovic.deportista.toLowerCase())) {
			this.puntuacio += enumDeportista.Djokovic.punts;
		}

		// SORTIDA
		return this.puntuacio;
	}

	private void cercarElements() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS		
		// Tenistes
		if (text.contains(enumDeportista.Federer.deportista.toLowerCase())) {
			this.tenista = enumDeportista.Federer.deportista;
		}else if (text.contains(enumDeportista.Nadal.deportista.toLowerCase())) {
			this.tenista = enumDeportista.Nadal.deportista;
		}else if (text.contains(enumDeportista.Djokovic.deportista.toLowerCase())) {
			this.tenista = enumDeportista.Djokovic.deportista;
		}else {
			this.tenista = "----";
		}
	}

	public String toString() {
		return String.format("		COMPETICI??: %s\r\n		TENISTA: %s\r\n",
				this.competicio, this.tenista);
	}
	
}
