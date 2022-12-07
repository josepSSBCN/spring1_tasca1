package NoticiesPackage;

import MainPackage.ToolsLcl.enumEquip;
import MainPackage.ToolsLcl.enumNoticia;

public class F1 extends Noticia{
	// ATRIBUTS
	protected String escuderia;

	// CONSTRUCTOR
	public F1() {
		super();
	}

	public F1(String titular, String text) {
		super(titular, text);
		// Es cerca lescuderia
		cercarElements();
	}

	// GETTERS & SETTERS
	public String getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(String escuderia) {
		this.escuderia = escuderia;
	}

	// METODES
	@Override
	public int calcularPreuNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.preu = enumNoticia.F1.preu;
		// Equips
		if (text.contains(enumEquip.Ferrari.equip.toLowerCase())) {
			this.preu += enumEquip.Ferrari.preu;
		}
		if (text.contains(enumEquip.Mercedes.equip.toLowerCase())) {
			this.preu += enumEquip.Mercedes.preu;
		}

		// SORTIDA
		return this.preu;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.preu = enumNoticia.F1.punts;
		// Equips
		if (text.contains(enumEquip.Ferrari.equip.toLowerCase())) {
			this.puntuacio += enumEquip.Ferrari.punts;
		}
		if (text.contains(enumEquip.Mercedes.equip.toLowerCase())) {
			this.puntuacio += enumEquip.Mercedes.punts;
		}

		// SORTIDA
		return this.puntuacio;
	}

	private void cercarElements() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		// Equips
		if (text.contains(enumEquip.Ferrari.equip.toLowerCase())) {
			this.escuderia = enumEquip.Ferrari.equip;
		} else if (text.contains(enumEquip.Mercedes.equip.toLowerCase())) {
			this.escuderia = enumEquip.Mercedes.equip;
		}else {
			this.escuderia = "----";
		}

	}

	public String toString() {
		return String.format("		ESCUDERIA: %s\r\n", this.escuderia);
	}

}
