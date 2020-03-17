package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaCallCenter {
	
	private List<Llamada> lstLlamadas;
	private List<Persona> lstPersonas;
	
	public SistemaCallCenter(List<Llamada> lstLlamadas, List<Persona> lstPersonas) {
		super();
		this.lstLlamadas = new ArrayList<Llamada>();
		this.lstPersonas = new ArrayList<Persona>();
	}
	
	public SistemaCallCenter() {
		super();
		this.lstLlamadas = new ArrayList<Llamada>();
		this.lstPersonas = new ArrayList<Persona>();
	}




	public List<Llamada> getLstLlamadas() {
		return lstLlamadas;
	}

	public void setLstLlamadas(List<Llamada> lstLlamadas) {
		this.lstLlamadas = lstLlamadas;
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	@Override
	public String toString() {
		return "SistemaCallCenter [lstLlamadas=" + lstLlamadas + ", lstPersonas=" + lstPersonas + "]";
	}
	
	/**************************************/ //1
	public Persona traerPersona(long dni) {
		int i=0;
		Persona personaEncontrado= null;
		while(i<lstPersonas.size() && personaEncontrado==null) {
			if(lstPersonas.get(i).getDni()==dni) {
				personaEncontrado=lstPersonas.get(i);
			}
			i++;
		}
		return personaEncontrado;
	}
	
	//--------------------------------------
	public int traerMaximoIdPersona(){
		int maximoId = 0;
		for (Persona persona: lstPersonas){
			if (persona.getIdPersona()>maximoId){
				maximoId = persona.getIdPersona();
			}
		}
		return maximoId;
	 }
	
	/**************************************/ //2
	public boolean agregarCliente(String nombre, String apellido, long dni, boolean activo) throws Exception {
		boolean respuesta= false;
		Persona personaExiste= traerPersona(dni);
		if(personaExiste!=null) {
			throw new Exception ("El dni ya existe");
		} 
		else {
		int idPersonaProximo=1;
		idPersonaProximo= traerMaximoIdPersona()+1;
		Cliente clienteAgregado= new Cliente(idPersonaProximo, nombre, apellido, dni, activo);
		lstPersonas.add(clienteAgregado);
		respuesta= true;
		}
		return respuesta;
	}
	
	/**************************************/ //3
	public boolean agregarEmpleado(String nombre, String apellido, long dni, int sueldoBase) throws Exception {
		boolean respuesta= false;
		Persona personaExiste= traerPersona(dni);
		if(personaExiste!=null) {
			throw new Exception ("El dni ya existe");
		} 
		else {
		int idPersonaProximo=1;
		idPersonaProximo= traerMaximoIdPersona()+1;
		Empleado empleadoAgregado= new Empleado(idPersonaProximo, nombre, apellido, dni, sueldoBase);
		lstPersonas.add(empleadoAgregado);
		respuesta= true;
		}
		return respuesta;
	}
	
	 //--------------------------------------
		public int traerMaximoIdLlamada(){
			int maximoId = 0;
			for (Llamada llamada: lstLlamadas){
				if (llamada.getIdLlamada()>maximoId){
					maximoId = llamada.getIdLlamada();
				}
			}
			return maximoId;
		 }
	
	/**************************************/ //4
	public boolean agregarLlamada(LocalDate fecha, Cliente cliente, Empleado empleado, int nivelDeSatisfaccion) {
		boolean respuesta= false;
		int idLlamadaProximo=1;
		idLlamadaProximo= traerMaximoIdLlamada()+1;
		Llamada llamadaAgregado= new Llamada(idLlamadaProximo, fecha, cliente, empleado, nivelDeSatisfaccion);
		lstLlamadas.add(llamadaAgregado);
		respuesta= true;
		return respuesta;
	}
	
	/**************************************/ //5
	public List<Persona> traerPersona() {
		return this.getLstPersonas();
	}
	
	/**************************************/ //6
	public List<Cliente> traerCliente() {
		List<Cliente> listaCliente= new ArrayList<Cliente>();
		for(Persona p: lstPersonas) {
			if(p instanceof Cliente) {
				listaCliente.add((Cliente) p);
			}
		}
		return listaCliente;
	}
	
	/**************************************/ //6
	public List<Empleado> traerEmpleado() {
		List<Empleado> listaEmpleado= new ArrayList<Empleado>();
		for(Persona p: lstPersonas) {
			if(p instanceof Empleado) {
				listaEmpleado.add((Empleado) p);
			}
		}
		return listaEmpleado;
	}
	
	/**************************************/ //8
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta) {
		List<Llamada> listaLlamada= new ArrayList<Llamada>();
		for(Llamada l: lstLlamadas) {
			if(l.getFecha().isAfter(desde) || l.getFecha().isEqual(desde) && l.getFecha().isBefore(hasta) || l.getFecha().isEqual(hasta)) {
				listaLlamada.add(l);
			}
		}
		return listaLlamada;
	}
	
	/**************************************/ //9
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion) {
		List<Llamada> listaLlamada= new ArrayList<Llamada>();
		for(Llamada l: traerLlamada(desde, hasta)) {
			if(l.getNivelDeSatisfaccion()==nivelDeSatisfaccion) {
				listaLlamada.add(l);
			}
		}
		return listaLlamada;
	}
	
	/**************************************/ //10
	public double calcularPorcentajeNivelDeSatisfaccion(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion) {
		double total= traerLlamada(desde, hasta).size();
		double parcial= traerLlamada(desde, hasta, nivelDeSatisfaccion).size();
		
		double resultado= (parcial/total)*100;
		
		return resultado;
		}
	
	/**************************************/ //11
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado) {
		List<Llamada> listaLlamada= new ArrayList<Llamada>();
		
		for(Llamada l: traerLlamada(desde, hasta)) {
			if(l.getEmpleado().equals(empleado)) {
				listaLlamada.add(l);
			}
		}
		return listaLlamada;
	}
	
	/**************************************/ //12
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado, int nivelDeSatisfaccion) {
		List<Llamada> listaLlamada= new ArrayList<Llamada>();
		
		for(Llamada l: traerLlamada(desde, hasta, empleado)) {
			if(l.getNivelDeSatisfaccion()==nivelDeSatisfaccion) {
				listaLlamada.add(l);
			}
		}
		return listaLlamada;
	}
	
	/**************************************/ //13
	public double calcularPorcentajeNivelDeSatisfaccion(LocalDate desde, LocalDate hasta, Empleado empleado, int nivelDeSatisfaccion) {
		int total= traerLlamada(desde, hasta, empleado).size();
		int parcial= traerLlamada(desde, hasta, empleado, nivelDeSatisfaccion).size();
		
		double resultado=(total/parcial)*100;
		
		return resultado;
		
	}
	
	
	
	
	
	
	
	

}
