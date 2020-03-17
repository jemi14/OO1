package modelo;

import java.time.LocalDate;

public class Comprobante {
	
	protected LocalDate fecha;
	protected Producto producto;
	protected int cantidad;
	protected Empleado vendedor;
	
	public Comprobante(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor) {
		super();
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.vendedor = vendedor;
	}

	public Comprobante() {
		super();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Empleado getVendedor() {
		return vendedor;
	}

	public void setVendedor(Empleado vendedor) {
		this.vendedor = vendedor;
	}

	@Override
	public String toString() {
		return "Comprobante [fecha=" + fecha + ", producto=" + producto.toStringProducto() + ", cantidad=" + cantidad + ", vendedor="
				+ vendedor + "]";
	}
	
	
	
	

}
