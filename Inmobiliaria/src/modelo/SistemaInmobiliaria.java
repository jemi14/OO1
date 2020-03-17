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
	//1
	public Cliente traerClientePordni(long dni){
		int i=0;
		Cliente clienteEncontrado=null;
		while(i<lstClientes.size()&& clienteEncontrado==null){
			if(lstClientes.get(i).getDni()==dni){
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
	
	/************************************************************************/
	public boolean agregarLocatorio(long dni, String nombre, String apellido, String telefono, 
			                        boolean enVeraz) throws Exception {
		boolean resultado=false;
		Cliente existeLocatorio=traerClientePordni(dni);
		if(existeLocatorio!=null) {
			throw new Exception ("No puedo agregar al Locatorio porque el cliente ya existe");
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
	
	/************************************************************************/
	public Propiedad traerPropiedad(long nroPartida){
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
	public int traerMaximoIdDePropiedad(){
		int maximoId = 0;
		for (Propiedad propiedad: lstPropiedades){
			if (propiedad.getIdPropiedad()>maximoId){
				maximoId = propiedad.getIdPropiedad();
			}
		}
		return maximoId;
	}
	
	/************************************************************************/
	public boolean agregarPropiedad(long nroPartida, String calle, int numero, int piso, String departamento, String localidad, String provincia, Locador propietario) throws Exception {
		boolean respuesta=false;
		Propiedad existePropiedad= traerPropiedad(nroPartida);
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
	public Contrato traerContratoPorPropiedad(Propiedad propiedad){
		int i=0;
		Contrato contratoEncontrado=null;
		while(i<lstContratos.size()&& contratoEncontrado==null){
			if(lstContratos.get(i).getPropiedad().getNroPartida()==propiedad.getNroPartida()){
			System.out.println("lo encontre y es: " +lstContratos.get(i).getPropiedad().getLocalidad());
				contratoEncontrado=lstContratos.get(i);
			}
			i++;
	}
		return contratoEncontrado;
	}
		
	/************************************************************************/
	public boolean agregarContrato(Locatorio locatorio, Propiedad propiedad, double comision, LocalDate fechaInicio, int diaPago, int duracionMeses, int monto, int costoDiarioMora) throws Exception {
		boolean respuesta=false;
		Contrato existeContrato= traerContratoPorPropiedad(propiedad);
		if(existeContrato!=null){
			throw new Exception("El contrato ya existe");
		}
		else {
			int idProximo=1;
			idProximo=traerMaximoIdDeContrato()+1;
			Contrato contratoAgregado=new Contrato(idProximo,locatorio,propiedad,comision,fechaInicio,diaPago,duracionMeses,monto,costoDiarioMora);
			lstContratos.add(contratoAgregado);
			respuesta=true;
		
			
			//Collections.sort((List<T>) lstClientes);
		}
		return respuesta;
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
	
	/************************************************************************/
	public void imprimirIngresos(LocalDate desde, LocalDate hasta) {
	
	for(Contrato c: traerContratosVigentes(desde, hasta)) {	
	
		System.out.println(c.calcularMontoPagoARecibir());
	}
		
	}
	
	/************************************************************************/
	public void imprimirEgresos(LocalDate desde, LocalDate hasta) {
	
	for(Contrato c: traerContratosVigentes(desde, hasta)) {	
	
		System.out.println(c.calcularMontoPagoARealizar());
	}
		
	}
	
	

}
