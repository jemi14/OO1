package test;

import modelo.Cliente;
import modelo.SistemaInmobiliaria;

public class TestLocadorHerencia {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaInmobiliaria sistema= new SistemaInmobiliaria();
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Agregar Cliente con Locador");
		
		sistema.agregarLocador(1, 1111111, "Nicolas", "Perez", "1234567890", "Animal", "Frances", 1, 20);
		sistema.agregarLocador(2, 2222222, "Romina", "Mansilla", "1234567810", "Pescado", "Santander Rio", 2, 19);
		sistema.agregarLocador(3, 3333333, "Alejandra", "Vranic", "1234567811", "Gato", "Patagonia", 3, 18);
		sistema.agregarLocador(4, 4444444, "Pablo", "Perez", "1234567812", "Perro", "Frances", 4, 17);
		sistema.agregarLocador(5, 5555555, "Homero", "Simpson", "1234567813", "Cerdo", "Santader Rio", 5, 17);
		sistema.agregarLocador(6, 6666666, "Lissa", "Simpson", "1234567814", "Oveja", "Patagonia", 6, 16);

		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
		/*-----------------------------------------------------------------------*/
	    
		System.out.println("Agregar Cliente con Locador pero con dni");
		
		sistema.agregarLocador(7777777, "Andres", "Benitez", "1234567815", "Caballo", "Santander Rio", 7, 15);
		sistema.agregarLocador(8888888, "Blanca", "Benitez", "1234567816", "Mariposa", "Patagonia", 8, 14);
		sistema.agregarLocador(9999999, "Angel", "Benitez", "1234567817", "Mono", "Frances", 9, 13);
		sistema.agregarLocador(1010101, "Ana", "Benitez", "1234567818", "Lechuza", "Naranja", 10, 12);
		sistema.agregarLocador(1212121, "Clara", "Simpson", "1234567819", "Vaca", "Santander Rio", 11, 11);
		sistema.agregarLocador(1313131, "Belen", "Montenegro", "1234567820", "Gato", "Frances", 12, 10);

		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Locador por id");
		 
		System.out.println(sistema.traerLocadorPorid(5));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Locador por dni de cliente");
		 
		System.out.println(sistema.traerLocadorPordni(6666666));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Locador por nombre de cliente");
		 
		System.out.println(sistema.traerLocadorPorNombre("Belen"));
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Eliminar Locador por id de Cliente");
		 
		System.out.println(sistema.eliminarCliente(2222222));
		
		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");
		
	}

}
