package almacenes;


public class Puerta {

	private boolean ocupada;


	public Puerta() {
		this.ocupada = false;
	}

	//Comprueba si la puerta está ocupada.
	public boolean estadoPuerta() {
		return this.ocupada;
	}


	public synchronized void desocuparPuerta() {
		this.ocupada = false;
		this.notify();
	}


	public synchronized boolean intentarEntrar() {

		// Si la puerta sigue ocupada después de esperar, devuelve false
		if (this.ocupada) {
			return false;

		}else {
			this.ocupada = true;
			return true;
		}


	}
}