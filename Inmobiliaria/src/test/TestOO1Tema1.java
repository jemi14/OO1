package test;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.Contrato;
import modelo.Locador;
import modelo.Locatorio;
import modelo.Propiedad;
import modelo.SistemaInmobiliaria;

public class TestOO1Tema1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaInmobiliaria sistema= new SistemaInmobiliaria();
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Agregar Locador");
		
		sistema.agregarLocador(11111111, "Romina", "Mansilla", "1511111111", "pez-animal-mesa", "Santander Rio", 20, 3);
		sistema.agregarLocador(22222222, "Alejandra", "Vranic", "22222222", "monitor-mate-botella", "Santander Rio", 10, 5);
		sistema.agregarLocador(33333333, "Pablo", "Perez", "3333333", "teclado-perro-vaso", "Galicia", 10, 7);

		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
		/*-----------------------------------------------------------------------*/
	    
		System.out.println("Agregar Locatorio ");
		
		sistema.agregarLocatorio(44444444, "Leandro", "Rios", "1544444444", false);
		sistema.agregarLocatorio(55555555, "Gustavo", "Siciliano", "1544444444", false);
		sistema.agregarLocatorio(66666666, "Diego", "Ramos", "1566666666", false);
		sistema.agregarLocatorio(77777777, "Dario", "Salvatore", "157777777", true);
	
		for(Cliente c: sistema.getLstClientes()){
			System.out.println(c.toString());
		}

		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Agregar Propiedad");
		
		sistema.agregarPropiedad(12121212, "29 de Septiembre", 1500, 0, null, "Lanus", "Buenos Aires", (Locador) sistema.traerClientePordni(11111111));
		sistema.agregarPropiedad(34343434, "Hipolito Yrigoyen", 8200, 4, "A", "Lomas de Zamora", "Buenos Aires", (Locador) sistema.traerClientePordni(22222222));
		sistema.agregarPropiedad(56565656, "Hipolito Yrigoyen", 8200, 4, "B", "Lomas de Zamora", "Buenos Aires", (Locador) sistema.traerClientePordni(33333333));
		sistema.agregarPropiedad(78787878, "Almirante Brown", 7000, 1, "A", "Temperley", "Buenos Aires", (Locador) sistema.traerClientePordni(33333333));

		for(Propiedad p: sistema.getLstPropiedades()){
			System.out.println(p.toString());
		}
		
	    System.out.println("-------------------------------------------------");
	    
	    /*-----------------------------------------------------------------------*/
	    
	    LocalDate fechaInicio1= LocalDate.of(2018, 04, 1);
		LocalDate fechaInicio2= LocalDate.of(2018, 02, 1);
		LocalDate fechaInicio3= LocalDate.of(2018, 07, 1);
	    
		System.out.println("Agregar Contrato con comision");
		
		sistema.agregarContrato((Locatorio) sistema.traerClientePordni(44444444), sistema.traerPropiedad(12121212), 3.5, fechaInicio1, 7, 12, 15000, (int) 1.0);
		sistema.agregarContrato((Locatorio) sistema.traerClientePordni(55555555), sistema.traerPropiedad(78787878), 2.0, fechaInicio2, 2, 12, 10000, (int) 1.0);
		sistema.agregarContrato((Locatorio) sistema.traerClientePordni(66666666), sistema.traerPropiedad(56565656), 2.5, fechaInicio3, 9, 12, 13000, (int) 1.0);
		
		
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
		
		LocalDate probarFecha1= LocalDate.of(2018, 8, 10);
		
		System.out.println("Contrato 1 :"+sistema.traerContratoPorId(1).calcularMontoPagoARecibir(probarFecha1)+" monto a pagar");
		System.out.println("Contrato 2 :"+sistema.traerContratoPorId(2).calcularMontoPagoARecibir(probarFecha1)+" monto a pagar");
		System.out.println("Contrato 3 :"+sistema.traerContratoPorId(3).calcularMontoPagoARecibir(probarFecha1)+" monto a pagar");
		
		System.out.println("-------------------------------------------------");
	    
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Calcular comision");
		
		System.out.println(sistema.traerContratoPorId(1).calcularComision());
		
		System.out.println("-------------------------------------------------");
	    
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Calcular Monto Pago a Realizar");
		
		System.out.println(sistema.traerContratoPorId(1).calcularMontoPagoARealizar());
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Traer contratos vigentes con fechas");
		
		LocalDate probarFecha2= LocalDate.of(2018, 04, 2);
		LocalDate probarFecha3= LocalDate.of(2018, 07, 2);
		
		System.out.println(sistema.traerContratosVigentes(probarFecha2, probarFecha3));
	
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Imprimir ingresos");
		
		//LocalDate probarFecha4= LocalDate.of(2018, 07, 2);
		//LocalDate probarFecha5= LocalDate.of(2018, 07, 9);
		
		sistema.imprimirIngresos(probarFecha2, probarFecha3);
		
		System.out.println("-------------------------------------------------");
		
		/*-----------------------------------------------------------------------*/
		
		System.out.println("Imprimir egresos");
		
		//LocalDate probarFecha6= LocalDate.of(2018, 07, 3);
		//LocalDate probarFecha7= LocalDate.of(2018, 07, 7);
		
		sistema.imprimirEgresos(probarFecha2, probarFecha3);
	    

	}

}
