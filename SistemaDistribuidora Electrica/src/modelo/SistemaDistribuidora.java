package modelo;

import java.util.ArrayList;
import java.util.List;

import funciones.Funciones;


public class SistemaDistribuidora {
	
	private List<Cliente> lstCliente= new ArrayList<Cliente>();
	private List<Lectura> lstLectura= new ArrayList<Lectura>();
	private List<Tarifa> lstTarifa= new ArrayList<Tarifa>();
	
	public SistemaDistribuidora(List<Cliente> lstCliente, List<Lectura> lstLectura, List<Tarifa> lstTarifa) {
		super();
		this.lstCliente = lstCliente;
		this.lstLectura = lstLectura;
		this.lstTarifa = lstTarifa;
	}
	
	public SistemaDistribuidora() {
		super();
	}

	public List<Cliente> getLstCliente() {
		return lstCliente;
	}

	public void setLstCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}

	public List<Lectura> getLstLectura() {
		return lstLectura;
	}

	public void setLstLectura(List<Lectura> lstLectura) {
		this.lstLectura = lstLectura;
	}

	public List<Tarifa> getLstTarifa() {
		return lstTarifa;
	}

	public void setLstTarifa(List<Tarifa> lstTarifa) {
		this.lstTarifa = lstTarifa;
	}
	
	/************************************************************************/
	public Cliente traerClientePorDNI(int dni) {
	int i=0;
	boolean respuesta=false;
	Cliente clienteEncontrado=null;
	while(i<lstCliente.size()&& !respuesta) {
		if(lstCliente.get(i).getDni()==dni) {
		  clienteEncontrado= lstCliente.get(i);
		}
		i++;
	}
	return clienteEncontrado;
	}
	
	/************************************************************************/
	public Cliente traerClientePorCuit(long cuit) {
	int i=0;
	boolean respuesta=false;
	Cliente clienteEncontrado=null;
	while(i<lstCliente.size()&& !respuesta) {
		if(lstCliente.get(i).getCuit()==cuit) {
		  clienteEncontrado= lstCliente.get(i);
		}
		i++;
	}
	return clienteEncontrado;
	}
	
	/*----------------------------------------------------------------------*/
	public long traerMaximoNroCliente() {
		long maximoNroCliente=0;
		for(Cliente cliente: lstCliente) {
			if(cliente.getNumeroCliente()>maximoNroCliente) {
				maximoNroCliente=cliente.getNumeroCliente();
			}
		}
		return maximoNroCliente;
		
	}
	
	/************************************************************************/
	public boolean agregarCliente(int dni, String apellido, String nombre) throws Exception {
		boolean respuesta=false;
		ClienteResidencial existeCliente= (ClienteResidencial) traerClientePorDNI(dni);
		if(existeCliente!=null) {
			throw new Exception ("El cliente "+dni+" ya existe en la lista");
		}
		else {
			long nroClienteProximo=1;
			nroClienteProximo= traerMaximoNroCliente()+1;
			ClienteResidencial clienteAgregado= new ClienteResidencial(nroClienteProximo, apellido, nombre, dni);
			lstCliente.add(clienteAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/**********************************************************************/
	public boolean agregarCliente(long cuit, String razonSocial) throws Exception {
		boolean respuesta=false;
		ClienteCorporativo existeCliente= (ClienteCorporativo) traerClientePorCuit(cuit);
		if(existeCliente!=null) {
			throw new Exception ("El cliente "+cuit+" ya existe en la lista");
		}
		else {
			long nroClienteProximo=1;
			nroClienteProximo= traerMaximoNroCliente()+1;
			ClienteCorporativo clienteAgregado= new ClienteCorporativo(nroClienteProximo, cuit, razonSocial);
			lstCliente.add(clienteAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/**********************************************************************/
	public boolean agregarTarifa(int consumoDesde, int consumoHasta, float cargoFijo, float cargoVariable) {
		boolean respuesta=false;
	
		Tarifa tarifaAgregado= new Tarifa(consumoDesde, consumoHasta, cargoFijo, cargoVariable);
		lstTarifa.add(tarifaAgregado);
		respuesta=true;
		
		return respuesta;
	}
	
	/**********************************************************************/
	//No queda bien claro la consigna u.u cambio int por boolean y saco fechaLectura
	public boolean agregarLectura (int mes, int anio, Cliente cliente, int estadoMedidor) {
		boolean respuesta=false;
		
		Lectura lecturaAgregado= new Lectura(mes, anio, cliente, estadoMedidor);
		lstLectura.add(lecturaAgregado);
		respuesta=true;
		
		return respuesta;
	}
	
	/**********************************************************************/
	public Lectura traerLectura (int mes, int anio, Cliente cliente) {
		int i=0;
		boolean respuesta=false;
	    Lectura lecturaEncontrado=null;
	    while(i<lstLectura.size()&& !respuesta) {
		if(Funciones.traerMes(lstLectura.get(i).getFecha())==mes && Funciones.traerAnio(lstLectura.get(i).getFecha())==anio && lstLectura.get(i).getCliente().equals(cliente)) {
			lecturaEncontrado=lstLectura.get(i);
		}
		i++;
	}
	return lecturaEncontrado;	
	}
	
	/**********************************************************************/
	public int calcularConsumo(Lectura lecturaAnterior) {
		int consumo=0;
		Lectura lecturaPeriodoFacturado= new Lectura();
			
		lecturaPeriodoFacturado=traerLectura(lecturaAnterior.getFecha().getMonthValue()-1,lecturaAnterior.getFecha().getYear(), lecturaAnterior.getCliente());
		
		if(lecturaPeriodoFacturado==null) {
		
			consumo=lecturaAnterior.getEstadoMedidor();
			
		}
		else {
		consumo=lecturaAnterior.getEstadoMedidor()-lecturaPeriodoFacturado.getEstadoMedidor();
		}
		
		return consumo;
	}
	
	/**********************************************************************/
	public Tarifa traerTarifa(int consumo) {
	int i=0;
	boolean respuesta=false;
	Tarifa tarifaEncontrado=null;
	while(i<lstTarifa.size()&& !respuesta) {
	if(lstTarifa.get(i).getComsumoMaximo()>consumo && lstTarifa.get(i).getConsumoMinimo()<consumo) {
	tarifaEncontrado=lstTarifa.get(i);
	}
	i++;
	}
	return tarifaEncontrado;	
	}
	
	/**********************************************************************/
	public float calcularTotalACobrar(int mes, int anio, Cliente cliente) {
	float totalACobrar= 0;
	Tarifa tarifa= new Tarifa();

	tarifa =traerTarifa(calcularConsumo(traerLectura(mes,anio,cliente)));
	
	totalACobrar=tarifa.getCargoFijo()+(tarifa.getCargoVariable()*calcularConsumo(traerLectura(mes,anio,cliente)));
	
	return totalACobrar;
	}
   
	/**********************************************************************/
	public float calcularTotalACobrar(int mes, int anio) {
	float totalACobrar=0;
	
	for(Cliente c: lstCliente) {
		
		totalACobrar=totalACobrar+calcularTotalACobrar(mes,anio,c);
	}
	
	return totalACobrar;
			
	}
	
}
