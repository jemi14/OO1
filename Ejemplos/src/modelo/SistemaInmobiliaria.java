package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaInmobiliaria {
	
	private List<Cliente>lstClientes=new ArrayList<Cliente>();
	private List<Propiedad>lstPropiedades=new ArrayList<Propiedad>();
	private List<Contrato>lstContratos=new ArrayList<Contrato>();

	public SistemaInmobiliaria(List<Cliente> lstClientes, List<Propiedad> lstPropiedades, List<Contrato> lstContratos) {
		super();
		this.lstClientes = lstClientes;
		this.lstPropiedades = lstPropiedades;
		this.lstContratos = lstContratos;
	}

	public SistemaInmobiliaria() {
		super();
	}

	public List<Cliente> getLstClientes() {
		return lstClientes;
	}

	public void setLstClientes(List<Cliente> lstClientes) {
		this.lstClientes = lstClientes;
	}

	public List<Propiedad> getLstPropiedades() {
		return lstPropiedades;
	}

	public void setLstPropiedades(List<Propiedad> lstPropiedades) {
		this.lstPropiedades = lstPropiedades;
	}

	public List<Contrato> getLstContratos() {
		return lstContratos;
	}

	public void setLstContratos(List<Contrato> lstContratos) {
		this.lstContratos = lstContratos;
	}

	/************************************************************************/
	public Cliente traerClientePordni(long dni){
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
	
	/*-----------------------------------------------------------------------*/
	public Cliente traerClientePorId(int idCliente){
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
	public int traerMaximoId(){
		int maximoId = 0;
		for (Cliente cliente: lstClientes){
			if (cliente.getIdCliente()>maximoId){
				maximoId = cliente.getIdCliente();
			}
		}
		return maximoId;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean agregarCliente(int idCliente, long dni, String nombre, String apellido, String telefono) throws Exception {
		boolean respuesta=false;
		Cliente existeCliente= traerClientePordni(dni);
		if(existeCliente!=null){
			throw new Exception("El cliente ya existe");
		}
		else {
			Cliente clienteAgregado=new Cliente(idCliente,dni,nombre,apellido,telefono);
			lstClientes.add(clienteAgregado);
			respuesta=true;
		}
		return respuesta;
	}

	/*-----------------------------------------------------------------------*/
	public boolean agregarCliente(long dni, String nombre, String apellido, String telefono) throws Exception {
		boolean respuesta=false;
		Cliente existeCliente= traerClientePordni(dni);
		if(existeCliente!=null){
			throw new Exception("El cliente ya existe");
		}
		else {
			int idProximo=1;
			idProximo=traerMaximoId()+1;
			Cliente clienteAgregado=new Cliente(idProximo,dni,nombre,apellido,telefono);
			lstClientes.add(clienteAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean modificarClientePorId(int idCliente, long dni, String nombre, String apellido, String telefono) throws Exception {
	boolean respuesta=false;
	Cliente existeCliente=traerClientePorId(idCliente);
	if(existeCliente==null) {
		throw new Exception("El cliente no se puede modificar, no existe en la lista");
	}
		else {
			existeCliente.setIdCliente(idCliente);
			existeCliente.setDni(dni);
			existeCliente.setNombre(nombre);
			existeCliente.setApellido(apellido);
			existeCliente.setTelefono(telefono);
			respuesta= true;
		}
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean modificarClientePordni(long dni, String nombre, String apellido, String telefono) throws Exception {
	boolean respuesta=false;
	Cliente existeCliente=traerClientePordni(dni);
	if(existeCliente==null) {
		throw new Exception("El cliente no se puede modificar, no existe en la lista");
	}
		else {
			existeCliente.setDni(dni);
			existeCliente.setNombre(nombre);
			existeCliente.setApellido(apellido);
			existeCliente.setTelefono(telefono);
			respuesta= true;
		}
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public Cliente traerClientePorNombre(String nombre){
		int i=0;
		boolean respuesta=false;
		Cliente clienteEncontrado=null;
		while(i<lstClientes.size()&& !respuesta){
			if(lstClientes.get(i).getNombre().equals(nombre)){
				clienteEncontrado=lstClientes.get(i);
			}
			i++;
	}
		return clienteEncontrado;
	}
	
	/*-----------------------------------------------------------------------*/
	public float promedioDedni() {
		float resultado=0;
		for(Cliente cliente: lstClientes){
			resultado = resultado+ cliente.getDni();
		}
		return resultado;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean eliminarCliente(long dni) throws Exception{
		boolean resultado=false;
		Cliente existeCliente= traerClientePordni(dni);
		if(existeCliente==null) {
			throw new Exception("El cliente no existe para eliminar");
		}
		else {
			lstClientes.remove(existeCliente);
			resultado=true;
		}
		return resultado;
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public boolean agregarLocador(int idCliente, long dni, String nombre, String apellido, String telefono, 
			                      String aliasCBU, String banco, int diaCobro, int sucursal) throws Exception {
		boolean resultado=false;
		Cliente existeLocador=traerClientePorId(idCliente);
		if(existeLocador!=null) {
			throw new Exception ("No puedo agregar al Locador porque ya existe");
		}
		else {
			Cliente locadorAgregado=new Locador(idCliente,dni,nombre,apellido,telefono, sucursal, banco, diaCobro, aliasCBU);
			lstClientes.add(locadorAgregado);
			resultado=true;
		}
		
		return resultado;
	}
	
	/************************************************************************/
	public boolean agregarLocador(long dni, String nombre, String apellido, String telefono, 
			                      String aliasCBU, String banco, int diaCobro, int sucursal) throws Exception {
		boolean resultado=false;
		Cliente existeLocador=traerClientePordni(dni);
		if(existeLocador!=null) {
			throw new Exception ("No puedo agregar al Locador porque ya existe");
		}
		else {
			int idProximo=1;
			idProximo=traerMaximoId()+1;
			Cliente locadorAgregado=new Locador(idProximo,dni,nombre,apellido,telefono, sucursal, banco, diaCobro, aliasCBU);
			lstClientes.add(locadorAgregado);
			resultado=true;
		}
		
		return resultado;
	}
	
	/*-----------------------------------------------------------------------*/
	public Cliente traerLocadorPorid(int idCliente) {
		int i=0;
		boolean respuesta=false;
		Cliente locadorEncontrada=null;

		while (i<lstClientes.size() && !respuesta) {
			Cliente cliente = lstClientes.get(i);
			if(cliente instanceof Locador) {	
				Locador locador = (Locador) cliente ;
				if(locador.getIdCliente()==idCliente) {
					locadorEncontrada= locador;
					respuesta=true;	
				}	 
			}
			i++;
		}
		return locadorEncontrada;
	}
	
	/*-----------------------------------------------------------------------*/
	public Cliente traerLocadorPordni(long dni) {
		int i=0;
		boolean respuesta=false;
		Cliente locadorEncontrada=null;

		while (i<lstClientes.size() && !respuesta) {
			Cliente cliente = lstClientes.get(i);
			if(cliente instanceof Locador) {	
				Locador locador = (Locador) cliente ;
				if(locador.getDni()==dni) {
					locadorEncontrada= locador;
					respuesta=true;	
				}	 
			}
			i++;
		}
		return locadorEncontrada;
	}
	
	/*-----------------------------------------------------------------------*/
	public Cliente traerLocadorPorNombre(String nombre) {
		int i=0;
		boolean respuesta=false;
		Cliente locadorEncontrada=null;

		while (i<lstClientes.size() && !respuesta) {
			Cliente cliente = lstClientes.get(i);
			if(cliente instanceof Locador) {	
				Locador locador = (Locador) cliente ;
				if(locador.getNombre().equals(nombre)) {
					locadorEncontrada= locador;
					respuesta=true;	
				}	 
			}
			i++;
		}
		return locadorEncontrada;
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++*/
	public boolean agregarLocatorio(int idCliente, long dni, String nombre, String apellido, String telefono, 
                                    boolean enVeraz) throws Exception {
    boolean resultado=false;
    Cliente existeLocatorio=traerClientePorId(idCliente);
    if(existeLocatorio!=null) {
    throw new Exception ("No puedo agregar al Locatorio porque ya existe");
    }
    else {
    Cliente locatorioAgregado=new Locatorio(idCliente,dni,nombre,apellido,telefono, enVeraz);
    lstClientes.add(locatorioAgregado);
    resultado=true;
    }
    return resultado;
    }
	
	/************************************************************************/
	public boolean agregarLocatorio(long dni, String nombre, String apellido, String telefono, 
			                        boolean enVeraz) throws Exception {
		boolean resultado=false;
		Cliente existeLocatorio=traerClientePordni(dni);
		if(existeLocatorio!=null) {
			throw new Exception ("No puedo agregar al Locatorio porque ya existe");
		}
		else {
			int idProximo=1;
			idProximo=traerMaximoId()+1;
			Cliente locatorioAgregado=new Locatorio(idProximo,dni,nombre,apellido,telefono, enVeraz);
			lstClientes.add(locatorioAgregado);
			resultado=true;
		}
		
		return resultado;
	}
	
	/*-----------------------------------------------------------------------*/
	public Cliente traerLocatorioPorid(int idCliente) {
		int i=0;
		boolean respuesta=false;
		Cliente locatorioEncontrada=null;

		while (i<lstClientes.size() && !respuesta) {
			Cliente cliente = lstClientes.get(i);
			if(cliente instanceof Locatorio) {	
				Locatorio locatorio = (Locatorio) cliente ;
				if(locatorio.getIdCliente()==idCliente) {
					locatorioEncontrada= locatorio;
					respuesta=true;	
				}	 
			}
			i++;
		}
		return locatorioEncontrada;
	}
	
	/*-----------------------------------------------------------------------*/
	public Cliente traerLocatorioPordni(long dni) {
		int i=0;
		boolean respuesta=false;
		Cliente locatorioEncontrada=null;

		while (i<lstClientes.size() && !respuesta) {
			Cliente cliente = lstClientes.get(i);
			if(cliente instanceof Locatorio) {	
				Locatorio locatorio = (Locatorio) cliente ;
				if(locatorio.getDni()==dni) {
					locatorioEncontrada= locatorio;
					respuesta=true;	
				}	 
			}
			i++;
		}
		return locatorioEncontrada;
	}
	
	/*-----------------------------------------------------------------------*/
	public Cliente traerLocatorioPorNombre(String nombre) {
		int i=0;
		boolean respuesta=false;
		Cliente locatorioEncontrada=null;

		while (i<lstClientes.size() && !respuesta) {
			Cliente cliente = lstClientes.get(i);
			if(cliente instanceof Locatorio) {	
				Locatorio locatorio = (Locatorio) cliente ;
				if(locatorio.getNombre().equals(nombre)) {
					locatorioEncontrada= locatorio;
					respuesta=true;	
				}	 
			}
			i++;
		}
		return locatorioEncontrada;
	}
	
	/************************************************************************/
	public Propiedad traerPropiedadNroPartida(long nroPartida){
		int i=0;
		boolean respuesta=false;
		Propiedad propiedadEncontrado=null;
		while(i<lstPropiedades.size()&& !respuesta){
			if(lstPropiedades.get(i).getNroPartida()==nroPartida){
				propiedadEncontrado=lstPropiedades.get(i);
			}
			i++;
	}
		return propiedadEncontrado;
	}
	
	/*-----------------------------------------------------------------------*/
	public Propiedad traerPropiedadPorId(int idPropiedad){
		int i=0;
		boolean respuesta=false;
		Propiedad propiedadEncontrado=null;
		while(i<lstPropiedades.size()&& !respuesta){
			if(lstPropiedades.get(i).getIdPropiedad()==idPropiedad){
				propiedadEncontrado=lstPropiedades.get(i);
			}
			i++;
	}
		return propiedadEncontrado;
	}
	
	/*-----------------------------------------------------------------------*/
	public int traerMaximoIdDePropiedad(){
		int maximoId = 0;
		for (Propiedad propiedad: lstPropiedades){
			if (propiedad.getIdPropiedad()>maximoId){
				maximoId = propiedad.getIdPropiedad();
			}
		}
		return maximoId;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean agregarPropiedad(int idPropiedad, long nroPartida, String calle, int numero, int piso, String departamento, String localidad, String provincia, Locador propietario) throws Exception {
		boolean respuesta=false;
		Propiedad existePropiedad= traerPropiedadPorId(idPropiedad);
		if(existePropiedad!=null){
			throw new Exception("La propiedad ya existe");
		}
		else {
			Propiedad propiedadAgregado=new Propiedad(idPropiedad, nroPartida, calle, numero, piso, departamento, localidad, provincia, propietario);
			lstPropiedades.add(propiedadAgregado);
			respuesta=true;
		}
		return respuesta;
	}

	/************************************************************************/
	public boolean agregarPropiedad(long nroPartida, String calle, int numero, int piso, String departamento, String localidad, String provincia, Locador propietario) throws Exception {
		boolean respuesta=false;
		Propiedad existePropiedad= traerPropiedadNroPartida(nroPartida);
		if(existePropiedad!=null){
			throw new Exception("La propiedad ya existe");
		}
		else {
			int idProximo=1;
			idProximo=traerMaximoIdDePropiedad()+1;
			Propiedad propiedadAgregado=new Propiedad(idProximo,nroPartida,calle,numero,piso,departamento,localidad,provincia,propietario);
			lstPropiedades.add(propiedadAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean modificarPropiedadPorId(int idPropiedad, long nroPartida, String calle, int numero, int piso, String departamento, String localidad, String provincia, Locador propietario) throws Exception {
	boolean respuesta=false;
	Propiedad existePropiedad=traerPropiedadPorId(idPropiedad);
	if(existePropiedad==null) {
		throw new Exception("La propiedad no se puede modificar, no existe en la lista");
	}
		else {
			existePropiedad.setIdPropiedad(idPropiedad);
			existePropiedad.setNroPartida(nroPartida);
			existePropiedad.setCalle(calle);
			existePropiedad.setNumero(numero);
			existePropiedad.setPiso(piso);
			existePropiedad.setDepartamento(departamento);
			existePropiedad.setLocalidad(localidad);
			existePropiedad.setProvincia(provincia);
			existePropiedad.setPropietario(propietario);
			respuesta= true;
		}
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean modificarPropiedadPorNroPartida(long nroPartida, String calle, int numero, int piso, String departamento, String localidad, String provincia, Locador propietario) throws Exception {
	boolean respuesta=false;
	Propiedad existePropiedad=traerPropiedadNroPartida(nroPartida);
	if(existePropiedad==null) {
		throw new Exception("La propiedad no se puede modificar, no existe en la lista");
	}
		else {
			existePropiedad.setNroPartida(nroPartida);
			existePropiedad.setCalle(calle);
			existePropiedad.setNumero(numero);
			existePropiedad.setPiso(piso);
			existePropiedad.setDepartamento(departamento);
			existePropiedad.setLocalidad(localidad);
			existePropiedad.setProvincia(provincia);
			existePropiedad.setPropietario(propietario);
			respuesta= true;
		}
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public Propiedad traerPropiedadPorCalle(String calle){
		int i=0;
		boolean respuesta=false;
		Propiedad propiedadEncontrado=null;
		while(i<lstPropiedades.size()&& !respuesta){
			if(lstPropiedades.get(i).getCalle().equals(calle)){
				propiedadEncontrado=lstPropiedades.get(i);
			}
			i++;
	}
		return propiedadEncontrado;
	}
	
	/*-----------------------------------------------------------------------*/
	public float promedioDeNroDePartida() {
		float resultado=0;
		for(Propiedad propiedad: lstPropiedades){
			resultado = resultado+ propiedad.getNroPartida();
		}
		return resultado;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean eliminarPropiedad(long nroPartida) throws Exception{
		boolean resultado=false;
		Propiedad existePropiedad=traerPropiedadNroPartida(nroPartida); 
		if(existePropiedad==null) {
			throw new Exception("La propiedad no existe para eliminar");
		}
		else {
			lstPropiedades.remove(existePropiedad);
			resultado=true;
		}
		return resultado;
	}
	
	/*-----------------------------------------------------------------------*/
	public Contrato traerContratoPorComision(double comision){
		int i=0;
		boolean respuesta=false;
		Contrato contratoEncontrado=null;
		while(i<lstContratos.size()&& !respuesta){
			if(lstContratos.get(i).getComision()==comision){
				contratoEncontrado=lstContratos.get(i);
			}
			i++;
	}
		return contratoEncontrado;
	}
	
	/*-----------------------------------------------------------------------*/
	public Contrato traerContratoPorId(int idContrato){
		int i=0;
		boolean respuesta=false;
		Contrato contratoEncontrado=null;
		while(i<lstContratos.size()&& !respuesta){
			if(lstContratos.get(i).getIdContrato()==idContrato){
				contratoEncontrado=lstContratos.get(i);
			}
			i++;
	}
		return contratoEncontrado;
	}
	
	/*-----------------------------------------------------------------------*/
	public int traerMaximoIdDeContrato(){
		int maximoId = 0;
		for (Contrato contrato: lstContratos){
			if (contrato.getIdContrato()>maximoId){
				maximoId = contrato.getIdContrato();
			}
		}
		return maximoId;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean agregarContrato(int idContrato, Locatorio locatorio, Propiedad propiedad, double comision, LocalDate fechaInicio, int diaPago, int duracionMeses, int monto, int costoDiarioMora) throws Exception {
		boolean respuesta=false;
		Contrato existeContrato= traerContratoPorId(idContrato);
		if(existeContrato!=null){
			throw new Exception("El contrato ya existe");
		}
		else {
			Contrato contratoAgregado=new Contrato(idContrato, locatorio, propiedad, comision, fechaInicio, diaPago, duracionMeses, monto, costoDiarioMora);
			lstContratos.add(contratoAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/************************************************************************/
	public boolean agregarContrato(Locatorio locatorio, Propiedad propiedad, double comision, LocalDate fechaInicio, int diaPago, int duracionMeses, int monto, int costoDiarioMora) throws Exception {
		boolean respuesta=false;
		Contrato existeContrato= traerContratoPorComision(comision);
		if(existeContrato!=null){
			throw new Exception("El contrato ya existe");
		}
		else {
			int idProximo=1;
			idProximo=traerMaximoIdDeContrato()+1;
			Contrato contratoAgregado=new Contrato(idProximo,locatorio,propiedad,comision,fechaInicio,diaPago,duracionMeses,monto,costoDiarioMora);
			lstContratos.add(contratoAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean modificarContratoPorId(int idContrato, Locatorio locatorio, Propiedad propiedad, double comision, LocalDate fechaInicio, int diaPago, int duracionMeses, int monto, int costoDiarioMora) throws Exception {
	boolean respuesta=false;
	Contrato existeContrato=traerContratoPorId(idContrato);
	if(existeContrato==null) {
		throw new Exception("El contrato no se puede modificar, no existe en la lista");
	}
		else {
			existeContrato.setIdContrato(idContrato);
			existeContrato.setLocatorio(locatorio);
			existeContrato.setComision(comision);
			existeContrato.setFechaInicio(fechaInicio);
			existeContrato.setDiaPago(diaPago);
			existeContrato.setDuracionMeses(duracionMeses);
			existeContrato.setMonto(monto);
			existeContrato.setCostoDiarioMora(costoDiarioMora);
			respuesta= true;
		}
		return respuesta;
	}
	
	/*-----------------------------------------------------------------------*/
	public boolean modificarContratoPorComision(Locatorio locatorio, Propiedad propiedad, double comision, LocalDate fechaInicio, int diaPago, int duracionMeses, int monto, int costoDiarioMora) throws Exception {
	boolean respuesta=false;
	Contrato existeContrato=traerContratoPorComision(comision);
	if(existeContrato==null) {
		throw new Exception("El contrato no se puede modificar, no existe en la lista");
	}
		else {
			existeContrato.setLocatorio(locatorio);
			existeContrato.setComision(comision);
			existeContrato.setFechaInicio(fechaInicio);
			existeContrato.setDiaPago(diaPago);
			existeContrato.setDuracionMeses(duracionMeses);
			existeContrato.setMonto(monto);
			existeContrato.setCostoDiarioMora(costoDiarioMora);
			respuesta= true;
		}
		return respuesta;
	}
	
	/************************************************************************/
	public List<Contrato> traerContratosVigentes(LocalDate desde, LocalDate hasta){
		
	List<Contrato> lista = new ArrayList<Contrato>();
		
	for(Contrato c: lstContratos) {
		if(c.getFechaInicio().isAfter(desde) && c.getFechaInicio().isBefore(hasta)) {
			lista.add(c);
		}
		}
	return lista;

	}
	
	
	
		
		
		
	}
	

