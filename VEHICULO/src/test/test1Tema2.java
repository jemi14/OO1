package test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Posicion;
import modelo.Recorrido;

public class test1Tema2 {

	public static void main(String[] args) {
		
		try{
		Posicion p1 = new Posicion (1,-0.663320236202079d,-1.0043055612300615d, 200, new GregorianCalendar(04,03,2016,12,00,00));
		Posicion p2 = new Posicion (2,-0.6738939644094362d, -1.0603622206785406d, 127, new GregorianCalendar(04,03,2016,15,26,00));
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
		  	
     	///////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("Esta es la primer posicion creada:" +p1.toString());
		System.out.println("Esta es la segunda posicion creada:" +p2.toString());
		
		
		System.out.println("Esta es la distancia entre ambas: " +p1.distancia(p2) +"  KM");
		
		
		for (Posicion p: r1.getPosiciones()){
		System.out.println ("Este es el recorrido: " +r1.getIdRecorrido() +r1.toString() +p.toString());}
	
	}//Cierra try
		
		catch (Exception e){ System.out.println ("Error: " + e.getMessage());} 

}//Cierra mmain
	
}//Cierra clase
