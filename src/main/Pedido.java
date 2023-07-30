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

    public static void realizarPedido(List<Cliente> clientes, List<Endereco> enderecos, Scanner scan) {
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
            System.out.println("Endereco não encontrado!");
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
        cliente.adicionarPedido(new Pedido(false, clientes, item, enderecos));
        System.out.println("Pedido realizado com sucesso!");



    }



}
