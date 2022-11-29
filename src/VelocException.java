import java.io.IOException;

public class VelocException extends IOException {

	VelocException() {
		System.out.println("\nA velocidade maxima esta fora dos limites brasileiros! <EXCEPTION> ");
	}

	public void impErro() {
		System.out.println("\nVelocidade maxima acima do permitido! <EXCEPTION>");
	}
}
