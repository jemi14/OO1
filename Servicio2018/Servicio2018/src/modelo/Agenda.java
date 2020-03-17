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
	private List<Servicio> lstServicios;
	
	
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
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
	
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Agenda(LocalDate fechaInicio, LocalTime horaInicio, int cantMaxima, int duracionMinutos) {
		super();
		this.fechaInicio = fechaInicio;
		this.horaInicio = horaInicio;
		this.cantMaxima = cantMaxima;
		this.duracionMinutos = duracionMinutos;
		this.lstServicios = new ArrayList<Servicio>();
	}
	@Override
	public String toString() {
		return "Agenda [fechaInicio=" + fechaInicio + ", horaInicio=" + horaInicio + ", cantMaxima=" + cantMaxima
				+ ", duracionMinutos=" + duracionMinutos + ", lstServicios=" + lstServicios + "]";
	}
	
	
	//caso de uso 1
	public Servicio traerServicio(LocalDate fecha, LocalTime hora) {
		
		Servicio servicio = null;
		
		for (Servicio s: lstServicios) {
			
			if(s.getFecha().equals(fecha)&&s.getHora().equals(hora)) {
				
				servicio = s;
			}
			
		}
		
		return servicio;
	}
	
	//caso de uso 2
	public boolean agregarLavado(LocalDate fecha, LocalTime hora,String dominio, int precioBase, double precioEncerado, boolean encerado) throws Exception {
		
		boolean fueAgregado = true;
		
		//aca esta la exception
		verificarTurno(fecha, hora);
		
		
		Lavado l = new Lavado(fecha,  hora, dominio, precioBase, precioEncerado, encerado);
		lstServicios.add(l);
		
		return fueAgregado;
	}
	
	//caso de uso3
	public boolean agregarAlineacion(LocalDate fecha, LocalTime hora,String dominio, int precioBase, double precioCubierta, int cantCubiertas) throws Exception {
		
		boolean fueAgregado = true;
		
		//aca esta la exception
				verificarTurno(fecha, hora);
		AlineacionBalanceo l = new AlineacionBalanceo(fecha,  hora, dominio, precioBase, precioCubierta, cantCubiertas);
		
		lstServicios.add(l);
		
		return fueAgregado;
	}
	
	//caso de uso4
	public boolean agregarCambioAceite(LocalDate fecha, LocalTime hora,String dominio, int precioBase, double precioCambioAceite, boolean cambioFiltro) throws Exception {
		
		boolean fueAgregado = true;
		
		//aca esta la exception
				verificarTurno(fecha, hora);
		CambioAceite l = new CambioAceite(fecha,  hora, dominio, precioBase,  precioCambioAceite,  cambioFiltro);
		
		lstServicios.add(l);
		
		return fueAgregado;
	}
	
	
	public void verificarTurno(LocalDate fecha, LocalTime hora) throws Exception {
		
		
	for(Servicio s: lstServicios) {
			
			if(s.getFecha().equals(fecha)&&s.getHora().equals(hora)) {
				
				throw new Exception ("Error: la fecha hora ya esta asignada  " +fecha +hora);
			}
		}
		
	}
	
	public List<LocalTime> generarTurnos() {
		
		
		List<LocalTime> turnos = new ArrayList<LocalTime>();
		
		
		LocalTime horaTurno = horaInicio;
		int conteoTurnos =0;
		boolean puedoAgregarTurno = true;
		
		while (conteoTurnos <cantMaxima&&horaTurno.getHour()<20) {
			
			puedoAgregarTurno = true;
			
			//Verifico si no tengo el turno asignado
			for(Servicio s: lstServicios) {
				
				if(horaTurno.equals(s.getHora())) {
					puedoAgregarTurno = false;
				}
				
			}
			
			if(puedoAgregarTurno) {
				turnos.add(horaTurno);
				horaTurno = horaTurno.plusMinutes(duracionMinutos);
				conteoTurnos++;
			}
			
			if(!puedoAgregarTurno) {
				
				horaTurno = horaTurno.plusMinutes(duracionMinutos);
			
				}
			
		}
		
		
		return  turnos;
		
		
		
	}

	
	public List<LocalTime> generarTurnosPosibles() {
		
		
		List<LocalTime> turnos = new ArrayList<LocalTime>();
		
		
		LocalTime horaTurno = horaInicio;
		int conteoTurnos =0;
		
		
		while (conteoTurnos <cantMaxima&&horaTurno.getHour()<20) {
			
		
		
				turnos.add(horaTurno);
				horaTurno = horaTurno.plusMinutes(duracionMinutos);
				conteoTurnos++;
			
		
			
		}
		
		
		return  turnos;
		
		
		
	}
	
	
	

}
