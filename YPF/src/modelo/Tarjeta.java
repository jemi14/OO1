package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import funciones.Funciones;

public class Tarjeta {
	
	private int idTarjeta;
	private int kilometros;
	private Cliente cliente;
	private List<Compra>lstCompras=new ArrayList<Compra>();
	
	public Tarjeta(int idTarjeta, int kilometros, Cliente cliente, List<Compra> lstCompras) {
		super();
		this.idTarjeta = idTarjeta;
		this.kilometros = kilometros;
		this.cliente = cliente;
		this.lstCompras = lstCompras;
	}

	public Tarjeta(int kilometros, Cliente cliente, List<Compra> lstCompras) {
		super();
		this.kilometros = kilometros;
		this.cliente = cliente;
		this.lstCompras = lstCompras;
	}

	public Tarjeta(int idTarjeta, int kilometros) {
		super();
		this.idTarjeta = idTarjeta;
		this.kilometros = kilometros;
	}

	public Tarjeta(int idTarjeta, int kilometros, Cliente cliente) {
		super();
		this.idTarjeta = idTarjeta;
		this.kilometros = kilometros;
		this.cliente = cliente;
	}

	public Tarjeta() {
		super();
	}
	
	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getKilometros() {
		return kilometros;
	}

	public void setKilometros(int kilometros) {
		this.kilometros = kilometros;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Compra> getLstCompras() {
		return lstCompras;
	}

	public void setLstCompras(List<Compra> lstCompras) {
		this.lstCompras = lstCompras;
	}

	@Override
	public String toString() {
		return "Tarjeta [idTarjeta=" + idTarjeta + ", kilometros=" + kilometros + ", cliente=" + cliente
				+ ", lstCompras=" + lstCompras + "]";
	}

	/*-----------------------------------------------------------------------*/
	public Compra traerCompra(LocalDate fechaHora){
		int i=0;
		boolean respuesta=false;
		Compra compraEncontrado=null;
		while(i<lstCompras.size()&& !respuesta){
			if(Funciones.sonFechasIguales(lstCompras.get(i).getFechaHora(),fechaHora)){
				compraEncontrado=lstCompras.get(i);
			}
			i++;
	}
		return compraEncontrado;
	}
	
	
	
	


}
