package NoticiesPackage;

import MainPackage.ToolsLcl.*;

public class Futbol extends Noticia {
	// ATRIBUTS
	protected String competicio;
	protected String club;
	protected String jugador;

	// CONSTRUCTOR
	public Futbol() {
		super();
	}

	public Futbol(String titular, String text) {
		super(titular, text);
		// Es cerquen la competició, club i jugador
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

	public String getJugador() {
		return jugador;
	}

	public void setJugador(String jugador) {
		this.jugador = jugador;
	}

	// METODES
	@Override
	public int calcularPreuNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.preu = enumNoticia.Futbol.preu;
		// Competicions
		if (text.contains(enumCompeticio.LligaCampions.tipus.toLowerCase())) {
			this.preu += enumCompeticio.LligaCampions.preu;
		}
		// Equips
		if (text.contains(enumEquip.Barca.equip.toLowerCase())) {
			this.preu += enumEquip.Barca.preu;
		}
		if (text.contains(enumEquip.Madrid.equip.toLowerCase())) {
			this.preu += enumEquip.Madrid.preu;
		}
		// Jugadors
		if (text.contains(enumDeportista.FerranTorres.deportista.toLowerCase())) {
			this.preu += enumDeportista.FerranTorres.preu;
		}
		if (text.contains(enumDeportista.Benzema.deportista.toLowerCase())) {
			this.preu += enumDeportista.Benzema.preu;
		}

		// SORTIDA
		return this.preu;
	}

	@Override
	public int calcularPuntuacioNoticia() {
		// DEFINICIO VARIABLES
		String text = this.text.toLowerCase();

		// ACCIONS
		this.puntuacio = enumNoticia.Futbol.punts;
		// Competicions
		if (text.contains(enumCompeticio.LligaCampions.tipus.toLowerCase())) {
			this.puntuacio += enumCompeticio.LligaCampions.punts;
		}
		if (text.contains(enumCompeticio.Lliga.tipus.toLowerCase())) {
			this.puntuacio += enumCompeticio.Lliga.punts;
		}
		// Equips
		if (text.contains(enumEquip.Barca.equip.toLowerCase())) {
			this.puntuacio += enumEquip.Barca.punts;
		}
		if (text.contains(enumEquip.Madrid.equip.toLowerCase())) {
			this.puntuacio += enumEquip.Madrid.punts;
		}
		// Jugadors
		if (text.contains(enumDeportista.FerranTorres.deportista.toLowerCase())) {
			this.puntuacio += enumDeportista.FerranTorres.punts;
		}
		if (text.contains(enumDeportista.Benzema.deportista.toLowerCase())) {
			this.puntuacio += enumDeportista.Benzema.punts;
		}

		// SORTIDA
		return this.puntuacio;
	}

	private void cercarElements() {
		// DEFINICIO VARIABLES
		String text = super.text.toLowerCase();

		// ACCIONS
		// Competicions
		if (text.contains(enumCompeticio.LligaCampions.tipus.toLowerCase())) {
			this.competicio = enumCompeticio.LligaCampions.tipus;
		} else if (text.contains(enumCompeticio.Lliga.tipus.toLowerCase())) {
			this.competicio = enumCompeticio.Lliga.tipus;
		} else {
			this.competicio = "----";
		}

		// Equips
		if (text.contains(enumEquip.Barca.equip.toLowerCase())) {
			this.club = enumEquip.Barca.equip;
		} else if (text.contains(enumEquip.Madrid.equip.toLowerCase())) {
			this.club = enumEquip.Madrid.equip;
		} else {
			this.club = "----";
		}
		// Jugadors
		if (text.contains(enumDeportista.FerranTorres.deportista.toLowerCase())) {
			this.jugador = enumDeportista.FerranTorres.deportista;
		} else if (text.contains(enumDeportista.Benzema.deportista.toLowerCase())) {
			this.jugador = enumDeportista.Benzema.deportista;
		} else {
			this.jugador = "----";
		}
	}

	public String toString() {
		return String.format("		COMPETICIÓ: %s\r\n		CLUB: %s\r\n		JUGADOR: %s\r\n", this.competicio,
				this.club, this.jugador);
	}

}
