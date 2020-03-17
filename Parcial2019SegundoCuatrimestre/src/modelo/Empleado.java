package modelo;

import java.time.LocalDate;

public class Empleado extends Persona {
	
	private boolean esGerente;

	public Empleado(int idPersona, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni,
			boolean esGerente) {
		super(idPersona, nombre, apellido, fechaDeNacimiento, dni);
		this.esGerente = esGerente;
	}

	public Empleado(int idPersona, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni) {
		super(idPersona, nombre, apellido, fechaDeNacimiento, dni);
	}

	public boolean isEsGerente() {
		return esGerente;
	}

	public void setEsGerente(boolean esGerente) {
		this.esGerente = esGerente;
	}

	@Override
	public String toString() {
		return "Empleado "+super.toString() +"[esGerente=" + esGerente + "]";
	}
	
	
	
	

}
