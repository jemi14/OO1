package test;

import java.time.LocalDate;

import modelo.Contrato;
import modelo.Locador;
import modelo.Locatorio;
import modelo.Propiedad;
import modelo.SistemaInmobiliaria;

public class TestContrato {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaInmobiliaria sistema= new SistemaInmobiliaria();
		
		LocalDate fechaInicio1= LocalDate.of(2019, 05, 28);
		LocalDate fechaInicio2= LocalDate.of(2019, 04, 19);
		LocalDate fechaInicio3= LocalDate.of(2019, 03, 27);
		
		Locatorio locatorio1= new Locatorio (4, 4444444, "Pablo", "Perez", "1234567812", true);
		Locatorio locatorio2= new Locatorio (5, 5555555, "Homero", "Simpson", "1234567813", true);
		Locatorio locatorio3= new Locatorio (6, 6666666, "Lissa", "Simpson", "1234567814", true);
		
		Locador locador1 = new Locador(1, 1111111, "Nicolas", "Perez", "1234567890",1,"Frances", 20,"Animal");
		Locador locador2= new Locador(2, 2222222, "Romina", "Mansilla", "1234567810",2,"Santander Rio",19,"Pescado");
		Locador locador3= new Locador(3, 3333333, "Alejandra", "Vranic", "1234567811",3,"Patagonia",18,"Gato");
		
		Propiedad propiedad1= new Propiedad (1, 1010, "Uno", 2340, 1, "UF", "Lanús", "Buenos Aires",locador1);
		Propiedad propiedad2= new Propiedad (2, 9090, "Dos", 2341, 2, "UF1", "Lanús", "Buenos Aires",locador2);
		Propiedad propiedad3= new Propiedad (3, 8080, "Tres", 2342, 3, "UF2", "Lanús", "Buenos Aires",locador3);

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Agregar Contrato con id");
		
		sistema.agregarContrato(1, locatorio1, propiedad1, 789, fechaInicio1, 1, 6, 7500, 10);
		sistema.agregarContrato(2, locatorio2, propiedad2, 345, fechaInicio2, 2, 8, 8500, 11);
		
		for(Contrato c: sistema.getLstContratos()){
			System.out.println(c.toString());
		}
		
	    System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
	    
		System.out.println("Agregar Contrato con comision");
		
		sistema.agregarContrato(locatorio3, propiedad3, 327, fechaInicio3, 3, 10, 1000, 12);

		for(Contrato c: sistema.getLstContratos()){
			System.out.println(c.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
	    
		System.out.println("Traer contrato por id");
		 
		System.out.println(sistema.traerContratoPorId(1));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer contrato por comision");
		 
		System.out.println(sistema.traerContratoPorComision(327));
		
		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Modificar contrato por id");
		 
		System.out.println(sistema.modificarContratoPorId(2, locatorio2, propiedad2, 345, fechaInicio2, 2, 8, 9050, 9));
		
		for(Contrato c: sistema.getLstContratos()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Modificar Propiedad por comision");
		 
		System.out.println(sistema.modificarContratoPorComision(locatorio2, propiedad2, 345, fechaInicio2, 2, 10, 9050, 9));
		
		for(Contrato c: sistema.getLstContratos()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");

		/*-----------------------------------------------------------------------*/
		
		System.out.println("Es contrato vigente?");

		LocalDate probarFecha= LocalDate.of(2019, 05, 31);
		
		System.out.println(sistema.traerContratoPorId(1).esContratoVigente(probarFecha));
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Calcular mora");
		
		System.out.println(sistema.traerContratoPorId(1).calcularMora(20));
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Calcular Monto Pago a Recibir");
		
		System.out.println(sistema.traerContratoPorId(1).calcularMontoPagoARecibir());
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Calcular Monto Pago a Recibir por fecha");
		
		LocalDate probarFecha1= LocalDate.of(2019, 5, 30);
		
		System.out.println(sistema.traerContratoPorId(1).calcularMontoPagoARecibir(probarFecha1));
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Calcular comision");
		
		System.out.println(sistema.traerContratoPorId(1).calcularComision());
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Calcular Monto Pago a Recibir que debe pagar la inmobiliaria a Locador");
		
		System.out.println(sistema.traerContratoPorId(1).calcularMontoPagoARecibirInmobiliariaAlLocador());
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer contratos vigentes con fechas");
		
		LocalDate probarFecha2= LocalDate.of(2019, 3, 30);
		LocalDate probarFecha3= LocalDate.of(2019, 4, 21);
		
		System.out.println(sistema.traerContratosVigentes(probarFecha2, probarFecha3));
	
		System.out.println("-------------------------------------------------");
		
	}

}
