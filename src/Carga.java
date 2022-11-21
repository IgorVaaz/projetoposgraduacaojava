
public final class Carga extends Veiculo implements Calcular {

	private int cargaMax;
	private int tara;

	public Carga() {
		this.cargaMax = 0;
		this.tara = 0;
	}

	@Override
	public void calcVel(float velocMax) {
		System.out.println("Velocidade Carga: " + velocMax * 100000 + "CM/H");
	}

	@Override
	public int calcular() {
		int soma = 0;

		soma += getMotor().getQtdPist();
		soma += getMotor().getPotencia();
		soma += getQtdRodas();
		soma += getVelocMax();
		soma += getTara();
		soma += getCargaMax();

		return soma;
	}

	public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public int getCargaMax() {
		return this.cargaMax;
	}

	public int getTara() {
		return this.tara;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}

}
