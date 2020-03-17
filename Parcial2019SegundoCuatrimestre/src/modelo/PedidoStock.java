package modelo;

import java.time.LocalDate;

public class PedidoStock {
	
	private int idPedidoStock;
	private LocalDate fecha;
	private Producto producto;
	private int cantidad;
	private Empleado vendedor;
	private Cliente cliente;
	private boolean resuelto;
	
	public PedidoStock(int idPedidoStock, LocalDate fecha, Producto producto, int cantidad, Empleado vendedor,
			Cliente cliente, boolean resuelto) {
		super();
		this.idPedidoStock = idPedidoStock;
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.resuelto = resuelto;
	}

	public PedidoStock(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente,
			boolean resuelto) {
		super();
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.resuelto = resuelto;
	}
	
	public PedidoStock(int idPedidoStock, LocalDate fecha, Producto producto, int cantidad, Empleado vendedor,
			Cliente cliente) {
		super();
		this.idPedidoStock = idPedidoStock;
		this.fecha = fecha;
		this.producto = producto;
		this.cantidad = cantidad;
		this.vendedor = vendedor;
		this.cliente = cliente;
	}

	public PedidoStock() {
		super();
	}

	public int getIdPedidoStock() {
		return idPedidoStock;
	}

	public void setIdPedidoStock(int idPedidoStock) {
		this.idPedidoStock = idPedidoStock;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public boolean isResuelto() {
		return resuelto;
	}

	public void setResuelto(boolean resuelto) {
		this.resuelto = resuelto;
	}

	@Override
	public String toString() {
		return "PedidoStock [idPedidoStock=" + idPedidoStock + ", fecha=" + fecha + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", resuelto=" + resuelto + "]";
	}
	
	
	
	
	

}
