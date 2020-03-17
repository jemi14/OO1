package modelo;

public class Inspector extends Persona {
	
	private int legajo;

	public Inspector(int idPersona, String apellido, String nombre, int dni, int legajo) {
		super(idPersona, apellido, nombre, dni);
		this.legajo = legajo;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	@Override
	public String toString() {
		return super.toString() +" Inspector [legajo=" + legajo + "]";
	}
	
	
	
	

}
