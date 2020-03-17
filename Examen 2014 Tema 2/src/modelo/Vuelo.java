package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Vuelo {
	
	private int idVuelo;
	private String aerolinea;
	private String lugarDesde;
	private String lugarHasta;
	private LocalDate fechaSalida;
	private LocalTime horaSalida;
	private double precio;
	
	public Vuelo(int idVuelo, String aerolinea, String lugarDesde, String lugarHasta, LocalDate fechaSalida,
			LocalTime horaSalida, double precio) {
		super();
		this.idVuelo = idVuelo;
		this.aerolinea = aerolinea;
		this.lugarDesde = lugarDesde;
		this.lugarHasta = lugarHasta;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.precio = precio;
	}

	public Vuelo() {
		super();
	}

	public Vuelo(int idVuelo, String aerolinea, String lugarDesde, LocalDate fechaSalida,
			LocalTime horaSalida, String lugarHasta) {
		super();
		this.idVuelo = idVuelo;
		this.aerolinea = aerolinea;
		this.lugarDesde = lugarDesde;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.lugarHasta = lugarHasta;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}

	public String getLugarDesde() {
		return lugarDesde;
	}

	public void setLugarDesde(String lugarDesde) {
		this.lugarDesde = lugarDesde;
	}

	public String getLugarHasta() {
		return lugarHasta;
	}

	public void setLugarHasta(String lugarHasta) {
		this.lugarHasta = lugarHasta;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Vuelo [idVuelo=" + idVuelo + ", aerolinea=" + aerolinea + ", lugarDesde=" + lugarDesde + ", lugarHasta="
				+ lugarHasta + ", fechaSalida=" + fechaSalida + ", horaSalida=" + horaSalida + ", precio=" + precio
				+ "]";
	}
	
	
	
	
	
	

}
