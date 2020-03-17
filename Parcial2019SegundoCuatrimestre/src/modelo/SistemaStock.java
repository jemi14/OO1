package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaStock {
	
	private List<Producto> lstProductos;
	private List<Persona> lstPersonas;
	private List<Lote> lstLotes;
	private List<PedidoStock> pedidoStock;
	
	public SistemaStock(List<Producto> lstProductos, List<Persona> lstPersonas, List<Lote> lstLotes,
			List<PedidoStock> pedidoStock) {
		super();
		this.lstProductos = new ArrayList<Producto>();
		this.lstPersonas = new ArrayList<Persona>();
		this.lstLotes = new ArrayList<Lote>();
		this.pedidoStock = new ArrayList<PedidoStock>();
	}

	public SistemaStock() {
		super();
		this.lstProductos = new ArrayList<Producto>();
		this.lstPersonas = new ArrayList<Persona>();
		this.lstLotes = new ArrayList<Lote>();
		this.pedidoStock = new ArrayList<PedidoStock>();
	}

	public List<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(List<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public List<Lote> getLstLotes() {
		return lstLotes;
	}

	public void setLstLotes(List<Lote> lstLotes) {
		this.lstLotes = lstLotes;
	}

	public List<PedidoStock> getPedidoStock() {
		return pedidoStock;
	}

	public void setPedidoStock(List<PedidoStock> pedidoStock) {
		this.pedidoStock = pedidoStock;
	}

	@Override
	public String toString() {
		return "SistemaStock [lstProductos=" + lstProductos + ", lstPersonas=" + lstPersonas + ", lstLotes=" + lstLotes
				+ ", pedidoStock=" + pedidoStock + "]";
	}	
	
	/***************************************************/ //1
	public boolean esCodigoValido(String codigo) throws Exception {
		boolean resultado=false;
		int digito=0;
		int suma=0;
		
		String codigoVerificador= String.valueOf(codigo);
		for(int i=0; i<codigoVerificador.length(); i++) {
			int n1= Integer.parseInt(codigoVerificador.substring(0, 1))*7;
			int n2= Integer.parseInt(codigoVerificador.substring(1, 2))*5;
			int n3= Integer.parseInt(codigoVerificador.substring(2, 3))*2;
			int n4= Integer.parseInt(codigoVerificador.substring(3, 4))*3;
			int n5= Integer.parseInt(codigoVerificador.substring(4, 5))*4;
			int n6= Integer.parseInt(codigoVerificador.substring(5, 6))*6;
			
			suma=n1+n2+n3+n4+n5+n6;
			digito=suma%10;
			
		if(digito==Integer.parseInt(codigoVerificador.substring(6, 7))) {
			resultado=true;
		}
		else {
			throw new Exception("El codigo producto es invalido");
		}
		}
		return resultado;
		}	
	
	/**********************************/ //2
	public List<Producto> traerProducto() {
		return this.getLstProductos();
	}
	
	/**********************************/ //3
	public Producto traerProducto(String codProducto) {
		int i=0;
		Producto productoEncontrado=null;
		while(i<traerProducto().size() && productoEncontrado==null) {
			
			if(traerProducto().get(i).getCodProducto()==codProducto) {
				productoEncontrado=traerProducto().get(i);
			}
			i++;
		}
		return productoEncontrado;
	}
	
	//-------------------------------------------------------//
	public int traerMaximoIdProducto(){
		int maximoId = 0;
		for (Producto producto: lstProductos){
			if (producto.getIdProducto()>maximoId){
				maximoId = producto.getIdProducto();
			}
		}
		return maximoId;
	}
	
	/**********************************/ //4
	public boolean agregarProducto(String codProducto, String producto, String talle, double precio) throws Exception {
		boolean resultado=false;
		boolean errorEncontrado = false;

		Producto productoExiste= traerProducto(codProducto);
		
		if(productoExiste!=null) { 
			errorEncontrado = true;
			
			throw new Exception("El codigo producto ya existe");
		}
		if(!esCodigoValido(codProducto)) { //es lo mismo que ==false
			//no hay que haceer productoExiste.esvalido(codigo)
			errorEncontrado = true;
		}
		if(!errorEncontrado) {	
		int idProductoProximo=1;
			idProductoProximo=traerMaximoIdProducto()+1;
			Producto productoAgregado= new Producto(idProductoProximo, codProducto, producto, talle, precio);
			traerProducto().add(productoAgregado);
			resultado=true;
		}
		return resultado;
	}
	
	//-------------------------------------------------------//
	public int traerMaximoIdPersona(){
		int maximoId = 0;
		for (Persona persona: lstPersonas){
			if (persona.getIdPersona()>maximoId){
				maximoId = persona.getIdPersona();
			}
		}
		return maximoId;
	}
	
	/**********************************/ //5
	public boolean agregarEmpleado(String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, boolean esGerente) {
		boolean respuesta=false;
		
		int idEmpleadoProximo=1;
		idEmpleadoProximo=traerMaximoIdPersona()+1;
		Empleado empleadoAgregado= new Empleado(idEmpleadoProximo, nombre, apellido, fechaDeNacimiento, dni, esGerente);
		traerPersona().add(empleadoAgregado); //lstPersonas
		respuesta= true;
		
		return respuesta;
	}
	
	/**********************************/ //6
	public boolean agregarCliente(String nombre, String apellido, LocalDate fechaDeNacimiento, long dni, boolean activo) {
		boolean respuesta=false;
		
		int idClienteProximo=1;
		idClienteProximo=traerMaximoIdPersona()+1;
		Cliente clienteAgregado= new Cliente(idClienteProximo, nombre, apellido, fechaDeNacimiento, dni, activo);
		traerPersona().add(clienteAgregado); //lstPersonas
		respuesta= true;
		
		return respuesta;
	}
	
	/**********************************/ //7
	public List<Persona> traerPersona() {
		return this.getLstPersonas();
	}
	
	//-------------------------------------------------------//
	public int traerMaximoIdLote(){
		int maximoId = 0;
		for (Lote lote: lstLotes){
			if (lote.getIdLote()>maximoId){
				maximoId = lote.getIdLote();
			}
		}
		return maximoId;
	}
	
	/**********************************/ //8
	public boolean agregarLote(LocalDate fAlta, Producto producto, int cantidadInicial, int cantidadExistente, boolean activo) {
		boolean respuesta=false;
		
		int idLoteProximo=1;
		idLoteProximo=traerMaximoIdLote()+1;
		Lote loteAgregado= new Lote(idLoteProximo, fAlta, producto, cantidadInicial, cantidadExistente, activo);
		traerLote().add(loteAgregado); //lstLotes
		respuesta= true;
		
		return respuesta;
	}
	
	/**********************************/ //9
	public List<Lote> traerLote() {
		return this.getLstLotes();
	}
	
	/**********************************/ //10
	public List<Lote> traerLote(Producto producto) {
		List<Lote> listaLote= new ArrayList<Lote>();
		
		for(Lote l: traerLote()) {
			if(l.getProducto().getIdProducto()==producto.getIdProducto()) {
				listaLote.add(l);
			}
		}
		return listaLote;
	}
	
	/**********************************/ //11
	public List<Lote> traerLote(Producto producto, boolean activo) {
		List<Lote> listaLote= new ArrayList<Lote>();
		
		for(Lote l: traerLote(producto)) {
			if(l.isActivo()==activo) {
				listaLote.add(l);
			}
		}
		return listaLote;
	}
	
	/**********************************/ //12
	public int calcularCantidadExistente(Producto producto) {
		int suma=0;
		
		for(Lote l: traerLote(producto, true)) {
			suma=suma+l.getCantidadExistente();
		}
		return suma;
	}
	
	/**********************************/ //13
	public Empleado traerEmpleado(long dni) {
		int i=0;
		Empleado empleadoEncontrada=null;
		while (i<traerPersona().size() && empleadoEncontrada==null) {
			if(traerPersona().get(i).getDni()==dni) {
				if(traerPersona().get(i) instanceof Empleado) {
					empleadoEncontrada=(Empleado) traerPersona().get(i);
				}
			}
			i++;
		}
		return empleadoEncontrada;
	} 

   /**********************************/ //14
   public Cliente traerCliente(long dni) {
	int i=0;
	Cliente clienteEncontrada=null;
	while (i<traerPersona().size() && clienteEncontrada==null) {
		if(traerPersona().get(i).getDni()==dni) {
			if(traerPersona().get(i) instanceof Cliente) {
				clienteEncontrada=(Cliente) traerPersona().get(i);
			}
		}
		i++;
	}
	    return clienteEncontrada;
    } 
   
	/**********************************/ //15
	public List<PedidoStock> traerPedidoStock() {
		return this.getPedidoStock();
	}
	
	//-------------------------------------------------------//
	public int traerMaximoIdPedidoStock(){
		int maximoId = 0;
		for (PedidoStock pedidoStock: traerPedidoStock()){
			if (pedidoStock.getIdPedidoStock()>maximoId){
				maximoId = pedidoStock.getIdPedidoStock();
			}
		}
		return maximoId;
	}
	
	/**********************************/ //16
	public boolean agregarPedidoStock(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, Cliente cliente) throws Exception {
		boolean respuesta= false;
		
		if(cantidad>calcularCantidadExistente(producto)) {
			throw new Exception("Error, supera la cantidad existente: "+ cantidad + calcularCantidadExistente(producto));
		}
		else {
			int idPedidoStockProximo=1;
			idPedidoStockProximo=traerMaximoIdPedidoStock();
			PedidoStock pedidoStrockAgregada=new PedidoStock(idPedidoStockProximo, fecha, producto, cantidad, vendedor, cliente);
			traerPedidoStock().add(pedidoStrockAgregada);
			respuesta=true;
		}
		return respuesta;
	}
	
	/**********************************/ //17
	public PedidoStock traerPedidoStock(int idPedidoStock) {
		int i=0;
		PedidoStock pedidoStockEncontrado=null;
		while(i<traerPedidoStock().size() && pedidoStockEncontrado==null) {
			if(traerPedidoStock().get(i).getIdPedidoStock()==idPedidoStock) {
				pedidoStockEncontrado=traerPedidoStock().get(i);
			}
			i++;
		}
		return pedidoStockEncontrado;
	}
	
	/**********************************/ //18
   public void resolverPedidoStock(PedidoStock pedidoStock) {
	
	int tengoQueDarle = pedidoStock.getCantidad();
	
	//Mientras no termine de dar los productos
	while (tengoQueDarle>0) {
		
	//traigo los lotes activos de este producto
	Lote l = traerLoteActivoMasViejo(pedidoStock.getProducto());
		
	//si alcanza con este lote
	if(l.getCantidadExistente()>=tengoQueDarle) {
			
			l.setCantidadExistente(l.getCantidadExistente()-tengoQueDarle);
			tengoQueDarle = 0;
		}
	
	//sino alcanza este lote
	if(l.getCantidadExistente()<tengoQueDarle) {
		tengoQueDarle = tengoQueDarle - l.getCantidadExistente();
		//dejo en cero la cantidad existente, use todo ya , y lo pongo pasivo NO ACTIVO:( 
		l.setCantidadExistente(0);
		l.setActivo(false);
		
	}
	}//cieera el while
	
	pedidoStock.setResuelto(true);
	}
	
	/**********************************/ //
	public Lote traerLoteActivoMasViejo(Producto p) {
		Lote lote = new Lote();
		List<Lote> lotes = traerLote(p, true);
		
		//busco el mas viejo
		int indiceMasAntiguo = 0;
		LocalDate antiguo = lotes.get(0).getFechaAlta();
		
		for (int i = 0; i<lotes.size(); i++) {//recorro los lotes activos del producto
			//si no es mas antigua, cambio la antiguedad
			if(!Funciones.esMasAntigua(antiguo, lotes.get(i).getFechaAlta())){
				antiguo = lotes.get(i).getFechaAlta();
				indiceMasAntiguo = i;
		}
		}
		// ya se cual es el lote mas antiguo de la lista, ahora lo traigo.
		lote = lotes.get(indiceMasAntiguo);
		
		return lote;
	}
	

	

	
	
	
	

}
