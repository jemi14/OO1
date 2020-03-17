package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Comedor {
	
	private List<Estudiante> lstEstudiantes= new ArrayList <Estudiante>();
	private List<Carrera> lstCarreras= new ArrayList <Carrera>();
	private List<TipoBeneficio> beneficiosDisponibles= new ArrayList <TipoBeneficio>();
	private List<Beneficio> beneficiosOtorgados= new ArrayList <Beneficio>();
	
	public Comedor(List<Estudiante> lstEstudiantes, List<Carrera> lstCarreras,
			List<TipoBeneficio> beneficiosDisponibles, List<Beneficio> beneficiosOtorgados) {
		super();
		this.lstEstudiantes = lstEstudiantes;
		this.lstCarreras = lstCarreras;
		this.beneficiosDisponibles = beneficiosDisponibles;
		this.beneficiosOtorgados = beneficiosOtorgados;
	}

	public Comedor() {
		super();
	}

	public List<Estudiante> getLstEstudiantes() {
		return lstEstudiantes;
	}

	public void setLstEstudiantes(List<Estudiante> lstEstudiantes) {
		this.lstEstudiantes = lstEstudiantes;
	}

	public List<Carrera> getLstCarreras() {
		return lstCarreras;
	}

	public void setLstCarreras(List<Carrera> lstCarreras) {
		this.lstCarreras = lstCarreras;
	}

	public List<TipoBeneficio> getBeneficiosDisponibles() {
		return beneficiosDisponibles;
	}

	public void setBeneficiosDisponibles(List<TipoBeneficio> beneficiosDisponibles) {
		this.beneficiosDisponibles = beneficiosDisponibles;
	}

	public List<Beneficio> getBeneficiosOtorgados() {
		return beneficiosOtorgados;
	}

	public void setBeneficiosOtorgados(List<Beneficio> beneficiosOtorgados) {
		this.beneficiosOtorgados = beneficiosOtorgados;
	}

	@Override
	public String toString() {
		return "Comedor [lstEstudiantes=" + lstEstudiantes + ", lstCarreras=" + lstCarreras + ", beneficiosDisponibles="
				+ beneficiosDisponibles + ", beneficiosOtorgados=" + beneficiosOtorgados + "]";
	}
	
	//-------------------------------------------------------//
	public int traerMaximoIdTipoBeneficio() {
		int maximoId=0;
		for(TipoBeneficio tipoBeneficio: beneficiosDisponibles) {
			if(tipoBeneficio.getIdTipoBeneficio()>maximoId) {
				maximoId= tipoBeneficio.getIdTipoBeneficio();
			}
		}
		return maximoId;
	}
	
	//-------------------------------------------------------//
	public int traerMaximoIdCarrera() {
		int maximoId=0;
		for(Carrera carrera: lstCarreras) {
			if(carrera.getIdCarrera()>maximoId) {
				maximoId= carrera.getIdCarrera();
			}
		}
		return maximoId;
	}
	
	//-------------------------------------------------------//
	public int traerMaximoIdDeLegajo() {
		int maximoId=0;
		for(Estudiante estudiante: lstEstudiantes) {
			if(estudiante.getLegajo()>maximoId) {
				maximoId= estudiante.getLegajo();
			}
		}
		return maximoId;
	}
	
	//-------------------------------------------------------//
	public int traerMaximoIdDeBenefico() {
		int maximoId=0;
		for(Beneficio beneficio: beneficiosOtorgados) {
			if(beneficio.getIdBeneficio()>maximoId) {
				maximoId= beneficio.getIdBeneficio();
			}
		}
		return maximoId;
	}
	
	/*******************************************************/
	//1
	public Carrera traerCarrera(int idCarrera) {
		int i=0;
		Carrera carreraEncontrado=null;
		while(i<lstCarreras.size() && carreraEncontrado==null) {
			if(lstCarreras.get(i).getIdCarrera()==idCarrera) {
				carreraEncontrado=lstCarreras.get(i);
			}
			i++;
		}
		return carreraEncontrado;
	}
	
	/*******************************************************/
	//2
	public boolean agregarCarrera(String descripcion) {
		boolean respuesta=false;
		int idProximo=1;
		idProximo=traerMaximoIdCarrera()+1;
		Carrera carreraAgregado= new Carrera(idProximo,descripcion);
		lstCarreras.add(carreraAgregado);
		respuesta=true;
		
		return respuesta;
	}
	
	/*******************************************************/
	//3
	public Estudiante traerEstudiante(int dni) throws Exception {
		int i=0;
		boolean respuesta=false;
		Estudiante estudianteEncontrado= null;
		if(!Funciones.esDocumentoValido(dni)) {
			throw new Exception("El dni "+dni+" es incorrecto");
		}
		while(i<traerEstudiantes().size() && !respuesta) {
			if(traerEstudiantes().get(i).getDni()==dni) {
				estudianteEncontrado=traerEstudiantes().get(i);
			}
			i++;
		}
		return estudianteEncontrado;
	}
	
	/*******************************************************/
	//4
	public boolean agregarEstudiante(int dni, String nombre, String apellido, Carrera carrera, boolean regular) throws Exception {
		boolean respuesta=false;
		if(!Funciones.esDocumentoValido(dni)) {
			throw new Exception("El dni "+dni+" es incorrecto");
		}
		
		Estudiante existeEstudiante=traerEstudiante(dni);
		if(existeEstudiante!=null) {
			throw new Exception("El estudiante "+dni+" ya existe");
		}
		else {
			int legajo=0;
			legajo=traerMaximoIdDeLegajo()+1;
			Estudiante estudianteAgregado= new Estudiante(legajo, dni, nombre, apellido, carrera, regular);
			traerEstudiantes().add(estudianteAgregado);
			respuesta=true;
		}
		return respuesta;
	}
	
	/*******************************************************/
	//5
	public List <Estudiante> traerEstudiante(boolean regulares) {
		List<Estudiante> listaEstudiantes = new ArrayList<Estudiante>();
		
		for(Estudiante e: traerEstudiantes()) {
			if(e.isRegular()==regulares) {
			listaEstudiantes.add(e);
		}
		}
		return listaEstudiantes;
	}
	
	/*******************************************************/
	//6
	public List <Estudiante> traerEstudiantes() {
		
		return this.getLstEstudiantes();
	}
	
	/*******************************************************/
	//7
	public TipoBeneficio traerTipoBeneficio(int idTipoBeneficio) {
		int i=0;
		boolean respuesta=false;
		TipoBeneficio tipoBeneficioEncontrado=null;
		while(i<traerTipoBeneficioActivo().size() && !respuesta) {
			if(traerTipoBeneficioActivo().get(i).getIdTipoBeneficio()==idTipoBeneficio) {
				tipoBeneficioEncontrado=traerTipoBeneficioActivo().get(i);
			}
			i++;
		}
		return tipoBeneficioEncontrado;
	}
	
	/*******************************************************/
	//8
	public boolean agregarTipoBeneficio(String descripcion, LocalTime horaDesde, LocalTime horaHasta, int maxDiario) {
		boolean respuesta=false;
		int idProximo=1;
		idProximo=traerMaximoIdTipoBeneficio()+1;
		TipoBeneficio tipoBeneficioAgregado= new TipoBeneficio(idProximo, descripcion, horaDesde, horaHasta, maxDiario);
		traerTipoBeneficioActivo().add(tipoBeneficioAgregado);
		respuesta=true;
		
		return respuesta;
	}
	
	/*******************************************************/
	//9
	public List<TipoBeneficio> traerTipoBeneficioActivo() {
		
		return this.getBeneficiosDisponibles();
	}
	
	/*******************************************************/
	//10
	public TipoBeneficio traerTipoBeneficioActivo(LocalTime hora) {
		int i=0;
		boolean respuesta=false;
		TipoBeneficio tipoBeneficioEncontrado=null;
		while(i<beneficiosOtorgados.size() && !respuesta) {
			if(Funciones.sonHorasIguales(beneficiosOtorgados.get(i).getHora(), hora)) {
				tipoBeneficioEncontrado= beneficiosOtorgados.get(i).getTipoBeneficio();
			}
			i++;
		}
		if(tipoBeneficioEncontrado.getHoraDesde().isBefore(hora) && tipoBeneficioEncontrado.getHoraHasta().isAfter(hora)) {
			respuesta=true;
		}
		else {
			tipoBeneficioEncontrado=null;
		}
		return tipoBeneficioEncontrado;
	}
	
	/*******************************************************/
	//12
	public Beneficio traerBeneficio(int idBeneficio) {
		int i=0;
		boolean respuesta=false;
		Beneficio beneficioEncontrado=null;
		while(i<beneficiosOtorgados.size() && !respuesta) {
			if(beneficiosOtorgados.get(i).getIdBeneficio()==idBeneficio) {
				beneficioEncontrado=beneficiosOtorgados.get(i);
			}
			i++;
		}
		return beneficioEncontrado;
	}
	
	/*******************************************************/
	//13
	public boolean agregarBeneficio(TipoBeneficio tipoBeneficio, Estudiante estudiante, LocalDate fecha, LocalTime hora) throws Exception {
		boolean respuesta=false;
		if(estudiante.isRegular()==false) {
			throw new Exception("El estudiante no es regular "+estudiante);
		}
		int idProximo=0;
		idProximo=traerMaximoIdDeBenefico()+1;
		Beneficio beneficioAgregado= new Beneficio(idProximo, tipoBeneficio, estudiante, fecha, hora);
		beneficiosOtorgados.add(beneficioAgregado);
		respuesta=true;
		
		return respuesta;
	}
	
	/*******************************************************/
	//14
	public boolean agregarBeneficio(TipoBeneficio tipoBeneficio, Estudiante estudiante) {
		boolean respuesta=false;
		Beneficio beneficioAgregado= new Beneficio(tipoBeneficio, estudiante);
		beneficiosOtorgados.add(beneficioAgregado);
		respuesta=true;
		
		return respuesta;
	}

	/*******************************************************/
	//15
	public List<Beneficio> traerBeneficios(LocalDate fechaDesde, LocalDate fechaHasta) {
    List<Beneficio> listaBeneficios = new ArrayList<Beneficio>();
		
		for(Beneficio b: beneficiosOtorgados) {
			if(b.getFecha().isAfter(fechaDesde) && b.getFecha().isBefore(fechaHasta)) {
				listaBeneficios.add(b);
		}
	}
		return listaBeneficios;
	}
	
	/*******************************************************/
	//16
	public List<Beneficio> traerBeneficios(LocalDate fecha) {
	List<Beneficio> listaBeneficios = new ArrayList<Beneficio>();
	
	for(Beneficio b: beneficiosOtorgados) {
		if(b.getFecha().isEqual(fecha)) {
			listaBeneficios.add(b);
		}
	}
	return listaBeneficios;
	}
	
	/*******************************************************/
	//17
	public List<Beneficio> traerBeneficios(TipoBeneficio tipoBeneficio, LocalDate fecha) throws Exception {
		List<Beneficio> listaBeneficios = new ArrayList<Beneficio>();
		
		for(Beneficio b: traerBeneficios(fecha)) {
			if(b.getFecha()!=fecha) {
				throw new Exception("La fecha no existe");
			}
				
			if(b.getFecha().isEqual(fecha) && b.getTipoBeneficio()==tipoBeneficio) {
				listaBeneficios.add(b);
			}
		}
		return listaBeneficios;
	}
	
	/*******************************************************/
	//18
	public List<Beneficio> traerBeneficios(Estudiante estudiante, LocalDate fecha) {
		List<Beneficio> listaBeneficios = new ArrayList<Beneficio>();
		
		for(Beneficio b: traerBeneficios(fecha)) {
			if(b.getEstudiante()==estudiante) {
				listaBeneficios.add(b);
			}
		}
		return listaBeneficios;
	}
	
	/*******************************************************/
	//19
	public int cantidadOtorgada(TipoBeneficio tipoBeneficio, LocalDate fecha) {
		int cantidad=0;
		
		for(Beneficio b: traerBeneficios(fecha)) {
			if(b.getTipoBeneficio()==tipoBeneficio) {
				cantidad=cantidad+1;
			}
		}		
		return cantidad;
	}
	
	/*******************************************************/
	//20
	public int cantidadOtorgada(Estudiante estudiante, LocalDate fecha) {
		int cantidad=0;
		
		for(Beneficio b: traerBeneficios(fecha)) {
			if(b.getEstudiante()==estudiante) {
				cantidad=cantidad+1;
			}
		}
	return cantidad;
	}
	
	
}
