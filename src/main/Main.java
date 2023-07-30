package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        List<Pedido> pedidos = new ArrayList<>();

        while (true) {
            switch (menu(scan, pedidos)) {
                case 1 -> Cliente.mostrarClientes(clientes);
                case 2 -> Cliente.cadastrarCliente(clientes, scan);
                case 3 -> Cliente.editarCliente(clientes, scan);
                case 4 -> Pedido.realizarPedido(clientes, scan, pedidos);
                case 5 ->  Pedido.mostrarPedidos(pedidos);
                case 6-> { Pedido.finalizarPedido(pedidos, scan);
                }
                case 7 -> System.exit(0);
                default -> System.out.println("Valor inválido!");
            }
        }
    }

    static int menu(Scanner scan, List<Pedido> pedidos) {

        System.out.println("");
        System.out.println("|Restaturante tem de tudo|");
        System.out.println("1 - Mostrar clientes");
        System.out.println("2 - Cadastrar cliente");
        System.out.println("3 - Editar cliente");
        System.out.println("4 - Realizar pedido");
        System.out.println("5 - Visualizar pedidos");
        System.out.println("6 - Encerrar pedido");
        System.out.println("7 - Sair");
        System.out.println("");

        int totalPedidos = pedidos.size();
        int pedidosAbertos = calcularPedidosAbertos(pedidos);
        int pedidosEncerrados = totalPedidos - pedidosAbertos;

        System.out.println("Pedidos no dia: " + totalPedidos +
                " | Pedidos abertos: " + pedidosAbertos +
                " | Pedidos encerrados: " + pedidosEncerrados);


        return scan.nextInt();
    }
    static int calcularPedidosAbertos(List<Pedido> pedidos) {
        int abertos = 0;
        for (Pedido pedido : pedidos) {
            if (!pedido.isEncerrado()) {
                abertos++;
            }
        }
        return abertos;
    }
}
