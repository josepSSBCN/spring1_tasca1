package Telefons;

public class Telefon {
	// ATRIBUTS
	private String marca;
	private String model;
	
	// CONSTRUCTORS
	public Telefon (String marca, String model) {
		this.marca = marca;
		this.model = model;
	}
	
	
	// GETTERS & SETTERS
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	// METODES
	public void trucar(String num) {
		System.out.println("S'està trucant al nº: " + num);
	}
	

}
