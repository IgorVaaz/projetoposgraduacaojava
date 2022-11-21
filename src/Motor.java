
public class Motor {
	private int qtdPist;
	private int potencia;

	public Motor() {
		this.qtdPist = 0;
		this.potencia = 0;
	}

	public int getQtdPist() {
		return this.qtdPist;
	}

	final public void setQtdPist(int qtdPist) {
		this.qtdPist = qtdPist;
	}

	public int getPotencia() {
		return this.potencia;
	}

	final public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
}
