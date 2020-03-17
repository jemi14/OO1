package test;

import modelo.Cliente;
import modelo.SistemaInmobiliaria;

public class TestLocatorioHerencia {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaInmobiliaria sistema= new SistemaInmobiliaria();
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Agregar cliente con Locatorio");
		
		sistema.agregarLocatorio(1, 1111111, "Nicolas", "Perez", "1234567890", false);
		sistema.agregarLocatorio(2, 2222222, "Romina", "Mansilla", "1234567810", false);
		sistema.agregarLocatorio(3, 3333333, "Alejandra", "Vranic", "1234567811", false);
		sistema.agregarLocatorio(4, 4444444, "Pablo", "Perez", "1234567812", true);
		sistema.agregarLocatorio(5, 5555555, "Homero", "Simpson", "1234567813", true);
		sistema.agregarLocatorio(6, 6666666, "Lissa", "Simpson", "1234567814", true);

		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
		/*-----------------------------------------------------------------------*/
	    
		System.out.println("Agregar Cliente con Locatorio pero con dni");
		
		sistema.agregarLocatorio(7777777, "Andres", "Benitez", "1234567815", false);
		sistema.agregarLocatorio(8888888, "Blanca", "Benitez", "1234567816", true);
		sistema.agregarLocatorio(9999999, "Angel", "Benitez", "1234567817", false);
		sistema.agregarLocatorio(1010101, "Ana", "Benitez", "1234567818", true);
		sistema.agregarLocatorio(1212121, "Clara", "Simpson", "1234567819", false);
		sistema.agregarLocatorio(1313131, "Belen", "Montenegro", "1234567820", false);

		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Locatorio por id");
		 
		System.out.println(sistema.traerLocatorioPorid(5));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Locatorio por dni de cliente");
		 
		System.out.println(sistema.traerLocatorioPordni(6666666));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Locatorio por nombre de cliente");
		 
		System.out.println(sistema.traerLocatorioPorNombre("Belen"));
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Eliminar Locatorio por id de Cliente");
		 
		System.out.println(sistema.eliminarCliente(2222222));
		
		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");

	}

}
