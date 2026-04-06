import java.util.Scanner;

public class Main {
    private static final int MATRICULA = 2238;
    private static final float PRECO_PROMO_1 = MATRICULA;
    private static final float PRECO_PROMO_2 = MATRICULA + 1234;
    private static final float PRECO_PROMO_3 = MATRICULA + 5678;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("=== LOJA DE COMPUTADORES ===");
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Digite o CPF do cliente: ");
            String cpfCliente = scanner.nextLine();

            Cliente cliente = new Cliente(nomeCliente, cpfCliente);

            int quantidade = lerQuantidadeComputadores(scanner);
            Computador[] computadores = new Computador[quantidade];

            for (int i = 0; i < quantidade; i++) {
                int opcao = lerOpcaoPromocao(scanner, i + 1);
                computadores[i] = criarComputadorPromocional(opcao);
            }

            cliente.setComputadores(computadores);

            System.out.println("\nResumo da compra de " + cliente.getNome() + " (CPF: " + cliente.getCpf() + "):");
            for (Computador computador : computadores) {
                computador.mostraPCConfigs();
            }

            System.out.println("------------------------------");
            System.out.println("TOTAL DA COMPRA: R$ " + cliente.calculaTotalCompra());

            ProcessarPedido.enviarPedido(cliente.getComputadores());
        }
    }

    private static int lerQuantidadeComputadores(Scanner scanner) {
        int quantidade;

        do {
            System.out.print("Quantidade de computadores (minimo 2): ");
            quantidade = scanner.nextInt();
        } while (quantidade < 2);

        return quantidade;
    }

    private static int lerOpcaoPromocao(Scanner scanner, int indiceCompra) {
        int opcao;

        do {
            System.out.println("\nEscolha a promocao para o computador " + indiceCompra + ":");
            System.out.println("1 - Promocao 1 (Apple | Preco = matricula)");
            System.out.println("2 - Promocao 2 (Samsung | Preco = matricula + 1234)");
            System.out.println("3 - Promocao 3 (Dell | Preco = matricula + 5678)");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
        } while (opcao != 1 && opcao != 2 && opcao != 3);

        return opcao;
    }

    private static Computador criarComputadorPromocional(int opcao) {
        if (opcao == 1) {
            HardwareBasico[] hardwares = new HardwareBasico[3];
            hardwares[0] = new HardwareBasico("Processador Pentium Core i3", 2200);
            hardwares[1] = new HardwareBasico("Memoria RAM", 8);
            hardwares[2] = new HardwareBasico("HD", 500);

            Computador computador = new Computador(
                "Apple",
                PRECO_PROMO_1,
                hardwares,
                new SistemaOperacional("macOS Sequoia", 64)
            );
            computador.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));
            return computador;
        }

        if (opcao == 2) {
            HardwareBasico[] hardwares = new HardwareBasico[3];
            hardwares[0] = new HardwareBasico("Processador Pentium Core i5", 3370);
            hardwares[1] = new HardwareBasico("Memoria RAM", 16);
            hardwares[2] = new HardwareBasico("HD", 1000);

            Computador computador = new Computador(
                "Samsung",
                PRECO_PROMO_2,
                hardwares,
                new SistemaOperacional("Windows 8", 64)
            );
            computador.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
            return computador;
        }

        HardwareBasico[] hardwares = new HardwareBasico[3];
        hardwares[0] = new HardwareBasico("Processador Pentium Core i7", 4500);
        hardwares[1] = new HardwareBasico("Memoria RAM", 32);
        hardwares[2] = new HardwareBasico("HD", 2000);

        Computador computador = new Computador(
            "Dell",
            PRECO_PROMO_3,
            hardwares,
            new SistemaOperacional("Windows 10", 64)
        );
        computador.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
        return computador;
    }
}