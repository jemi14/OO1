package modelo;

import java.time.LocalDate;

public class Persona {
	
	private int idPersona;
	private int dni;
	private String apellido;
	private String nombre;
	private LocalDate fechaDeNacimiento;
	
	public Persona(int idPersona, int dni, String apellido, String nombre, LocalDate fechaDeNacimiento) {
		super();
		this.idPersona = idPersona;
		this.dni = dni;
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", dni=" + dni + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", fechaDeNacimiento=" + fechaDeNacimiento + "]";
	}
	
	/*******************************************************/
	public boolean esMayor(int edad, LocalDate fechaHoy) {
		boolean respuesta= false;
		
		int saberEdad= Funciones.calcularEdad(fechaDeNacimiento, fechaHoy);
		int resultado= edad - saberEdad;
		
		if(resultado<=0) {
			respuesta=true;
		}
		if(resultado>0) {
			respuesta=false;
		}
		
		return respuesta;
	}
	
	

}
