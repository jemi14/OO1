package test1;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo1.Cabina;
import modelo1.CategoriaVehiculo;
import modelo1.SistemaPeajes;

public class Test3Tema2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SistemaPeajes sistema = new SistemaPeajes();
		
		Cabina c1= new Cabina(1, "Cabina 1");
		Cabina c2= new Cabina(2, "Cabina 2");
		Cabina c3= new Cabina(3, "Cabina 3");
		
		CategoriaVehiculo t1= new CategoriaVehiculo(1, "Moto", 10f);
		CategoriaVehiculo t2= new CategoriaVehiculo(2, "Sedan", 15f);
		CategoriaVehiculo t3= new CategoriaVehiculo(3, "Monovolumen", 15f);
		CategoriaVehiculo t4= new CategoriaVehiculo(4, "Utilitario", 20f);
		CategoriaVehiculo t5= new CategoriaVehiculo(1, "Camioneta", 25f);
		
		sistema.agregarPeaje(LocalDate.of(2015, 9, 24), LocalTime.of(18, 30), c1 , t1);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 24), LocalTime.of(21, 10), c1 , t2);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 24), LocalTime.of(21, 11), c2 , t4);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 24), LocalTime.of(21, 14), c2 , t5);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 24), LocalTime.of(21, 11), c3 , t1);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 24), LocalTime.of(18, 30), c1 , t1);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 25), LocalTime.of(8, 30), c1 , t4);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 25), LocalTime.of(9, 10), c1 , t5);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 25), LocalTime.of(11, 11), c2 , t3);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 25), LocalTime.of(11, 14), c2 , t1);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 24), LocalTime.of(10, 11), c3 , t1);
		sistema.agregarPeaje(LocalDate.of(2015, 9, 24), LocalTime.of(10, 14), c3 , t2);
		
		System.out.println(sistema.toString());
		
	}

}
