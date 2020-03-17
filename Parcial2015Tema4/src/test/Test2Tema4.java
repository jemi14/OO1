package test;

import modelo.AdmClientes;

public class Test2Tema4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		AdmClientes admCliente= new AdmClientes();
		
		admCliente.agregarCliente("Perez", "Nicolas", 12345678, 'm', "12345", true);
		admCliente.agregarCliente("Haugg", "Hugo", 2345678, 'm', "67890", true);
		admCliente.agregarCliente("Benitez", "Andres", 34567890,'m', "98765", true);
		admCliente.agregarCliente("Simpson", "Homero", 98765432, 'm', "13579", false);
		admCliente.agregarCliente("aaaaa", "bbbbb", 24680135, 'f', "97543", false);
		admCliente.agregarCliente("ccccc", "ddddd", 12345690, 'f', "34678", false);
		
		System.out.println(admCliente.toString());
		
		

	}

}
