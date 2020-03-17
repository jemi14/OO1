package modelo;

public class Pasaje {
	
	private int idPasaje;
	private Cliente cliente;
	private Vuelo vuelo;
	
	public Pasaje(int idPasaje, Cliente cliente, Vuelo vuelo) {
		super();
		this.idPasaje = idPasaje;
		this.cliente = cliente;
		this.vuelo = vuelo;
	}

	public Pasaje(Cliente cliente, Vuelo vuelo) {
		super();
		this.cliente = cliente;
		this.vuelo = vuelo;
	}

	public Pasaje() {
		super();
	}

	public int getIdPasaje() {
		return idPasaje;
	}

	public void setIdPasaje(int idPasaje) {
		this.idPasaje = idPasaje;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	@Override
	public String toString() {
		return "Pasaje [idPasaje=" + idPasaje + ", cliente=" + cliente + ", vuelo=" + vuelo + "]";
	}
	
	
}
