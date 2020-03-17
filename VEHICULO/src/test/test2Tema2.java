package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Posicion;
import modelo.Recorrido;
import modelo.Vehiculo;

public class test2Tema2 {

	public static void main(String[] args) {
		
		try{
			
			GregorianCalendar f1 = new GregorianCalendar(05,03,2016,0,43,00);
			
			//Creo recorrido 1
			Posicion p3 = new Posicion(3, -0.6037360918023941d, -1.018827398738355d, 200, new GregorianCalendar(04,03,2016,06,00,00));
	     	Posicion p4 = new Posicion(4, -0.607013471071789d, -1.0150271188250626d, 189, new GregorianCalendar(04,03,2016,06,30,00));
	     	Posicion p5 = new Posicion(5, -0.6126519317532819d, -1.0134622566177245d, 179, new GregorianCalendar(04,03,2016,07,00,00));
	     	Posicion p6 = new Posicion(6, -0.621321156680863d, -1.0118181564623459d, 168, new GregorianCalendar(04,03,2016,07,30,00));
	     	Posicion p7 = new Posicion(7, -0.6286569500599204d, -1.0094455558771849d, 158, new GregorianCalendar(04,03,2016,8,01,00));
	     	Posicion p8 = new Posicion(8, -0.6363466962112821d, -1.0074885181869235d, 147, new GregorianCalendar(04,03,2016,8,31,00));
	     	Posicion p9 = new Posicion(9, -0.6418797390059546d, -1.0089175937784565d, 136, new GregorianCalendar(04,03,2016,9,02,00));
	     	Posicion p10 = new Posicion(10, -0.6503709403498321d, -1.0084852757227376d, 126, new GregorianCalendar(04,03,2016,9,32,00));
	     	Posicion p11= new Posicion(11, -0.6588569057059539d, -1.00608527346832d, 115, new GregorianCalendar(04,03,2016,10,02,00));
	     	Posicion p12 = new Posicion(12, -0.663320236202079d, -1.0043055612300615d, 104, new GregorianCalendar(04,03,2016,10,32,00));
	     	
	     	
			ArrayList<Posicion> lstPosiciones = new ArrayList<Posicion>();
			
			lstPosiciones.add(p3);
			lstPosiciones.add(p4);
			lstPosiciones.add(p5);
			lstPosiciones.add(p6);
			lstPosiciones.add(p7);
			lstPosiciones.add(p8);
			lstPosiciones.add(p9);
			lstPosiciones.add(p10);
			lstPosiciones.add(p11);
			lstPosiciones.add(p12);
			
	     	Recorrido r1 = new Recorrido(1, "designacion=Buenos Aires - Mar del Plata", "chofer=Ernesto Busdriver", lstPosiciones);
	     	
	     	//recorrido 1 creado.... vamos con el 2
	     	
	     	/////////////////////////////////////////////////////////////////////
	     	Posicion p23 = new Posicion(13, -0.663320236202079d, -1.0043055612300615d, 200, new GregorianCalendar(04,03,2016,12,00,00));
	     	Posicion p24 = new Posicion(14, -0.6644374214562805d,-1.0094511409307911d, 187, new GregorianCalendar(04,03,2016,12,34,00));
	     	Posicion p25 = new Posicion(15, -0.6683623178781652d, -1.016393537096449d, 175, new GregorianCalendar(04,03,2016,13,8,00));
	     	Posicion p26 = new Posicion(16, -0.6724730918653876d, -1.0286214883688465d, 163, new GregorianCalendar(04,03,2016,13,43,00));
	     	Posicion p27 = new Posicion(17, -0.6715007689391015d, -1.045850855145759d, 151, new GregorianCalendar(04,03,2016,14,17,00));
	     	Posicion p28 = new Posicion(18, -0.6706110000864349d, -1.053543393823924d, 139, new GregorianCalendar(04,03,2016,14,52,00));
	     	Posicion p29 = new Posicion(19, -0.6738939644094362d, -1.0603622206785406d, 127, new GregorianCalendar(04,03,2016,15,26,00));
	     	Posicion p210 = new Posicion(210, -0.6758606014105834d, -1.0688963571220174d, 115, new GregorianCalendar(04,03,2016,16,1,00));
	     	Posicion p211= new Posicion(21, -0.6767912109677466d, -1.0800961349320648d, 103, new GregorianCalendar(04,03,2016,16,35,00));
	     	Posicion p212 = new Posicion(22, -0.6757621648407709d, -1.0867528206991712d, 91, new GregorianCalendar(04,03,2016,17,9,00));
	     	
	     	
			ArrayList<Posicion> lstPosiciones2 = new ArrayList<Posicion>();
			
			lstPosiciones.add(p23);
			lstPosiciones.add(p24);
			lstPosiciones.add(p25);
			lstPosiciones.add(p26);
			lstPosiciones.add(p27);
			lstPosiciones.add(p28);
			lstPosiciones.add(p29);
			lstPosiciones.add(p210);
			lstPosiciones.add(p211);
			lstPosiciones.add(p212);
			
	     	Recorrido r2 = new Recorrido(2, "designacion=Mar del Plata - Bahia Blanca", "chofer=José Moyano", lstPosiciones2);
	     	
	    	//recorrido 2 creado.... vamos con el 3
	     	
			/////////////////////////////////////////////////////////////////////
			Posicion p33 = new Posicion(23, -0.6757621648407709d, -1.0867528206991712d, 200, new GregorianCalendar(04,03,2016,20,00,00));
			Posicion p34 = new Posicion(24, -0.6729148346990673d, -1.0803053999093788d, 183, new GregorianCalendar(04,03,2016,20,47,00));
			Posicion p35 = new Posicion(25, -0.6651427090070114d, -1.0726959389036088d, 167, new GregorianCalendar(04,03,2016,21,34,00));
			Posicion p36 = new Posicion(26, -0.6523955222821457d, -1.0644051013578602d, 150, new GregorianCalendar(04,03,2016,22,21,00));
			Posicion p37 = new Posicion(27, -0.643610232959307d, -1.0496623051662641d, 134, new GregorianCalendar(04,03,2016,23,8,00));
			Posicion p38 = new Posicion(28, -0.6357091274355287d, -1.0389475543553457d, 117, new GregorianCalendar(04,03,2016,23,55,00));
			Posicion p39 = new Posicion(29, -0.6246465325046878d, -1.0286371963321144d, 101, f1);
			Posicion p310 = new Posicion(30, -0.6159963316659535d, -1.0258444949959984d, 84, new GregorianCalendar(05,03,2016,1,30,00));
			Posicion p311= new Posicion(31, -0.6082442772602954d, -1.0217752598449736d, 68, new GregorianCalendar(05,03,2016,2,17,00));
			Posicion p312 = new Posicion(32, -0.6039472766418854d, -1.0189563785700775d, 51, new GregorianCalendar(05,03,2016,3,4,00));
			
			
			ArrayList<Posicion> lstPosiciones3 = new ArrayList<Posicion>();
			
			lstPosiciones.add(p33);
			lstPosiciones.add(p34);
			lstPosiciones.add(p35);
			lstPosiciones.add(p36);
			lstPosiciones.add(p37);
			lstPosiciones.add(p38);
			lstPosiciones.add(p39);
			lstPosiciones.add(p310);
			lstPosiciones.add(p311);
			lstPosiciones.add(p312);
			
			Recorrido r3 = new Recorrido(3, "Bahia Blanca - Buenos Aires", "Otto Mann", lstPosiciones3);
	     	
			
			//////////////Una vez creado los recorridos los enlisto y pongo en el vehiculo
			
			ArrayList<Recorrido> lstRecorridos = new ArrayList<Recorrido>();
			
			lstRecorridos.add(r1);
			lstRecorridos.add(r2);
			lstRecorridos.add(r3);
			
			Vehiculo v1 = new Vehiculo (1, "AAA 111", lstRecorridos);
			
			////////////////////////////////Muestra por pantalla///////////////
			System.out.println(v1.toString());
			
            for (Recorrido r : lstRecorridos){
            	System.out.println(" " +r.toString());
            	
            	for (Posicion p : lstPosiciones){
            		System.out.println(" " +p.toString());
            	}
            }
			
    	 
         
         System.out.println("traigo esa posicion: " +(r3.traerPosicion(f1)).toString());
            
		}//cierro try
		
		catch (Exception e){ System.out.println ("Error: " + e.getMessage());}
		
		
		
		
	}//cierra main

}//cierra clase
