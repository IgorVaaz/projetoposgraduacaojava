
public abstract class Veiculo { // não deixa mais instanciar ela
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private float velocMax;
	private int qtdRodas;
	private Motor motor;

	public Veiculo() {
		this.placa = "";
		this.marca = "";
		this.modelo = "";
		this.cor = "";
		this.velocMax = 0;
		this.qtdRodas = 0;
		motor = new Motor();
	}

	public abstract void calcVel(float velocMax);

	public String getPlaca() {
		return this.placa;
	}

	final public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return this.marca;
	}

	final public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	final public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return this.cor;
	}

	final public void setCor(String cor) {
		this.cor = cor;
	}

	public float getVelocMax() {
		return this.velocMax;
	}

	final public void setVelocMaxPasseio(float velocMax) throws VelocException {
		try {
			if (velocMax >= 80 && velocMax <= 110) {
				this.velocMax = velocMax;
			} else {
				this.velocMax = 100;
				throw new VelocException();
			}
		} catch (VelocException e) {
			e.impErro();
		}
	}

	final public void setVelocMaxCarga(float velocMax) throws VelocException {
		try {
			if (velocMax >= 80 && velocMax <= 110) {
				this.velocMax = velocMax;
			} else {
				this.velocMax = 90;
				throw new VelocException();
			}
		} catch (VelocException e) {
			e.impErro();
		}
	}

	public int getQtdRodas() {
		return this.qtdRodas;
	}

	final public void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	public Motor getMotor() {
		return this.motor;
	}

	final public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public String toString() {
		System.out.println("Placa: " + this.placa);
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Cor: " + this.cor);
		System.out.println("velocMax: " + this.velocMax);
		System.out.println("qtdRodas: " + this.qtdRodas);
		System.out.println("Motor qtdPista: " + this.motor.getQtdPist());
		System.out.println("Motor potencia: " + this.motor.getPotencia());
		System.out.println("-----------------------------");
		return null;
	}
}
