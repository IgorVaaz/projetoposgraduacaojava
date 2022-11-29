import java.io.IOException;

public class VeicExistException extends IOException {

	VeicExistException() {
		System.out.println("\nJa existe um veiculo com esta placa! <EXCEPTION>");
	}

	public void impErro() {
		System.out.println("\nPlaca ja utilizada! <EXCEPTION>");
	}
}
