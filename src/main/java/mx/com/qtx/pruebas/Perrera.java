package mx.com.qtx.pruebas;

import mx.com.qtx.perros.Perro;

public class Perrera {

	public static void main(String[] args) {
		Perro firu = new Perro("Firulais","French Poodle");
		Perro solovino = new Perro("Solovino","electrico");
		Perro fido = new Perro("Fido", "Boxer");
		Perro barack = new Perro("Barack","Pastor Alemán");
		
		firu.empezarAladrar();
		solovino.empezarAladrar();
		fido.empezarAladrar();
		barack.empezarAladrar();
		
		System.out.println("Arrancan!!" + getIdHilo());
		
		esperarMilis(5000);
		firu.terminarDeLadrar();
		solovino.terminarDeLadrar();
		fido.terminarDeLadrar();
		barack.terminarDeLadrar();
		
		firu.avisarFin();
		solovino.avisarFin();
		fido.avisarFin();
		barack.avisarFin();
				
		System.out.println("*** Han callado todos los perros ***" + getIdHilo());
		
	}

	private static void esperarMilis(int milis) {
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	public static String getIdHilo() {
		return  " ..." + Thread.currentThread().getName() 
				+ ", id: " 
				+ Thread.currentThread().getId();
	}

}
