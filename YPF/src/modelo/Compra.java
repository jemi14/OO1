package modelo;

import java.time.LocalDate;


public class Compra {
	
	private Producto producto;
	private LocalDate fechaHora;
	private double cantidad;

	
	public Compra(Producto producto, LocalDate fechaHora, double cantidad) {
		super();
		this.producto = producto;
		this.fechaHora = fechaHora;
		this.cantidad = cantidad;
	
	}

	public Compra() {
		super();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public LocalDate getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDate fechaHora) {
		this.fechaHora = fechaHora;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}



	@Override
	public String toString() {
		return "Compra [producto=" + producto + ", fechaHora=" + fechaHora + ", cantidad=" + cantidad + "]";
	}

	
	
	
	
	

}
