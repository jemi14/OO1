package modelo;

public class Contribuyente extends Persona {
	
	private boolean esExcepto;

	public Contribuyente(int idPersona, String apellido, String nombre, int dni, boolean esExcepto) {
		super(idPersona, apellido, nombre, dni);
		this.esExcepto = esExcepto;
	}

	public boolean isEsExcepto() {
		return esExcepto;
	}

	public void setEsExcepto(boolean esExcepto) {
		this.esExcepto = esExcepto;
	}

	@Override
	public String toString() {
		return super.toString()+" Contribuyente [esExcepto=" + esExcepto + "]";
	}
	
	
	
	
	

}
