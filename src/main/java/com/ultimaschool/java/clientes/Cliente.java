package com.ultimaschool.java.clientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cliente {

    final private static String DATA_FORMAT = "dd/MM/yyyy";

    private int id;
    private String first_Name;
    private String middle_Name;
    private String last_Name;
    private String full_Name;
    private String cpf;
    private String dataDeNascimento;
    private int age;
    private String genero;
    private String email;
    private String endereco;
    private String telefone;

    public Cliente(){

    }
    public Cliente(String primeiroNome, String nomesDoMeio, String sobrenome, String cpf, String dataDeNascimento,
                   String genero, String email, String endereco, String telefone){
        this.first_Name = primeiroNome;
        this.middle_Name = nomesDoMeio;
        this.last_Name = sobrenome;
        this.full_Name = primeiroNome + " " + nomesDoMeio + " " + sobrenome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.age = definirIdadeAtual();
        this.genero = genero;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    private int definirIdadeAtual(){
        return recuperarAnoData(new Date()) - recuperarAnoData(dataDeNascimento);
    }

    private int recuperarAnoData(String data){
        Calendar calendario = Calendar.getInstance();
        Date dataConversao;
        try {
            dataConversao = definirFormatoData(DATA_FORMAT).parse(data);
        } catch (ParseException e) {
            System.out.println("Erro de conversão de data");
            throw new RuntimeException(e);
        }
        calendario.setTime(dataConversao);
        return calendario.get(Calendar.YEAR);
    }

    private int recuperarAnoData(Date data){
        Calendar calendario = Calendar.getInstance();
        calendario.setTime(data);
        return calendario.get(Calendar.YEAR);
    }

    private SimpleDateFormat definirFormatoData(String formatoData){
        if (formatoData.equals("")){
            return new SimpleDateFormat(DATA_FORMAT);
        } else {
            return new SimpleDateFormat(formatoData);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getMiddle_Name() {
        return middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        this.middle_Name = middle_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getFull_Name() {
        return full_Name;
    }

    public void setFull_Name(String full_Name) {
        this.full_Name = full_Name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() { return full_Name; }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String tratamentoGenero(){
        if (getGenero() == "F"){
            return "Sra.";
        } else if (getGenero() == "M") {
            return "Sr.";
        }else{
            return "";
        }
    }

    @Override
    public String toString(){
        return tratamentoGenero() + getNomeCompleto() + ", com CPF " + getCpf() +
                " , data de nascimento " + getDataDeNascimento() + " com idade de " + getAge() +
                ", e-mail " + getEmail() + ", endereço " + getEndereco() + " e telefone " + getTelefone();
    }
}