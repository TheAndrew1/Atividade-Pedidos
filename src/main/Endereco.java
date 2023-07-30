package main;

import java.util.List;
import java.util.Scanner;

public class Endereco {
    private String rua;
    private int numero;

    public Endereco() {
    }

    public Endereco(String rua, int numero) {
        this.rua = rua;
        this.numero = numero;
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
        System.out.println("Digite o numero da residencia: ");
        int numero = scan.nextInt();

        for (Endereco endereco : enderecos) {
            if (endereco.getNumero()==(numero)) {
                return endereco;
            }
        }
        return null;
    }

}