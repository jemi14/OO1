package modelo;

import java.time.LocalDate;

public class Lote {
	
	private int idLote;
	private LocalDate fechaAlta;
	private Producto producto;
	private int cantidadInicial;
	private int cantidadExistente;
	private boolean activo;
	
	public Lote(int idLote, LocalDate fechaAlta, Producto producto, int cantidadInicial, int cantidadExistente,
			boolean activo) {
		super();
		this.idLote = idLote;
		this.fechaAlta = fechaAlta;
		this.producto = producto;
		this.cantidadInicial = cantidadInicial;
		this.cantidadExistente = cantidadExistente;
		this.activo = activo;
	}

	public Lote() {
		super();
	}

	public Lote(LocalDate fechaAlta, Producto producto, int cantidadInicial, int cantidadExistente, boolean activo) {
		super();
		this.fechaAlta = fechaAlta;
		this.producto = producto;
		this.cantidadInicial = cantidadInicial;
		this.cantidadExistente = cantidadExistente;
		this.activo = activo;
	}

	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public int getCantidadExistente() {
		return cantidadExistente;
	}

	public void setCantidadExistente(int cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", fechaAlta=" + fechaAlta + ", cantidadInicial=" + cantidadInicial
				+ ", cantidadExistente=" + cantidadExistente + ", activo=" + activo + "]";
	}
	
	
	
	
	

}
