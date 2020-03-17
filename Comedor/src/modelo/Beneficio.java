package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Beneficio {
	
	private int idBeneficio;
	private TipoBeneficio tipoBeneficio;
	private Estudiante estudiante;
	private LocalDate fecha;
	private LocalTime hora;
	
	public Beneficio(int idBeneficio, TipoBeneficio tipoBeneficio, Estudiante estudiante, LocalDate fecha,
			LocalTime hora) {
		super();
		this.idBeneficio = idBeneficio;
		this.tipoBeneficio = tipoBeneficio;
		this.estudiante = estudiante;
		this.fecha = fecha;
		this.hora = hora;
	}

	public Beneficio() {
		super();
	}
	
	public Beneficio(TipoBeneficio tipoBeneficio, Estudiante estudiante, LocalDate fecha, LocalTime hora) {
		super();
		this.tipoBeneficio = tipoBeneficio;
		this.estudiante = estudiante;
		this.fecha = fecha;
		this.hora = hora;
	}
	
	public Beneficio(TipoBeneficio tipoBeneficio, Estudiante estudiante) {
		super();
		this.tipoBeneficio = tipoBeneficio;
		this.estudiante = estudiante;
	}

	public int getIdBeneficio() {
		return idBeneficio;
	}

	public void setIdBeneficio(int idBeneficio) {
		this.idBeneficio = idBeneficio;
	}

	public TipoBeneficio getTipoBeneficio() {
		return tipoBeneficio;
	}

	public void setTipoBeneficio(TipoBeneficio tipoBeneficio) {
		this.tipoBeneficio = tipoBeneficio;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Beneficio [idBeneficio=" + idBeneficio + ", tipoBeneficio=" + tipoBeneficio + ", estudiante="
				+ estudiante + ", fecha=" + fecha + ", hora=" + hora + "]";
	}
	
	/*******************************************************/
	//11
	public TipoBeneficio traerTipoBeneficio() {
		
		return tipoBeneficio;
		
	}
	
	

}
