package modelo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecursosHumanos {
	
	private List<Licencia> licencia;

	public RecursosHumanos(List<Licencia> licencia) {
		super();
		this.licencia = licencia;
	}

	public RecursosHumanos() {
		super();
		this.licencia = new ArrayList<Licencia>();
		
	}

	public List<Licencia> getLicencia() {
		return licencia;
	}

	public void setLicencia(List<Licencia> licencia) {
		this.licencia = licencia;
	}

	@Override
	public String toString() {
		return "RecursosHumanos [licencia=" + licencia + "]";
	}
	
	//------------------------------------------
	public int traerMaximoIdLicencia() {
		int maximoId=0;
		for(Licencia l: licencia) {
			if(l.getIdLicencia()>maximoId) {
				maximoId=l.getIdLicencia();
			}
		}
		return maximoId;
	}
	
	/***************************************/
	public boolean agregarLicencia(String motivo, LocalDate fechaInicio, Empleado empleado) {
		boolean respuesta= false;
		
			int idLicenciaProximo=1;
			idLicenciaProximo=traerMaximoIdLicencia()+1;
			Licencia licenciaAgregado= new Licencia(idLicenciaProximo, motivo, fechaInicio, empleado);
			licencia.add(licenciaAgregado);
		
		return respuesta;
	}
	
	/***************************************/
	public boolean agregarLicencia(String motivo, LocalDate fechaInicio, LocalDate fechaFin, boolean alta, Empleado empleado) {
		boolean respuesta= false;
		
			int idLicenciaProximo=1;
			idLicenciaProximo=traerMaximoIdLicencia()+1;
			Licencia licenciaAgregado= new Licencia(idLicenciaProximo, motivo, fechaInicio, fechaFin, alta, empleado);
			licencia.add(licenciaAgregado);
		
		return respuesta;
	}
	
	/***************************************/
	public Licencia traerLicencia(int idLicencia) {
		int i=0;
		Licencia licenciaEncontrado=null;
		while(i<licencia.size() && licenciaEncontrado==null) {
			if(licencia.get(i).getIdLicencia()==idLicencia) {
				licenciaEncontrado=licencia.get(i);
			}
			i++;
		}
		return licenciaEncontrado;
	}
	
	/***************************************/
	public Licencia traerLicencia(boolean alta) {
		int i=0;
		Licencia licenciaEncontrado=null;
		while(i<licencia.size() && licenciaEncontrado==null) {
			if(licencia.get(i).isAlta()==alta) {
				licenciaEncontrado=licencia.get(i);
			}
			i++;
		}
		return licenciaEncontrado;
	}
	

}
