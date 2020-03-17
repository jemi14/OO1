package modelo;

public class Producto {

	private int idProducto;
	private String nombreProducto;
	private String codigo;
	private String tipo;
	
	public Producto(){}

	public Producto(int idProducto, String nombreProducto, String codigo, String tipo) {
	this.idProducto = idProducto;
	this.nombreProducto = nombreProducto;
	this.codigo = codigo;
	this.tipo = tipo;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", codigo=" + codigo
				+ ", tipo=" + tipo + "]";
	}
	
	public boolean equals(Producto p) {
		return (p.getIdProducto()==idProducto);
	
	
	}
	
}

