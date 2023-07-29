package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            switch (menu(scan)){
                case 1 -> cadastrarCliente(clientes, scan);

                case 2 -> editarCliente(clientes, scan);

                case 3 -> cadastrarCliente(clientes, scan);

                case 4 -> editarCliente(clientes, scan);

                case 5 -> System.exit(0);

                default -> System.out.println("Valor inválido!");
            }
        }
    }

    static int menu(Scanner scan){
        int pedidosAbertos;
        int pedidosEncerrados;

        System.out.println("");
        System.out.println("1 - Cadastrar cliente");
        System.out.println("2 - Editar cliente");
        System.out.println("3 - Realizar pedido");
        System.out.println("4 - Encerrar pedido");
        System.out.println("5 - Sair");
        System.out.println("");
        System.out.println("Pedidos no dia: " + " Pedidos abertos: " + " Pedidos encerrados: ");

        return scan.nextInt();
    }

    static void cadastrarCliente(List<Cliente> clientes, Scanner scan){
        System.out.println("Digite o nome: ");
        String nome = scan.next();
        System.out.println("Digite a idade: ");
        int idade = scan.nextInt();

        List<Endereco> enderecos = new ArrayList<>();
        int cont = 1;
        while (true) {
            System.out.println("Endereço " + cont + " : (Digite 0 para sair)");

            System.out.println("Digite o nome da rua: ");
            String rua = scan.next();

            if (rua.equals("0")) {
                break;
            }

            System.out.println("Digite o numero da residência: ");
            int numero = scan.nextInt();
            enderecos.add(new Endereco(rua, numero));

            cont++;
        }

        clientes.add(new Cliente(nome, idade, enderecos));
    }

    static void editarCliente(List<Cliente> clientes, Scanner scan){
        System.out.println("Digite o nome do cliente: ");
        String nome = scan.next();
        boolean find = false;

        for (Cliente cliente : clientes)
        {
            if (cliente.getNome().equals(nome)){
                System.out.println("");
                System.out.println(cliente.getNome() + ", " + cliente.getIdade() + " anos");
                System.out.println("Endereços:");
                for (int i = 0; i < cliente.getEnderecos().size(); i++)
                {
                    System.out.println(cliente.getEnderecos().get(i).getRua() + ", " + cliente.getEnderecos().get(i).getNumero());
                }
                System.out.println("");

                find = true;
            }
        }

        if (!find){
            System.out.println("Pessoa não encontrada!");
            System.out.println("");
        }
    }

    static Cliente buscarCliente(List<Cliente> clientes, Scanner scan){
        System.out.println("Digite o nome do cliente: ");
        String nome = scan.next();

        for (Cliente cliente : clientes)
        {
            if (cliente.getNome().equals(nome)){
                return cliente;
            }
        }

        return null;
    }
}