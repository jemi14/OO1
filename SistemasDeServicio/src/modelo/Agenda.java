package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
	
	private LocalDate fechaInicio;
	private LocalTime horaInicio;
	private int cantMaxima;
	private int duracionMinutos;
	private List<Servicio> lstServicios= new ArrayList<Servicio>();
	
	public Agenda(LocalDate fechaInicio, LocalTime horaInicio, int cantMaxima, int duracionMinutos,
			List<Servicio> lstServicios) {
		super();
		this.fechaInicio = fechaInicio;
		this.horaInicio = horaInicio;
		this.cantMaxima = cantMaxima;
		this.duracionMinutos = duracionMinutos;
		this.lstServicios = lstServicios;
	}

	public Agenda() {
		super();
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getCantMaxima() {
		return cantMaxima;
	}

	public void setCantMaxima(int cantMaxima) {
		this.cantMaxima = cantMaxima;
	}

	public int getDuracionMinutos() {
		return duracionMinutos;
	}

	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}

	public List<Servicio> getLstServicios() {
		return lstServicios;
	}

	public void setLstServicios(List<Servicio> lstServicios) {
		this.lstServicios = lstServicios;
	}

	@Override
	public String toString() {
		return "Agenda [fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio + ", cantMaxima=" + cantMaxima
				+ ", duracionMinutos=" + duracionMinutos + ", lstServicios=" + lstServicios + "]";
	}
	
	/**********************************************************/
	public Servicio traerServicio(LocalDate fecha, LocalTime hora) {
		int i=0;
		boolean respuesta=false;
		Servicio servicioEncontrado=null;
		while(i<lstServicios.size() && !respuesta) {
			if(lstServicios.get(i).getFecha().equals(fecha) && lstServicios.get(i).getHora().equals(hora)) {
				servicioEncontrado=lstServicios.get(i);
			}
			i++;
		}
		return servicioEncontrado;
	}
	
	/**********************************************************/
	public boolean agregarLavado(LocalDate fecha, LocalTime hora, String dominio, int precioBase, double precioEncerado, boolean encerado) throws Exception {
		boolean respuesta=false;
		Servicio lavadoExiste= traerServicio(fecha, hora);
		if(lavadoExiste!=null) {
			throw new Exception("El servicio ya existe para esa fecha y hora para lavado");
		}
		else {
		Servicio lavadoAgregar= new Lavado(fecha, hora, dominio, precioBase, precioEncerado, encerado);
		lstServicios.add(lavadoAgregar);
		respuesta=true;
		}
	return respuesta;
	}
	
	/***********************************************************/
	public boolean agregarAlineacionBalanceo(LocalDate fecha, LocalTime hora, String dominio, int precioBase, double precioCubierta, int cantCubiertas) throws Exception {
		boolean respuesta=false;
		Servicio alineacionBalanceoExiste=traerServicio(fecha, hora);
		if(alineacionBalanceoExiste!=null) {
			throw new Exception("El servicio ya existe para esa fecha y hora para la alineación balanceo");
		}
		else {
			Servicio alineacionAgregar= new AlineacionBalanceo(fecha, hora, dominio, precioBase, precioCubierta, cantCubiertas);
			lstServicios.add(alineacionAgregar);
			respuesta=true;
		}
		return respuesta;
	}
	
	/************************************************************/
	public boolean agregarCambioDeAceite(LocalDate fecha, LocalTime hora, String dominio, int precioBase, double precioCambioFiltro, boolean cambioFiltro) throws Exception {
		boolean respuesta=false;
		Servicio cambioDeAceiteExiste=traerServicio(fecha, hora);
		if(cambioDeAceiteExiste!=null) {
			throw new Exception("El servicio ya existe para esa fecha y hora para cambio de aceite");
		}
		else {
			Servicio cambioDeAceiteAgregar= new CambioAceite(fecha, hora, dominio, precioBase, precioCambioFiltro, cambioFiltro);
			lstServicios.add(cambioDeAceiteAgregar);
			respuesta=true;
		}
		return respuesta;
	}
	
	
	

}
