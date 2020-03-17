package modelo1;

import java.time.LocalDate;

public class Licencia {
	
	private int idLicencia;
	private String motivo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private boolean alta;
	private Empleado empleado;
	
	public Licencia(int idLicencia, String motivo, LocalDate fechaInicio, LocalDate fechaFin, boolean alta,
			Empleado empleado) {
		super();
		this.idLicencia = idLicencia;
		this.motivo = motivo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.alta = alta;
		this.empleado = empleado;
	}

	public Licencia(String motivo, LocalDate fechaInicio, LocalDate fechaFin, boolean alta, Empleado empleado) {
		super();
		this.motivo = motivo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.alta = alta;
		this.empleado = empleado;
	}

	public Licencia(int idLicencia, String motivo, LocalDate fechaInicio, Empleado empleado) {
		super();
		this.idLicencia = idLicencia;
		this.motivo = motivo;
		this.fechaInicio = fechaInicio;
		this.empleado = empleado;
	}

	public Licencia() {
		super();
	}

	public int getIdLicencia() {
		return idLicencia;
	}

	public void setIdLicencia(int idLicencia) {
		this.idLicencia = idLicencia;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isAlta() {
		return alta;
	}

	public void setAlta(boolean alta) {
		this.alta = alta;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Licencia [idLicencia=" + idLicencia + ", motivo=" + motivo + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + ", alta=" + alta + ", empleado=" + empleado + "]";
	}
	
	/***************************************/
    	public int calcularDiasDeLicencia(LocalDate fHoy) {
		int dias=0;
		
		dias=Funciones.distanciaEntreFechasEnDias(fechaInicio, fHoy);
		
		return dias;
	
	} 
	

	

}
