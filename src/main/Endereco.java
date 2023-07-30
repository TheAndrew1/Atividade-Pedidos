package main;

import java.util.List;
import java.util.Scanner;

public class Endereco {
    private int id;

    private String rua;
    private int numero;

    public Endereco() {
    }

    public Endereco(String rua, int numero) {
        this.rua = rua;
        this.numero = numero;
    }

    public Endereco(int id, String rua, int numero) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static Endereco cadastrarEndereco(Scanner scan, int idEndereco){
        System.out.println("Endereço " + idEndereco + " : (Digite 0 para sair)");

        System.out.println("Digite o nome da rua: ");
        scan.nextLine();
        String rua = scan.nextLine();

        if (rua.equals("0")) {
            return null;
        }

        System.out.println("Digite o numero da residência: ");
        int numero = scan.nextInt();

        return new Endereco(idEndereco, rua, numero);
    }

    public static List<Endereco> excluirEndereco(List<Endereco> enderecos, int id){
        for (Endereco endereco : enderecos) {
            if (endereco.getId() == id) {
                enderecos.remove(id-1);
                System.out.println("Endereço excluido com sucesso!");
                return enderecos;
            }
        }

        System.out.println("Id do endereço não encontrado!");
        return null;
    }

    public static Endereco buscarEndereco(List<Endereco> enderecos, Scanner scan) {
        System.out.println("Digite id do endereço: ");
        int id = scan.nextInt();

        for (Endereco endereco : enderecos) {
            if (endereco.getId() == id) {
                return endereco;
            }
        }
        return null;
    }

}