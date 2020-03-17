package modelo;

public class Tarifa {
	
	private int consumoMinimo;
	private int comsumoMaximo;
	private float cargoFijo;
	private float cargoVariable;
	
	public Tarifa(int consumoMinimo, int comsumoMaximo, float cargoFijo, float cargoVariable) {
		super();
		this.consumoMinimo = consumoMinimo;
		this.comsumoMaximo = comsumoMaximo;
		this.cargoFijo = cargoFijo;
		this.cargoVariable = cargoVariable;
	}

	public Tarifa() {
		super();
	}
	
	public int getConsumoMinimo() {
		return consumoMinimo;
	}

	public void setConsumoMinimo(int consumoMinimo) {
		this.consumoMinimo = consumoMinimo;
	}

	public int getComsumoMaximo() {
		return comsumoMaximo;
	}

	public void setComsumoMaximo(int comsumoMaximo) {
		this.comsumoMaximo = comsumoMaximo;
	}

	public float getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(float cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public float getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(float cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

	@Override
	public String toString() {
		return "Tarifa [consumoMinimo=" + consumoMinimo + ", comsumoMaximo=" + comsumoMaximo + ", cargoFijo="
				+ cargoFijo + ", cargoVariable=" + cargoVariable + "]";
	}
	
	
	
	

}
