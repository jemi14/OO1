package modelo1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import modelo.Funciones;

public class SistemaPeajes {
	
	private List<Peaje> lstPeaje;

	public SistemaPeajes(List<Peaje> lstPeaje) {
		super();
		this.lstPeaje = lstPeaje;
	}

	public SistemaPeajes() {
		super();
		this.lstPeaje = new ArrayList<Peaje>();
	}

	public List<Peaje> getLstPeaje() {
		return lstPeaje;
	}

	public void setLstPeaje(List<Peaje> lstPeaje) {
		this.lstPeaje = lstPeaje;
	}

	@Override
	public String toString() {
		return "SistemaPeajes [lstPeaje=" + lstPeaje + "]";
	}
	
	//---------------------------------------------------------
	public int traerMaximoIdPeaje() {
		int maximoId=0;
		for(Peaje peaje: lstPeaje) {
			if(peaje.getIdPeaje()>maximoId) {
				maximoId= peaje.getIdPeaje();
			}
		}
		return maximoId;
	}
	
	/******************************************************/
	public boolean agregarPeaje(LocalDate fecha, LocalTime hora, Cabina cabina, CategoriaVehiculo categoriaVehiculo) {
		boolean respuesta= false;
			int idPeajeProximo=1;
			idPeajeProximo=traerMaximoIdPeaje()+1;
			Peaje peajeAgregado= new Peaje (idPeajeProximo, fecha, hora, cabina, categoriaVehiculo);
			lstPeaje.add(peajeAgregado);
		return respuesta;
	}
	
	/******************************************************/
	public double traerTotalFacturado(LocalDate fecha) throws Exception {
		double total=0;
		int i=0;

		for(i=0; i<lstPeaje.size(); i++) {
			if(Funciones.sonFechasIguales(fecha, lstPeaje.get(i).getFecha())) {
				
				total= total+lstPeaje.get(i).getCategoriaVehiculo().getPrecio();
	}
		}
		return total;
	}
	
	/******************************************************/
	public double traerTotalFacturada(CategoriaVehiculo categoriaVehiculo) throws Exception {
		double total=0;
		boolean respuesta= false;
		int i=0;

		for(i=0; i<lstPeaje.size(); i++) {
			if(lstPeaje.get(i).getCategoriaVehiculo().equals(categoriaVehiculo)) {
				
				total= total+lstPeaje.get(i).getCategoriaVehiculo().getPrecio();
				respuesta=true;
			}
		}
		if(!respuesta) {
			throw new Exception ("Categoria no existe");
		}
		return total;
	}
	
	

}
