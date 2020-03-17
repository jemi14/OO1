package modelo;

import java.time.LocalTime;

public class TipoBeneficio {
	
	private int idTipoBeneficio;
	private String descripcion;
	private LocalTime horaDesde;
	private LocalTime horaHasta;
	private int maxDiario;
	
	public TipoBeneficio(int idTipoBeneficio, String descripcion, LocalTime horaDesde, LocalTime horaHasta,
			int maxDiario) {
		super();
		this.idTipoBeneficio = idTipoBeneficio;
		this.descripcion = descripcion;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
		this.maxDiario = maxDiario;
	}

	public TipoBeneficio(String descripcion, LocalTime horaDesde, LocalTime horaHasta, int maxDiario) {
		super();
		this.descripcion = descripcion;
		this.horaDesde = horaDesde;
		this.horaHasta = horaHasta;
		this.maxDiario = maxDiario;
	}

	public TipoBeneficio() {
		super();
	}

	public int getIdTipoBeneficio() {
		return idTipoBeneficio;
	}

	public void setIdTipoBeneficio(int idTipoBeneficio) {
		this.idTipoBeneficio = idTipoBeneficio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalTime getHoraDesde() {
		return horaDesde;
	}

	public void setHoraDesde(LocalTime horaDesde) {
		this.horaDesde = horaDesde;
	}

	public LocalTime getHoraHasta() {
		return horaHasta;
	}

	public void setHoraHasta(LocalTime horaHasta) {
		this.horaHasta = horaHasta;
	}

	public int getMaxDiario() {
		return maxDiario;
	}

	public void setMaxDiario(int maxDiario) {
		this.maxDiario = maxDiario;
	}

	@Override
	public String toString() {
		return "TipoBeneficio [idTipoBeneficio=" + idTipoBeneficio + ", descripcion=" + descripcion + ", horaDesde="
				+ horaDesde + ", horaHasta=" + horaHasta + ", maxDiario=" + maxDiario + "]";
	}
	
	
	
	
	
	
	
	

}
