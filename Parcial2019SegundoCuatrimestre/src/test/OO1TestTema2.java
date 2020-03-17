package test;

import java.time.LocalDate;

import modelo.SistemaStock;

public class OO1TestTema2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaStock sistema= new SistemaStock();
		
		//------------------------------------------
		
		System.out.println("1 Agregar los siguientes productos e imprimir la lista de productos");
		
		try {
		sistema.agregarProducto("1234561", "Remera Hockey", "M", 590.0);
		sistema.agregarProducto("4832758", "Camiseta Futbol", "L", 750.0);
		sistema.agregarProducto("3852173", "Zapatillas", "40", 2500.0);
				
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		System.out.println(sistema.traerProducto());
		
		System.out.println("--------------------------------");
		
		System.out.println("2 Intentar agregar el producto codigo producto");
		
		try {
		sistema.agregarProducto("3839172", "Pantalon", "XL", 1520.0);
		
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		System.out.println("--------------------------------");
		
		System.out.println("3 Intentar agregar el producto codigo producto");
		
		try {
			sistema.agregarProducto("4832758", "Camiseta Futbol", "L", 750.0);
			
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		System.out.println("--------------------------------");
		
		System.out.println("4 Traer e imprimir un codigo");
		
		System.out.println(sistema.traerProducto("1234561"));
		
        System.out.println("--------------------------------");
		
		System.out.println("5 Agregar personas e imprimir las listas de personas");
		
		try {
			sistema.agregarEmpleado("Luis", "Perez", LocalDate.of(2000, 10, 01), 11111111, false);
			sistema.agregarCliente("Mariana", "Rodriguez", LocalDate.of(2000, 02, 11), 22222222, true);
			sistema.agregarEmpleado("Marta", "Lopez", LocalDate.of(2000, 02, 01), 33333333, true);
			sistema.agregarCliente("Mariano", "Martinez", LocalDate.of(2000, 10, 15), 44444444, true);
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		System.out.println(sistema.traerPersona());
		
		System.out.println("--------------------------------");
		
		System.out.println("6 Agregar lotes e imprimir las listas de lotes");
		
		//Incompleto
		
		
	}
}
