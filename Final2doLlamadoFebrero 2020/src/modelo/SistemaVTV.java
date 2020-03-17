package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaVTV {
	
	private List<Persona> lstPersonas;
	private List<Automotor> lstAutomotor;
	private List<Inspeccion> lstInspeccion;
	
	public SistemaVTV(List<Persona> lstPersonas, List<Automotor> lstAutomotor, List<Inspeccion> lstInspeccion) {
		super();
		this.lstPersonas = new ArrayList<Persona>();
		this.lstAutomotor = new ArrayList<Automotor>();
		this.lstInspeccion = new ArrayList<Inspeccion>();
	}

	public SistemaVTV() {
		super();
		this.lstPersonas = new ArrayList<Persona>();
		this.lstAutomotor = new ArrayList<Automotor>();
		this.lstInspeccion = new ArrayList<Inspeccion>();
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}

	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}

	public List<Automotor> getLstAutomotor() {
		return lstAutomotor;
	}

	public void setLstAutomotor(List<Automotor> lstAutomotor) {
		this.lstAutomotor = lstAutomotor;
	}

	public List<Inspeccion> getLstInspeccion() {
		return lstInspeccion;
	}

	public void setLstInspeccion(List<Inspeccion> lstInspeccion) {
		this.lstInspeccion = lstInspeccion;
	}

	@Override
	public String toString() {
		return "SistemaVTV [lstPersonas=" + lstPersonas + ", lstAutomotor=" + lstAutomotor + ", lstInspeccion="
				+ lstInspeccion + "]";
	}
	
	//------------------------------------------------
	public int traerMaximoIdPersona() {
    int maximoId = 0;
     for (Persona persona: lstPersonas){
	if (persona.getIdPersona()>maximoId){
		maximoId = persona.getIdPersona();
	 }
    }
    return maximoId;
    } 
	
	/*****************************************************************/ //1
	public boolean agregarInspector(String apellido, String nombre, int dni, int legajo) {
	boolean respuesta= false;
	int idPersonaProximo=1;
	idPersonaProximo= traerMaximoIdPersona()+1;
	Inspector inspectorAgregado= new Inspector(idPersonaProximo, apellido, nombre, dni, legajo);
	lstPersonas.add(inspectorAgregado);
	respuesta= true;
	
	return respuesta;
  } 
	
	/*****************************************************************/ //2
	public boolean agregarContribuyente(String apellido, String nombre, int dni, boolean esExento) {
	boolean respuesta= false;
	int idPersonaProximo=1;
	idPersonaProximo= traerMaximoIdPersona()+1;
	Contribuyente contribuyenteAgregado= new Contribuyente(idPersonaProximo, apellido, nombre, dni, esExento);
	lstPersonas.add(contribuyenteAgregado);
	respuesta= true;
	
	return respuesta;
  } 
	/*****************************************************************/ //3
	public Contribuyente traerContribuyente(int idPersona) {
	    int i=0;
	    Contribuyente contribuyenteEncontrada=null;
	    while (i<lstPersonas.size() && contribuyenteEncontrada==null) {
	    	Persona persona= lstPersonas.get(i);
	    	if(persona instanceof Contribuyente) {
	    		Contribuyente contribuyente = (Contribuyente) persona;
	    		if(contribuyente.getIdPersona()==idPersona) {
	    			contribuyenteEncontrada= contribuyente;
	    		}
	    	}
	    	i++;
	    }
	    return contribuyenteEncontrada;
	}
	    
	    /*****************************************************************/ //4
		public Inspector traerInspector(int idPersona) {
		    int i=0;
		    Inspector inspectorEncontrada=null;
		    while (i<lstPersonas.size() && inspectorEncontrada==null) {
		    	Persona persona= lstPersonas.get(i);
		    	if(persona instanceof Inspector) {
		    		Inspector inspector = (Inspector) persona;
		    		if(inspector.getIdPersona()==idPersona) {
		    			inspectorEncontrada= inspector;
		    		}
		    	}
		    	i++;
		    }
	    return inspectorEncontrada;
	    }

	/*****************************************************************/ //5
   public Automotor traerAutomotor(String dominio) {
	int i=0;
	Automotor automotorEncontrado= null;
	while(i<lstAutomotor.size() && automotorEncontrado==null) {
		if(lstAutomotor.get(i).getDominio().equals(dominio)) {
			automotorEncontrado=lstAutomotor.get(i);
		}
		i++;
	}
	return automotorEncontrado;
   } 

   
   //------------------------------------------------
 	public int traerMaximoIdAutomotor() {
     int maximoId = 0;
      for (Automotor automotor: lstAutomotor){
 	if (automotor.getIdAutomotor()>maximoId){
 		maximoId = automotor.getIdAutomotor();
 	 }
     }
     return maximoId;
     } 
   
   /*****************************************************************/ //6
	public boolean agregarAutomotor(String dominio, int modelo, String marca, Contribuyente contribuyente) throws Exception {
	boolean respuesta= false;
	Automotor automotorExiste= traerAutomotor(dominio);
	if(automotorExiste!=null) {
		throw new Exception ("El dominio ya existe");
	}
	else {
	int idAutomotorProximo=1;
	idAutomotorProximo= traerMaximoIdAutomotor()+1;
	Automotor automotorAgregado= new Automotor(idAutomotorProximo, dominio, modelo, marca, contribuyente);
	lstAutomotor.add(automotorAgregado);
	respuesta= true;
	}
	
	return respuesta;
 } 
	
	//------------------------------------------------
	 public int traerMaximoIdInspeccion() {
	     int maximoId = 0;
	      for (Inspeccion inspeccion: lstInspeccion){
	 	if (inspeccion.getIdInspeccion()>maximoId){
	 		maximoId = inspeccion.getIdInspeccion();
	 	 }
	     }
	     return maximoId;
	     } 
	
	/*****************************************************************/ //7
	public boolean agregarInspeccion(LocalDate fecha, boolean estadoPagado, String estado, Automotor automotor, Inspector inspector) {
	boolean respuesta= false;
	int idInspeccionProximo=1;
	idInspeccionProximo= traerMaximoIdInspeccion()+1;
	Inspeccion inspeccionAgregado= new Inspeccion(idInspeccionProximo, fecha, estadoPagado, estado, automotor, inspector);
	lstInspeccion.add(inspeccionAgregado);
	respuesta= true;
	
	return respuesta;
	}
	
	/*****************************************************************/ //8
	   public Inspeccion traerInspeccion(int idInspeccion) {
		int i=0;
		Inspeccion inspeccionEncontrado= null;
		while(i<lstInspeccion.size() && inspeccionEncontrado==null) {
			if(lstInspeccion.get(i).getIdInspeccion()==idInspeccion) {
				inspeccionEncontrado=lstInspeccion.get(i);
			}
			i++;
		}
		return inspeccionEncontrado;
	   } 
	   
	   /*****************************************************************/ //9
	   public List<Inspeccion> traerInspeccion(Automotor automotor) {
		List<Inspeccion> listaInspeccion= new ArrayList<Inspeccion>();
		
		for(Inspeccion n: lstInspeccion) {
			if(n.getAutomotor()==automotor) {
				listaInspeccion.add(n);
			}
		}
		return listaInspeccion;
	   }
   
	   /*****************************************************************/ //10
	   public List<Inspeccion> traerInspeccion(LocalDate fecha) {
		   List<Inspeccion> listaInspecciones = new ArrayList<Inspeccion>();
		   
		   for(Inspeccion n: lstInspeccion) {
			   if(n.getFecha().getDayOfMonth()==fecha.getDayOfMonth() && n.getFecha().getMonth()==fecha.getMonth() && n.getFecha().getYear()==fecha.getYear()) {
		    listaInspecciones.add(n);
			   }
	   }
	   return listaInspecciones;
	   }
	   
	   /*****************************************************************/ //11
	   public List<Inspeccion> traerInspeccion(Inspector inspector, LocalDate fecha) {
		List<Inspeccion> listaInspeccion= new ArrayList<Inspeccion>();
		
		for(Inspeccion n: traerInspeccion(fecha)) {
			if(n.getInspector().equals(inspector)) {
				listaInspeccion.add(n);
			}
		}
		return listaInspeccion;
	   }
	   
	 /*****************************************************************/ //12
	  public List<Inspeccion> traerInspeccion(LocalDate fecha, String estado) {
		List<Inspeccion> listaInspeccion= new ArrayList<Inspeccion>();
		
		for(Inspeccion n: traerInspeccion(fecha)) {
			if(n.getEstado().equals(estado)) {
				listaInspeccion.add(n);
			}
		}
      return listaInspeccion;
	  }
	
	

}
