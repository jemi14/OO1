package modelo;

public class ClienteResidencial extends Cliente{
	
	private String nombre;
	private String apellido;
	private int dni;
	
	public ClienteResidencial(long numeroCliente, String nombre, String apellido, int dni) {
		super(numeroCliente);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
		
	public ClienteResidencial(long numeroCliente) {
		super(numeroCliente);
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
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "ClienteResidencial [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
	/************************************************************************/
	public long getCuit() {
		return 0;
	}
	
	
	
	
	

}
