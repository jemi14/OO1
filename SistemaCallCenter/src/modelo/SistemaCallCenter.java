package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaCallCenter {
	
	private List<Llamada> lstLlamadas;
	private List<Persona> lstPersonas;
	
	public SistemaCallCenter() {
		super();
		this.lstLlamadas = new ArrayList<Llamada>();
		this.lstPersonas = new ArrayList<Persona>();
	}
	
	public List<Llamada> getLstLlamadas() {
		return lstLlamadas;
	}

	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	
	@Override
	public String toString() {
		return "Sistema [lstLlamadas=" + lstLlamadas + ", lstPersonas=" + lstPersonas + "]";
	}
	

	/////////////////////////////////////////////////////////////

	//1
	public Persona traerPersona(long dni) {
		Persona encontrada=null;
		int i=0;
		
		while(i<lstPersonas.size() && encontrada==null) {
			if(lstPersonas.get(i).getDni()==dni) {			
					encontrada=lstPersonas.get(i);	
			}
			i++;
		}
		
		
		
		return encontrada;
	}
	
	//2
	public boolean agregarCliente(String nombre, String apellido, long dni, boolean activo) throws Exception {
		Persona p=traerPersona(dni);
		int id=1;
		if(p!=null) throw new Exception("Cliente ya existe");	
			
		if(!lstPersonas.isEmpty())  
			id=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		return	lstPersonas.add(new Cliente(id,nombre, apellido,  dni, activo));	
	}

	//3
	public boolean agregarEmpleado(String nombre, String apellido, long dni, int sueldoBase) throws Exception{
		Persona p=traerPersona(dni);
		int id=1;
		if(p!=null) throw new Exception("Empleado ya existe");
		
		if(!lstPersonas.isEmpty())
			id=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
		return lstPersonas.add(new Empleado(id,nombre,  apellido, dni,  sueldoBase));
	}
	
	//4-AGREGAR LLAMADA ES SIN EXCEPCIONES, ver bien el if
	public boolean agregarLlamada(Cliente cliente, Empleado empleado, LocalDate fecha, int nivel){
		Cliente p1=(Cliente) traerPersona(cliente.getDni());
		Empleado e1=(Empleado) traerPersona(empleado.getDni());
		boolean agregar=false;
		int id=1;
		
		if((p1.isActivo()==true)&&(e1!=null)&&(nivel>=1 || nivel<=5)){
			if(!lstLlamadas.isEmpty()){
				id=lstLlamadas.get(lstLlamadas.size()-1).getIdLlamada()+1;
				agregar=lstLlamadas.add(new Llamada(id,cliente,empleado,fecha,nivel));
			}else{
				agregar=lstLlamadas.add(new Llamada(id,cliente,empleado,fecha,nivel));
			}
		}
		return agregar;
	}
	
	//5
	public List<Persona> traerPersonas(){
		List<Persona> lista=new ArrayList<Persona>();
		
		for(Persona p: lstPersonas){
			lista.add(p);
		}
		return lista;
	}
	
	//6
	public List<Cliente> traerClientes(){
		List<Cliente> lista=new ArrayList<Cliente>();
		
		for(Persona p: lstPersonas){
			if(p instanceof Cliente){
				lista.add((Cliente) p);
			}
		}
		return lista;
	}
	
	//7
	public List<Empleado> traerEmpleados(){
		List<Empleado> lista=new ArrayList<Empleado>();
		
		for(Persona p: lstPersonas){
			if(p instanceof Empleado){
				lista.add((Empleado)p);
			}
		}
		return lista;
	}
	
	//8
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta){
		List<Llamada> lista=new ArrayList<Llamada>();
		
		for(Llamada l: lstLlamadas){
			if((l.getFecha().isAfter(desde)|| l.getFecha().isEqual(desde))&&(l.getFecha().isBefore(hasta) || l.getFecha().isEqual(hasta))){
				lista.add(l);
			}
		}
		return lista;
	}
	
	//9--TODO VER NIVEL DE SATISFACCION	
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, int nivel){
		List<Llamada> lista=traerLlamada(desde, hasta);
		List<Llamada> lista2=new ArrayList<Llamada>();
		
		for(Llamada l: lista){
			if(l.getNivelSatisfaccion()==nivel){
				lista2.add(l);
			}
		}
		return lista2;
	}
	
	//10
	public double calcularPorcentajeNivel(LocalDate desde, LocalDate hasta, int nivel){
		double cantidad=0;
		List<Llamada> lista=traerLlamada(desde, hasta, nivel);
		cantidad=(lista.size()*100)/lstLlamadas.size();	
		return cantidad;
	}
	
	//11
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado){
		List<Llamada> lista=traerLlamada(desde,hasta);
		List<Llamada> lista2=new ArrayList<Llamada>();
		
		for(Llamada l: lista){
				if(l.getEmpleado().getDni()==empleado.getDni()){
					lista2.add(l);
				}
			}
		return lista2;
	}
		
	//12
	public List<Llamada> traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado, int nivel){
		List<Llamada> lista=traerLlamada(desde,hasta,empleado);
		List<Llamada> lista2=new ArrayList<Llamada>();
		
		for(Llamada l: lista){
			if(l.getNivelSatisfaccion()==nivel){
				lista2.add(l);
			}
		}	
		return lista2;
	}
	
	//13
	public double calcularPorcentaje(LocalDate desde, LocalDate hasta, Empleado empleado, int nivel){
		double cantidad=0;
		List<Llamada> lista=traerLlamada(desde,hasta,empleado,nivel);
		cantidad=(lista.size()*100)/lstLlamadas.size();	
		return cantidad;
	}
	
	
	
	
	
	
	
}//fin
