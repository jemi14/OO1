package modelo1;

public class Cabina {
	
	private int idCabina;
	private String cabina;
	
	public Cabina(int idCabina, String cabina) {
		super();
		this.idCabina = idCabina;
		this.cabina = cabina;
	}

	public Cabina() {
		super();
	}

	public int getIdCabina() {
		return idCabina;
	}

	public void setIdCabina(int idCabina) {
		this.idCabina = idCabina;
	}

	public String getCabina() {
		return cabina;
	}

	public void setCabina(String cabina) {
		this.cabina = cabina;
	}

	@Override
	public String toString() {
		return "Cabina [idCabina=" + idCabina + ", cabina=" + cabina + "]";
	}
	
	
	
	

}
