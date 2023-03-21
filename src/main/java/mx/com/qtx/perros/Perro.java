package mx.com.qtx.perros;

public class Perro implements Runnable {
	private String nombre;
	private String raza;
	private Thread hilo;
	
	public Perro(String nombre, String raza) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.hilo = new Thread(this);
	}
	
	public void empezarAladrar() {
		this.hilo.start();
	}
	public void terminarDeLadrar() {
		this.hilo.interrupt();
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}

	public void ladrar() {
		System.out.println(String.format("%-10s", this.nombre) + " dice Guau!" + this.getIdHilo() );
	}
	
	public String getIdHilo() {
		return  " ..." + Thread.currentThread().getName() 
				+ ", id: " 
				+ Thread.currentThread().getId();
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", raza=" + raza + "]";
	}

	public void run() {
		try {
			this.esperarRandom();
			this.ladrar();
			this.esperarRandom();
			this.ladrar();
			this.esperarRandom();
			this.ladrar();
			this.esperarRandom();
			this.ladrar();
		}
		catch(InterruptedException e) {
			System.out.println(String.format("%-10s", this.nombre)  + " ha sido interrumpido" + this.getIdHilo());
		}
		finally {
			System.out.println(String.format("%-10s", this.nombre)  + " dice Auuuuuu " + this.getIdHilo());
		}
	}
	public void esperarRandom() throws InterruptedException {
		int milis = (int)(Math.random() * 3000);
		this.esperar(milis);
	}
	
	public void esperar(int milis) throws InterruptedException {
			Thread.sleep(milis);		
	}
	
	public void avisarFin() {
		try {
			this.hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
