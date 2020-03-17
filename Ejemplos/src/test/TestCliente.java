package test;

import modelo.Cliente;
import modelo.SistemaInmobiliaria;

public class TestCliente {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaInmobiliaria sistema= new SistemaInmobiliaria();
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Agregar Cliente con id");
		
		sistema.agregarCliente(1, 1111111, "Nicolas", "Perez", "1234567890");
		sistema.agregarCliente(2, 2222222, "Romina", "Mansilla", "1234567810");
		sistema.agregarCliente(3, 3333333, "Alejandra", "Vranic", "1234567811");
		sistema.agregarCliente(4, 4444444, "Pablo", "Perez", "1234567812");
		sistema.agregarCliente(5, 5555555, "Homero", "Simpson", "1234567813");
		sistema.agregarCliente(6, 6666666, "Lissa", "Simpson", "1234567814");

		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
		/*-----------------------------------------------------------------------*/
	    
		System.out.println("Agregar Cliente con dni");
		
		sistema.agregarCliente(7777777, "Andres", "Benitez", "1234567815");
		sistema.agregarCliente(8888888, "Blanca", "Benitez", "1234567816");
		sistema.agregarCliente(9999999, "Angel", "Benitez", "1234567817");
		sistema.agregarCliente(1010101, "Ana", "Benitez", "1234567818");
		sistema.agregarCliente(1212121, "Clara", "Simpson", "1234567819");
		sistema.agregarCliente(1313131, "Belen", "Montenegro", "1234567820");

		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Cliente por id");
		 
		System.out.println(sistema.traerClientePorId(5));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Cliente por dni");
		 
		System.out.println(sistema.traerClientePordni(6666666));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Modificar Cliente por id");
		 
		System.out.println(sistema.modificarClientePorId(4, 12345678, "Maggie", "Simpson", "9876543212"));
		
		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Modificar Cliente por dni");
		 
		System.out.println(sistema.modificarClientePordni(1212121, "Griselda", "Benitez", "9876543213"));
		
		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Cliente por nombre");
		 
		System.out.println(sistema.traerClientePorNombre("Belen"));
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Promedio de DNI");
		 
		System.out.println(sistema.promedioDedni());
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Eliminar Cliente");
		 
		System.out.println(sistema.eliminarCliente(2222222));
		
		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");

		
	}

}
