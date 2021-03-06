package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract  class Servicio {
	
	
	
	private LocalDate fecha;
	private LocalTime hora;
	private String dominio;
	private int precioBase;
	
	
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fechaHora) {
		this.fecha = fechaHora;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public int getPrecioBase() {
		return precioBase;
	}
	public void setPrecioBase(int precioBase) {
		this.precioBase = precioBase;
	}
	
	
	
	
	
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	
	public Servicio(LocalDate fecha, LocalTime hora, String dominio, int precioBase) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.dominio = dominio;
		this.precioBase = precioBase;
	}
	
	public Servicio() {
		
	}
	
	
	@Override
	public String toString() {
		return "Servicio [fecha=" + fecha + ", hora=" + hora + ", dominio=" + dominio + ", precioBase=" + precioBase
				+ "]";
	}
	
	
	public abstract String traerServicioBrindado();
	
	public abstract double calcularTotalAPagar();
	
	
	
	

	
	
	
	
	
	
	
	
	

}
