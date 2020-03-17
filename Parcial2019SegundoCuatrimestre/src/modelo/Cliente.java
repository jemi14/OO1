package modelo;

import java.time.LocalDate;

public class Cliente extends Persona {
	
	private boolean activo;

	public Cliente(int idPersona, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni,
			boolean activo) {
		super(idPersona, nombre, apellido, fechaDeNacimiento, dni);
		this.activo = activo;
	}

	public Cliente() {
		super();
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente "+super.toString() +"[activo=" + activo + "]";
	}
	
	

}
