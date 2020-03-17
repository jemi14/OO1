package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Vehiculo {
	
	
	private int idVehiculo;
	private String patente;
	private ArrayList <Recorrido> recorridos = new ArrayList <Recorrido>();
	
	/////////////////////////////////////////////////////////////////////
	public Vehiculo(int idVehiculo, String patente,
			ArrayList<Recorrido> recorridos) {
		super();
		this.idVehiculo = idVehiculo;
		this.patente = patente;
		this.recorridos = recorridos;
	}

	public int getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public ArrayList<Recorrido> getRecorridos() {
		return recorridos;
	}

	public void setRecorridos(ArrayList<Recorrido> recorridos) {
		this.recorridos = recorridos;
	}
	
/////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", patente=" + patente;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		if (idVehiculo != other.idVehiculo)
			return false;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		if (recorridos == null) {
			if (other.recorridos != null)
				return false;
		} else if (!recorridos.equals(other.recorridos))
			return false;
		return true;
	}
	
	
	//////////////////////////////////////////////////////////////////////
	public Recorrido traerRecorrido (int idRecorrido) throws Exception{
		Recorrido recorrido = null;
		boolean recorridoEncontrado= false;
		
		for (Recorrido r: recorridos){
			if (r.getIdRecorrido()==idRecorrido){
				recorrido = r;
				recorridoEncontrado = true;
			}
		}
		
		if (!recorridoEncontrado){throw new Exception ("No existe ese idRecorrido"); }
		
		return recorrido;
	}
	
	//////////////////////////////////////////////////////////////////////
	
	
	
	/////////////////////////////////////////////////////////////
	
	public double distanciaRecorrida(GregorianCalendar fechaHoraInicial, GregorianCalendar fechaHoraFinal)throws Exception{
		double distanciaRecorridaPorVehiculo = 0;
		
		Posicion pInicial = null;
		Posicion pFinal = null;
		
		
		
		for (Recorrido r : recorridos){
			
			
			
		pInicial = r.traerPosicion(fechaHoraInicial);
		pFinal = r.traerPosicion(fechaHoraFinal);
		
		double distanciaRecorrida = r.distancia (pInicial,pFinal);
		
		
		 distanciaRecorridaPorVehiculo =  distanciaRecorridaPorVehiculo + distanciaRecorrida;
			
		}//Cierro el for recorridos
		return  distanciaRecorridaPorVehiculo;
	}
	
	//////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////////////////
	  
	public double kmPorLitro(GregorianCalendar fechaHoraInicial,GregorianCalendar fechaHoraFinal) throws Exception{
	double kmPorLitro = 0;
	double distanciaRecorrida = 0;
	double consumoCombustible = 0;
	double consumoCombustibleTotal = 0;
	//double tiempo = 0;
	
	distanciaRecorrida = distanciaRecorrida(fechaHoraInicial, fechaHoraFinal); 
	
	//tiempo = Funciones.restaFechas(fechaHoraInicial, fechaHoraFinal);
	
	
	for (Recorrido r : recorridos){
		
	consumoCombustible = r.consumoCombustible(fechaHoraInicial, fechaHoraFinal);
	consumoCombustibleTotal = consumoCombustibleTotal+consumoCombustible;
	} //Cierro el for

	kmPorLitro = distanciaRecorrida/consumoCombustibleTotal;
	
	return kmPorLitro;

}

}
