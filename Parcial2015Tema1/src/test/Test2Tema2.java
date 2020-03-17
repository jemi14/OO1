package test;

import java.time.LocalDate;

import modelo.AdmPersona;

public class Test2Tema2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdmPersona admPersona= new AdmPersona();
		
		try {
			admPersona.agregarPersona(12345678, "Pardo", "Juan", LocalDate.of(2015, 04, 12));
			admPersona.agregarPersona(91011121, "Simpson", "Lisa", LocalDate.of(1990, 01, 30));
			admPersona.agregarPersona(31415161, "Flander", "Leno", LocalDate.of(2003, 8, 23));
			admPersona.agregarPersona(41516171, "Lezcano", "Camila", LocalDate.of(2003, 01, 12));
		}catch(Exception e) {
			System.out.println("Exception :"+e.getMessage());
		}

		System.out.println(admPersona.traerPersona());
		
		System.out.println("----------------------------");
		
		System.out.println(admPersona.traerMayores(14, LocalDate.of(2020, 01, 23)));
		
		
	}

}
