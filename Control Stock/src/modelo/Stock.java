package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;


public class Stock {

	private int idStock;
	private int puntoAprovisionamiento;
	private int puntoStockdeseado;
	private Producto producto;
	private List <Lote> listaLote;


	public Stock(){
	this.listaLote = new ArrayList<Lote>();
	}

	//EN EL CONSTRUCTOR NO PONER THIS LISTA.......
	
	public Stock(int idStock, int puntoAprovisionamiento, int puntoStockdeseado, Producto producto){
		{
			this.idStock = idStock;
			this.puntoAprovisionamiento = puntoAprovisionamiento;
			this.puntoStockdeseado = puntoStockdeseado;
			this.producto = producto;


		}
	}
	public int getIdStock() {
		return idStock;
	}


	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}


	public int getPuntoAprovisionamiento() {
		return puntoAprovisionamiento;
	}


	public void setPuntoAprovisionamiento(int puntoAprovisionamiento) {
		this.puntoAprovisionamiento = puntoAprovisionamiento;
	}


	public int getPuntoStockdeseado() {
		return puntoStockdeseado;
	}


	public void setPuntoStockdeseado(int puntoStockdeseado) {
		this.puntoStockdeseado = puntoStockdeseado;
	}


	public Producto getProducto() {
		return producto;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}


	public List<Lote> getListaLote() {
		return listaLote;
	}


	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", puntoAprovisionamiento="
				+ puntoAprovisionamiento + ", puntoStockdeseado="
				+ puntoStockdeseado + ", producto=" + producto + ", listaLote="
				+ listaLote + "]";
	}

    public Lote traerLote(GregorianCalendar FechaProduccion){

	Lote loteencontrado = null;
	int pos=0;

	while (pos<listaLote.size() && loteencontrado==null){


		if(listaLote.get(pos).getFechaProduccion().equals(FechaProduccion)){
			loteencontrado=listaLote.get(pos);
		}
		pos++;
	}

	return loteencontrado;

}
    
    //7-CALCULAR CANTIDAD EXISTENTE
    public int calcularCantidadExistente(){    		
	int total=0;
    
	for(int i=0;i<listaLote.size();i++){
	total=total+listaLote.get(i).getCantidadExistente();    	
	}	
	return total;
}

    //8-CALCULAR CANTIDAD EXISTENTE-PRODUCTO
    public int calcularCantidadExistente(Producto producto){    		
    	int total=0;
        
    	for(int i=0;i<listaLote.size();i++){
    	total=total+listaLote.get(i).getCantidadExistente();    	
    	}	
    	return total;
    }
   


}
//10-CALCULAR CANTIDAD A PRODUCIR-PRODUCTO
//11-CALCULAR CANTIDAD POR ENCIMA STOCK DESEADO
//12-CALCULAR CANTIDAD POR ENCIMA STOCK DESEADO-PRODUCTO
    

    


