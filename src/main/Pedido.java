package main;

import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Pedido {
    private boolean encerrado;
    private List <Cliente> clientes = new ArrayList<>();
    private String item;
    private  List<Endereco> enderecos;

    public boolean isEncerrado() {
        return encerrado;
    }

    public static void setEncerrado(boolean encerrado) {
        encerrado = encerrado;
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

    public Pedido(boolean encerrado, List<Cliente> clientes, String item, List<Endereco> enderecos) {
        this.encerrado = encerrado;
        this.clientes = clientes;
        this.item = item;
        this.enderecos = enderecos;
    }

    public static void realizarPedido(List<Cliente> clientes, List<Endereco> enderecos, Scanner scan,List<Pedido> pedidos) {
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
        Pedido.setItem(item);
        Pedido.setEncerrado(false);
        Pedido pedido = new Pedido(false, clientes, item, enderecos);
        cliente.adicionarPedido(new Pedido(false, clientes, item, enderecos));
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
            System.out.println("Cliente: " + pedido.getClientes().get(0).getNome());
            System.out.println("Item do Pedido: " + pedido.getItem());
            System.out.println("Status do Pedido: " + (pedido.isEncerrado() ? "Encerrado" : "Aberto"));
            System.out.println("---------------------------");
        }
    }
    public static void mostrarAbertos(List<Pedido> pedidos) {
        System.out.println("Pedidos em aberto:");
        for (Pedido pedido : pedidos) {
            if (!pedido.isEncerrado()) {
                mostrarTodosPedidos(pedidos);
            }
        }
    }

    public static void mostrarFinalizados(List<Pedido> pedidos) {
        System.out.println("Pedidos finalizados:");
        for (Pedido pedido : pedidos) {
            if (pedido.isEncerrado()) {
                mostrarTodosPedidos(pedidos);
            }
        }
    }


}
