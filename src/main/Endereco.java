package main;

import java.util.List;
import java.util.Scanner;

public class Endereco {
    private int id;

    private String rua;
    private int numero;

    public Endereco() {
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