package MainPackage;

public class Main {

	public static void main(String[] args) {
		// DEFINICIO VARIABLES
		Cotxe cotxe_1;
		Cotxe cotxe_2;
		
		
		// ACCIONS
		// DIFERENCIA ENTRE ATRIBUTS STATIC FINAL, STATIC I FINAL
		// ATRIBUT MARCA:STATIC FINAL
		// És igualx totes les instàncies
		// NO es pot modificar
		System.out.println(Cotxe.marca);

		// ATRIBUT STATIC: Model
		// És igual x totes les instàncies
		// Modificant 1 instància es modifiquen en totes
		cotxe_1 = new Cotxe("FORMENTOR", 150);
		cotxe_2 = new Cotxe("BORN", 140);
		System.out.println("cotxe 1: " + cotxe_1.model);
		System.out.println("cotxe 2: " + cotxe_2.model);
		cotxe_1.model = "BORN";
		System.out.println("cotxe 1: " + cotxe_1.model);
		System.out.println("cotxe 2: " + cotxe_2.model);

		// ATRIBUT TIPUS FINAL: Potencia
		// És diferent x cada instància
		// NO es pot modificar, després d'haver-se creat
		System.out.println("cotxe 1: " + cotxe_1.potencia);
		System.out.println("cotxe 2: " + cotxe_2.potencia);
		// Si s'intenta modificar, dona error de compilació
		// cotxe_1.potencia = 123;

		// DIFERENCIA ENTRE MÈTODE STATIC I NO ESTÀTIC
		// METODE STATIC: Frenar
		// En la classe 'cotxe' ja existeix.
		Cotxe.frenar();
		// MÈTODE NO ESTÀTIC: ACCELERAR
		// Sols existeix en les instàncies
		System.out.println("Mètode no estàtic 'accelerar': sols existeix en les instàncies.");
		cotxe_1.accelerar();

	}

}
