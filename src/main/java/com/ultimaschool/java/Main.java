package com.ultimaschool.java;

import com.ultimaschool.java.clientes.Cliente;
import com.ultimaschool.java.clientes.ClienteBuilder;
import com.ultimaschool.java.domain.Client;
import com.ultimaschool.java.exceptions.InvalidDateException;
import com.ultimaschool.java.exceptions.InvalidEmailException;
import com.ultimaschool.java.repository.ClientRepository;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws InvalidEmailException, InvalidDateException, SQLException {

//        Cliente clienteF = new Cliente("Joana", "Maria","Rocha","123.456.789-00",
//                "10/01/1993", 'F', "joana@mail.com", "Av. Brasil",
//                "(83) 9999-9999");
//        System.out.println(clienteF);
//
//        Cliente clienteM = new Cliente("Rogerio", "","Azevedo","999.888.777-55",
//                "09/06/1981", 'M', "rogerio@mail.com", "Av. Flores",
//                "(83) 8888-8888");
//        System.out.println(clienteM);
//
//        ClienteBuilder clienteFCompleto = new ClienteBuilder().comIdentificacao("Joana", "Maria",
//                "Rocha","123.456.789-00","10/01/1993", 'F').comContatos(
//                        "joana@mail.com", "Av. Brasil","(83) 9999-9999");
//        System.out.println(clienteFCompleto.toString());
//
//        ClienteBuilder clienteFContato = new ClienteBuilder().comContatos("joana@mail.com", "Av. Brasil",
//                "(83) 9999-9999");
//        System.out.println(clienteFContato.toStringContatos());
//
//        ClienteBuilder clienteMIdentificacao = new ClienteBuilder().comIdentificacao("Rogerio", "",
//                "Azevedo","999.888.777-55","09/06/1981", 'M');
//        System.out.println(clienteMIdentificacao.toStringIdentificacao());


        System.out.println("Clientes na base de dados");
        ClientRepository clientRepository = new ClientRepository();
        clientRepository.findAll().forEach(System.out::println);

        Client client =  clientRepository.findById(1);
        if (client != null){
            System.out.println(client.toString());
            client.setAge(42);
            clientRepository.update(client);
        } else {
            System.out.println("Cliente não encontrado");
        }

//        Client client1 = new Client();
//        client1.setFirstName("Maria");
//        client1.setLastName("dos Santos");
//        client1.setEmail("maria@gmail.com");
//        client1.setCpf("00691478929");
//        client1.setAge(25);
//        if (clientRepository.insert(client1)) {
//            clientRepository.findAll().forEach(System.out::println);
//        }
        clientRepository.delete(3);
    }
}