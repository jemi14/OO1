package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class AlineacionBalanceo extends Servicio{
	
	
	private double precioCubierta;
	private int cantCubiertas;
	public double getPrecioCubierta() {
		return precioCubierta;
	}
	public void setPrecioCubierta(double precioCubierta) {
		this.precioCubierta = precioCubierta;
	}
	public int getCantCubiertas() {
		return cantCubiertas;
	}
	public void setCantCubiertas(int cantCubiertas) {
		this.cantCubiertas = cantCubiertas;
	}
	@Override
	public String toString() {
		return super.toString() +"AlineacionBalanceo [precioCubierta=" + precioCubierta + ", cantCubiertas=" + cantCubiertas + "]";
	}
	public AlineacionBalanceo(LocalDate fecha, LocalTime hora, String dominio, int precioBase, double precioCubierta,
			int cantCubiertas) {
		super(fecha, hora, dominio, precioBase);
		this.precioCubierta = precioCubierta;
		this.cantCubiertas = cantCubiertas;
	}
	@Override
	public String traerServicioBrindado() {
		// TODO Auto-generated method stub
		return "El servicio brinda es: " + toString();
	}
	
	

	public double calcularTotalAPagar() {
		
		double resultado =0;
		
		resultado = super.getPrecioBase();
		
		resultado = resultado + cantCubiertas*precioCubierta;
		return resultado;
	}
	
	
	
	
	
	
	
	
	

}
