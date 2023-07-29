package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            switch (menu(scan)) {
                case 1 -> Cliente.mostrarClientes(clientes);
                case 2 -> Cliente.cadastrarCliente(clientes, scan);
                case 3 -> Cliente.editarCliente(clientes, scan);
                case 4 -> {
                }

                case 5 -> {
                }

                case 6 -> System.exit(0);
                default -> System.out.println("Valor inválido!");
            }
        }
    }

    static int menu(Scanner scan) {
        int pedidosAbertos;
        int pedidosEncerrados;

        System.out.println("");
        System.out.println("1 - Mostrar clientes");
        System.out.println("2 - Cadastrar cliente");
        System.out.println("3 - Editar cliente");
        System.out.println("4 - Realizar pedido");
        System.out.println("5 - Encerrar pedido");
        System.out.println("6 - Sair");
        System.out.println("");
        System.out.println("Pedidos no dia: " + " Pedidos abertos: " + " Pedidos encerrados: ");

        return scan.nextInt();
    }
}
