package modelo;

import java.util.ArrayList;
import java.util.List;

public class AdmClientes {
	
	private List<Cliente> cartera;

	public AdmClientes(List<Cliente> cartera) {
		super();
		this.cartera = cartera;
	}
	
	public AdmClientes() {
		super();
		this.cartera = new ArrayList<Cliente>();
	}

	public List<Cliente> getCartera() {
		return cartera;
	}

	public void setCartera(List<Cliente> cartera) {
		this.cartera = cartera;
	}

	@Override
	public String toString() {
		return "AdmClientes [cartera=" + cartera + "]";
	}

	//------------------------------------------
	public int traerMaximoIdCliente() {
		int maximoId=0;
		for(Cliente cliente: cartera) {
			if(cliente.getIdCliente()>maximoId) {
				maximoId=cliente.getIdCliente();
			}
		}
		return maximoId;
	}
	
	/***************************************/
	public Cliente traerCliente(int dni) {
		int i=0;
		Cliente clienteEncontrado=null;
		while(i<cartera.size() && clienteEncontrado==null) {
			if(cartera.get(i).getDni()==dni) {
				clienteEncontrado=cartera.get(i);
			}
			i++;
		}
		return clienteEncontrado;
	}
	
	/***************************************/
	public boolean agregarCliente(String apellido, String nombre, int dni, char sexo, String nroCliente, boolean activo) throws Exception {
		boolean respuesta= false;
		Cliente clienteExiste= traerCliente(dni);
		if(clienteExiste!=null) {
			throw new Exception("El cliente ya existe"); 
			}
		else {
			int idClienteProximo=1;
			idClienteProximo=traerMaximoIdCliente()+1;
			Cliente clienteAgregado= new Cliente(idClienteProximo, apellido, nombre, dni, sexo, nroCliente, activo);
			cartera.add(clienteAgregado);
		}
		return respuesta;
	}
	
	/***************************************/
	public List<Cliente> traerCliente(boolean activo) {
		List <Cliente> listaClientes = new ArrayList<Cliente>();
		
		for(Cliente c: cartera) {
			if(c.isActivo()==activo) {
					listaClientes.add(c);
			}
		}
		return listaClientes;
	}
	
	

}
