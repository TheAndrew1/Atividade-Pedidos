package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private int id;
    private String nome;
    private int idade;
    private List<Endereco> enderecos;
    private List<Pedido> pedidos;
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void adicionarPedido(Pedido pedido) {
        this.pedidos.add(pedido);
    }
    public Cliente() {
    }
    public Cliente(int id, String nome, int idade, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.enderecos = enderecos;
        this.pedidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }


    public static void cadastrarCliente(List<Cliente> clientes, Scanner scan) {
        System.out.println("Digite o nome: ");
        scan.nextLine();
        String nome = scan.nextLine();
        System.out.println("Digite a idade: ");
        int idade = scan.nextInt();

        List<Endereco> enderecos = new ArrayList<>();
        int idEndereco = 1;
        while (true) {
            Endereco endereco = Endereco.cadastrarEndereco(scan, idEndereco);

            if (endereco == null){
                break;
            }

            enderecos.add(endereco);

            idEndereco++;
        }

        int id = clientes.size() + 1;

        clientes.add(new Cliente(id, nome, idade, enderecos));
    }

    public static void editarCliente(List<Cliente> clientes, Scanner scan) {
        Cliente cliente = buscarCliente(clientes, scan);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            System.out.println("");
            return;
        }

        mostrarCliente(cliente);

        System.out.println("Editar: 1 - nome | 2 - idade | 3 - endereços");
        int opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> {
                System.out.println("Digite o novo nome do cliente: ");
                scan.nextLine();
                String nome = scan.nextLine();
                clientes.get(cliente.getId() - 1).setNome(nome);
                System.out.println("Nome editado com sucesso!");
            }
            case 2 -> {
                System.out.println("Digite a nova idade do cliente: ");
                scan.nextLine();
                int idade = scan.nextInt();
                clientes.get(cliente.getId() - 1).setIdade(idade);
                System.out.println("Idade editada com sucesso!");
            }
            case 3 -> {
                System.out.println("1 - Excluir endereço | 2 - Cadastrar endereço");
                int op = scan.nextInt();
                switch (op) {
                    case 1 -> {
                        System.out.println("Digite o id do endereco a ser excluido: ");
                        int id = scan.nextInt();
                        List<Endereco> newEnderecos = Endereco.excluirEndereco(cliente.getEnderecos(), id);
                        if (newEnderecos == null){
                            break;
                        }
                        cliente.setEnderecos(newEnderecos);
                    }
                    case 2 -> {
                        Endereco newEndereco = Endereco.cadastrarEndereco(scan, (cliente.getEnderecos().size() + 1));
                        if (newEndereco == null){
                            System.out.println("Operação cancelada!");
                            break;
                        }
                        List<Endereco> newEnderecos = cliente.getEnderecos();
                        newEnderecos.add(newEndereco);
                        cliente.setEnderecos(newEnderecos);
                    }
                    default -> System.out.println("Opção inválida!");
                }
            }
            default -> System.out.println("Opção inválida!");
        }
    }

    public static Cliente buscarCliente(List<Cliente> clientes, Scanner scan) {
        System.out.println("Digite o nome do cliente: ");
        scan.nextLine();
        String nome = scan.nextLine();

        for (Cliente cliente : clientes) {
            if (cliente.getNome().equals(nome)) {
                return cliente;
            }
        }
        return null;
    }

    public static void mostrarClientes(List<Cliente> clientes) {
        for (Cliente cliente : clientes) {
            mostrarCliente(cliente);
        }
    }

    public static void mostrarCliente(Cliente cliente) {
        System.out.println("Nome:" + cliente.getNome() + ", " + cliente.getIdade() + " anos");
        System.out.println("Endereços:");
        for (int i = 0; i < cliente.getEnderecos().size(); i++) {
            System.out.println(cliente.getEnderecos().get(i).getId() + " - " + cliente.getEnderecos().get(i).getRua() + ", " + cliente.getEnderecos().get(i).getNumero());
        }
        System.out.println("");
    }
}
