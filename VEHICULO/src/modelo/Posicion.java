package modelo;

import java.util.GregorianCalendar;


public class Posicion {
	
	
	private int idPosicion; 
	private double latitud;
	private double longitud;
	private int estadoCombustible;
	private GregorianCalendar fechaHora;
	
	
	
	public Posicion(int idPosicion, double latitud, double longitud,
			int estadoCombustible, GregorianCalendar fechaHora) {
		super();
		this.idPosicion = idPosicion;
		this.latitud = latitud;
		this.longitud = longitud;
		this.estadoCombustible = estadoCombustible;
		this.fechaHora = fechaHora;
	}



	public int getIdPosicion() {
		return idPosicion;
	}



	public void setIdPosicion(int idPosicion) {
		this.idPosicion = idPosicion;
	}



	public double getLatitud() {
		return latitud;
	}



	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}



	public double getLongitud() {
		return longitud;
	}



	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}



	public int getEstadoCombustible() {
		return estadoCombustible;
	}



	public void setEstadoCombustible(int estadoCombustible) {
		this.estadoCombustible = estadoCombustible;
	}



	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}



	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}



	@Override
	public String toString() {
		return "Posicion [idPosicion=" + idPosicion + ", latitud=" + latitud
				+ ", longitud=" + longitud + ", estadoCombustible="
				+ estadoCombustible + ", fechaHora=" + Funciones.traerFechaLarga(fechaHora) + "]";
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (estadoCombustible != other.estadoCombustible)
			return false;
		if (fechaHora == null) {
			if (other.fechaHora != null)
				return false;
		} else if (!fechaHora.equals(other.fechaHora))
			return false;
		if (idPosicion != other.idPosicion)
			return false;
		if (Double.doubleToLongBits(latitud) != Double
				.doubleToLongBits(other.latitud))
			return false;
		if (Double.doubleToLongBits(longitud) != Double
				.doubleToLongBits(other.longitud))
			return false;
		return true;
	}
	
	///////////////////////////////////////////////////////////
	
	
	public int consumoCombustible (Posicion posicion){
		int consumoCombustible = 0; 
		
		//Estoy en la posicion latitud, longitud..... quiero saber el consumo
		//de combustible con respecto a la posicion.getLatitud y posicion.getLatitud
		
		//En la posicion tenia mas combustible o el mismo que ahora... por eso 
		//hago la resta asi 
		consumoCombustible = posicion.getEstadoCombustible()- estadoCombustible;
		
		return consumoCombustible;
	}
	
	///////////////////////////////////////////////////////////
	
	public double distancia (Posicion posicion){
		double distancia = 0;
		int R = 6378; 
		
		double primerTermino = ((Math.sin(latitud - posicion.getLatitud()))/2);
		double primerterminoCuadrado = primerTermino*primerTermino;
		
		double segundoTermino = (Math.cos(posicion.getLatitud()))*(Math.cos(latitud));
		 
		double tercerTermino = ((Math.sin(longitud - posicion.getLongitud()))/2);
		double tercerTerminoCuadrado = tercerTermino*tercerTermino;
		
		//Vamos con la raz
		double miembroRaiz = Math.sqrt(primerterminoCuadrado+segundoTermino*tercerTerminoCuadrado);
		
		distancia = 2*R*Math.asin(miembroRaiz);
		
		return distancia;
	}

	
	
}
