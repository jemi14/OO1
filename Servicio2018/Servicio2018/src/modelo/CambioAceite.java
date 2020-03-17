package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CambioAceite extends Servicio {
	
	
	private double precioFiltro;
	private boolean cambioFiltro;
	
	
	public double getPrecioFiltro() {
		return precioFiltro;
	}
	public void setPrecioFiltro(double precioFiltro) {
		this.precioFiltro = precioFiltro;
	}
	public boolean isCambioFiltro() {
		return cambioFiltro;
	}
	public void setCambioFiltro(boolean cambioFiltro) {
		this.cambioFiltro = cambioFiltro;
	}
	
	
	public CambioAceite(LocalDate fecha, LocalTime hora, String dominio, int precioBase, double precioFiltro,
			boolean cambioFiltro) {
		super(fecha, hora, dominio, precioBase);
		this.precioFiltro = precioFiltro;
		this.cambioFiltro = cambioFiltro;
	}
	
	
	@Override
	public String toString() {
		return super.toString() +"CambioAceite [precioFiltro=" + precioFiltro + ", cambioFiltro=" + cambioFiltro + "]";
	}
	@Override
	public String traerServicioBrindado() {
		// TODO Auto-generated method stub
		return "El servicio brinda es: " + toString();
	}
	
	
	public double calcularTotalAPagar() {
		
		double resultado =0;
		
		resultado = super.getPrecioBase();
		
		if(cambioFiltro) {
			resultado = resultado + precioFiltro;
		}
		
		return resultado;
	}
	
	
	public List<LocalTime> generarTurnos(){
		
		 List<LocalTime> turnos = new  ArrayList<LocalTime>();
		
		 
		 return turnos;
	}
	
	
	
	
	
	
}