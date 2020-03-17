package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.Pasaje;
import modelo.Vuelo;

public class OO1TestTema1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente4 = new Cliente ("Rodriguez", "Martin", 11111111);
		Cuenta cuenta1 = new Cuenta("834843568/5", cliente4);
		
		System.out.println("Escenario 1: El numero de cuenta NO tiene 11 digitos");
		
		try {
			
			cuenta1.verificarDigitos();
			
		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
		
		System.out.println("-------------------------------------------");
		
		System.out.println("Escenario 2: Verificador incorrecto");

		Cliente cliente1= new Cliente("Rodriguez","Ana",22222222);
		Cuenta cuenta2 = new Cuenta("7382834951/3", cliente1);
		
        try {
			
			cuenta2.verificarCuenta();
			
		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
        
		System.out.println("-------------------------------------------");
		
		System.out.println("Escenario 3: Verificador correcto");

		Cuenta cuenta3 = new Cuenta("7992739871/3", cliente1);
		
			try {
				System.out.println(cuenta3.verificarCuenta());
			} catch (Exception e) {
				System.out.println("Exception : "+e.getMessage());
			}
			
        System.out.println("-------------------------------------------");
		
		Cuenta cuenta = new Cuenta();
		
		//-------------------------------------
		Vuelo vuelo1 = new Vuelo(1,"Aerolineas Argentinas","Buenos Aires", LocalDate.of(2014, 10, 31), LocalTime.of(9, 30), "Jujuy");
		//-------------------------------------
		
		System.out.println("Escenario 4: Agregar Pasaje Duplicado");
		
		try {
			cuenta.agregarPasaje(1, cliente1, vuelo1);
			cuenta.agregarPasaje(1, cliente1, vuelo1);
		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
	
	System.out.println("-------------------------------------------");

	System.out.println("Escenario 5: Correcto");
	
	//-------------------------------------
	 Cliente cliente2= new Cliente("Rodriguez","Juan",33333333);
	 Cliente cliente3= new Cliente("Rodriguez","Lucia",44444444);
	//-------------------------------------
	
	try {
		cuenta.agregarPasaje(2, cliente1, vuelo1);
		cuenta.agregarPasaje(3, cliente2, vuelo1);
		cuenta.agregarPasaje(4, cliente3, vuelo1);
	} catch (Exception e) {
		System.out.println("Exception : "+e.getMessage());
	}
	
	 for(Pasaje pasaje: cuenta.getLstPasajes() ) {
	System.out.println(pasaje.toStringCorrecto());
    }
	
	
	
	
	}
	
}
