package com.ultimaschool.java.clientes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClienteBuilder {

    private String primeiroNome;
    private String nomesDoMeio;
    private String sobrenome;
    private String nomeCompleto;
    private String cpf;
    private String dataDeNascimento;
    private int idadeAtual;
    private char genero;
    private String email;
    private String endereco;
    private String telefone;

    public ClienteBuilder comIdentificacao(String primeiroNome, String nomesDoMeio, String sobrenome, String cpf,
                                           String dataDeNascimento, char genero){
        this.primeiroNome = primeiroNome;
        this.nomesDoMeio = nomesDoMeio;
        this.sobrenome = sobrenome;
        this.nomeCompleto = primeiroNome + " " + nomesDoMeio + " " + sobrenome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.idadeAtual = definirIdadeAtual();
        this.genero = genero;

        return this;
    }

    public ClienteBuilder comContatos(String email, String endereco, String telefone){
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;

        return this;
    }

    private int definirIdadeAtual(){
        return recuperarAnoData(new Date()) - recuperarAnoData(dataDeNascimento);
    }

    private int recuperarAnoData(String data){
        Calendar calendario = Calendar.getInstance();
        Date dataConversao;
        try {
            dataConversao = definirFormatoData("dd/MM/yyyy").parse(data);
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
            return new SimpleDateFormat("dd/MM/yyyy");
        } else {
            return new SimpleDateFormat(formatoData);
        }
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

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getNomesDoMeio() {
        return nomesDoMeio;
    }

    public void setNomesDoMeio(String nomesDoMeio) {
        this.nomesDoMeio = nomesDoMeio;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public int getIdadeAtual() {
        return idadeAtual;
    }

    public void setIdadeAtual(int idadeAtual) {
        this.idadeAtual = idadeAtual;
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
        if (getGenero() == 'F'){
            return "Sra.";
        } else if (getGenero() == 'M') {
            return "Sr.";
        }else{
            return "";
        }
    }

    @Override
    public String toString(){
        return tratamentoGenero() + getNomeCompleto() + ", com CPF " + getCpf() +
                " , data de nascimento " + getDataDeNascimento() + " com idade de " + getIdadeAtual() +
                ", e-mail " + getEmail() + ", endereço " + getEndereco() + " e telefone " + getTelefone();
    }

    public String toStringIdentificacao(){
        return "Os dados pessoais são: " + tratamentoGenero() + getNomeCompleto() + ", com CPF " + getCpf() +
                " , data de nascimento " + getDataDeNascimento() + " com idade de " + getIdadeAtual();
    }

    public String toStringContatos(){
        return "Os dados de contatos são: E-mail " + getEmail() + ", endereço " + getEndereco() + " e telefone " + getTelefone();
    }

}
