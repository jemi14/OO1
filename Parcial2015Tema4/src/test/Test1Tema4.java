package test;

import modelo.Cliente;

public class Test1Tema4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente= new Cliente();
		
		System.out.println("Escenario 1 Invalido ");
		
		System.out.println(cliente.validarNroCliente("34526"));
		
		System.out.println("--------------------------------");
		
		System.out.println("Escenario 2 Valido");
		
		System.out.println(cliente.validarNroCliente("34527"));
		
		
		
	}

}
