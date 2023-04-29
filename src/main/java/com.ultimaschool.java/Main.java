package com.ultimaschool.java;

import com.ultimaschool.java.clientes.Cliente;

public class Main {

    public static void main(String[] args){

        Cliente clienteF = new Cliente("123.456.789-00", "joana@mail.com", "Joana Maria Rocha", 'F');
        System.out.println(clienteF.toString());

        Cliente clienteM = new Cliente("999.888.777-55", "rogerio@mail.com", "Rogerio Azevedo", 'M');
        System.out.println(clienteM.toString());
    }
}