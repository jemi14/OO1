package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaStock {
	
	private List<Producto> lstProductos; 
	private List<Comprobante> lstComprobantes;
	private List<Sucursal> lstSucursales;
	
	public SistemaStock(List<Producto> lstProductos, List<Comprobante> lstComprobantes, List<Sucursal> lstSucursales) {
		super();
		this.lstProductos = new ArrayList<Producto>();
		this.lstComprobantes = new ArrayList<Comprobante>();
		this.lstSucursales = new ArrayList<Sucursal>();
	}

	public SistemaStock() {
		super();
		this.lstProductos = new ArrayList<Producto>();
		this.lstComprobantes = new ArrayList<Comprobante>();
		this.lstSucursales = new ArrayList<Sucursal>();
	}

	public List<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	public List<Comprobante> getLstComprobantes() {
		return lstComprobantes;
	}

	public void setLstComprobantes(List<Comprobante> lstComprobantes) {
		this.lstComprobantes = lstComprobantes;
	}

	public List<Sucursal> getLstSucursales() {
		return lstSucursales;
	}

	public void setLstSucursales(List<Sucursal> lstSucursales) {
		this.lstSucursales = lstSucursales;
	}

	@Override
	public String toString() {
		return "SistemaStock [lstProductos=" + lstProductos + ", lstComprobantes=" + lstComprobantes
				+ ", lstSucursales=" + lstSucursales + "]";
	}
	
	/********************************************************/ //1
	public Producto traerProducto(String descripcion) {
		int i=0;
		Producto productoEncontrado= null;
		while(i<lstProductos.size() && productoEncontrado==null) {
			if(lstProductos.get(i).getDescripcion().equals(descripcion)) {
				productoEncontrado=lstProductos.get(i);
			}
			i++;
		}
		return productoEncontrado;
	}
	
	//----------------------------------------------------/
	public int traerMaximoIdProducto(){
	int maximoId = 0;
	for (Producto producto: lstProductos){
		if (producto.getIdProducto()>maximoId){
			maximoId = producto.getIdProducto();
		}
	}
	return maximoId;
 }
	
	/********************************************************/ //2
	public boolean agregarProducto(String descripcion, double precioUnitario) throws Exception {
		boolean respuesta=false;
		Producto productoExiste=traerProducto(descripcion);
		if(productoExiste!=null) {
			throw new Exception("La descripcion ya existe");
		}
		else {
		int idProductoProximo=1;
		idProductoProximo=traerMaximoIdProducto()+1;
		Producto productoAgregado= new Producto(idProductoProximo, descripcion, precioUnitario);
		lstProductos.add(productoAgregado);
		respuesta=true;
	}
	return respuesta;
	}
	
	/********************************************************/ //3
	public Sucursal traerSucursal(String direccion) {
		int i=0;
		Sucursal sucursalEncontrado= null;
		while(i<lstSucursales.size() && sucursalEncontrado==null) {
			if(lstSucursales.get(i).getDireccion().equals(direccion)) {
				sucursalEncontrado=lstSucursales.get(i);
			}
			i++;
		}
		return sucursalEncontrado;
	}
	
	//----------------------------------------------------/
	public int traerMaximoIdSucursal(){
	int maximoId = 0;
	for (Sucursal sucursal: lstSucursales){
		if (sucursal.getIdSucursal()>maximoId){
			maximoId = sucursal.getIdSucursal();
		}
	}
	return maximoId;
 }
	
	/********************************************************/ //4
	public boolean agregarSucursal(String direccion) throws Exception {
		boolean respuesta=false;
		Sucursal sucursalExiste=traerSucursal(direccion);
		if(sucursalExiste!=null) {
			throw new Exception("La direccion ya existe");
		}
		else {
		int idSucursalProximo=1;
		idSucursalProximo=traerMaximoIdSucursal()+1;
		Sucursal sucursalAgregado= new Sucursal(idSucursalProximo, direccion);
		lstSucursales.add(sucursalAgregado);
		respuesta=true;
	}
	return respuesta;
	}
	
	/********************************************************/ //5
	public Sucursal traerSucursal(int idSucursal) {
		int i=0;
		Sucursal sucursalEncontrado= null;
		while(i<lstSucursales.size() && sucursalEncontrado==null) {
			if(lstSucursales.get(i).getIdSucursal()==idSucursal) {
				sucursalEncontrado=lstSucursales.get(i);
			}
			i++;
		}
		return sucursalEncontrado;
	}
	
	/********************************************************/ //8
	public Producto traerProducto(int idProducto) {
		int i=0;
		Producto productoEncontrado=null;
		while (i<lstProductos.size() && productoEncontrado==null) {
			if(lstProductos.get(i).getIdProducto()==idProducto) {
				productoEncontrado= lstProductos.get(i);
			}
			i++;
		}
		return productoEncontrado;
	}
	
	/********************************************************/ //13
	public Remito generarRemitoDeConsumo(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, String formaDePago) throws Exception {
	Remito remito= new Remito();
	/*
	if(vendedor.getSucursal().traerCantidad(producto)>=cantidad) {
		
		remito= new Remito(fecha, producto, cantidad, vendedor, formaDePago);
		
	} else {
		throw new Exception("No hay producto");
	}**/
	
	remito = generarRemitoDeConsumo(vendedor.getSucursal(), fecha,  producto,  cantidad,  vendedor, formaDePago);
	
	return remito;
	}
	
	
	/********************************************************/ //14
	public Remito generarRemitoDeConsumo(Sucursal sucursal, LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, String formaDePago) throws Exception {
	Remito remito= new Remito();
	
	int cantidadAVender = cantidad;
	
	if(sucursal.traerCantidad(producto)>=cantidad) {
		
		for(Lote l: sucursal.traerLoteActivos(producto)) {
			
			if(l.getCantidadActual()>=cantidad) {
				l.setCantidadActual(l.getCantidadActual()-cantidad);
				cantidadAVender = 0;
			}else {
				cantidadAVender = cantidadAVender - l.getCantidadActual();
				l.setCantidadActual(0);
			}
			
	
		}
		
		remito= new Remito(fecha, producto, cantidad, vendedor, formaDePago);
		
	} else {
		throw new Exception("No hay producto");
	}
	
	return remito;
	}
	
	/********************************************************/ //15
	public SolicitudStock generarSolicitudStock(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor) {
		
		SolicitudStock solicitudStock= new SolicitudStock(fecha, producto, cantidad, vendedor);
		
		return solicitudStock;
	}
	
	/********************************************************/ //16
	public List<Sucursal> validarConsumo(Producto producto, int cantidad) {
		List<Sucursal> listaSucursal= new ArrayList<Sucursal>();
		
		for(Sucursal s: lstSucursales) {
			if(s.validarConsumo(producto, cantidad)) {
				listaSucursal.add(s);
			}
		}
		return listaSucursal;
	}
	
	/********************************************************/ //17
	public void actualizarSolicitudStock(SolicitudStock solicitudStock, long dni, boolean aceptado) {
		
		solicitudStock.getVendedor().setDni(dni);
		solicitudStock.setAceptado(aceptado);
		
	}
	
	

	

	
	
	

}
