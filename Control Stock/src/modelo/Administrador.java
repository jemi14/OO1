package modelo;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import modelo.Producto;
import modelo.Stock;

public class Administrador {


	private List <Producto> listaProducto;
	private List <Stock> listaStock;

	public Administrador(){

		this.listaProducto = new ArrayList<Producto>();//inicializo la lista
		this.listaStock= new ArrayList<Stock>();//inicializo la lista

	}

	public List<Producto> getListaProducto() {
		return listaProducto;
	}


	public List<Stock> getListaStock() {
		return listaStock;
	}




	//1-AGREGAR PRODUCTO A LA LISTA 

	public boolean agregarProducto (String nombreProducto, String codigo, String tipo) throws Exception{
		int proxIdProducto=1;

		if(this.traerProducto(codigo)!=null)throw new Exception ("Ese producto ya existe");

		if(!listaProducto.isEmpty()){
			proxIdProducto=listaProducto.get(listaProducto.size()-1).getIdProducto()+1;//determinar el ultimo lugar de la lista.- 
		}

		Producto p= new Producto (proxIdProducto,nombreProducto,codigo,tipo);//agregar en el ultimo lugar de la lista.- 
		return listaProducto.add(p);
	}

	//2- TRAER PRODUCTO POR ID
	    public Producto traerProducto(String codigo){
		Producto pencontrado = null;
		int pos=0;

		while (pos<listaProducto.size() && pencontrado==null){
			if(listaProducto.get(pos).getCodigo().equals(codigo)){
				pencontrado=listaProducto.get(pos);
			}
			pos++;
		}
    	return pencontrado;
	}

	//2- TRAER PRODUCTO POR ID
	public Producto traerProducto(int idProducto){
		Producto pencontrado = null;
		int pos=0;

		while (pos<listaProducto.size() && pencontrado==null){
			if (listaProducto.get(pos).getIdProducto()==idProducto){
				pencontrado=listaProducto.get(pos);
			}
			pos++;
		}
		return pencontrado;
	}


	//3.-AGREGAR STOCK
	public boolean agregarStock (int puntoAprovisionamiento, int puntoStockdeseado, Producto producto) throws Exception{
		int proxIdStock=1;
		int puntoaprovisionamientominimo= puntoStockdeseado*30/100; 

		if(puntoAprovisionamiento<puntoaprovisionamientominimo) throw new Exception ("Cantidad minima no valida"); 
		if(this.traerStock(producto)!=null)throw new Exception ("Ese producto ya existe");

		if(!listaStock.isEmpty()){
			proxIdStock=listaStock.get(listaStock.size()-1).getIdStock()+1;//determinar el ultimo lugar de la lista. 
		}

		Stock s= new Stock (proxIdStock,puntoAprovisionamiento, puntoStockdeseado,producto);//aregar en el ultimo lugar de la lista. 
		return listaStock.add(s);
	}

	//4.AGREGAR LOTE
	public boolean agregarlote(int cantidadInicial, int cantidadExistente, boolean enUso, GregorianCalendar fechaProduccion)throws Exception{
	Lote ultimo=new Lote();
	Lote lo=null;
	int pos=0;
	
	while (pos<listaStock.size()){	
	lo=listaStock.get(pos).getListaLote().get(pos);
	if  (lo.getFechaProduccion().equals(fechaProduccion)) throw new Exception ("Ese lote ya existe");
	pos++;
	}
	
	if(!listaStock.get(pos).getListaLote().isEmpty()){	
	ultimo=listaStock.get(pos).getListaLote().get(listaStock.get(pos).getListaLote().size()-1);
	}
		
	Lote l= new Lote (ultimo.getIdLote()+1,cantidadInicial, cantidadExistente, enUso, fechaProduccion);
	return listaStock.get(pos).getListaLote().add(l);	
	}
	

	//5.-TRAER STOCK POR ID
	public Stock traerStock(int idStock){
		Stock sencontrado = null;
		int pos=0;

		while (pos<listaProducto.size() && sencontrado==null){

			if (listaProducto.get(pos).getIdProducto()==idStock){
				sencontrado=listaStock.get(pos);
			}
			pos++;
		}
		return sencontrado;
	}


	//6.-TRAER STOCK POR PRODUCTO
	public Stock traerStock(Producto producto){
		Stock sencontrado = null;
		int pos=0;

		while (pos<listaProducto.size() && sencontrado==null){
			if (listaProducto.get(pos).getNombreProducto().equals(producto)){
				sencontrado=listaStock.get(pos);
			}
			pos++;
		}
		return sencontrado;
	}


	//9-CALCULAR CANTIDAD A PRODUCIR
	public int calcularCantidadAProducir(){    		
		int total=0;

		for(int i=0;i<listaStock.size();i++){
			total=total+(listaStock.get(i).getPuntoStockdeseado() - listaStock.get(i).getListaLote().get(i).getCantidadExistente());    	
		}	
		return total;
	}

	//10-CALCULAR CANTIDAD A PRODUCIR
		public int calcularCantidadAProducir(Producto producto){    		
			int total=0;
			boolean uso=false;

			for(int i=0;i<listaStock.size();i++){
				if(producto.getIdProducto()==listaStock.get(i).getIdStock() && listaStock.get(i).getListaLote().get(i).isEnUso()==uso){
				total=total+(listaStock.get(i).getPuntoStockdeseado() - listaStock.get(i).getListaLote().get(i).getCantidadExistente());    	
			}	
		}
			return total;
	}
		
		


}

      