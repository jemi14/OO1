package modelo;

import java.time.LocalDate;

import funciones.Funciones;

public class Contrato {

	private int idContrato;
	private Locatorio locatorio;
	private Propiedad propiedad;
	private double comision;
	private LocalDate fechaInicio;
	private int diaPago;
	private int duracionMeses;
	private int monto;
	private int costoDiarioMora;
	
	public Contrato(int idContrato, Locatorio locatorio, Propiedad propiedad, double comision, LocalDate fechaInicio,
			int diaPago, int duracionMeses, int monto, int costoDiarioMora) {
		super();
		this.idContrato = idContrato;
		this.locatorio = locatorio;
		this.propiedad = propiedad;
		this.comision = comision;
		this.fechaInicio = fechaInicio;
		this.diaPago = diaPago;
		this.duracionMeses = duracionMeses;
		this.monto = monto;
		this.costoDiarioMora = costoDiarioMora;
	}

	public Contrato(Locatorio locatorio, Propiedad propiedad, double comision, LocalDate fechaInicio, int diaPago,
			int duracionMeses, int monto, int costoDiarioMora) {
		super();
		this.locatorio = locatorio;
		this.propiedad = propiedad;
		this.comision = comision;
		this.fechaInicio = fechaInicio;
		this.diaPago = diaPago;
		this.duracionMeses = duracionMeses;
		this.monto = monto;
		this.costoDiarioMora = costoDiarioMora;
	}

	public Contrato() {
		super();
	}

	public int getIdContrato() {
		return idContrato;
	}

	public void setIdContrato(int idContrato) {
		this.idContrato = idContrato;
	}

	public Locatorio getLocatorio() {
		return locatorio;
	}

	public void setLocatorio(Locatorio locatorio) {
		this.locatorio = locatorio;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	public double getComision() {
		return comision;
	}

	public void setComision(double comision) {
		this.comision = comision;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public int getDiaPago() {
		return diaPago;
	}

	public void setDiaPago(int diaPago) {
		this.diaPago = diaPago;
	}

	public int getDuracionMeses() {
		return duracionMeses;
	}

	public void setDuracionMeses(int duracionMeses) {
		this.duracionMeses = duracionMeses;
	}

	public int getMonto() {
		return monto;
	}

	public void setMonto(int monto) {
		this.monto = monto;
	}

	public int getCostoDiarioMora() {
		return costoDiarioMora;
	}

	public void setCostoDiarioMora(int costoDiarioMora) {
		this.costoDiarioMora = costoDiarioMora;
	}

	@Override
	public String toString() {
		return "Contrato [idContrato=" + idContrato + ", locatorio=" + locatorio + ", propiedad=" + propiedad
				+ ", comision=" + comision + ", fechaInicio=" + fechaInicio + ", diaPago=" + diaPago
				+ ", duracionMeses=" + duracionMeses + ", monto=" + monto + ", costoDiarioMora=" + costoDiarioMora
				+ "]";
	}
	
	/************************************************************************/
	
	public boolean esContratoVigente(LocalDate fecha) {
	boolean respuesta=false;
	
	respuesta= fecha.isAfter(fechaInicio);
	
	return !respuesta;
	}
	
	/************************************************************************/
	
	public double calcularMora(int diasAtrasados) {
		double mora=0;
		
		mora=monto*(costoDiarioMora)*diasAtrasados/100;
		
		return mora;
	}
	
	/************************************************************************/
	
	public double calcularMontoPagoARecibir() {
		double resultado=0;
		
		resultado=monto/duracionMeses;
		
		return resultado;
	}
	
	/************************************************************************/
	
	public double calcularMontoPagoARecibir(LocalDate fechaEfectivaDePago) {
	double resultado=0;
	
	int mora=Funciones.distanciaEntreFechasEnDias(fechaInicio,fechaEfectivaDePago);
	
	if(mora<=0) {
		mora=0;
	}
	
	resultado=calcularMontoPagoARecibir()+calcularMora(mora);
	
	return resultado;
	}
	
	/************************************************************************/

	public double calcularComision() {
		double resultado=0;
		
		resultado=monto*(comision/100);
		
		return resultado;
	}
	
	/************************************************************************/
	
	public double calcularMontoPagoARecibirInmobiliariaAlLocador() {
	double resultado=0;
	
	resultado=calcularComision()-calcularMontoPagoARecibir();
	
	return resultado;
	
	}
	
	
	
	
	
	
	
	
}
