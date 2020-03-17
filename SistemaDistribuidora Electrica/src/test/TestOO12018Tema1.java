package test;

import modelo.SistemaDistribuidora;
import modelo.Tarifa;

public class TestOO12018Tema1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaDistribuidora sistema= new SistemaDistribuidora();
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Agregar Cliente");
		
		sistema.agregarCliente(11111111, "Vranic", "Alejandra");
		sistema.agregarCliente(22222222, "Mansilla", "Romina");
		sistema.agregarCliente(33333333333l, "La Serenísima SA");
		sistema.agregarCliente(44444444444l, "Sancor SA");
		
	    try{
	    	sistema.agregarCliente(22222222, "Siciliano", "Gustavo");
	    
	    } catch (Exception e) 
	    {
	    	System.out.println(e.getMessage());
	    }
	    
	    try{
	    	sistema.agregarCliente(44444444444l, "Ilolay");
	    
	    } catch (Exception e) 
	    {
	    	System.out.println(e.getMessage());
	    }
		
		//for(Cliente c: sistema.getLstCliente()){
			//System.out.println(c.toString());
		//}
		
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
	    
	    System.out.println("Traer Clientes");
	    
	    System.out.println(sistema.getLstCliente());
		
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
	    
	    System.out.println("Agregar Tarifas");
	    
	    sistema.agregarTarifa(0, 50,300.0f,2.0f);
	    sistema.agregarTarifa(51, 100,350.0f,2.1f);
	    sistema.agregarTarifa(101, 200,(float) 450.0,(float) 2.5);
	    sistema.agregarTarifa(201, 400,(float) 1000.0, (float) 4.0);
	    sistema.agregarTarifa(401, 2000,(float) 1000.0,(float) 4.0);
	    
		for(Tarifa t: sistema.getLstTarifa()){
			System.out.println(t.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
	    
	    System.out.println("Agregar Lecturas");
	    
	    sistema.agregarLectura(11, 2018, sistema.traerClientePorDNI(11111111), 153);
	    sistema.agregarLectura(10, 2018, sistema.traerClientePorDNI(22222222), 104);
	    sistema.agregarLectura(11, 2018, sistema.traerClientePorDNI(22222222), 279);
	    sistema.agregarLectura(10, 2018, sistema.traerClientePorCuit(33333333333l), 4527);
	    sistema.agregarLectura(11, 2018, sistema.traerClientePorCuit(33333333333l), 5785);
	    sistema.agregarLectura(10, 2018, sistema.traerClientePorCuit(44444444444l), 10962);
	    sistema.agregarLectura(11, 2018, sistema.traerClientePorCuit(44444444444l), 11782);
	    
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
	    
	    System.out.println("Traer Lecturas de Medidor");
	    
		System.out.println(sistema.getLstLectura());
		
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
	    
	    System.out.println("Mostrar Total a Cobrar a Cliente");
	    
	    System.out.println(sistema.calcularConsumo(sistema.traerLectura(11, 2018,sistema.traerClientePorDNI(22222222))));
	    
       /*-----------------------------------------------------------------------*/
	    
	    System.out.println("Mostrar Total a Cobrar de todos los Cliente");
	    
	    System.out.println(sistema.calcularTotalACobrar(11, 2018));
	    
	}

}
