package test;

import java.time.LocalDate;

import modelo.AdmPersona;
import modelo.Persona;

public class Test1Tema2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		AdmPersona admPersona= new AdmPersona();
		
		
		try {
			admPersona.agregarPersona(12345678, "Pardo", "Juan", LocalDate.of(2015, 04, 12));
			admPersona.agregarPersona(91011121, "Simpson", "Lisa", LocalDate.of(1990, 01, 30));
			admPersona.agregarPersona(31415161, "Flander", "Leno", LocalDate.of(1998, 8, 23));
			admPersona.agregarPersona(41516171, "Lezcano", "Camila", LocalDate.of(1998, 01, 12));
		}catch(Exception e) {
			System.out.println("Exception :"+e.getMessage());
		}
		
		for(Persona p: admPersona.getLstPersona()) {
			System.out.println(p.toString());
		}
		
		

	}

}
