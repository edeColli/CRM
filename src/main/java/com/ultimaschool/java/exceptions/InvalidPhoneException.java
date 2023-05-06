package com.ultimaschool.java.exceptions;

public class InvalidPhoneException extends Exception{

    private String errorMessage;

    public InvalidPhoneException(String telefone){
        this.errorMessage = "O "+ telefone + " é inválido.";
    }
}
