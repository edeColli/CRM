package com.ultimaschool.java.clientes;

import com.ultimaschool.java.exceptions.InvalidDateException;
import com.ultimaschool.java.exceptions.InvalidPhoneException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import com.ultimaschool.java.exceptions.InvalidEmailException;


public class ClienteBuilderTest {

    private ClienteBuilder clienteBuilder;
    private ClienteBuilder clienteBuilder2;

    @Before
    public void setUp() throws InvalidDateException {
        clienteBuilder2 = new ClienteBuilder();
        clienteBuilder = new ClienteBuilder().comIdentificacao("Joana", "Maria",
                "Rocha","123.456.789-00","10/01/1993", 'F').comContatos(
                "joana@mail.com", "Av. Brasil","(83) 9999-9999");
    }

    @Test
    public void testGetDataDeNascimento() {
        Assertions.assertEquals(clienteBuilder.getDataDeNascimento(), "10/01/1993");
        Assertions.assertNull(clienteBuilder2.getDataDeNascimento());
    }

    @Test
    public void testSetDataDeNascimento() throws InvalidDateException {
        clienteBuilder.setDataDeNascimento("01/01/2002");
        Assertions.assertEquals(clienteBuilder.getDataDeNascimento(), "01/01/2002");
        clienteBuilder2.setDataDeNascimento("01/10/1952");
        Assertions.assertEquals(clienteBuilder2.getDataDeNascimento(), "01/10/1952");
    }

    @Test
    public void testSetDataNascimentoFailure() throws InvalidDateException {
        Assert.assertThrows(InvalidDateException.class, () -> clienteBuilder2.setDataDeNascimento("35/13/1999"));
        Assert.assertThrows(InvalidDateException.class, () -> clienteBuilder2.setDataDeNascimento("35/12/1999"));
        Assert.assertThrows(InvalidDateException.class, () -> clienteBuilder2.setDataDeNascimento("01/13/1999"));
        Assert.assertThrows(InvalidDateException.class, () -> clienteBuilder2.setDataDeNascimento("01-12-1999"));
        Assert.assertThrows(InvalidDateException.class, () -> clienteBuilder2.setDataDeNascimento("01.12.1999"));
    }

    @Test
    public void testGetCpf(){
        Assertions.assertEquals(clienteBuilder.getCpf(), "123.456.789-00");
        Assertions.assertNull(clienteBuilder2.getCpf());
    }

    @Test
    public void testSetCpf(){
        clienteBuilder.setCpf("000.000.000-22");
        Assertions.assertEquals(clienteBuilder.getCpf(), "000.000.000-22");
        clienteBuilder2.setCpf("111.111.111-00");
        Assertions.assertEquals(clienteBuilder2.getCpf(), "111.111.111-00");
    }

    @Test
    public void testGetEmail(){
        Assertions.assertEquals(clienteBuilder.getEmail(), "joana@mail.com");
        Assertions.assertNull(clienteBuilder2.getEmail());
        Assertions.assertTrue(clienteBuilder.getEmail().contains("@"));
    }

    @Test
    public void testSetEmail()  throws InvalidEmailException{
        clienteBuilder.setEmail("username@domain.com");
        Assertions.assertEquals(clienteBuilder.getEmail(), "username@domain.com");

        clienteBuilder.setEmail("user.name@domain.com");
        Assertions.assertEquals(clienteBuilder.getEmail(), "user.name@domain.com");

        clienteBuilder.setEmail("user-name@domain.com");
        Assertions.assertEquals(clienteBuilder.getEmail(), "user-name@domain.com");

        clienteBuilder.setEmail("username@domain.co.in");
        Assertions.assertEquals(clienteBuilder.getEmail(), "username@domain.co.in");

        clienteBuilder.setEmail("username@domain.com");
        Assertions.assertEquals(clienteBuilder.getEmail(), "username@domain.com");
    }

    @Test
    public void testSetEmailFailure() throws InvalidEmailException{
        Assert.assertThrows(InvalidEmailException.class, () -> clienteBuilder2.setEmail("username.@domain.com"));
        Assert.assertThrows(InvalidEmailException.class, () -> clienteBuilder2.setEmail(".user.name@domain.com"));
        Assert.assertThrows(InvalidEmailException.class, () -> clienteBuilder2.setEmail("user-name@domain.com."));
        Assert.assertThrows(InvalidEmailException.class, () -> clienteBuilder2.setEmail("username@.com"));
        Assert.assertThrows(InvalidEmailException.class, () -> clienteBuilder2.setEmail("username@@domain.com"));
        Assert.assertThrows(InvalidEmailException.class, () -> clienteBuilder2.setEmail("@domain.com"));
        Assert.assertThrows(InvalidEmailException.class, () -> clienteBuilder2.setEmail("username@"));
    }

    @Test
    public void testGetTelefone() {
        Assertions.assertEquals(clienteBuilder.getTelefone(), "(83) 9999-9999");
    }

    @Test
    public void testSetTelefone() throws InvalidPhoneException{
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder.setTelefone("(99) 99999-9999"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder.setTelefone("(99)99999-9999"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder.setTelefone("(88)88888-8888"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder.setTelefone("(77)7777-7777"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder.setTelefone("(66)66666-666"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder.setTelefone("55 555555555"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder.setTelefone("55-555555555"));
    }

    @Test
    public void testSetTelefoneFailure() {
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("444444444"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(99) 99999.9999"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(99)99999.9999"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(88)88888.8888"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(77)7777.7777"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(66)66666.666"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("55 555555555"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("55.555555555"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(99) 99999_9999"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(99)99999_9999"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(88)88888_8888"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(77)7777_7777"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("(66)66666_666"));
        Assert.assertThrows(InvalidPhoneException.class, () -> clienteBuilder2.setTelefone("55_555555555"));
    }

    @Test
    public void testGetNomeCompleto(){
        Assertions.assertEquals(clienteBuilder.getNomeCompleto(), "Joana Maria Rocha");
        Assertions.assertNull(clienteBuilder2.getNomeCompleto());
    }

    @Test
    public void testSetNomeCompleto(){
        clienteBuilder.setNomeCompleto("Pedro Santos");
        Assertions.assertEquals(clienteBuilder.getNomeCompleto(), "Pedro Santos");
        clienteBuilder2.setNomeCompleto("José da Silva");
        Assertions.assertEquals(clienteBuilder2.getNomeCompleto(), "José da Silva");
    }

    @Test
    public void testGetGenero(){
        Assertions.assertEquals(clienteBuilder.getGenero(),'F');
        clienteBuilder2.setGenero('M');
        Assertions.assertEquals(clienteBuilder2.getGenero(),'M');
    }

    @Test
    public void testSetGenero(){
        clienteBuilder.setGenero('M');
        Assertions.assertEquals(clienteBuilder.getGenero(),'M');
        clienteBuilder2.setGenero('F');
        Assertions.assertEquals(clienteBuilder2.getGenero(),'F');
    }

    @Test
    public void testGetPrimeiroNome(){
        Assertions.assertEquals(clienteBuilder.getPrimeiroNome(),"Joana");
        Assertions.assertNull(clienteBuilder2.getPrimeiroNome());
    }

    @Test
    public void testSetPrimeiroNome() {
        clienteBuilder.setPrimeiroNome("Maria");
        Assertions.assertEquals(clienteBuilder.getPrimeiroNome(),"Maria");
        clienteBuilder2.setPrimeiroNome("John");
        Assertions.assertEquals(clienteBuilder2.getPrimeiroNome(),"John");
    }

    @Test
    public void testGetNomesDoMeio() {
        Assertions.assertEquals(clienteBuilder.getNomesDoMeio(),"Maria");
        Assertions.assertNull(clienteBuilder2.getNomesDoMeio());
    }

    @Test
    public void testSetNomesDoMeio() {
        clienteBuilder.setNomesDoMeio("Tereza");
        Assertions.assertEquals(clienteBuilder.getNomesDoMeio(),"Tereza");
        clienteBuilder2.setNomesDoMeio("Max");
        Assertions.assertEquals(clienteBuilder2.getNomesDoMeio(),"Max");
    }

    @Test
    public void testGetSobrenome() {
        Assertions.assertEquals(clienteBuilder.getSobrenome(),"Rocha");
        Assertions.assertNull(clienteBuilder2.getSobrenome());
    }

    @Test
    public void testSetSobrenome() {
        clienteBuilder.setSobrenome("Silva");
        Assertions.assertEquals(clienteBuilder.getSobrenome(),"Silva");
        clienteBuilder2.setSobrenome("Moreira");
        Assertions.assertEquals(clienteBuilder2.getSobrenome(),"Moreira");
    }

    @Test
    public void testToStringComContato(){
        Assert.assertEquals(clienteBuilder.toStringContatos(), "Os dados de contatos são: E-mail joana@mail.com, endereço Av. Brasil e telefone (83) 9999-9999");
    }

    @Test
    public void testToStringIdentificacao(){
        Assert.assertEquals(clienteBuilder.toStringIdentificacao(), "Os dados pessoais são: Sra.Joana Maria Rocha, com CPF 123.456.789-00 , data de nascimento 10/01/1993 com idade de 30");
        clienteBuilder.setGenero('M');
        Assert.assertEquals(clienteBuilder.toStringIdentificacao(), "Os dados pessoais são: Sr.Joana Maria Rocha, com CPF 123.456.789-00 , data de nascimento 10/01/1993 com idade de 30");
        clienteBuilder.setGenero(' ');
        Assert.assertEquals(clienteBuilder.toStringIdentificacao(), "Os dados pessoais são: Joana Maria Rocha, com CPF 123.456.789-00 , data de nascimento 10/01/1993 com idade de 30");
        clienteBuilder.setGenero('X');
        Assert.assertEquals(clienteBuilder.toStringIdentificacao(), "Os dados pessoais são: Joana Maria Rocha, com CPF 123.456.789-00 , data de nascimento 10/01/1993 com idade de 30");
    }

    @Test
    public void testToString(){
        Assert.assertEquals(clienteBuilder.toString(), "Sra.Joana Maria Rocha, com CPF 123.456.789-00 , data de nascimento 10/01/1993 com idade de 30, e-mail joana@mail.com, endereço Av. Brasil e telefone (83) 9999-9999");
        clienteBuilder.setGenero('M');
        Assert.assertEquals(clienteBuilder.toString(), "Sr.Joana Maria Rocha, com CPF 123.456.789-00 , data de nascimento 10/01/1993 com idade de 30, e-mail joana@mail.com, endereço Av. Brasil e telefone (83) 9999-9999");
        clienteBuilder.setGenero(' ');
        Assert.assertEquals(clienteBuilder.toString(), "Joana Maria Rocha, com CPF 123.456.789-00 , data de nascimento 10/01/1993 com idade de 30, e-mail joana@mail.com, endereço Av. Brasil e telefone (83) 9999-9999");
        clienteBuilder.setGenero('X');
        Assert.assertEquals(clienteBuilder.toString(), "Joana Maria Rocha, com CPF 123.456.789-00 , data de nascimento 10/01/1993 com idade de 30, e-mail joana@mail.com, endereço Av. Brasil e telefone (83) 9999-9999");
    }

    @Test
    public void testGetIdadeAtual() {
        Assertions.assertEquals(clienteBuilder.getIdadeAtual(), 30);
        Assertions.assertEquals(clienteBuilder2.getIdadeAtual(), 0);
    }

    @Test
    public void testSetIdadeAtual() {
        clienteBuilder.setIdadeAtual(45);
        Assertions.assertEquals(clienteBuilder.getIdadeAtual(),45);
        clienteBuilder2.setIdadeAtual(12);
        Assertions.assertEquals(clienteBuilder2.getIdadeAtual(),12);
    }

    @Test
    public void testGetEndereco() {
        Assertions.assertEquals(clienteBuilder.getEndereco(), "Av. Brasil");
        Assertions.assertNull(clienteBuilder2.getEndereco());
    }

    @Test
    public void testSetEndereco() {
        clienteBuilder.setEndereco("Rua XV Novembro");
        Assertions.assertEquals(clienteBuilder.getEndereco(),"Rua XV Novembro");
        clienteBuilder2.setEndereco("Av. Amarela");
        Assertions.assertEquals(clienteBuilder2.getEndereco(),"Av. Amarela");
    }

    @After
    public void tearDown() {
        clienteBuilder = null;
        clienteBuilder2 = null;
    }

}