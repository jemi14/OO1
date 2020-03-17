package modelo;

import java.time.LocalDate;

public class Cliente {
	
	private int idCliente;
	private String apellido;
	private String nombre;
	private long dni;
	private String email;
	private LocalDate fechaDeNacimiento;
	
	public Cliente(int idCliente, String apellido, String nombre, long dni, String email, LocalDate fechaDeNacimiento) {
		super();
		this.idCliente = idCliente;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Cliente() {
		super();
	}
	
	public Cliente(String apellido, String nombre, long dni) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ ", email=" + email + ", fechaDeNacimiento=" + fechaDeNacimiento + "]";
	}
	
	
	
	

}
