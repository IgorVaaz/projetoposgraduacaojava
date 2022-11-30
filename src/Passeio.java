
public final class Passeio extends Veiculo implements Calcular {

    private int qtdPassageiros;

    public Passeio() {
        this.qtdPassageiros = 0;
    }

    @Override
    public void calcVel(float velocMax) {
        System.out.println("Velocidade Passeio Atualizada: " + velocMax * 1000 + "M/H");
    }

    @Override
    public int calcular() {

        int somaLetras = 0;

        somaLetras += getPlaca().length();
        somaLetras += getMarca().length();
        somaLetras += getModelo().length();
        somaLetras += getCor().length();

        return somaLetras;
    }

    public int getQtdPassageiros() {
        return this.qtdPassageiros;
    }

    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

}
