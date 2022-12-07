package NoticiesPackage;

import MainPackage.ToolsLcl.enumCompeticio;
import MainPackage.ToolsLcl.enumEquip;
import MainPackage.ToolsLcl.enumNoticia;

public class Basquet extends Noticia{
	// ATRIBUTS
	private String competicio;
	private String club;

	
	// CONSTRUCTOR
	public Basquet() {
		super();
	}

	public Basquet(String titular, String text) {
		super(titular, text);
		// Es cerca la competició i l'equip
		cercarElements();
	}
	

	// GETTERS & SETTERS
	public String getCompeticio() {
		return competicio;
	}

	public void setCompeticio(String competicio) {
		this.competicio = competicio;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}
	
	
	// METODES
	@Override
	public int calcularPreuNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.preu = enumNoticia.Basquet.preu;
		// Competicions
		if (text.contains(enumCompeticio.EuroLliga.tipus.toLowerCase())) {
			this.preu += enumCompeticio.EuroLliga.preu;
		}
		if (text.contains(enumCompeticio.ACB.tipus.toLowerCase())) {
			this.preu += enumCompeticio.ACB.preu;
		}
		// Equips
		if (text.contains(enumEquip.Barca.equip.toLowerCase())) {
			this.preu += enumEquip.Barca.preu;
		}
		if (text.contains(enumEquip.Madrid.equip.toLowerCase())) {
			this.preu += enumEquip.Madrid.preu;
		}		

		// SORTIDA
		return this.preu;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.puntuacio = enumNoticia.Basquet.punts;
		// Competicions
		if (text.contains(enumCompeticio.EuroLliga.tipus.toLowerCase())) {
			this.puntuacio += enumCompeticio.EuroLliga.punts;
		}
		if (text.contains(enumCompeticio.ACB.tipus.toLowerCase())) {
			this.puntuacio += enumCompeticio.ACB.punts;
		}
		// Equips
		if (text.contains(enumEquip.Barca.equip.toLowerCase())) {
			this.puntuacio += enumEquip.Barca.punts;
		}
		if (text.contains(enumEquip.Madrid.equip.toLowerCase())) {
			this.puntuacio += enumEquip.Madrid.punts;
		}
		
		// SORTIDA
		return this.puntuacio;
	}
	
	private void cercarElements() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		// Competicions
		if (text.contains(enumCompeticio.EuroLliga.tipus.toLowerCase())) {
			this.competicio = enumCompeticio.EuroLliga.tipus;
		}else if (text.contains(enumCompeticio.ACB.tipus.toLowerCase())) {
			this.competicio = enumCompeticio.ACB.tipus;
		}
		// Equips
		if (text.contains(enumEquip.Barca.equip.toLowerCase())) {
			this.club = enumEquip.Barca.equip;
		}else if (text.contains(enumEquip.Madrid.equip.toLowerCase())) {
			this.club = enumEquip.Madrid.equip;
		}else {
			this.club = "----";
		}
	}

	public String toString() {
		return String.format("		COMPETICIÓ: %s\r\n		CLUB: %s\r\n",
				this.competicio, this.club);
	}


}
