package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sucursal {
	
	private int idSucursal;
	private String direccion;
	private List<Empleado> lstEmpleados;
	private List<Lote> lstLotes;
	
	public Sucursal(int idSucursal, String direccion, List<Empleado> lstEmpleados, List<Lote> lstLotes) {
		super();
		this.idSucursal = idSucursal;
		this.direccion = direccion;
		this.lstEmpleados = new ArrayList<Empleado>();
		this.lstLotes = new ArrayList<Lote>();
	}

	public Sucursal(String direccion, List<Empleado> lstEmpleados, List<Lote> lstLotes) {
		super();
		this.direccion = direccion;
		this.lstEmpleados = new ArrayList<Empleado>();
		this.lstLotes = new ArrayList<Lote>();
	}
	
	public Sucursal(int idSucursal, String direccion) {
		super();
		this.idSucursal = idSucursal;
		this.direccion = direccion;
		this.lstEmpleados = new ArrayList<Empleado>();
		this.lstLotes = new ArrayList<Lote>();
	}

	public Sucursal() {
		super();
		this.lstEmpleados = new ArrayList<Empleado>();
		this.lstLotes = new ArrayList<Lote>();
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}

	public void setLstEmpleados(List<Empleado> lstEmpleados) {
		this.lstEmpleados = lstEmpleados;
	}

	public List<Lote> getLstLotes() {
		return lstLotes;
	}

	public void setLstLotes(List<Lote> lstLotes) {
		this.lstLotes = lstLotes;
	}

	public String toString1() {
		return "Sucursal [idSucursal=" + idSucursal + ", direccion=" + direccion +"]";
	}
	
	public String toString2() {
		return "Sucursal [idSucursal=" + idSucursal + "]";
	}
	
	
	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", direccion=" + direccion + ", lstEmpleados=" + lstEmpleados
				+ ", lstLotes=" + lstLotes + "]";
	}

	/********************************************************/ //6
	public boolean agregarEmpleado(String nombre, String apellido, long dni) {
		boolean respuesta=false;
		
		Empleado empleadoAgregado= new Empleado(nombre, apellido, dni);
		lstEmpleados.add(empleadoAgregado);
		
		traerEmpleado(dni).setSucursal(this);
		
		respuesta=true;
		return respuesta;
	}
	
	/********************************************************/ //7
	public Empleado traerEmpleado(long dni) {
		int i=0;
		Empleado empleadoEncontrado=null;
		while(i<lstEmpleados.size() && empleadoEncontrado==null) {
			if(lstEmpleados.get(i).getDni()==dni) {
				empleadoEncontrado= lstEmpleados.get(i);
			}
			i++;
		}
		return empleadoEncontrado;
	}
	
	/********************************************************/ //9
	public boolean agregarLote(Producto producto, LocalDate fechaAlta, int cantidadInicial) {
		boolean respuesta=false;
		//La cantidad inicial es la misma q la cantidad actual
		int cantidadActual = cantidadInicial;
		Lote loteAgregado= new Lote(this, producto, fechaAlta, cantidadInicial,cantidadActual,true);
		lstLotes.add(loteAgregado);
		respuesta=true;
		return respuesta;
	}
	
	/********************************************************/ //10
	public List<Lote> traerLoteActivos(Producto producto) {
		List<Lote> listaLotes= new ArrayList<Lote>();
		
		for(Lote l: lstLotes) {
			if(l.getProductos().getIdProducto()==producto.getIdProducto()) {
				listaLotes.add(l);
			}
		}
		return listaLotes;
	}
	
	/********************************************************/ //11
	public int traerCantidad(Producto producto) {
		int cantidad=0;
		
		for(Lote l: traerLoteActivos(producto)) {
			cantidad= cantidad+ l.getCantidadActual();
		}
		return cantidad;
	}
	
	/********************************************************/ //12
	public boolean validarConsumo(Producto producto, int cantidad) {
		boolean resultado= false;
		
			if(traerCantidad(producto)>=cantidad) {
				resultado=true;
		}
			return resultado;
	}
	
}
	
	