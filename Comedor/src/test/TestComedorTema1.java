package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Beneficio;
import modelo.Carrera;
import modelo.Comedor;
import modelo.Estudiante;
import modelo.TipoBeneficio;

public class TestComedorTema1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Comedor sistema = new Comedor();
		
		//--------------------------------------------------------//
		System.out.println("Agregar imprimir las siguientes carreras");
		
		sistema.agregarCarrera("Lic. Alimentos");
		sistema.agregarCarrera("Lic. Sistemas");
		
		for(Carrera c: sistema.getLstCarreras()) {
			System.out.println(c.toString());
		}
		
		System.out.println("----------------------------------------");
		
		//--------------------------------------------------------//
		System.out.println("Agregar imprimir todos los estudiantes");
		
		try {
		sistema.agregarEstudiante(403215487, "Pablo", "Perez", sistema.traerCarrera(1), true);
		}
		catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
		
		sistema.agregarEstudiante(37654812, "Laura", "Diaz", sistema.traerCarrera(1), true);
		sistema.agregarEstudiante(34587624, "Daiana", "Grusepe", sistema.traerCarrera(2), true);
		sistema.agregarEstudiante(42654875, "Juan", "Cuda", sistema.traerCarrera(2), true);
		
		for(Estudiante e: sistema.getLstEstudiantes()) {
			System.out.println(e.toStringSinLegajo());
		}
		
		System.out.println("----------------------------------------");
		
		//--------------------------------------------------------//
		System.out.println("Traer Estudiante 34587624 y modificar su condicion a NoRegular y imprimir todos los estudiantes");
		
		sistema.traerEstudiante(34587624).setRegular(false);
		
		System.out.println(sistema.traerEstudiantes());
		
		System.out.println("----------------------------------------");
		
		//--------------------------------------------------------//
		System.out.println("Agregar los tipos de beneficios e imprimirlos");
		
		LocalTime horaDesde1= LocalTime.of(06, 30);
		LocalTime horaHasta1= LocalTime.of(11, 48);
		LocalTime horaDesde2= LocalTime.of(11, 45);
		LocalTime horaHasta2= LocalTime.of(13, 15);
		LocalTime horaDesde3= LocalTime.of(16, 00);
		LocalTime horaHasta3= LocalTime.of(18, 30);
		
		sistema.agregarTipoBeneficio("Desayuno", horaDesde1 , horaHasta1, 200);
		sistema.agregarTipoBeneficio("Almuerzo", horaDesde2 , horaHasta2, 150);
		sistema.agregarTipoBeneficio("Merienda", horaDesde3 , horaHasta3, 300);
		
		for(TipoBeneficio t: sistema.getBeneficiosDisponibles()) {
			System.out.println(t.toString());
		}
		
		System.out.println("----------------------------------------");
		
		//--------------------------------------------------------//
		System.out.println("Agregar los siguientes beneficios e imprimirlos");
		
		LocalDate fecha1= LocalDate.of(2018, 5, 14);
		LocalDate fecha2= LocalDate.of(2018, 5, 15);
		LocalDate fecha3= LocalDate.of(2018, 5, 16);
		LocalDate fecha4= LocalDate.of(2018, 6, 1);
		
		LocalTime hora1= LocalTime.of(16, 35);
		LocalTime hora2= LocalTime.of(10, 30);
		LocalTime hora3= LocalTime.of(11, 10);
		LocalTime hora4= LocalTime.of(13, 00);
		LocalTime hora5= LocalTime.of(17, 30);
		
		sistema.agregarBeneficio(sistema.traerTipoBeneficio(3), sistema.traerEstudiante(42654875), fecha1, hora1);
		
		try {
		sistema.agregarBeneficio(sistema.traerTipoBeneficio(1), sistema.traerEstudiante(403215487), fecha2, hora2);
		} catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
			
		sistema.agregarBeneficio(sistema.traerTipoBeneficio(1), sistema.traerEstudiante(37654812), fecha3, hora3);
		
		try {
		sistema.agregarBeneficio(sistema.traerTipoBeneficio(2), sistema.traerEstudiante(403215487), fecha2, hora4);
		} catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
		
		sistema.agregarBeneficio(sistema.traerTipoBeneficio(3), sistema.traerEstudiante(42654875), fecha4, hora5);
		
		for(Beneficio b: sistema.getBeneficiosOtorgados()) {
			System.out.println(b.toString());
		}
		
        System.out.println("----------------------------------------");
		
		//--------------------------------------------------------//
        System.out.println("Imprimir los beneficios del estudiante 403215487 de dia 15/05/2018 ");
        
        try {
        System.out.println(sistema.traerBeneficios(sistema.traerEstudiante(403215487), fecha2));
        } catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
        
        System.out.println("----------------------------------------");
		
      	//--------------------------------------------------------//
        System.out.println("Escenario 1: Agregar un beneficio ");
        
		LocalTime hora6= LocalTime.of(17, 15);
        
		try {
        System.out.println(sistema.agregarBeneficio(sistema.traerTipoBeneficio(3),sistema.traerEstudiante(34587624), fecha3, hora6));
		 } catch (Exception e) {
				System.out.println("Exception: "+ e.getMessage());
			}
		
		System.out.println("----------------------------------------");
       
      	//--------------------------------------------------------//
        System.out.println("Escenario 2: Agregar un beneficio ");
        
        LocalTime hora7= LocalTime.of(17, 25);
        
        try {
            System.out.println(sistema.agregarBeneficio(sistema.traerTipoBeneficio(3),sistema.traerEstudiante(403215487), fecha3, hora7));
    		 } catch (Exception e) {
    				System.out.println("Exception: "+ e.getMessage());
    			}
        
        System.out.println("----------------------------------------");
        
    	//--------------------------------------------------------//
        System.out.println("Escenario 3: Agregar un beneficio NO SE ENTIENDE ");
        
        LocalTime hora8= LocalTime.of(11, 00);
        
        sistema.traerTipoBeneficio(1).setMaxDiario(2);
        
        try {
            System.out.println(sistema.agregarBeneficio(sistema.traerTipoBeneficio(1),sistema.traerEstudiante(42654875), fecha3, hora8));
    		 } catch (Exception e) {
    				System.out.println("Exception: "+ e.getMessage());
    			}
        
        System.out.println("----------------------------------------");
        
      //--------------------------------------------------------//
        System.out.println("Imprimir todas las meriendas otorgadas el 01/06/2018 ");
        
       // LocalDate fecha5= LocalDate.of(2018, 6, 1);
        
        try {
        System.out.println(sistema.traerBeneficios(sistema.traerTipoBeneficio(3), fecha4));
        } catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
		}
        
        System.out.println("----------------------------------------");
        
       //--------------------------------------------------------//
        System.out.println("Imprimir los beneficios otorgados entre 15/05/2018 y 30/05/2018");
        
        LocalDate fecha6= LocalDate.of(2018, 5, 30);
        
        System.out.println(sistema.traerBeneficios(fecha2, fecha6));
        
	}

}
