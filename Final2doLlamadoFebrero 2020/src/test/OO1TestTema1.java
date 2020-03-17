package test;

import java.time.LocalDate;

import modelo.SistemaVTV;

public class OO1TestTema1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SistemaVTV sistema = new SistemaVTV();

		//--------------------------------------------------
		
		System.out.println("1 Agregar e imprimir la lista personas");
		
		sistema.agregarInspector("Perez", "Juan", 11111111, 100);
		sistema.agregarContribuyente("Lopez", "Rodrigo", 22222222, false);
		sistema.agregarContribuyente("Martinez", "Julian", 33333333, false);
		sistema.agregarInspector("Alvarez", "José", 44444444, 101);
		sistema.agregarContribuyente("Martinez", "Martin", 55555555, true);
		sistema.agregarContribuyente("Fernandez", "Julio", 66666666, false);
		sistema.agregarInspector("Bou", "Gustavo", 77777777, 102);
		sistema.agregarInspector("Gonzales", "Cristian", 88888888, 103);
		
		System.out.println(sistema.getLstPersonas());
		
		System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("2 Traer contribuyente id= 2");
		
		System.out.println(sistema.traerContribuyente(2));
		
        System.out.println("------------------------------");
		
		//--------------------------------------------------
		
		System.out.println("3 Agregar e imprimir la lista de automores");
		
		try {
			
		sistema.agregarAutomotor("GAA111", 2010, "Fiat", sistema.traerContribuyente(2));
		sistema.agregarAutomotor("AAA100", 2005, "Corsa", sistema.traerContribuyente(3));
		sistema.agregarAutomotor("HHH222", 2011, "volkswagen", sistema.traerContribuyente(5));
		sistema.agregarAutomotor("JJJ333", 2010, "Fiat", sistema.traerContribuyente(6));
		sistema.agregarAutomotor("LLL444", 2010, "Honda", sistema.traerContribuyente(3));
		}
		catch (Exception e) {
			System.out.println("Exception "+ e.getMessage());
		}
		
		System.out.println(sistema.getLstAutomotor());
	
	    System.out.println("------------------------------");
	
	//--------------------------------------------------
	
	System.out.println("4 Tratar de agregar el siguiente automotor");
	
	   try {
		
		sistema.agregarAutomotor("GAA111", 2015, "Fiat", sistema.traerContribuyente(3));
		}
		catch (Exception e) {
			System.out.println("Exception "+ e.getMessage());
		}
	   
	   System.out.println("------------------------------");
		
		//--------------------------------------------------
	   
	   System.out.println("5 Traer el inspector con id=1");
	   
	   System.out.println(sistema.traerInspector(1));
	   
	   System.out.println("------------------------------");
		
	   //--------------------------------------------------
	   
	   System.out.println("6 Traer el automotor con LLL444");
	   
	   System.out.println(sistema.traerAutomotor("LLL444"));
	   
	   System.out.println("------------------------------");
		
	   //--------------------------------------------------
	
	   System.out.println("7 Agregar e imprimir la lista de inspecciones");
	   
	   LocalDate fecha1= LocalDate.of(2019, 02, 10);
	   LocalDate fecha2= LocalDate.of(2019, 02, 11);
	   LocalDate fecha3= LocalDate.of(2019, 02, 13);
	   
	   sistema.agregarInspeccion(fecha1, false, "apto", sistema.traerAutomotor("LLL444"), sistema.traerInspector(1));
	   sistema.agregarInspeccion(fecha1, false, "Condicional", sistema.traerAutomotor("LLL444"), sistema.traerInspector(1));
	   sistema.agregarInspeccion(fecha1, false, "Condicional", sistema.traerAutomotor("LLL444"), sistema.traerInspector(1));
	   sistema.agregarInspeccion(fecha2, false, "apto", sistema.traerAutomotor("LLL444"), sistema.traerInspector(1));
	   sistema.agregarInspeccion(fecha2, false, "apto", sistema.traerAutomotor("LLL444"), sistema.traerInspector(1));
	   sistema.agregarInspeccion(fecha3, false, "rechazado", sistema.traerAutomotor("LLL444"), sistema.traerInspector(1));
	   sistema.agregarInspeccion(fecha3, false, "apto", sistema.traerAutomotor("LLL444"), sistema.traerInspector(1));
	   sistema.agregarInspeccion(fecha3, false, "apto", sistema.traerAutomotor("LLL444"), sistema.traerInspector(1));
	   
	   System.out.println(sistema.getLstInspeccion());
	
	   System.out.println("------------------------------");
		
	  //--------------------------------------------------
	   
	   System.out.println("8 Traer la inspeccion con id=1");
	   
	   System.out.println(sistema.traerInspeccion(1));
	   
	   System.out.println("------------------------------");
		
		//--------------------------------------------------
	   
       System.out.println("9 Traer la inspeccion del automotor LLL444");
	   
	   System.out.println(sistema.traerInspeccion(sistema.traerAutomotor("LLL444")));
	   
	   System.out.println("------------------------------");
		
		//--------------------------------------------------
	   
       System.out.println("10 Traer la inspeccion del 11/02/2019");
	   
	   System.out.println(sistema.traerInspeccion(fecha2));
	   
	   System.out.println("------------------------------");
		
		//--------------------------------------------------
	   
      System.out.println("11 Traer la inspeccion de la persona con id=1 del 11/02/2019");
	   
	   System.out.println(sistema.traerInspeccion(sistema.traerInspector(1), fecha2));
	   
	   System.out.println("------------------------------");
		
		//--------------------------------------------------
	   
      System.out.println("12 Traer la inspeccion del 11/02/2019 con estado apto");
	   
	   System.out.println(sistema.traerInspeccion(fecha2, "apto"));
	   
	   System.out.println("------------------------------");
		
		//--------------------------------------------------
	   
	}

}
