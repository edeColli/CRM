package com.ultimaschool.java;

import com.ultimaschool.java.clientes.Cliente;
import com.ultimaschool.java.clientes.ClienteBuilder;

public class Main {

    public static void main(String[] args){

        Cliente clienteF = new Cliente("Joana", "Maria","Rocha","123.456.789-00",
                "10/01/1993", 'F', "joana@mail.com", "Av. Brasil",
                "(83) 9999-9999");
        System.out.println(clienteF.toString());

        Cliente clienteM = new Cliente("Rogerio", "","Azevedo","999.888.777-55",
                "09/06/1981", 'M', "rogerio@mail.com", "Av. Flores",
                "(83) 8888-8888");
        System.out.println(clienteM.toString());

        ClienteBuilder clienteFCompleto = new ClienteBuilder().comIdentificacao("Joana", "Maria",
                "Rocha","123.456.789-00","10/01/1993", 'F').comContatos(
                        "joana@mail.com", "Av. Brasil","(83) 9999-9999");
        System.out.println(clienteFCompleto.toString());

        ClienteBuilder clienteFContato = new ClienteBuilder().comContatos("joana@mail.com", "Av. Brasil",
                "(83) 9999-9999");
        System.out.println(clienteFContato.toStringContatos());
    }
}