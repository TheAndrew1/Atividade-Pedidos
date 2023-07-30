package main;

import javax.xml.transform.stream.StreamSource;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Pedido {
    private static int contadorPedidos = 1;
    private int id;
    private boolean encerrado;
    private List<Cliente> clientes = new ArrayList<>();
    private Cliente cliente;
    private String item;
    private List<Endereco> enderecos;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public static int getContadorPedidos() {
        return contadorPedidos;
    }


    public boolean isEncerrado() {
        return encerrado;
    }

    public void setEncerrado(boolean encerrado) {
        this.encerrado = encerrado; // Corrigir atribuição aqui
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public String getItem() {
        return item;
    }

    public static void setItem(String item) {
        item = item;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Pedido(){
    }

    public Pedido(boolean encerrado, Cliente cliente, String item, List<Endereco> enderecos) {
        this.encerrado = encerrado;
        this.cliente = cliente;
        this.item = item;
        this.enderecos = enderecos;
    }
    public static void incrementarContadorPedidos() {
        contadorPedidos++;
    }
    public static void realizarPedido(List<Cliente> clientes, List<Endereco> enderecos, Scanner scan, List<Pedido> pedidos) {
        Cliente cliente = Cliente.buscarCliente(clientes, scan);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.println("Cliente selecionado:");
        Cliente.mostrarCliente(cliente);

        System.out.println("Selecione o endereço:");
        Endereco endereco = Endereco.buscarEndereco(enderecos, scan);

        if (enderecos == null) {
            System.out.println("Endereço não encontrado!");
            System.out.println("");
            return;
        }

        System.out.println("Escolha o item do pedido:");
        System.out.println("1- pizza");
        System.out.println("2- hamburguer");
        System.out.println("3- sushi");

        int opcao = scan.nextInt();
        String item;

        switch (opcao) {
            case 1:
                item = "pizza";
                break;
            case 2:
                item = "hamburguer";
                break;
            case 3:
                item = "sushi";
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        Pedido pedido = new Pedido(false, cliente, item, enderecos);
        int novoId = pedidos.size() + 1;
        pedido.setId(novoId);
        cliente.adicionarPedido(pedido);
        pedidos.add(pedido);

        System.out.println("Pedido realizado com sucesso!");
    }
    public static void mostrarPedidos(List<Pedido> pedidos){
        int item;
        Scanner scan = new Scanner(System.in);

        System.out.println("1- Visualizar todos os pedidos");
        System.out.println("2- Visualizar os pedidos abertos");
        System.out.println("3- Visualizar os pedidos finalizados");
        item = scan.nextInt();

        switch (item){
            case 1 -> Pedido.mostrarTodosPedidos(pedidos);
            case 2 -> Pedido.mostrarAbertos(pedidos);
            case 3 -> Pedido.mostrarFinalizados(pedidos);

        }
    }

    public static void mostrarTodosPedidos(List<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            System.out.println("Id: " + pedido.getId());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Item do Pedido: " + pedido.getItem());
            System.out.println("Status do Pedido: " + (pedido.isEncerrado() ? "Finalizado" : "Aberto"));
            System.out.println("---------------------------");
        }
    }

    public static void mostrarAbertos(List<Pedido> pedidos) {
        System.out.println("Pedidos em aberto:");
        for (Pedido pedido : pedidos) {
            if (!pedido.isEncerrado()) {
                mostrarPedido(pedido);
            }
        }
    }

    public static void mostrarFinalizados(List<Pedido> pedidos) {
        System.out.println("Pedidos finalizados:");
        for (Pedido pedido : pedidos) {
            if (pedido.isEncerrado()) {
                mostrarPedido(pedido);
            }
        }
    }

    public static void mostrarPedido(Pedido pedido) {
        System.out.println("Id: " + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Item do Pedido: " + pedido.getItem());
        System.out.println("Status do Pedido: " + (pedido.isEncerrado() ? "Finalizado" : "Aberto"));
        System.out.println("---------------------------");

    }
    public static Pedido buscarPedido(List<Pedido> pedidos, int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }
    public static void finalizarPedido(List<Pedido> pedidos, Scanner scan) {
        System.out.println("Pedidos em aberto:");
        mostrarAbertos(pedidos);

        System.out.println("Digite o id do pedido que deseja finalizar:");
        int idPedido = scan.nextInt();

        Pedido pedido = buscarPedido(pedidos, idPedido);

        if (pedido == null) {
            System.out.println("Pedido não encontrado!");
            return;
        }

        if (pedido.isEncerrado()) {
            System.out.println("Este pedido já está finalizado!");
            return;
        }

        pedido.setEncerrado(true);
        System.out.println("Pedido finalizado com sucesso!");
        pedido.criarArquivoTxt();
    }
    public void criarArquivoTxt() {
        String Arquivo = "Pedido-ID" + this.getId() + ".txt";
        try {
            FileWriter arquivo = new FileWriter(Arquivo);
            arquivo.write("ID: " + this.getId() + "\n");
            arquivo.write("Cliente: " + this.getCliente().getNome() + "\n");
            arquivo.write("Item do Pedido: " + this.getItem() + "\n");
            arquivo.write("Status do Pedido: " + (this.isEncerrado() ? "Finalizado" : "Aberto") + "\n");
            arquivo.close();
            System.out.println("Arquivo " + Arquivo + " criado com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao criar arquivo " + Arquivo);
            e.printStackTrace();
        }
    }


}



