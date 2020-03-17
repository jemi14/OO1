package modelo;

public class Producto {
	
	private int idProducto;
	private String producto;
	private String codProducto;
	private String talle;
	private double precioUnitario;
	
	public Producto(int idProducto,  String codProducto,String producto, String talle, double precioUnitario) {
		super();
		this.idProducto = idProducto;
		
		this.codProducto = codProducto;
		this.talle = talle;
		this.precioUnitario = precioUnitario;
		this.producto = producto;
	}

	public Producto(String codProducto, String producto, String talle, double precioUnitario) {
		super();
		this.codProducto = codProducto;
		this.producto = producto;
		this.talle = talle;
		this.precioUnitario = precioUnitario;
	}

	public Producto() {
		super();
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	public String getTalle() {
		return talle;
	}

	public void setTalle(String talle) {
		this.talle = talle;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", producto=" + producto + ", codProducto=" + codProducto
				+ ", talle=" + talle + ", precioUnitario=" + precioUnitario + "]";
	}
	
}
