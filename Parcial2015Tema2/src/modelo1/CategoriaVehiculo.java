package modelo1;

public class CategoriaVehiculo {
	
	private int idCategoria;
	private String categoria;
	private float precio;
	
	public CategoriaVehiculo(int idCategoria, String categoria, float precio) {
		super();
		this.idCategoria = idCategoria;
		this.categoria = categoria;
		this.precio = precio;
	}

	public CategoriaVehiculo(String categoria, float precio) {
		super();
		this.categoria = categoria;
		this.precio = precio;
	}

	public CategoriaVehiculo() {
		super();
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "CategoriaVehiculo [idCategoria=" + idCategoria + ", categoria=" + categoria + ", precio=" + precio
				+ "]";
	}
	
	
	
	

}
