public class ProcessarPedido {
    public static void enviarPedido(Computador[] computadores) {
        if (computadores == null || computadores.length == 0) {
            System.out.println("Pedido vazio. Nada para enviar.");
            return;
        }

        System.out.println("Pedido enviado...");
    }
}
