package modelo;

public class Cliente {
	
	private int idCliente;
	private String apellido;
	private String nombre;
	private int dni;
	private char sexo;
	private String nroCliente;
	private boolean activo;
	
	public Cliente(int idCliente, String apellido, String nombre, int dni, char sexo, String nroCliente,
			boolean activo) {
		super();
		this.idCliente = idCliente;
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.nroCliente = nroCliente;
		this.activo = activo;
	}

	public Cliente() {
		super();
	}

	public Cliente(String apellido, String nombre, int dni, char sexo, String nroCliente, boolean activo) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.dni = dni;
		this.sexo = sexo;
		this.nroCliente = nroCliente;
		this.activo = activo;
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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getNroCliente() {
		return nroCliente;
	}

	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni
				+ ", sexo=" + sexo + ", nroCliente=" + nroCliente + ", activo=" + activo + "]";
	}
	
	/********************************************/
	public boolean validarNroCliente(String nroCliente) {
		int digito=0;
		int suma=0;
		boolean respuesta=false;
		
		String validarNro= String.valueOf(nroCliente);
		for(int i=0; i<validarNro.length(); i++) {
			int n1= Integer.parseInt(validarNro.substring(0, 1))*9;
			int n2= Integer.parseInt(validarNro.substring(1, 2))*8;
			int n3= Integer.parseInt(validarNro.substring(2, 3))*7;
			int n4= Integer.parseInt(validarNro.substring(3, 4))*6;
			
			suma=n1+n2+n3+n4;
			digito= suma%9;
			
		}
			if(digito==Integer.parseInt(validarNro.substring(4, 5))) {
				respuesta=true;
			}
			return respuesta;
	}
	
	
	
	

}
