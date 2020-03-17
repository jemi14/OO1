package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdmPersona {
	
	private List<Persona> lstPersona;

	public AdmPersona(List<Persona> lstPersona) {
		super();
		this.lstPersona = lstPersona;
	}

	public AdmPersona() {
		super();
		this.lstPersona= new ArrayList<Persona>();
		
	}

	public List<Persona> getLstPersona() {
		return lstPersona;
	}

	public void setLstPersona(List<Persona> lstPersona) {
		this.lstPersona = lstPersona;
	}

	@Override
	public String toString() {
		return "AdmPersona [lstPersona=" + lstPersona + "]";
	}
	
	//---------------------------------------------------------
	public int traerMaximoIdPersona() {
		int maximoId=0;
		for(Persona persona: lstPersona) {
			if(persona.getIdPersona()>maximoId) {
				maximoId= persona.getIdPersona();
			}
		}
		return maximoId;
	}
	
	//---------------------------------------------------------
	public Persona traerPersona(int dni) {
		int i=0;
		Persona personaEncontrada=null;
		//if(lstPersona.size()!=0) {//si la lista no esta vacia la recorro
		while(i<lstPersona.size() && personaEncontrada==null) {
			if(lstPersona.get(i).getDni()==dni) {
				personaEncontrada=lstPersona.get(i);
			}
			i++;
		}
		//}//cierra el si
		return personaEncontrada;
	}
	
	/******************************************************/
	public boolean agregarPersona(int dni, String apellido, String nombre, LocalDate fechaDeNacimiento) throws Exception {
		boolean respuesta= false;
		Persona personaExiste= traerPersona(dni);
		if(personaExiste!=null) {
			throw new Exception("La persona ya existe");
		}
		else {
			int idPersonaProximo=1;
			idPersonaProximo=traerMaximoIdPersona()+1;
			Persona personaAgregado= new Persona (idPersonaProximo, dni, apellido, nombre, fechaDeNacimiento);
			lstPersona.add(personaAgregado);
		}
		return respuesta;
	}
	
	//-------------------------------------------------------------------
		public List<Persona> traerPersona() {
			
			return this.getLstPersona();
		}
	
	/******************************************************/
	public List<Persona> traerMayores(int edad, LocalDate fechaHoy) {
		List<Persona> listaPersonas = new ArrayList<Persona>();
		
		for(Persona p: traerPersona()) {
		if(p.esMayor(edad, fechaHoy)) {
			listaPersonas.add(p);
		}	
		}
		return listaPersonas; 
	}
	
	
	
}
