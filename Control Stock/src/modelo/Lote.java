package modelo;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;


public class Lote {

	private int idLote;
	private int cantidadInicial;
	private int cantidadExistente;
	private boolean enUso;
	private GregorianCalendar fechaProduccion;
	
	public Lote(){}

		
	
	public Lote(int idLote, int cantidadInicial, int cantidadExistente, boolean enUso,
			GregorianCalendar fechaProduccion) {
		this.idLote = idLote;
		this.cantidadInicial = cantidadInicial;
		this.cantidadExistente = cantidadExistente;
		this.enUso = enUso;
		this.fechaProduccion = fechaProduccion;
	}


	public int getIdLote() {
		return idLote;
	}

	public void setIdLote(int idLote) {
		this.idLote = idLote;
	}

	public int getCantidadInicial() {
		return cantidadInicial;
	}

	public void setCantidadInicial(int cantidadInicial) {
		this.cantidadInicial = cantidadInicial;
	}

	public int getCantidadExistente() {
		return cantidadExistente;
	}

	public void setCantidadExistente(int cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}

	public boolean isEnUso() {
		return enUso;
	}

	public void setEnUso(boolean enUso) {
		this.enUso = enUso;
	}

	public GregorianCalendar getFechaProduccion() {
		return fechaProduccion;
	}

	public void setFechaProduccion(GregorianCalendar fechaProduccion) {
		this.fechaProduccion = fechaProduccion;
	}

	@Override
	public String toString() {
		return "Lote [idLote=" + idLote + ", cantidadInicial=" + cantidadInicial + ", cantidadExistente="
				+ cantidadExistente + ", enUso=" + enUso + ", fechaProduccion=" + fechaProduccion + "]";
	}
	
	
	
	
	
	
	
}
