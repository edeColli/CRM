package com.ultimaschool.java.domain;

import com.ultimaschool.java.enums.Status_entrega;

import java.util.Date;

public class Entrega {

    private int id;
    private int id_pedido;
    private String nome_entregador;
    private String nome_receptor;

    public Status_entrega getStatus_entrega() {
        return status_entrega;
    }

    public void setStatus_entrega(Status_entrega status_entrega) {
        this.status_entrega = status_entrega;
    }

    private Status_entrega status_entrega;
    private int qtd_tentativas_entrega;

    private Date data_entrega;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getNome_entregador() {
        return nome_entregador;
    }

    public void setNome_entregador(String nome_entregador) {
        this.nome_entregador = nome_entregador;
    }

    public String getNome_receptor() {
        return nome_receptor;
    }

    public void setNome_receptor(String nome_receptor) {
        this.nome_receptor = nome_receptor;
    }

    public int getQtd_tentativas_entrega() {
        return qtd_tentativas_entrega;
    }

    public void setQtd_tentativas_entrega(int qtd_tentativas_entrega) {
        this.qtd_tentativas_entrega = qtd_tentativas_entrega;
    }

    public Date getData_entrega() {
        return data_entrega;
    }

    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    @Override
    public String toString() {
        return "Entrega{" +
                "id=" + id +
                ", id_pedido=" + id_pedido +
                ", nome_entregador='" + nome_entregador + '\'' +
                ", nome_receptor='" + nome_receptor + '\'' +
                ", status_entrega=" + status_entrega +
                ", qtd_tentativas_entrega=" + qtd_tentativas_entrega +
                ", data_entrega=" + data_entrega +
                '}';
    }
}
