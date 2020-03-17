package modelo;

import java.time.LocalDate;

public class Lectura {
	
	private LocalDate fecha;
	private Cliente cliente;
	private int estadoMedidor;
	
	public Lectura(LocalDate fecha, Cliente cliente, int estadoMedidor) {
		super();
		this.fecha = fecha;
		this.cliente = cliente;
		this.estadoMedidor = estadoMedidor;
	}
	
	/*----------------------------------------------------------------*/
	public Lectura(int mes, int anio, Cliente cliente, int estadoMedidor) {
		super();
		this.fecha = LocalDate.of(anio,mes,25);
		this.cliente = cliente;
		this.estadoMedidor = estadoMedidor;
	}

	public Lectura() {
		super();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getEstadoMedidor() {
		return estadoMedidor;
	}

	public void setEstadoMedidor(int estadoMedidor) {
		this.estadoMedidor = estadoMedidor;
	}

	@Override
	public String toString() {
		return "Lectura [fecha=" + fecha + ", cliente=" + cliente + ", estadoMedidor=" + estadoMedidor + "]";
	}
	

	
	
	
	
	

}
