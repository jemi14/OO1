package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
	
	private int idCuenta;
	private String nroDeCuenta;
	private Cliente cliente;
	private List<Pasaje> lstPasajes= new ArrayList<Pasaje>();
	
	public Cuenta(int idCuenta, String nroDeCuenta, Cliente cliente, List<Pasaje> lstPasajes) {
		super();
		this.idCuenta = idCuenta;
		this.nroDeCuenta = nroDeCuenta;
		this.cliente = cliente;
		this.lstPasajes = lstPasajes;
	}

	public Cuenta(String nroDeCuenta, Cliente cliente, List<Pasaje> lstPasajes) {
		super();
		this.nroDeCuenta = nroDeCuenta;
		this.cliente = cliente;
		this.lstPasajes = lstPasajes;
	}
	
	public Cuenta(int idCuenta, String nroDeCuenta, Cliente cliente) {
		super();
		this.idCuenta = idCuenta;
		this.nroDeCuenta = nroDeCuenta;
		this.cliente = cliente;
	}

	public Cuenta(String nroDeCuenta, Cliente cliente) {
		super();
		this.nroDeCuenta = nroDeCuenta;
		this.cliente = cliente;
	}

	public Cuenta() {
		super();
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}

	public String getNroDeCuenta() {
		return nroDeCuenta;
	}

	public void setNroDeCuenta(String nroDeCuenta) {
		this.nroDeCuenta = nroDeCuenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pasaje> getLstPasajes() {
		return lstPasajes;
	}

	public void setLstPasajes(List<Pasaje> lstPasajes) {
		this.lstPasajes = lstPasajes;
	}

	@Override
	public String toString() {
		return "Cuenta [idCuenta=" + idCuenta + ", nroDeCuenta=" + nroDeCuenta + ", cliente=" + cliente
				+ ", lstPasajes=" + lstPasajes + "]";
	}
	
	/******************************************************/
	public boolean verificarDigitos() throws Exception {
		boolean resultado =false;
		
		String nroC = nroDeCuenta.replace("/", ""); //Reemplaza la barra por cualquiera
		
		int cantidadNumeros = nroC.length(); //Esto me dice que son 11
		//el cero es el 7, el uno es el 9.......... el 10 es el 3
		if(cantidadNumeros!=11) {
			throw new Exception ("ERROR: Nro de cuenta invalido "+ nroDeCuenta );
			}
		else {
			resultado=true;
		}

		return resultado;
	}
	
	/******************************************************/
	public boolean verificarCuenta() throws NumberFormatException, Exception {
		
		
		String nroC = nroDeCuenta.replace("/", "");
		
		boolean resultadoComparacion = false;
		int cuentaParcial = 0;
		int sumaDigitos = 0;
		int sumaFinal = 0;
		
		//primero, tenes que saber el tamanio del numero, es decir cuantos numeros tiene, este tiene 11
		
		int cantidadNumeros = nroC.length(); //Esto me dice que son 11
		//el cero es el 7, el uno es el 9.......... el 10 es el 3
		
		//hacer un for de 0 a 9, para sumar
		for (int i = 0; i<10; i++) {
			
			//si la posicion es par (0-2-4-6-8) no hace nada
			if( i%2 == 0) { //eso queire decir par
				
				cuentaParcial = Integer.parseInt(nroC.substring(i, i+1)); //nada
			}
			else {
				
				cuentaParcial = Integer.parseInt(nroC.substring(i, i+1))*2;// multiplica por 2
			}
		
			//si la cuenta parcial tiene dos digitos, 11, 12, 13... tengo que sumarlos
			if(cuentaParcial>9) {
				
				sumaDigitos = 1 +cuentaParcial%10;  //1 mas el ultimo digito.... 14 es 1 +4
				
			}
			else {
				sumaDigitos = cuentaParcial;
				
			}
			
			sumaFinal = sumaFinal + sumaDigitos;

		}//cierra el for
		
		sumaFinal = sumaFinal *9; //al final multiplicar por 9
		
		sumaFinal = sumaFinal%10; //quedarme con el ultimo numero
		
		
		if(sumaFinal==Integer.parseInt(nroC.substring(cantidadNumeros-1, cantidadNumeros)) && verificarDigitos()) {
			
			resultadoComparacion = true;
		}
		
		if(!resultadoComparacion) {
			throw new Exception ("ERROR: Nro de cuenta invalido "+ nroDeCuenta );
			}
		
		return resultadoComparacion;
	}
	
	//-------------------------------------------------------//
	public Pasaje traerPasaje(int id) {
		int i=0;
		Pasaje pasajeEncontrada=null;
		while (i<lstPasajes.size() && pasajeEncontrada==null) {
			if(lstPasajes.get(i).getIdPasaje()==id) {
				pasajeEncontrada= lstPasajes.get(i);
			}
			i++;
		}
		return pasajeEncontrada;
	}
	
	/******************************************************/
	public boolean agregarPasaje(int idPasaje, Cliente cliente, Vuelo vuelo) throws Exception {
		boolean respuesta= false;
		Pasaje pasajeExiste=traerPasaje(idPasaje);
		if(pasajeExiste!=null) {
			throw new Exception ("ERROR! El pasaje ya existe, El nro de pasaje es " + idPasaje + pasajeExiste.toString());
		}
		else {
		Pasaje pasajeAgregado= new Pasaje(idPasaje, cliente, vuelo);
		lstPasajes.add(pasajeAgregado);
		}
		return respuesta;
	}
	
}
