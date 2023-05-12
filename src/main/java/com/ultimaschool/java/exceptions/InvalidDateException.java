package com.ultimaschool.java.exceptions;

public class InvalidDateException extends Exception{

    private String errorMessage;

    public InvalidDateException(String data){
        this.errorMessage = "A " + data + " informada está inválido. O formato aceito é dd/MM/yyyy";
    }
}