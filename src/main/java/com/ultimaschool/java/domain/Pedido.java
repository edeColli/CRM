package com.ultimaschool.java.domain;

import java.util.Date;

public class Pedido {

    private int id;
    private int cliente_id;
    private Date datahora_criacao;

    private Date datahora_entrega;
    private double valor_pedido;
    private enum status_pedido {CRIADO, AGUARDANDO_PAGAMENTO, ERRO_PAGAMENTO, PAGO, PREPARANDO_ENTREGA, ENVIADO, CANCELADO, ENTREGUE}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getDatahora_criacao() {
        return datahora_criacao;
    }

    public void setDatahora_criacao(Date datahora_criacao) {
        this.datahora_criacao = datahora_criacao;
    }

    public Date getDatahora_entrega() {
        return datahora_entrega;
    }

    public void setDatahora_entrega(Date datahora_entrega) {
        this.datahora_entrega = datahora_entrega;
    }

    public double getValor_pedido() {
        return valor_pedido;
    }

    public void setValor_pedido(double valor_pedido) {
        this.valor_pedido = valor_pedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", cliente_id=" + cliente_id +
                ", datahora_criacao=" + datahora_criacao +
                ", datahora_entrega=" + datahora_entrega +
                ", valor_pedido=" + valor_pedido +
                '}';
    }
}
