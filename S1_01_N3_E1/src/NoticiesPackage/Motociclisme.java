package NoticiesPackage;

import MainPackage.ToolsLcl.enumEquip;
import MainPackage.ToolsLcl.enumNoticia;

public class Motociclisme extends Noticia {
	// ATRIBUTS
	protected String equip;

	// CONSTRUCTOR
	public Motociclisme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Motociclisme(String titular, String text) {
		super(titular, text);
		// Es cerca l'escuderia
		cercarElements();
	}

	// GETTERS & SETTERS
	public String getEquip() {
		return equip;
	}

	public void setEquip(String equip) {
		this.equip = equip;
	}

	// METODES
	@Override
	public int calcularPreuNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.preu = enumNoticia.Motociclisme.preu;
		// Equips
		if (text.contains(enumEquip.Honda.equip.toLowerCase())) {
			this.preu += enumEquip.Honda.preu;
		}
		if (text.contains(enumEquip.Yamaha.equip.toLowerCase())) {
			this.preu += enumEquip.Yamaha.preu;
		}

		// SORTIDA
		return this.preu;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.preu = enumNoticia.Motociclisme.punts;
		// Equips
		if (text.contains(enumEquip.Honda.equip.toLowerCase())) {
			this.puntuacio += enumEquip.Honda.punts;
		}
		if (text.contains(enumEquip.Yamaha.equip.toLowerCase())) {
			this.puntuacio += enumEquip.Yamaha.punts;
		}

		// SORTIDA
		return this.puntuacio;
	}
	
	private void cercarElements() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		// Equips
		if (text.contains(enumEquip.Honda.equip.toLowerCase())) {
			this.equip = enumEquip.Honda.equip;
		} else if (text.contains(enumEquip.Yamaha.equip.toLowerCase())) {
			this.equip = enumEquip.Yamaha.equip;
		}else {
			this.equip = "----";
		}

	}

	public String toString() {
		return String.format("		EQUIP: %s\r\n", this.equip);
	}

}
