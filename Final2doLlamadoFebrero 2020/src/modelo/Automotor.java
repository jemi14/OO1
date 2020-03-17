package modelo;

public class Automotor {
	
	private int idAutomotor;
	private String dominio;
	private int modelo;
	private String marca;
	private Contribuyente contibuyente;
	
	public Automotor(int idAutomotor, String dominio, int modelo, String marca, Contribuyente contibuyente) {
		super();
		this.idAutomotor = idAutomotor;
		this.dominio = dominio;
		this.modelo = modelo;
		this.marca = marca;
		this.contibuyente = contibuyente;
	}
	
	public Automotor(String dominio, int modelo, String marca, Contribuyente contibuyente) {
		super();
		this.dominio = dominio;
		this.modelo = modelo;
		this.marca = marca;
		this.contibuyente = contibuyente;
	}
	
	public int getIdAutomotor() {
		return idAutomotor;
	}

	public void setIdAutomotor(int idAutomotor) {
		this.idAutomotor = idAutomotor;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getModelo() {
		return modelo;
	}

	public void setModelo(int modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Contribuyente getContibuyente() {
		return contibuyente;
	}

	public void setContibuyente(Contribuyente contibuyente) {
		this.contibuyente = contibuyente;
	}

	@Override
	public String toString() {
		return "Automotor [idAutomotor=" + idAutomotor + ", dominio=" + dominio + ", modelo=" + modelo + ", marca="
				+ marca + ", contibuyente=" + contibuyente + "]";
	}
	
	
	
	

}
