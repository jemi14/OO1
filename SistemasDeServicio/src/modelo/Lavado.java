package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lavado extends Servicio {
	
	private double precioEncerado;
	private boolean encerado;
	
	public Lavado(LocalDate fecha, LocalTime hora, String dominio, int precioBase, double precioEncerado,
			boolean encerado) {
		super(fecha, hora, dominio, precioBase);
		this.precioEncerado = precioEncerado;
		this.encerado = encerado;
	}

	public Lavado(LocalDate fecha, LocalTime hora, String dominio, int precioBase) {
		super(fecha, hora, dominio, precioBase);
	}

	public double getPrecioEncerado() {
		return precioEncerado;
	}

	public void setPrecioEncerado(double precioEncerado) {
		this.precioEncerado = precioEncerado;
	}

	public boolean isEncerado() {
		return encerado;
	}

	public void setEncerado(boolean encerado) {
		this.encerado = encerado;
	}

	@Override
	public String toString() {
		return "Lavado [precioEncerado=" + precioEncerado + ", encerado=" + encerado + "]";
	}

	@Override
	/********************************************************/
	public String traerServicioBrindado() {
		// TODO Auto-generated method stub
		return toString();
	}

	@Override
	/********************************************************/
	public double calcularTotalAPagar() {
		// TODO Auto-generated method stub
		double resultado=0;
		encerado=false;
		
		resultado=super.getPrecioBase();
		
		resultado=resultado+precioEncerado;
		encerado=true;
	
		return resultado;
	}
	
	
	
	

	
	
	
}
