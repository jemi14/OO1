package modelo;

public class Propiedad {
	
	private int idPropiedad;
	private long nroPartida;
	private String calle;
	private int numero;
	private int piso;
	private String departamento;
	private String localidad;
	private String provincia;
	private Locador propietario;
	
	public Propiedad(int idPropiedad, long nroPartida, String calle, int numero, int piso, String departamento,
			String localidad, String provincia, Locador propietario) {
		super();
		this.idPropiedad = idPropiedad;
		this.nroPartida = nroPartida;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.departamento = departamento;
		this.localidad = localidad;
		this.provincia = provincia;
		this.propietario = propietario;
	}

	public Propiedad(long nroPartida, String calle, int numero, int piso, String departamento, String localidad,
			String provincia, Locador propietario) {
		super();
		this.nroPartida = nroPartida;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.departamento = departamento;
		this.localidad = localidad;
		this.provincia = provincia;
		this.propietario = propietario;
	}

	public Propiedad() {
		super();
	}

	public int getIdPropiedad() {
		return idPropiedad;
	}

	public void setIdPropiedad(int idPropiedad) {
		this.idPropiedad = idPropiedad;
	}

	public long getNroPartida() {
		return nroPartida;
	}

	public void setNroPartida(long nroPartida) {
		this.nroPartida = nroPartida;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Locador getPropietario() {
		return propietario;
	}

	public void setPropietario(Locador propietario) {
		this.propietario = propietario;
	}

	@Override
	public String toString() {
		return "Propiedad [idPropiedad=" + idPropiedad + ", nroPartida=" + nroPartida + ", calle=" + calle + ", numero="
				+ numero + ", piso=" + piso + ", departamento=" + departamento + ", localidad=" + localidad
				+ ", provincia=" + provincia + ", propietario=" + propietario + "]";
	}
	
	
	
	

}
