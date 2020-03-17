package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaYPF {
	
	private List<Cliente>lstClientes=new ArrayList<Cliente>();
	private List<Producto>lstProductos=new ArrayList<Producto>();
	private List<Tarjeta>lstTarjetas=new ArrayList<Tarjeta>();
	
	public SistemaYPF(List<Cliente> lstClientes, List<Producto> lstProductos, List<Tarjeta> lstTarjetas) {
		super();
		this.lstClientes = lstClientes;
		this.lstProductos = lstProductos;
		this.lstTarjetas = lstTarjetas;
	}

	public SistemaYPF() {
		super();
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

	public List<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	public List<Tarjeta> getLstTarjetas() {
		return lstTarjetas;
	}

	public void setLstTarjetas(List<Tarjeta> lstTarjetas) {
		this.lstTarjetas = lstTarjetas;
	}

	@Override
	public String toString() {
		return "SistemaYPF [lstClientes=" + lstClientes + ", lstProductos=" + lstProductos + ", lstTarjetas="
				+ lstTarjetas + "]";
	}
	
	/*-----------------------------------------------------------------------*/
	public int traerMaximoIdCliente(){
		int maximoId = 0;
		for (Cliente cliente: lstClientes){
			if (cliente.getIdCliente()>maximoId){
				maximoId = cliente.getIdCliente();
			}
		}
		return maximoId;
	}

	/*-----------------------------------------------------------------------*/
	public boolean agregarCliente(int idCliente, String nombre, String apellido, String email, long dni) throws Exception {
		boolean respuesta=false;
		Cliente existeCliente= traerCliente(idCliente);
		if(existeCliente!=null){
			throw new Exception("El cliente ya existe");
		}
		else {
			Cliente clienteAgregado=new Cliente(idCliente,nombre,apellido,email,dni);
			lstClientes.add(clienteAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/*************************************************************************/
	public Cliente traerCliente(long dni){
		int i=0;
		boolean respuesta=false;
		Cliente clienteEncontrado=null;
		while(i<lstClientes.size()&& !respuesta){
			if(lstClientes.get(i).getDni()==dni){
				clienteEncontrado=lstClientes.get(i);
			}
			i++;
	}
		return clienteEncontrado;
	}

	/*************************************************************************/
	public boolean agregarCliente(String nombre, String apellido, String email, long dni) throws Exception {
		boolean respuesta=false;
		Cliente existeCliente= traerCliente(dni);
		if(existeCliente!=null){
			throw new Exception("El cliente ya existe");
		}
		else {
			int idProximo=1;
			idProximo=traerMaximoIdCliente()+1;
			Cliente clienteAgregado=new Cliente(idProximo,nombre,apellido,email,dni);
			lstClientes.add(clienteAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/*************************************************************************/
	public Cliente traerCliente(int idCliente){
		int i=0;
		boolean respuesta=false;
		Cliente clienteEncontrado=null;
		while(i<lstClientes.size()&& !respuesta){
			if(lstClientes.get(i).getIdCliente()==idCliente){
				clienteEncontrado=lstClientes.get(i);
			}
			i++;
	}
		return clienteEncontrado;
	}
	
	/*-----------------------------------------------------------------------*/
	public int traerMaximoIdProducto(){
		int maximoId = 0;
		for (Producto producto: lstProductos){
			if (producto.getIdProducto()>maximoId){
				maximoId = producto.getIdProducto();
			}
		}
		return maximoId;
	}

	/*************************************************************************/
	public Producto traerProducto(String nombre){
		int i=0;
		boolean respuesta=false;
		Producto productoEncontrado=null;
		while(i<lstProductos.size()&& !respuesta){
			if(lstProductos.get(i).getNombre().equals(nombre)){
				productoEncontrado=lstProductos.get(i);
			}
			i++;
	}
		return productoEncontrado;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean agregarProducto(String nombre, double precio, String unidadDeMedida, double pesosPorKms) throws Exception {
		boolean respuesta=false;
		Producto existeProducto= traerProducto(nombre);
		if(existeProducto!=null){
			throw new Exception("El producto ya existe");
		}
		else {
			int idProximo=1;
			idProximo=traerMaximoIdProducto()+1;
			Producto productoAgregado=new Producto(idProximo,nombre,precio,unidadDeMedida,pesosPorKms);
			lstProductos.add(productoAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean agregarTarjeta(int kilometros, Cliente cliente) throws Exception {
		boolean respuesta=false;
		
			Tarjeta tarjetaAgregado=new Tarjeta(lstTarjetas.size()+1, kilometros, cliente);
			lstTarjetas.add(tarjetaAgregado);
			respuesta=true;
		
		return respuesta;
	}
	
	/*************************************************************************/
	public boolean agregarTarjeta(Cliente cliente) throws Exception {
		boolean respuesta=false;
		Tarjeta existeTarjeta= traerTarjeta(cliente);
		if(existeTarjeta!=null){
			throw new Exception("La tarjeta ya existe");
		}
		else {
		agregarTarjeta(0,cliente);
		}
	
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public Tarjeta traerTarjeta(Cliente cliente){
		int i=0;
		boolean respuesta=false;
		Tarjeta tarjetaEncontrado=null;
		while(i<lstTarjetas.size()&& !respuesta){
			if(lstTarjetas.get(i).getCliente().getIdCliente()==cliente.getIdCliente()){
				tarjetaEncontrado=lstTarjetas.get(i);
			}
			i++;
	}
		return tarjetaEncontrado;
	}
	
	/*************************************************************************/
	public boolean agregarCompra(Cliente cliente, Producto producto, LocalDate fechaHora, double cantidad) throws Exception {
		
		boolean respuesta = true;
		
		traerTarjeta(cliente).getLstCompras().add(new Compra(producto, fechaHora, cantidad));
				
		return respuesta;
	}
	
	/*************************************************************************/
	public List<Compra> traerCompra(Cliente cliente) {
		
		return traerTarjeta(cliente).getLstCompras();
		
	}
	
	/*************************************************************************/

	
	
	
	
	
	


}
