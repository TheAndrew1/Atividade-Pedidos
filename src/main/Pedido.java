package main;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private boolean encerrado;
    private List <Cliente> clientes = new ArrayList<>();
    private String item;
    private List<Endereco> enderecos;
    public boolean isEncerrado() {
        return encerrado;
    }

    public void setEncerrado(boolean encerrado) {
        this.encerrado = encerrado;
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

    public void setItem(String item) {
        this.item = item;
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


}
