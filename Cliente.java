public class Cliente {
    private final String nome;
    private final String cpf;
    private Computador[] computadores;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void setComputadores(Computador[] computadores) {
        this.computadores = computadores;
    }

    public Computador[] getComputadores() {
        return computadores;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public float calculaTotalCompra() {
        float total = 0;

        if (computadores == null) {
            return total;
        }

        for (Computador computador : computadores) {
            total += computador.getPreco();
        }

        return total;
    }
}