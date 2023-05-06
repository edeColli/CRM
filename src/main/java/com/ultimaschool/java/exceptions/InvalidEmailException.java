package com.ultimaschool.java.exceptions;

public class InvalidEmailException extends Exception{

    private String errorMessage;

    public InvalidEmailException(String email){
        this.errorMessage = "O " + email + " digitado está inválido";
    }
}
