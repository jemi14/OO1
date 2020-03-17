package modelo;

public class Locatorio extends Cliente {
	
	private boolean enVeraz;

	public Locatorio(int idCliente, long dni, String nombre, String apellido, String telefono, boolean enVeraz) {
		super(idCliente, dni, nombre, apellido, telefono);
		this.enVeraz = enVeraz;
	}

	public Locatorio() {
	}

	public boolean isEnVeraz() {
		return enVeraz;
	}

	public void setEnVeraz(boolean enVeraz) {
		this.enVeraz = enVeraz;
	}

	@Override
	public String toString() {
		return "Locatorio "+super.toString()+"[enVeraz=" + enVeraz + "]";
	}

}
