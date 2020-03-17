package modelo1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Peaje {
	
	private int idPeaje;
	private LocalDate fecha;
	private LocalTime hora;
	private Cabina cabina;
	private CategoriaVehiculo categoriaVehiculo;
	
	public Peaje(int idPeaje, LocalDate fecha, LocalTime hora, Cabina cabina, CategoriaVehiculo categoriaVehiculo) {
		super();
		this.idPeaje = idPeaje;
		this.fecha = fecha;
		this.hora = hora;
		this.cabina = cabina;
		this.categoriaVehiculo = categoriaVehiculo;
	}

	public Peaje(LocalDate fecha, LocalTime hora, Cabina cabina, CategoriaVehiculo categoriaVehiculo) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.cabina = cabina;
		this.categoriaVehiculo = categoriaVehiculo;
	}

	public Peaje() {
		super();
	}

	public int getIdPeaje() {
		return idPeaje;
	}

	public void setIdPeaje(int idPeaje) {
		this.idPeaje = idPeaje;
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

	public Cabina getCabina() {
		return cabina;
	}

	public void setCabina(Cabina cabina) {
		this.cabina = cabina;
	}

	public CategoriaVehiculo getCategoriaVehiculo() {
		return categoriaVehiculo;
	}

	public void setCategoriaVehiculo(CategoriaVehiculo categoriaVehiculo) {
		this.categoriaVehiculo = categoriaVehiculo;
	}

	@Override
	public String toString() {
		return "Peaje [idPeaje=" + idPeaje + ", fecha=" + fecha + ", hora=" + hora + ", cabina=" + cabina
				+ ", categoriaVehiculo=" + categoriaVehiculo + "]";
	}
	
	
	
	
	
	

}
