package modelo;

import java.time.LocalDate;

public class Lote {
	
	private Sucursal sucursal;
	private Producto productos;
	private LocalDate fechaAlta;
	private int cantidadInicial;
	private int cantidadActual;
	private boolean activo;
	
	public Lote(Sucursal sucursal, Producto productos, LocalDate fechaAlta, int cantidadInicial, int cantidadActual,
			boolean activo) {
		super();
		this.sucursal = sucursal;
		this.productos = productos;
		this.fechaAlta = fechaAlta;
		this.cantidadInicial = cantidadInicial;
		this.cantidadActual = cantidadActual;
		this.activo = activo;
	}

	public Lote() {
		super();
	}
	
	public Lote(Sucursal sucursal, Producto productos, LocalDate fechaAlta, int cantidadInicial, boolean activo) {
		super();
		this.sucursal = sucursal;
		this.productos = productos;
		this.fechaAlta = fechaAlta;
		this.cantidadInicial = cantidadInicial;
		this.activo = activo;
		
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Producto getProductos() {
		return productos;
	}

	public void setProductos(Producto productos) {
		this.productos = productos;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public int getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public int getCantidadActual() {
		return cantidadActual;
	}

	public void setCantidadActual(int cantidadActual) {
		this.cantidadActual = cantidadActual;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Lote [sucursal=" + sucursal.toString2() + ", productos=" + productos.toStringProducto() + ", fechaAlta=" + fechaAlta
				+ ", cantidadInicial=" + cantidadInicial + ", cantidadActual=" + cantidadActual + ", activo=" + activo
				+ "]";
	}
	
	
	
	
	
	

}
