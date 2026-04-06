public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hardwares;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;

    public Computador(String marca, float preco, HardwareBasico[] hardwares, SistemaOperacional sistemaOperacional) {
        this.marca = marca;
        this.preco = preco;
        this.hardwares = hardwares;
        this.sistemaOperacional = sistemaOperacional;
    }

    public void mostraPCConfigs() {
        System.out.println("------------------------------");
        System.out.println("Marca: " + marca);
        System.out.println("Preco: R$ " + preco);
        System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " " + sistemaOperacional.getTipo() + " bits");
        System.out.println("Hardwares Basicos:");

        for (int i = 0; i < hardwares.length; i++) {
            System.out.println("- " + hardwares[i].getNome() + ": " + hardwares[i].getCapacidade());
        }

        if (memoriaUSB != null) {
            System.out.println("Memoria USB: " + memoriaUSB.getNome() + " - " + memoriaUSB.getCapacidade() + " GB");
        } else {
            System.out.println("Memoria USB: sem memoria adicional");
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.memoriaUSB = musb;
    }

    public float getPreco() {
        return preco;
    }
}