package modelo;

public class Cliente {

	protected int idCliente;
	protected long dni;
	protected String nombre;
	protected String apellido;
	protected String telefono;
	
	public Cliente(int idCliente, long dni, String nombre, String apellido, String telefono) {
		super();
		this.idCliente = idCliente;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public Cliente(long dni, String nombre, String apellido, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}
	
	public Cliente() {
		super();
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", telefono=" + telefono + "]";
	}
	
	
}
