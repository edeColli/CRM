package com.ultimaschool.java.clientes;

import com.ultimaschool.java.exceptions.InvalidEmailException;
import com.ultimaschool.java.exceptions.InvalidPhoneException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClienteBuilder {

    //As seguintes restrições são impostas na parte local do endereço de e-mail usando este regex:
    //Permite valores numéricos de 0 a 9.
    //Letras maiúsculas e minúsculas de a a z são permitidas.
    //São permitidos sublinhado “_”, hífen “-“ e ponto “.”
    //Ponto não é permitido no início e no final da parte local.
    //Pontos consecutivos não são permitidos.
    //Para a parte local, são permitidos no máximo 64 caracteres.
    //As restrições para a parte do domínio nesta expressão regular incluem:
    //
    //Permite valores numéricos de 0 a 9.
    //Permitimos letras maiúsculas e minúsculas de a a z.
    //Hífen “-” e ponto “.” não são permitidos no início e no final da parte do domínio.
    //Sem pontos consecutivos.
    //Sem @ consecutivos

    private static final String EMAIL_REGEX = "^(?=.{1,64}@)(?!.*@@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    private static final String PHONE_REGEX = "/(\\([0-9]{2}\\)\\s?[0-9]{4,5}-?[0-9]{3,4})|([0-9]{10,11})|([0-9]{2}\\s?[0-9]{8,9})/gm";
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if (email.matches(EMAIL_REGEX)){
            this.email = email;
        } else {
            throw new InvalidEmailException(email);
        }

    }

    public void setTelefone(String telefone) throws InvalidPhoneException {
        if (telefone.matches(PHONE_REGEX)) {
            this.telefone = telefone;
        } else {
            throw new InvalidPhoneException(telefone);
        }
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
