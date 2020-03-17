package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Agenda;
import modelo.Servicio;

public class OO1TestTema1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Agenda agenda = new Agenda(LocalDate.of(2018, 11, 30), LocalTime.of(8, 0,0),20,30);
		System.out.println("----Escenario 1---Agenda vacia pero creada");
		System.out.println(agenda);
		
		agenda.agregarLavado(LocalDate.of(2018, 11, 30), LocalTime.of(15, 30,0), "AAA000", 200, 50.0, true);
		agenda.agregarCambioAceite(LocalDate.of(2018, 11, 30), LocalTime.of(14, 30,0), "AAA111", 750, 300, true);
		agenda.agregarAlineacion(LocalDate.of(2018, 11, 30), LocalTime.of(9, 30,0), "AAA222", 500, 1200, 2);
		agenda.agregarLavado(LocalDate.of(2018, 11, 30), LocalTime.of(11, 00,0), "AAA333", 200, 50.0, false);
		agenda.agregarAlineacion(LocalDate.of(2018, 11, 30), LocalTime.of(13, 00,0), "AAA444", 800, 1500, 2);
		agenda.agregarCambioAceite(LocalDate.of(2018, 11, 30), LocalTime.of(17, 30,0), "AAA555", 1050, 450, false);
		
		System.out.println("----Escenario 2--- agenda cargada");
		for(Servicio s: agenda.getLstServicios()) {
		System.out.println(s.toString());}
		
		System.out.println("----Escenario 3--- asignar horario que ya existe");
		try {
		agenda.agregarCambioAceite(LocalDate.of(2018, 11, 30), LocalTime.of(9, 30,0), "AAA666", 1050, 450, true);}
		catch(Exception e) {System.out.println(e.getMessage());}
		
		
		System.out.println("----Escenario 4--- Servicio con pagos");
		for(Servicio s: agenda.getLstServicios()) {
		System.out.println(s.toString() +"\nTotal a pagar: "+s.calcularTotalAPagar());}
		
		System.out.println("----Escenario 5a--- Turnos Posibles");
		System.out.println(agenda.generarTurnosPosibles());
		System.out.println("----Escenario 5b--- Turnos disponibles");
		System.out.println(agenda.generarTurnos());
		
		
		

	}

}
