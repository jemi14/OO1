package test;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.Empleado;
import modelo.SistemaCallCenter;

public class TestOO1Tema2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SistemaCallCenter sistema= new SistemaCallCenter();
		
		//---------------------------------------------------//
		
		System.out.println("1 Agregar los siguientes objetos a la lista personas e imprimir la lista");
		
		try {
			sistema.agregarCliente("Luis", "Perez", 11111111, true);
			sistema.agregarCliente("Lucas", "Pereyra", 22222222, true);
			sistema.agregarEmpleado("Pedro", "Lopez", 33333333, 10000);
			sistema.agregarEmpleado("Pablo", "Gomes", 44444444, 9000);
		} 
		catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		
		System.out.println(sistema.traerPersona());
		
		System.out.println("-----------------------------");
		
		//---------------------------------------------------//
		
		System.out.println("2 Traer e Imprimir el cliente con el dni 11111111");
		
		System.out.println(sistema.traerPersona(11111111));
		
        System.out.println("-----------------------------");
		
		//---------------------------------------------------//
		
        System.out.println("3 Traer e Imprimir el empleado con el dni 33333333");
		
		System.out.println(sistema.traerPersona(33333333));
		
        System.out.println("-----------------------------");
		
		//---------------------------------------------------//
        
        System.out.println("4 Tratar de agregar el siguiente Cliente");
		
		try {
			sistema.agregarCliente("Marcos", "Rios", 22222222, true);
		} catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
		}
		
		//System.out.println(sistema.traerPersona());
		
        System.out.println("-----------------------------");
		
		//---------------------------------------------------//
        
        System.out.println("5 Tratar de agregar el siguiente Empleado");
        
        try {
        	sistema.agregarEmpleado("Miguel", "Martinez", 44444444, 9500);
        } catch (Exception e) {
        	System.out.println("Exception " + e.getMessage());
        }
        
        System.out.println("-----------------------------");
		
   		//---------------------------------------------------//
        
       System.out.println("6 Agregar los siguientes objetos a la lista llamadas e imprimir la lista");
        
        try {
        	sistema.agregarLlamada(LocalDate.of(2018, 02, 19), (Cliente)sistema.traerPersona(11111111), (Empleado) sistema.traerPersona(33333333), 5);
        	sistema.agregarLlamada(LocalDate.of(2018, 02, 19), (Cliente)sistema.traerPersona(11111111), (Empleado) sistema.traerPersona(44444444), 5);
        	sistema.agregarLlamada(LocalDate.of(2018, 02, 19), (Cliente)sistema.traerPersona(22222222), (Empleado) sistema.traerPersona(33333333), 5);
        	sistema.agregarLlamada(LocalDate.of(2018, 02, 20), (Cliente)sistema.traerPersona(11111111), (Empleado) sistema.traerPersona(33333333), 4);
        	sistema.agregarLlamada(LocalDate.of(2018, 02, 20), (Cliente)sistema.traerPersona(11111111), (Empleado) sistema.traerPersona(33333333), 3);
        	sistema.agregarLlamada(LocalDate.of(2018, 02, 20), (Cliente)sistema.traerPersona(11111111), (Empleado) sistema.traerPersona(33333333), 2);
        	sistema.agregarLlamada(LocalDate.of(2018, 02, 21), (Cliente)sistema.traerPersona(11111111), (Empleado) sistema.traerPersona(33333333), 5);
            
        } catch (Exception e) {
        	System.out.println("Exception " + e.getMessage());
        }
        
        System.out.println(sistema.getLstLlamadas());
        
        System.out.println("-----------------------------");
		
   		//---------------------------------------------------//
        
        System.out.println("7 Traer todos los clientes e imprimir la lista");
        
        System.out.println(sistema.traerCliente());
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("8 Traer todos los empleados e imprimir la lista");
        
        System.out.println(sistema.traerEmpleado());
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("9 Traer e imprimir las llamadas entre 19/02/2018 al 21/02/2018");
        
        System.out.println(sistema.traerLlamada(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21)));
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("10 Traer e imprimir las llamadas con nivel de satisfaccion 5 entre el 19/02/2018 al 21/02/2018");
        
        System.out.println(sistema.traerLlamada(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21), 5));
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("11 Calcular el porcentaje de nivel de satisfaccion de llamadas con nivel 5 entre el 19/02/2018 al 21/02/2018");
        
        System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21), 5));
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("12 Calcular el porcentaje de nivel de satisfaccion de llamadas con nivel 4 entre el 19/02/2018 al 21/02/2018");
        
        System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21), 4));
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("13 Calcular el porcentaje de nivel de satisfaccion de llamadas con nivel 3 entre el 19/02/2018 al 21/02/2018");
        
        System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21), 3));
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("14 Calcular el porcentaje de nivel de satisfaccion de llamadas con nivel 2 entre el 19/02/2018 al 21/02/2018");
        
        System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21), 2));
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("15 Calcular el porcentaje de nivel de satisfaccion de llamadas con nivel 1 entre el 19/02/2018 al 21/02/2018");
        
        System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21), 1));
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("16 Traer e imprimir las llamadas entre 19/02/2018 al 21/02/2018 del empleado con el dni 33333333");
        
        System.out.println(sistema.traerLlamada(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21), (Empleado)sistema.traerPersona(33333333)));
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("17 Traer e imprimir las llamadas con nivel de satisfaccion 5 entre 19/02/2018 al 21/02/2018 del empleado con dni 33333333");
        
        System.out.println(sistema.traerLlamada(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21), 5));
        
        System.out.println("-----------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("18 Calcular el porcentaje de nivel de satisfaccion 5 entre 19/02/2018 al 21/02/2018 del empleado con dni 33333333");
        
        System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 02, 19), LocalDate.of(2018, 02, 21), (Empleado) sistema.traerPersona(33333333), 5));
        
        System.out.println("-----------------------------");
        
        
        
	}

}
