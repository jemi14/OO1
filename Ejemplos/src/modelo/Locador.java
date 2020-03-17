package modelo;

public class Locador extends Cliente {
	
	private int diaCobro;
	private String banco;
	private int sucursal;
	private String aliasCBU;
	
	public Locador(int idCliente, long dni, String nombre, String apellido, String telefono, int diaCobro, String banco,
			int sucursal, String aliasCBU) {
		super(idCliente, dni, nombre, apellido, telefono);
		this.diaCobro = diaCobro;
		this.banco = banco;
		this.sucursal = sucursal;
		this.aliasCBU = aliasCBU;
	}
	
	public Locador(long dni, String nombre, String apellido, String telefono, int diaCobro, String banco,
			int sucursal, String aliasCBU) {
		super(dni, nombre, apellido, telefono);
		this.diaCobro = diaCobro;
		this.banco = banco;
		this.sucursal = sucursal;
		this.aliasCBU = aliasCBU;
	}

	public Locador() {
	}

	public int getDiaCobro() {
		return diaCobro;
	}

	public void setDiaCobro(int diaCobro) {
		this.diaCobro = diaCobro;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public int getSucursal() {
		return sucursal;
	}

	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}

	public String getAliasCBU() {
		return aliasCBU;
	}

	public void setAliasCBU(String aliasCBU) {
		this.aliasCBU = aliasCBU;
	}

	@Override
	public String toString() {
		return "Locador "+super.toString() +"[diaCobro=" + diaCobro + ", banco=" + banco + ", sucursal=" + sucursal + ", aliasCBU="
				+ aliasCBU + "]";
	}

	
	
	
	
	
	
	
	

}
