package RedaccioPackage;

import java.util.ArrayList;

import MainPackage.ToolsLcl.enumNoticia;
import NoticiesPackage.*;

public class Redactor {
	// ATRIBUTS
	private String nom;
	private final String dni;
	private static int sou;
	private ArrayList<Noticia> noticies;

	// CONSTRUCTORA
	public Redactor(String nom, String dni) {
		this.noticies = new ArrayList<Noticia>();
		this.dni = dni;
		this.nom = nom;
	}

	// GETTERS & SETTERS
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public static int getSou() {
		return sou;
	}

	public static void setSou(int sou) {
		Redactor.sou = sou;
	}

	public ArrayList<Noticia> getNoticies() {
		return noticies;
	}

	public void setNoticies(ArrayList<Noticia> noticies) {
		this.noticies = noticies;
	}

	public String getDNI() {
		return dni;
	}

	// METODES
	public static void definirSou(int nouSou) {
		sou = nouSou;
	}

	public boolean afegirNoticia(Noticia novaNoticia) {
		this.noticies.add(novaNoticia);
		return true;
	}
	
	public int calcularPuntsNoticia(int idNoticia) {
		// DEFINICIÓ VARIABLES
		int resultat = -1;
				
		// ACCIONS
		resultat = noticies.get(idNoticia).calcularPuntuacioNoticia();
				
		// SORTIDA
		return resultat;
		
	}
	
	public int calcularPreuNoticia(int idNoticia) {
		// DEFINICIÓ VARIABLES
		int resultat = -1;
				
		// ACCIONS
		resultat = noticies.get(idNoticia).calcularPreuNoticia();
				
		// SORTIDA
		return resultat;
		
	}

	public boolean eliminarNoticia(int idNoticia) {
		// DEFINIR VARIABLES
		boolean resultat = false;
		
		// ACCIONS
		if(noticies.size() > idNoticia) {
			this.noticies.remove(idNoticia);
			resultat = true;
		}
		
		
		// SORTIDA
		return resultat;
				
	}
	
	
	public String mostrarNoticies() {
		// DEFINICIO VARIABLES
		String text ="", tipus = "";
		
		// ACCIONS
		for(int i = 0; i < this.noticies.size(); i++) {
			tipus = tipusNoiticia(this.noticies.get(i).getClass().toString());
			text = text + String.format("	NOTICIA %s\r\n		TIPUS: %s\r\n"
					+ "		TITULAR: %s\r\n		TEXT: %s,\r\n"
					+ "		PUNTUACIO: %s\r\n		PREU: %s\r\n"
					,i+1, tipus,
					this.noticies.get(i).getTitular(), this.noticies.get(i).getText(), 
					this.noticies.get(i).getPuntuacio(), this.noticies.get(i).getPreu());
			text = text + this.noticies.get(i).toString();		
		}
		
		// SORTIDA
		return text;
		
	}	
	
	private String tipusNoiticia(String text) {
		text = text.toLowerCase();
		
		if(text.contains(enumNoticia.Futbol.tipus.toLowerCase())){
			text = enumNoticia.Futbol.tipus;
		}else if(text.contains(enumNoticia.Basquet.tipus.toLowerCase())){
			text = enumNoticia.Basquet.tipus;
		}else if(text.contains(enumNoticia.Tenis.tipus.toLowerCase())){
			text = enumNoticia.Tenis.tipus;
		}else if(text.contains(enumNoticia.Motociclisme.tipus.toLowerCase())){
			text = enumNoticia.Motociclisme.tipus;
		}else   if(text.contains(enumNoticia.F1.tipus.toLowerCase())){
			text = enumNoticia.F1.tipus;
		}
		
		return text;
	}
}

















