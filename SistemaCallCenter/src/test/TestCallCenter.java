package test;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.Empleado;
import modelo.SistemaCallCenter;

public class TestCallCenter {

	public static void main(String[] args) {
	
		SistemaCallCenter s=new SistemaCallCenter();
		LocalDate f1=LocalDate.of(2018,2, 19);
		LocalDate f2=LocalDate.of(2018,2, 20);
		LocalDate f3=LocalDate.of(2018,2, 21);
		
		
		//1
		System.out.println("AGREGAR");
		try {
			s.agregarCliente("N1","apellido1", 111L, true);
			s.agregarCliente("N2","apellido2", 222L, true);
			s.agregarEmpleado("N3","apellido3", 333L, 10000);
			s.agregarEmpleado("N4","apellido4", 444L, 20000);
		
			
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}

		System.out.println("Personas "+s.getLstPersonas());
	
		//2- TRAER E IMPRIMIR CLIENTE
		System.out.println("Cliente: "+s.traerPersona(111));
		
		//3- TRAER E IMPRIMIR EMPLEADO
		System.out.println("Cliente: "+s.traerPersona(333));
		
		//4- TRATAR DE AGREGAR CLIENTE DNI=222
		try {		
			s.agregarCliente("N2","apellido2", 222L, true);
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		//5-TRATAR DE AGREGAR EMPLEADO DNI=444
		try {
			s.agregarEmpleado("N4","apellido4", 444L, 20000);	
		}catch(Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		
		//6-AGREGAR E IMPRIMIR
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(333), f1, 5);
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(333), f1, 5);
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(333), f1, 5);
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(333), f1, 5);
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(444), f1, 5);
		s.agregarLlamada((Cliente)s.traerPersona(222), (Empleado)s.traerPersona(333), f1, 5);
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(333), f2, 4);
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(333), f2, 3);
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(333), f2, 3);
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(333), f2, 2);
		s.agregarLlamada((Cliente)s.traerPersona(111), (Empleado)s.traerPersona(333), f3, 5);
		
		System.out.println("\nLlamadas: "+s.getLstLlamadas());
		
		//7-TRAER TODOS LOS CLIENTES E IMPRIMIR
		System.out.println("\nClientes: \n"+s.traerClientes());
		
		
		//8- TRAER TODOS LOS EMPLEADOS E IMPRIMIR
		System.out.println("\nEmpleados: \n"+s.traerEmpleados());
		
		//9- IMPRIMIR LLAMADAS ENTRE EL 19/02 Y EL 21/02
		System.out.println("\nLlamadas entre el 19/02 y el 21/02: \n"+s.traerLlamada(f1, f3));
		
		//10- IMPRIMIR LLAMADAS NIVEL=5 ENTRE EL 19/02 Y EL 21/02
		System.out.println("\nLlamadas nivel=5, entre el 19/02 y el 21/02: \n"+s.traerLlamada(f1, f3, 5));
		
		//11-CALCULAR PORCENTAJE LLAMADAS NIVEL 5 ENTRE EL 19/02 Y EL 21/02
		System.out.println("\nPORCENTAJE Llamadas N5, entre el 19/02 y el 21/02: "+s.calcularPorcentajeNivel(f1, f3, 5));
		
		//12-CALCULAR PORCENTAJE LLAMADAS NIVEL 4 ENTRE EL 19/02 Y EL 21/02
		System.out.println("\nPORCENTAJE Llamadas N4, entre el 19/02 y el 21/02: "+s.calcularPorcentajeNivel(f1, f3, 4));

		//13-CALCULAR PORCENTAJE LLAMADAS NIVEL 3 ENTRE EL 19/02 Y EL 21/02
		System.out.println("\nPORCENTAJE Llamadas N3, entre el 19/02 y el 21/02: "+s.calcularPorcentajeNivel(f1, f3, 3));

		//14-CALCULAR PORCENTAJE LLAMADAS NIVEL 2 ENTRE EL 19/02 Y EL 21/02
		System.out.println("\nPORCENTAJE Llamadas N2, entre el 19/02 y el 21/02: "+s.calcularPorcentajeNivel(f1, f3, 2));

		//15-CALCULAR PORCENTAJE LLAMADAS NIVEL 1 ENTRE EL 19/02 Y EL 21/02
		System.out.println("\nPORCENTAJE Llamadas N1, entre el 19/02 y el 21/02: "+s.calcularPorcentajeNivel(f1, f3, 1));

		//16- IMPRIMIR LLAMADAS ENTRE EL 19/02 Y EL 21/02 DEL EMPLEAADO CON DNI=333
		System.out.println("\nLlamadas entre el 19/02 y el 21/02, empleado dni=333: \n"+s.traerLlamada(f1, f3, (Empleado)s.traerPersona(333)));
		
		//17- IMPRIMIR LLAMADAS CON NIVEL=5, ENTRE EL 19/02 Y EL 21/02 DEL EMPLEAADO CON DNI=333
		System.out.println("\nLlamadas nivel=5, entre el 19/02 y el 21/02, empleado dni=333: \n"+s.traerLlamada(f1, f3, (Empleado)s.traerPersona(333), 5));

		//18- CALCULAR PORCENTAJE DE LLAMADAS CON NIVEL=5, ENTRE EL 19/02 Y EL 21/02 DEL EMPLEAADO CON DNI=333
		System.out.println("\nPORCENTAJE Llamadas nivel=5, entre el 19/02 y el 21/02, empleado dni=333: "+s.calcularPorcentaje(f1, f3, (Empleado)s.traerPersona(333), 5));

		
	}

}
