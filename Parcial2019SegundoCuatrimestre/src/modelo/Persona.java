package modelo;

import java.time.LocalDate;

public class Persona {
	
	protected int idPersona;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaDeNacimiento;
	protected long dni;
	
	public Persona(int idPersona, String nombre, String apellido, LocalDate fechaDeNacimiento, long dni) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dni = dni;
	}

	public Persona(String nombre, String apellido, LocalDate fechaDeNacimiento, long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.dni = dni;
	}

	public Persona() {
		super();
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + ", dni=" + dni + "]";
	}
	
	
	
	
	

}
