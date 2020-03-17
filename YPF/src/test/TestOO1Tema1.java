package test;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.Producto;
import modelo.SistemaYPF;
import modelo.Tarjeta;

public class TestOO1Tema1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaYPF sistema= new SistemaYPF();
		
       /*-----------------------------------------------------------------------*/
		
		System.out.println("Escenarios 1");
		sistema.agregarCliente("Micaela", "Hidaldo", "mhidalgo@gmail.com", 11111111);
		sistema.agregarCliente("Juan", "Lopez", "jLopez@gmail.com", 22222222);
		sistema.agregarCliente("Daniela", "Rojas", "drojas@gmail.com", 33333333);
		sistema.agregarCliente("Lucas", "Suarez", "lsuarez@gmail.com", 44444444);
		sistema.agregarCliente("Micaela", "Hidaldo", "mhidalgo@gmail.com", 55555555);
		
		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
		
	    try {
	    
		System.out.println("Escenarios 2");
		sistema.agregarCliente("Juan", "Lopez", "jlopez@gmail.com", 22222222);
	    }
	    
	    catch(Exception e) { 
	    	
	    	System.out.println(e.getMessage());
	    }
	    
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
	    
	    System.out.println("Escenarios 1");
	    sistema.agregarProducto("NAFTA SUPER", 12.0,"Litros", 6.0);
	    sistema.agregarProducto("NAFTA INFINIA", 15.0,"Litros", 3.0);
	    sistema.agregarProducto("NAFTA DIESEL", 15.5,"Litros", 3.0);
	    sistema.agregarProducto("GNC", 10.0,"Litros", 1.0);
		
		
		for(Producto p: sistema.getLstProductos()){
			System.out.println(p.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
		
	    try {
	    
		System.out.println("Escenarios 2");
		sistema.agregarProducto("NAFTA INFINIA",15.0, "Litros", 3.0);
	    }
	    
	    catch(Exception e) { 
	    	
	    	System.out.println(e.getMessage());
	    }
	    
	    System.out.println("-------------------------------------------------");
	    
       /*-----------------------------------------------------------------------*/
	   
	    System.out.println("Escenarios 1");
	    
	    sistema.agregarTarjeta(sistema.traerCliente(1));
	    sistema.agregarTarjeta(sistema.traerCliente(2));
	    sistema.agregarTarjeta(sistema.traerCliente(3));
	    sistema.agregarTarjeta(sistema.traerCliente(4));
		
		
		for(Tarjeta t: sistema.getLstTarjetas()){
			System.out.println(t.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
		
	    try {
	    
		System.out.println("Escenarios 2");
		sistema.agregarTarjeta(sistema.traerCliente(3));
	    }
	    
	    catch(Exception e) { 
	    	
	    	System.out.println(e.getMessage());
	    }
	    
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
	    
		 System.out.println("Agregar compra");
		
		sistema.agregarCompra(sistema.traerCliente(1), sistema.traerProducto("NAFTA SUPER"), LocalDate.of(2017, 10, 19), 10.0);
		sistema.agregarCompra(sistema.traerCliente(3), sistema.traerProducto("INFINIA DIESEL"), LocalDate.of(2019, 04, 19), 22.0);
		sistema.agregarCompra(sistema.traerCliente(2), sistema.traerProducto("NAFTA INFINIA"), LocalDate.of(2019, 04, 20), 25.0);
		sistema.agregarCompra(sistema.traerCliente(2), sistema.traerProducto("NAFTA INFINIA"), LocalDate.of(2019, 04, 20), 20.5);
	    
		
		for(Tarjeta t: sistema.getLstTarjetas()){
			System.out.println(t.toString());
		}
		
		System.out.println("-------------------------------------------------");
		    
		    /*-----------------------------------------------------------------------*/
	    
		    
	    
	}

}
