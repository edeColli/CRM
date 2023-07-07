package com.ultimaschool.java.domain;

public class PedidoProduto {

    private int id;
    private int produto_id;
    private int pedido_id;
    private int quantidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public int getPedido_id() {
        return pedido_id;
    }

    public void setPedido_id(int pedido_id) {
        this.pedido_id = pedido_id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "PedidoProduto{" +
                "id=" + id +
                ", produto_id=" + produto_id +
                ", pedido_id=" + pedido_id +
                ", quantidade=" + quantidade +
                '}';
    }
}
