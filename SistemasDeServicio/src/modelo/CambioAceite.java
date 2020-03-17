package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class CambioAceite extends Servicio {
	
	private double precioFiltro;
	private boolean cambioFiltro;
	
	public CambioAceite(LocalDate fecha, LocalTime hora, String dominio, int precioBase, double precioFiltro,
			boolean cambioFiltro) {
		super(fecha, hora, dominio, precioBase);
		this.precioFiltro = precioFiltro;
		this.cambioFiltro = cambioFiltro;
	}

	public CambioAceite(LocalDate fecha, LocalTime hora, String dominio, int precioBase) {
		super(fecha, hora, dominio, precioBase);
	}

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

	@Override
	public String toString() {
		return "CambioAceite [precioFiltro=" + precioFiltro + ", cambioFiltro=" + cambioFiltro + "]";
	}

	@Override
	/********************************************************/
	public String traerServicioBrindado() {
		// TODO Auto-generated method stub
		return toString();
	}

	/********************************************************/
	@Override
	public double calcularTotalAPagar() {
		// TODO Auto-generated method stub
		double resultado=0;
		cambioFiltro=false;
		
		resultado=super.getPrecioBase();
		
		resultado=resultado+precioFiltro;
		cambioFiltro=true;
	
		return resultado;
		
	}
	
	
	
	

}
