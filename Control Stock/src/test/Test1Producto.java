package test;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import modelo.Administrador;
import java.util.List;
import modelo.Producto;
import modelo.Lote;
import modelo.Stock;



public class Test1Producto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Generamos la lista
	
		Administrador a1= new Administrador();

		Administrador a2= new Administrador();


		//AGREGAR PRODUCTO

		
			Producto p1= new Producto(1,"Queso Cremoso","001","Queso");
			Producto p2= new Producto(2,"Queso Light","002","Queso");
			Producto p3= new Producto(3,"Yogurt","010","yogurt");
			Producto p4= new Producto(4,"Leche Descremada","101","leche");
			Producto p5= new Producto(5,"Queso Fresco","102","Queso");
			Producto p6= new Producto(6,"Dulce de Leche","201","dulces");
		
			//ArrayList<Producto> listaProducto = new ArrayList<Producto>();
			
			try{
				System.out.println("AGREGAR PRODUCTO: "+a1.agregarProducto("Queso Cremoso","001","Queso"));
			}catch(Exception e){
				e.printStackTrace();
			}


		//2-TRAER PRODUCTO POR ID
		System.out.println("TRAER 1: " +a1.traerProducto(1));
		System.out.println("TRAER 2: " +a1.traerProducto(2));
		System.out.println("TRAER 3: " +a1.traerProducto(3));
		

		//3-AGREGAR STOCK
		try{
			System.out.println("AGREGAR STOCK: " +a1.agregarStock(100, 200, p1));
			System.out.println("AGREGAR STOCK: " +a1.agregarStock(120, 240, p1));

		}
		catch(Exception e){
			e.printStackTrace();
		}

		
		//4-AGREGAR LOTE
		GregorianCalendar fecha= new GregorianCalendar(19,04,2016);
		GregorianCalendar fecha2= new GregorianCalendar(10,10,2016);
		Stock s1= new Stock();
        try{
    	System.out.println("AGREGAR LOTE: " +a1.agregarlote(200, 150,true,fecha));
    	System.out.println("AGREGAR LOTE: " +a1.agregarlote(200, 200,false,fecha2));
        }
    	catch(Exception e){
			e.printStackTrace();
		}
		
        //5 Y 6 TRAER STOCK
        System.out.println("TRAER STOCK POR ID: " +a1.traerStock(1));
        System.out.println("TRAER STOCK POR PRODUCTO: " +a1.traerStock(1));	

        //7-CALCULAR TOTAL CANTIDAD EXISTENTE 	
        System.out.println("CALCULAR TOTAL CANTIDAD EXISTENTE: " +s1.calcularCantidadExistente());

        //8-CALCULAR CANTIDAD A PRODUCIR
        System.out.println("CANTIDAD A PRODUCIR: "+a2.calcularCantidadAProducir());  
        System.out.println("CANTIDAD A PRODUCIR: "+a2.calcularCantidadAProducir(p1));  

	}
}
 	   