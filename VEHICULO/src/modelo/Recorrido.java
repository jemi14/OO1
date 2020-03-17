package modelo;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Recorrido {

	
	
	private int idRecorrido;
	private String designacion;
	private String chofer;
	private ArrayList <Posicion> posiciones = new ArrayList <Posicion>();
	
	
	public Recorrido(int idRecorrido, String designacion, String chofer,
			ArrayList<Posicion> posiciones) {
		super();
		this.idRecorrido = idRecorrido;
		this.designacion = designacion;
		this.chofer = chofer;
		this.posiciones = posiciones;
	}
	@Override
	public String toString() {
		return "Recorrido [idRecorrido=" + idRecorrido + ", designacion="
				+ designacion + ", chofer=" + chofer;
	}
	public int getIdRecorrido() {
		return idRecorrido;
	}
	public void setIdRecorrido(int idRecorrido) {
		this.idRecorrido = idRecorrido;
	}
	public String getDesignacion() {
		return designacion;
	}
	public void setDesignacion(String designacion) {
		this.designacion = designacion;
	}
	public String getChofer() {
		return chofer;
	}
	public void setChofer(String chofer) {
		this.chofer = chofer;
	}
	public ArrayList<Posicion> getPosiciones() {
		return posiciones;
	}
	public void setPosiciones(ArrayList<Posicion> posiciones) {
		this.posiciones = posiciones;
	}
	
	
	/////////////////////////////////////////////////////////////////
	public Posicion traerPosicion(GregorianCalendar fechaHora) {
		Posicion posicionSegunFechaHora = null;
		boolean fechaCorrecta = false;
		
		for (Posicion p : posiciones){
			if (Funciones.compararFechas(fechaHora, p.getFechaHora())==0){
				posicionSegunFechaHora = p; 
				fechaCorrecta = true;
			}
		}
		
		//if (!fechaCorrecta) {throw new Exception ("La fecha no existe");}
		
		
		return posicionSegunFechaHora;
	}
	
	
	 ///////////////////////////////////////////////////////////
	public double consumoCombustible (GregorianCalendar fechaHoraInicial, GregorianCalendar fechaHoraFinal)throws Exception{
		double consumoCombustible = 0; 
		
		Posicion pInicial = null;
		Posicion pFinal = null;
		
		pInicial = traerPosicion(fechaHoraInicial);
		pFinal = traerPosicion(fechaHoraFinal);
		
		consumoCombustible = pInicial.getEstadoCombustible()-pFinal.getEstadoCombustible();
		
		return consumoCombustible;
	}
	
	/////////////////////////////////////////////////////////////
	
	public double distanciaRecorrida(GregorianCalendar fechaHoraInicial, GregorianCalendar fechaHoraFinal)throws Exception{
		double distanciaRecorrida = 0;
		
		Posicion pInicial = null;
		Posicion pFinal = null;
		
		pInicial = traerPosicion(fechaHoraInicial);
		pFinal = traerPosicion(fechaHoraFinal);
		
		distanciaRecorrida = distancia (pInicial,pFinal);
		
		
		return distanciaRecorrida;
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////
	public double distancia (Posicion pInicial, Posicion pFinal){
		double distancia = 0;
		int R = 6378; 
		
		double primerTermino = ((Math.sin(pFinal.getLatitud() - pInicial.getLatitud()))/2);
		double primerterminoCuadrado = primerTermino*primerTermino;
		
		double segundoTermino = (Math.cos(pInicial.getLatitud()))*(Math.cos(pFinal.getLatitud()));
		 
		double tercerTermino = ((Math.sin(pFinal.getLongitud() - pInicial.getLongitud()))/2);
		double tercerTerminoCuadrado = tercerTermino*tercerTermino;
		
		//Vamos con la raz
		double miembroRaiz = Math.sqrt(primerterminoCuadrado+segundoTermino*tercerTerminoCuadrado);
		
		distancia = 2*R*Math.asin(miembroRaiz);
		
		return distancia;
	}

	///////////////////////////////////////////////////////////
		  
	public double kmPorLitro(GregorianCalendar fechaHoraInicial,GregorianCalendar fechaHoraFinal) throws Exception{
	double kmPorLitro = 0;
	double distanciaRecorrida = 0; 
	//double tiempo = 0;
	
	distanciaRecorrida = distanciaRecorrida(fechaHoraInicial, fechaHoraFinal); 
	
	//tiempo = Funciones.restaFechas(fechaHoraInicial, fechaHoraFinal);
	
	double consumoCombustible = consumoCombustible(fechaHoraInicial, fechaHoraFinal);
	
	
	kmPorLitro = distanciaRecorrida/consumoCombustible;
	
	return kmPorLitro;

}
	
	public double velocidadMedia(GregorianCalendar fechaHoraInicial,GregorianCalendar fechaHoraFinal) throws Exception{
	
	double distanciaRecorrida = 0; 
	double tiempo = 0;
	
	distanciaRecorrida = distanciaRecorrida(fechaHoraInicial, fechaHoraFinal); 
	
	tiempo = Funciones.restaFechas(fechaHoraInicial, fechaHoraFinal);
	
	
	
	double velocidadMedia = distanciaRecorrida/tiempo;
	
	return velocidadMedia;

}
	
}
