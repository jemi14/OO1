package modelo;

public class Cliente extends Persona {
	
	private boolean activo;

	public Cliente(int idPersona, String nombre, String apellido, long dni, boolean activo) {
		super(idPersona, nombre, apellido, dni);
		this.activo = activo;
	}
	
	public Cliente(int idPersona, String nombre, String apellido, long dni) {
		super(idPersona, nombre, apellido, dni);
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return super.toString() +"Cliente [activo=" + activo + "]";
	}
	
	
	

}
