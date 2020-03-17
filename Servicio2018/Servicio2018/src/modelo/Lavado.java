package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lavado extends Servicio{
	
	
	private double precioEncerado;
	private boolean encerado;
	
	
	public Lavado(LocalDate fecha, LocalTime hora, String dominio, int precioBase, double precioEncerado,
			boolean encerado) {
		super(fecha, hora, dominio, precioBase);
		this.precioEncerado = precioEncerado;
		this.encerado = encerado;
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
		return super.toString() +"Lavado [precioEncerado=" + precioEncerado + ", encerado=" + encerado + "]";
	}


	@Override
	public  String traerServicioBrindado() {
		// TODO Auto-generated method stub
		return "El servicio brinda es: " + toString();
	}
	
	
	public double calcularTotalAPagar() {
		
		double resultado =0;
		
		resultado = super.getPrecioBase();
		
		if(encerado) {
			resultado = resultado + precioEncerado;
		}
		
		return resultado;
	}
	
	
	
	

	
	
	
	
	
	
	
	

}




