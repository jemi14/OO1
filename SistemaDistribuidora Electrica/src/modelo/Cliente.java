package modelo;

public abstract class Cliente {
	
	protected long numeroCliente;

	public Cliente(long numeroCliente) {
		super();
		this.numeroCliente = numeroCliente;
	}

	public long getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(long numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	@Override
	public String toString() {
		return "Cliente [numeroCliente=" + numeroCliente + "]";
	}
	
	/************************************************************************/
	public abstract int getDni();
	
	/************************************************************************/
	public abstract long getCuit();

	/************************************************************************/
     public boolean equals(Cliente cliente) {
     boolean respuesta= false;
     if(numeroCliente==cliente.getNumeroCliente()) {
    	respuesta=true;
     }
     return respuesta;
   
    	 
		
	}
	
	
}
