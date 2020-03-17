package test;

import java.time.LocalDate;

import modelo.SistemaStock;
import modelo.SolicitudStock;

public class TestTema1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		SistemaStock sistema= new SistemaStock();
		
		//---------------------------------------------------//
		
		System.out.println("1 Agregar los siguientes productos e imprimir la lista");
		
		try {
			sistema.agregarProducto("Producto A", 45.5d);
			sistema.agregarProducto("Producto B", 65.5d);
		} catch (Exception e) {
			System.out.println("Exception "+e.getMessage());
		}
		
		System.out.println(sistema.traerProducto(1));
		System.out.println(sistema.traerProducto(2));
		
		System.out.println("------------------------------");
		
		//---------------------------------------------------//
		
		System.out.println("2 Agregar los siguientes sucursales e imprimir la lista");
		
		try {
			sistema.agregarSucursal("Direccion A");
			sistema.agregarSucursal("Direccion B");
		} catch (Exception e) {
			System.out.println("Exception "+e.getMessage());
		}
		
		System.out.println(sistema.traerSucursal(1).toString1());
		System.out.println(sistema.traerSucursal(2).toString1());
		
		System.out.println("------------------------------");
		
		//---------------------------------------------------//
		
		System.out.println("3 Agregar los siguientes empleado e imprimirlos");
		
		sistema.traerSucursal(1).agregarEmpleado("Jose", "Gomez", 11111111l);
		sistema.traerSucursal(2).agregarEmpleado("Felipe", "Suarez", 22222222l);
		
		System.out.println(sistema.traerSucursal(1).getLstEmpleados());
		System.out.println(sistema.traerSucursal(2).getLstEmpleados());
		
        System.out.println("------------------------------");
		
		//---------------------------------------------------//
        
        System.out.println("4 Agregar los siguientes lotes e imprimirlos");
        
        sistema.traerSucursal(1).agregarLote(sistema.traerProducto(1), LocalDate.of(2019, 10, 1), 100);
        sistema.traerSucursal(1).agregarLote(sistema.traerProducto(2), LocalDate.of(2019, 10, 1), 50);
        sistema.traerSucursal(1).agregarLote(sistema.traerProducto(1), LocalDate.of(2019, 10, 3), 40);
        
        sistema.traerSucursal(2).agregarLote(sistema.traerProducto(1), LocalDate.of(2019, 10, 2), 80);
        sistema.traerSucursal(2).agregarLote(sistema.traerProducto(2), LocalDate.of(2019, 10, 2), 80);
        
        System.out.println(sistema.traerSucursal(1).getLstLotes());
        System.out.println(sistema.traerSucursal(2).getLstLotes());
        
        System.out.println("------------------------------");
		
		//---------------------------------------------------//
        
        System.out.println("5 Traer la cantidad de stock total de producto 1 de la sucursal 1 e imprimir el resultado");
        
        System.out.println(sistema.traerSucursal(1).traerCantidad(sistema.traerProducto(1)));
        
        System.out.println("------------------------------");
		
		//---------------------------------------------------//
        
        System.out.println("6 Validar si se pueden consumir 80 unidades del producto 1 de la sucursal 1 e imprimir el resultado");
        
        System.out.println(sistema.traerSucursal(1).validarConsumo(sistema.traerProducto(1), 80));
        
        System.out.println("------------------------------");
		
		//---------------------------------------------------//
        
        System.out.println("7 Generar el siguiente remito de consumo e imprimirlo");
        
        sistema.traerSucursal(1).traerEmpleado(11111111).setNombre("Juan");
        
        System.out.println(sistema.generarRemitoDeConsumo(LocalDate.of(2019, 10, 5), sistema.traerProducto(1), 80,sistema.traerSucursal(1).traerEmpleado(11111111) , "1"));
        
        System.out.println("------------------------------");
        
       //---------------------------------------------------//
        
        System.out.println("8 Tratar de generar un remito de consumo igual a la anterior pero con fecha del dia siguiente");
        
        try {
        
        System.out.println(sistema.generarRemitoDeConsumo(LocalDate.of(2019, 10, 6), sistema.traerProducto(1), 80,sistema.traerSucursal(1).traerEmpleado(11111111) , "1"));
        } catch (Exception e) {
        	System.out.println("Exception " + e.getMessage());
        }
        
        System.out.println("------------------------------");
        
        //---------------------------------------------------//
         
        System.out.println("9 Generar la siguiente solicitud de stock al sistema e imprimirla");
        
        SolicitudStock solicitud= sistema.generarSolicitudStock(LocalDate.of(2019, 10, 5), sistema.traerProducto(1), 70, sistema.traerSucursal(1).traerEmpleado(11111111));
        
        System.out.println(solicitud);
        
        System.out.println("------------------------------");
        
        //---------------------------------------------------//
        
        System.out.println("10 Obtener las sucursales del sistema que tienen stock para generar el remito de consumo fallido del punto 8, luego imprimir la lista");
        
        System.out.println(sistema.validarConsumo(sistema.traerProducto(1), 80));
        
        System.out.println("------------------------------");
        
        //---------------------------------------------------//
        
        System.out.println("11 Actualizar la solicitud de stock aceptando por el vendedor con dni=22222222 de la sucursal 2 e imprimir");
        
        sistema.actualizarSolicitudStock(solicitud, 22222222, true);
        
        System.out.println(solicitud);
	}

}
