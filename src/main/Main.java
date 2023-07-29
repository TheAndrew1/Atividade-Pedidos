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
                case 1 -> mostrarClientes(clientes);

                case 2 -> cadastrarCliente(clientes, scan);

                case 3 -> editarCliente(clientes, scan);

                case 4 -> cadastrarCliente(clientes, scan);

                case 5 -> editarCliente(clientes, scan);

                case 6 -> System.exit(0);

                default -> System.out.println("Valor inválido!");
            }
        }
    }

    static int menu(Scanner scan){
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

        int id = clientes.size() + 1;

        clientes.add(new Cliente(id, nome, idade, enderecos));
    }

    static void editarCliente(List<Cliente> clientes, Scanner scan){
        Cliente cliente = buscarCliente(clientes, scan);

        if (cliente == null){
            System.out.println("Cliente não encontrado!");
            System.out.println("");
            return;
        }

        mostrarCliente(cliente);

        System.out.println("Editar: 1 - nome, 2 - idade, 3 - endereços");
        int opcao = scan.nextInt();

        switch (opcao){
            case 1 -> {
                System.out.println("Digite o novo nome do cliente: ");
                String nome = scan.next();
                clientes.get(cliente.getId() - 1).setNome(nome);
                System.out.println("Nome editado com sucesso!");
            }
            case 2 -> {
                System.out.println("Digite a nova idade do cliente: ");
                int idade = scan.nextInt();
                clientes.get(cliente.getId() - 1).setIdade(idade);
                System.out.println("Idade editada com sucesso!");
            }
            default -> {
                System.out.println("Opção inválida!");
            }
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

    static void mostrarClientes(List<Cliente> clientes){
        for(Cliente cliente : clientes){
            System.out.println(cliente.getNome() + ", " + cliente.getIdade() + " anos");
            System.out.println("Endereços:");
            for (int i = 0; i < cliente.getEnderecos().size(); i++)
            {
                System.out.println((i+1) + " - " + cliente.getEnderecos().get(i).getRua() + ", " + cliente.getEnderecos().get(i).getNumero());
            }
            System.out.println("");
        }
    }

    static void mostrarCliente(Cliente cliente){
        System.out.println(cliente.getNome() + ", " + cliente.getIdade() + " anos");
        System.out.println("Endereços:");
        for (int i = 0; i < cliente.getEnderecos().size(); i++)
        {
            System.out.println((i+1) + " - " + cliente.getEnderecos().get(i).getRua() + ", " + cliente.getEnderecos().get(i).getNumero());
        }
        System.out.println("");
    }
}