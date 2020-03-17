package modelo;

import java.time.LocalDate;

public class Llamada {

	private int idLlamada;
	private Cliente cliente;
	private Empleado empleado;
	private LocalDate fecha;
	private int nivelDeSatisfaccion;
	
	public Llamada(int idLlamada, LocalDate fecha, Cliente cliente, Empleado empleado, int nivelDeSatisfaccion) {
		super();
		this.idLlamada = idLlamada;
		this.fecha = fecha;
		this.cliente = cliente;
		this.empleado = empleado;
		this.nivelDeSatisfaccion = nivelDeSatisfaccion;
	}

	public int getIdLlamada() {
		return idLlamada;
	}

	public void setIdLlamada(int idLlamada) {
		this.idLlamada = idLlamada;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getNivelDeSatisfaccion() {
		return nivelDeSatisfaccion;
	}

	public void setNivelDeSatisfaccion(int nivelDeSatisfaccion) {
		this.nivelDeSatisfaccion = nivelDeSatisfaccion;
	}

	@Override
	public String toString() {
		return "Llamada [idLlamada=" + idLlamada + ", cliente=" + cliente.toStringDNI() + ", empleado=" + empleado.toStringDNI() + ", fecha="
				+ fecha + ", nivelDeSatisfaccion=" + nivelDeSatisfaccion + "]";
	} 
	
	//-------------------------------------------
	public boolean validarNivelDeSatisfaccion(int nivelDeSatisfaccion) throws Exception {
		boolean respuesta= false;
		
		if(nivelDeSatisfaccion <=1 && nivelDeSatisfaccion >=5) {
			respuesta= true;
		}
		else {
			throw new Exception("Nivel de Satisfaccion invalido");
		}
		return respuesta;
	}
	
	
	
	
	
}
