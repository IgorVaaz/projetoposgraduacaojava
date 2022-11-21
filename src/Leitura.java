import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Leitura {

	public String entDados(String rotulo) {
		System.out.println(rotulo);

		InputStreamReader teclado = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(teclado);

		String res = "";

		try {
			res = buff.readLine();
		} catch (IOException ioe) {
			System.out.println("\n Erro de sistema");
		}

		return res;
	}
}
