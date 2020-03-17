package test;

import modelo.Locador;
import modelo.Propiedad;
import modelo.SistemaInmobiliaria;

public class TestPropiedad {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaInmobiliaria sistema= new SistemaInmobiliaria();
		
		Locador locador1 = new Locador(1111111, "Nicolas", "Perez", "1234567890",1,"Frances", 20,"Animal");
		Locador locador2= new Locador(2222222, "Romina", "Mansilla", "1234567810",2,"Santander Rio",19,"Pescado");
		Locador locador3= new Locador(3333333, "Alejandra", "Vranic", "1234567811",3,"Patagonia",18,"Gato");
		
		Locador locador4= new Locador(7777777, "Andres", "Benitez", "1234567815",7,"Santander Rio",15,"Caballo");
		Locador locador5= new Locador(8888888, "Blanca", "Benitez", "1234567816",8,"Patagonia",14,"Mariposa");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Agregar Propiedad con id");
		
		sistema.agregarPropiedad(1, 1010, "Uno", 2340, 1, "UF", "Lanús", "Buenos Aires",locador1);
		sistema.agregarPropiedad(2, 9090, "Dos", 2341, 2, "UF1", "Lanús", "Buenos Aires",locador2);
		sistema.agregarPropiedad(3, 8080, "Tres", 2342, 3, "UF2", "Lanús", "Buenos Aires",locador3);


		for(Propiedad p: sistema.getLstPropiedades()){
			System.out.println(p.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
		/*-----------------------------------------------------------------------*/
	    
		System.out.println("Agregar Propiedad con nro partida");
		
		sistema.agregarPropiedad(7070, "Cuatro", 2343, 4, "UF3", "Lanús", "Buenos Aires",locador4);
		sistema.agregarPropiedad(8081, "Cinco", 2344, 5, "UF4", "Lanús", "Buenos Aires",locador5);

		for(Propiedad p: sistema.getLstPropiedades()){
			System.out.println(p.toString());
		}

		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Propiedad por id");
		 
		System.out.println(sistema.traerPropiedadPorId(3));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Propiedad por nro partida");
		 
		System.out.println(sistema.traerPropiedadNroPartida(8081));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Modificar Propiedad por id");
		 
		System.out.println(sistema.modificarPropiedadPorId(4, 7071, "Cuatro", 2348, 6, "UF3", "Lanús", "Buenos Aires",locador4));
		
		for(Propiedad p: sistema.getLstPropiedades()){
			System.out.println(p.toString());
		}

		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Modificar Propiedad por nro partida");
		 
		System.out.println(sistema.modificarPropiedadPorNroPartida(1010, "Uno", 2640, 1, "UF", "Lanús", "Corriente",locador1));
		
		for(Propiedad p: sistema.getLstPropiedades()){
			System.out.println(p.toString());
		}

		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer Propiedad por calle");
		 
		System.out.println(sistema.traerPropiedadPorCalle("Dos"));
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Promedio de Nro Partida");
		 
		System.out.println(sistema.promedioDeNroDePartida());
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Eliminar Propiedad");
		 
		System.out.println(sistema.eliminarPropiedad(9090));
		
		for(Propiedad p: sistema.getLstPropiedades()){
			System.out.println(p.toString());
		}

		System.out.println("-------------------------------------------------");


	}

}
