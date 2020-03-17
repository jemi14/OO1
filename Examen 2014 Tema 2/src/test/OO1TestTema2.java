package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Pasaje;
import modelo.Vuelo;

public class OO1TestTema2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente4 = new Cliente ("Dominguez", "Julian", 11111111);
		Cuenta cuenta1 = new Cuenta("735845O73/4", cliente4);
		
		System.out.println("Escenario 1: El numero de cuenta NO tiene 11 digitos");
		
		try {
			
			cuenta1.verificarDigitos();
			
		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
		
	    System.out.println("-------------------------------------------");
		
		System.out.println("Escenario 2: Verificador incorrecto");

		Cliente cliente1= new Cliente("Perez","Martin Juan",22222222);
		Cuenta cuenta2 = new Cuenta("7435978542/3", cliente1);
		
        try {
			
			cuenta2.verificarCuenta();
			
		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
        
       System.out.println("-------------------------------------------");
		
		System.out.println("Escenario 3: Verificador correcto");

		Cuenta cuenta3 = new Cuenta("7534897531/1", cliente1);
		
			try {
				System.out.println(cuenta3.verificarCuenta());
			} catch (Exception e) {
				System.out.println("Exception : "+e.getMessage());
			}
			
        System.out.println("-------------------------------------------");
		
		Cuenta cuenta = new Cuenta();
		
		//-------------------------------------
		Vuelo vuelo1 = new Vuelo(1,"Aerolineas Argentinas","Buenos Aires", LocalDate.of(2014, 11, 1), LocalTime.of(18, 30), "Mendoza");
		
		Cliente cliente2= new Cliente("Perez","Maria",22222222);
		
		//-------------------------------------
		
		System.out.println("Escenario 4: Agregar Pasaje Duplicado");
		
		try {
			cuenta.agregarPasaje(1, cliente2, vuelo1);
			cuenta.agregarPasaje(1, cliente2, vuelo1);
		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
	
	    System.out.println("-------------------------------------------");

		System.out.println("Escenario 5: Correcto");
		
		//-------------------------------------
		 Cliente cliente3= new Cliente("Rodriguez","Juan",33333333);
		 Cliente cliente5= new Cliente("Rodriguez","Lucia",44444444);
		//-------------------------------------
		
		try {
			cuenta.agregarPasaje(2, cliente1, vuelo1);
			cuenta.agregarPasaje(3, cliente3, vuelo1);
			cuenta.agregarPasaje(4, cliente5, vuelo1);
		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
		
		 for(Pasaje pasaje: cuenta.getLstPasajes() ) {
		System.out.println(pasaje.toString());
	    }
	    
		

	}

}
