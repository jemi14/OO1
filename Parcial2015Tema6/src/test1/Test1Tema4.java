package test1;

import java.time.LocalDate;

import modelo1.Empleado;
import modelo1.RecursosHumanos;

public class Test1Tema4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RecursosHumanos recursos= new RecursosHumanos();
		
		Empleado e1= new Empleado(1, "Lopez", "Luis", 11111111);
		Empleado e2= new Empleado(2, "Rodriguez", "Maria", 22222222);
		Empleado e3= new Empleado(3, "Perez", "Juan", 33333333);
		
		LocalDate fInicio1= LocalDate.of(2015, 02, 01);
		LocalDate fFin1= LocalDate.of(2015, 02, 11);
		
		LocalDate fInicio2= LocalDate.of(2015, 10, 26);
		
		LocalDate fInicio3= LocalDate.of(2015, 04, 03);
		LocalDate fFin3= LocalDate.of(2015, 04, 14);
		
		LocalDate fInicio4= LocalDate.of(2015, 10, 27);
		
		
		System.out.println("Agregar Lista de Licencias");
		
		recursos.agregarLicencia("Gripe", fInicio1, fFin1, true, e1);
		recursos.agregarLicencia("Esguince tobillo izquierdo", fInicio2, LocalDate.now(), false, e2);
		recursos.agregarLicencia("Dolor lumbar por esfuerzo", fInicio3, fFin3, true, e3);
		recursos.agregarLicencia("Bronquitis", fInicio4, LocalDate.now(), false, e1);
		
		System.out.println(recursos.toString());
		

	}

}
